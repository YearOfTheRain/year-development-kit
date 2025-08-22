package cn.year;

import java.lang.instrument.Instrumentation;

/**
 * 用于测试boolean类型内存占用的类
 * 需要通过Java agent方式运行才能获得准确结果
 */
public class BooleanMemoryTest {
    
    // 用于保存Instrumentation实例
    private static Instrumentation instrumentation;
    
    // 测试用的boolean变量
    private boolean boolField;
    
    public static void premain(String args, Instrumentation inst) {
        instrumentation = inst;
    }
    
    public static long getObjectSize11(Object object) {
        if (instrumentation == null) {
            throw new IllegalStateException("Instrumentation不可用，需要通过-javaagent参数启动");
        }
        return instrumentation.getObjectSize(object);
    }
    
    public static void main(String[] args) {
        System.out.println("Java boolean类型内存占用测试");
        System.out.println("==============================");
        
        // 测试1: boolean数组
        System.out.println("1. boolean数组内存占用测试:");
        for (int i = 0; i <= 16; i++) {
            boolean[] boolArray = new boolean[i];
            System.out.println("   长度为 " + i + " 的boolean数组占用内存: " + 
                             getSizeString(boolArray) + " 字节");
        }
        
        // 测试2: 包含boolean的对象
        System.out.println("\n2. 包含boolean字段的对象:");
        BooleanMemoryTest testObj = new BooleanMemoryTest();
        System.out.println("   包含1个boolean字段的对象: " + getSizeString(testObj) + " 字节");
        
        // 测试3: Boolean包装类
        System.out.println("\n3. Boolean包装类对象:");
        System.out.println("   Boolean.TRUE: " + getSizeString(Boolean.TRUE) + " 字节");
        System.out.println("   Boolean.FALSE: " + getSizeString(Boolean.FALSE) + " 字节");
        
        // 理论分析
        System.out.println("\n4. 理论分析:");
        System.out.println("   根据JVM实现不同，boolean类型大小可能不同:");
        System.out.println("   - 在Oracle HotSpot JVM中:");
        System.out.println("     * 单个boolean变量占用1字节(8位)");
        System.out.println("     * boolean数组中每个元素只占用1位");
        System.out.println("   - JVM规范并未明确规定boolean的大小");
        System.out.println("   - 实际大小取决于JVM的具体实现");
    }
    
    private static String getSizeString(Object obj) {
        try {
            long size = getObjectSize11(obj);
            return size + " 字节";
        } catch (Exception e) {
            return "无法测量 (需要Instrumentation)";
        }
    }
    
    private static long getObjectSize(Object obj) {
        // 简化的大小计算，实际需要Instrumentation
        if (obj instanceof boolean[]) {
            boolean[] arr = (boolean[]) obj;
            // 简化计算: 数组对象头(12字节) + 长度字段(4字节) + 数据(向上取整到字节)
            int dataBytes = (arr.length + 7) / 8;  // 每个boolean占用1位
            return 16 + dataBytes;  // 对象头 + 数据
        } else if (obj instanceof BooleanMemoryTest) {
            return 16; // 对象头 + 1个boolean字段(1字节) + 对齐
        } else if (obj instanceof Boolean) {
            return 16; // Boolean对象包含对象头和内部boolean值
        }
        return 0;
    }
}