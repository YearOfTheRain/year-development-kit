package cn.year;

/**
 * 演示Java中boolean类型内存占用的示例程序
 */
public class BooleanDemo {
    
    // 实例变量
    private boolean flag1;
    private boolean flag2;
    
    public static void main(String[] args) {
        System.out.println("Java中boolean类型的内存占用演示");
        System.out.println("================================");
        
        // 1. boolean基本类型变量
        boolean boolVar = true;
        System.out.println("1. boolean基本类型变量:");
        System.out.println("   - boolVar = " + boolVar);
        System.out.println("   - 理论上占用: 1字节 (8位)");
        System.out.println("   - 实际值只需要: 1位 (0或1)");
        System.out.println();
        
        // 2. boolean数组
        System.out.println("2. boolean数组:");
        boolean[] boolArray = new boolean[8];
        boolArray[0] = true;
        boolArray[3] = true;
        boolArray[7] = true;
        
        System.out.println("   - 长度为8的boolean数组");
        System.out.println("   - 理论上可以只占用: 8位 (1字节)");
        System.out.println("   - 实际在HotSpot JVM中也确实如此实现");
        System.out.println();
        
        // 3. Boolean包装类
        System.out.println("3. Boolean包装类:");
        Boolean boolObj1 = Boolean.TRUE;
        Boolean boolObj2 = Boolean.FALSE;
        System.out.println("   - Boolean.TRUE = " + boolObj1);
        System.out.println("   - Boolean.FALSE = " + boolObj2);
        System.out.println("   - Boolean对象包含额外的对象头信息");
        System.out.println("   - 通常占用12-16字节 (取决于JVM实现)");
        System.out.println();
        
        // 4. 包含boolean字段的对象
        System.out.println("4. 包含boolean字段的对象:");
        BooleanDemo demo = new BooleanDemo();
        System.out.println("   - 对象包含2个boolean字段");
        System.out.println("   - 每个boolean字段占用1字节");
        System.out.println("   - 加上对象头等信息总共约16字节");
        System.out.println();
        
        // 5. 总结
        System.out.println("总结:");
        System.out.println("1. Java语言规范没有明确规定boolean的大小");
        System.out.println("2. Oracle HotSpot JVM实现:");
        System.out.println("   - 单个boolean变量: 1字节 (8位)");
        System.out.println("   - boolean数组元素: 1位 (bit)");
        System.out.println("3. 其他JVM实现可能会有不同");
        System.out.println("4. Boolean包装类对象包含额外开销");
    }
}