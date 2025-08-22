package cn.year;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public class BooleanSizeTest {
    
    private boolean boolValue;
    
    public static void main(String[] args) throws Exception {
        System.out.println("测试Java中boolean类型占位大小");
        
        // 测试1: 创建boolean数组，查看内存占用
        int size = 1000000;
        boolean[] boolArray = new boolean[size];
        
        // 输出数组大小信息
        System.out.println("boolean数组长度: " + boolArray.length);
        System.out.println("boolean数组理论最小占用位数(按1位/boolean): " + size + " bits (" + (size/8) + " bytes)");
        System.out.println("boolean数组实际占用内存: " + getObjectSize(boolArray) + " bytes");
        
        // 测试2: 单个boolean变量测试
        BooleanSizeTest testObj = new BooleanSizeTest();
        System.out.println("包含boolean字段的对象大小: " + getObjectSize(testObj) + " bytes");
        
        // 测试3: boolean值在不同情况下的内存占用
        boolean trueValue = true;
        boolean falseValue = false;
        System.out.println("单个boolean变量大小(估计): " + getObjectSize(trueValue) + " bytes");
        System.out.println("Boolean对象大小: " + getObjectSize(Boolean.TRUE) + " bytes");
        
        // 测试4: 不同大小的boolean数组
        for (int i = 0; i < 10; i++) {
            boolean[] testArray = new boolean[i];
            System.out.println("boolean数组长度 " + i + " 占用内存: " + getObjectSize(testArray) + " bytes");
        }
    }
    
    private static long getObjectSize(Object object) throws Exception {
        // 使用Unsafe类获取对象大小
        Unsafe unsafe = getUnsafe();
        if (unsafe == null) {
            return -1;
        }
        return unsafe.objectFieldOffset(getLastField(object.getClass())) - unsafe.objectFieldOffset(getFirstField(object.getClass())) + getSizeOfField(getLastField(object.getClass()));
    }
    
    private static Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            return null;
        }
    }
    
    private static Field getFirstField(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        return fields.length > 0 ? fields[0] : null;
    }
    
    private static Field getLastField(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        return fields.length > 0 ? fields[fields.length - 1] : null;
    }
    
    private static int getSizeOfField(Field field) {
        Class<?> type = field.getType();
        if (type == boolean.class || type == byte.class) {
            return 1;
        } else if (type == char.class || type == short.class) {
            return 2;
        } else if (type == int.class || type == float.class) {
            return 4;
        } else if (type == long.class || type == double.class) {
            return 8;
        } else {
            return 4; // 引用类型
        }
    }
}