package demo;

/**
 * 抽象父类 Vehicle：
 * - 抽象方法 run()
 * - 普通方法 start(), stop()
 * - final 方法：子类不能重写
 */
public abstract class Vehicle {
    protected String name;

    public Vehicle(String name) {
        this.name = name;
    }

    // 抽象方法：不同子类有不同的行驶方式
    public abstract void run();

    public void start() {
        System.out.println(name + " 启动发动机。");
    }

    // final 方法：子类不能重写
    public final void stop() {
        System.out.println(name + " 停止。");
    }
}
