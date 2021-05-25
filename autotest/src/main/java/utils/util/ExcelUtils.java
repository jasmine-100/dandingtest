package utils.util;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author： jasmine
 * @Description :
 * @Date : Created in 2021/4/20 10:30
 */
public class ExcelUtils {
    private static final Map<Class<?>, Class<?>> pwMap = new HashMap<Class<?>, Class<?>>();

    static {
        pwMap.put(byte.class, Byte.class);
        pwMap.put(short.class, Short.class);
        pwMap.put(int.class, Integer.class);
        pwMap.put(long.class, Long.class);
        pwMap.put(float.class, Float.class);
        pwMap.put(double.class, Double.class);
        pwMap.put(boolean.class, Boolean.class);
        pwMap.put(char.class, Character.class);
    }

    private ExcelUtils() {
    }

    /**
     * 从Excel中获取对象列
     * @param excelFile 文件
     * @param sheetindex 第几个sheet
     * @param props 属性名（按顺序） （如果有非基本类型需要实现valueOf方法）
     * @param clazz 类型
     * @return
     * @throws Exception
     *      String[], Class, SimpleDateFormat)
     */
    public static <T> List<T> getDataList(File excelFile, int sheetindex,int startRow, int startCol, String[] props, Class<T> clazz)throws Exception {
        return getDataList(excelFile, sheetindex, startRow, startCol, props,clazz, null);
    }

    public static <T> List<T> getDataList(File excelFile, int sheetindex,int startRow, int startCol, String[] props, Class<T> clazz,SimpleDateFormat sdf) throws Exception {
        Workbook excel = null;
        try {
            excel = Workbook.getWorkbook(excelFile);
            Sheet sheet = excel.getSheet(sheetindex);
            int n = sheet.getRows();
            List<T> result = new ArrayList<T>(n);
            for (int i = startRow; i < n; i++) {
                Cell[] row = sheet.getRow(i);
                result.add(getRowData(props, row, clazz, sdf, startCol));
            }
            return result;
        } catch (BiffException | IOException e) {
            throw new Exception("读取Excel文件出错！");
        } finally {
            excel.close();
        }
    }

    /**
     * 获取其中一行的数据注入到对象中
     * @param props
     * @param row
     * @param clazz
     * @return
     * @throws Exception
     */
    public static <T> T getRowData(String[] props, Cell[] row, Class<T> clazz, int startCol) throws Exception {
        return getRowData(props, row, clazz, null, startCol);
    }

    /**
     *
     * @param props
     * @param row
     * @param clazz
     * @param sdf
     * @return
     * @throws Exception
     */
    public static <T> T getRowData(String[] props, Cell[] row, Class<T> clazz,SimpleDateFormat sdf, int startCol) throws Exception {
        // 属性首字母大写
        for (int i = 0; i < props.length; i++) {
            if (props[i] == null)
                continue;
            StringBuilder sb = new StringBuilder(props[i]);
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
            props[i] = sb.toString();
        }
        // 实例化一个对象
        T result = clazz.newInstance();
        for (int i = 0; i < props.length; i++) {
            String propName = props[i];
            if (propName == null) {
                continue;
            }
            Class<?> type = getPropType(clazz, propName);
            // 把getter的返回类型作为参数类型获取setter
            Method setter = clazz.getMethod("set" + propName, type);
            String contents = row[i + startCol].getContents();

            if (contents != null) {
                Object val = string2Type(contents, type, sdf);
                // 执行setter
                setter.invoke(result, val);
            }
        }
        return result;
    }

    private static final SimpleDateFormat DEFALUT_SIMPLEDATEF = new SimpleDateFormat("yyyy-MM-dd");

    @SuppressWarnings("unchecked")
    private static <T> T string2Type(String val, Class<T> clazz,SimpleDateFormat sdf) throws Exception {
        Method valueOf = null;
        // 对Date和String特殊处理
        if (String.class == clazz) {
            return (T) val;
        }
        if (Date.class == clazz) {
            return (T) (sdf != null ? sdf.parse(val) : DEFALUT_SIMPLEDATEF.parse(val));
        }
        if (char.class == clazz || Character.class == clazz) {
            Character c = val.toCharArray().length > 0 ? val.toCharArray()[0]: (Character.class == clazz ? null : (char) 0);
            return (T) c;
        }
        // 对基本类型做处理
        Class<?> finalclazz = clazz.isPrimitive() ? pwMap.get(clazz) : clazz;
        try {
            valueOf = finalclazz.getMethod("valueOf", String.class);
        } catch (NoSuchMethodException e) {
            throw new Exception("成员类型需要有T valueOf(String)静态方法");
        }
        return (T) valueOf.invoke(null, val);
    }

    private static Class<?> getPropType(Class<?> clazz, String propName)throws NoSuchMethodException, SecurityException {
        Method getter = clazz.getMethod("get" + propName);
        Class<?> type = getter.getReturnType();
        return type;
    }
}
