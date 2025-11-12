package demo;

public class Dog implements Animal {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void makeSound() {
        System.out.println("狗 " + name + "：汪汪汪！ (来自 " + KINGDOM + ")");
    }

    @Override
    public void move() {
        System.out.println("狗 " + name + " 飞奔起来。");
    }
}
