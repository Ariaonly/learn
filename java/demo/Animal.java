package demo;

/**
 * 接口 Animal
 * - 只有常量和抽象方法（以及 JDK8+ 的默认方法/静态方法）
 * - 用来演示“接口的多态 + 多实现”
 */
public interface Animal {
    // 接口中的变量默认是 public static final
    String KINGDOM = "动物界";

    void makeSound();  // 抽象方法：发出叫声

    default void move() {
        System.out.println("动物在移动...");
    }
}
