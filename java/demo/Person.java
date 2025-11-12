package demo;

/**
 * 抽象类 Person：不能直接创建对象，只能被继承。
 * 包含普通方法 + 抽象方法。
 */
public abstract class Person {
    // 使用 protected，让子类可以访问
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;  // this 关键字访问当前对象的成员变量
        this.age = age;
    }

    // 抽象方法：只声明，不写方法体；由子类重写实现。
    public abstract void introduce();

    // 普通方法：子类可以直接使用或重写
    public void sayHello() {
        System.out.println("大家好，我是 " + name);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + '\'' + ", age=" + age + '}';
    }
}
