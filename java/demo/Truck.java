package demo;

/**
 * Truck 类：继承 Vehicle，演示 super、方法重写、多态。
 */
public class Truck extends Vehicle {
    private int load; // 载重量（吨）

    public Truck(String name, int load) {
        super(name);  // 使用 super 调用父类构造
        this.load = load;
    }

    @Override
    public void run() {
        System.out.println("卡车 " + name + " 正在运输货物，载重：" + load + " 吨。");
    }
}
