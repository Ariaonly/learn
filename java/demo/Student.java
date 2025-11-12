package demo;

/**
 * Student 类：继承抽象类 Person。
 */
public class Student extends Person {
    private String major;

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    @Override
    public void introduce() {
        System.out.println("我是学生 " + name + "，年龄 " + age + "，专业：" + major);
    }

    public String getMajor() {
        return major;
    }
}
