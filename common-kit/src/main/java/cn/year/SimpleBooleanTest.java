package cn.year;

public class SimpleBooleanTest {
    boolean b1;
    
    public static void main(String[] args) {
        System.out.println("Java中boolean类型大小测试");
        
        // 测试boolean数组的大小
        for (int i = 0; i <= 8; i++) {
            boolean[] arr = new boolean[i];
            System.out.println("boolean数组长度: " + i + ", 数组对象引用大小通常为: " + getObjectReferenceSize() + " 字节");
        }
        
        // 展示boolean在对象中的占用情况
        System.out.println("\n在Java中:");
        System.out.println("1. 单个boolean变量在内存中通常占用 1 字节 (8位)");
        System.out.println("2. boolean数组中每个元素可以优化为只占用 1 位 (bit)");
        System.out.println("3. 但这取决于具体的JVM实现");
        
        // 创建不同包含boolean的对象
        showBooleanUsage();
    }
    
    private static void showBooleanUsage() {
        System.out.println("\n验证说明:");
        System.out.println("根据Java虚拟机规范:");
        System.out.println("- boolean类型被定义为具有true和false两个值");
        System.out.println("- 但具体占用多少位/字节并未明确规定");
        System.out.println("- 在Oracle HotSpot JVM中:");
        System.out.println("  * 单个boolean变量通常占用1个字节(8位)");
        System.out.println("  * boolean数组中的每个元素只占用1位");
        System.out.println("- 不同JVM实现可能会有不同行为");
    }
    
    private static int getObjectReferenceSize() {
        // 在32位JVM上通常是4字节，在64位JVM上通常是8字节(开启压缩指针后是4字节)
        return 4; // 简化处理
    }
}