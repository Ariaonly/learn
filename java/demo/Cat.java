package demo;

public class Cat implements Animal {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println("猫 " + name + "：喵喵喵~  (来自 " + KINGDOM + ")");
    }

    @Override
    public void move() {
        System.out.println("猫 " + name + " 轻盈地走路。");
    }
}
