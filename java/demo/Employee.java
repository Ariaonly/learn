package demo;

/**
 * Employee 类：
 * - 继承抽象类 Person
 * - 使用 super 调用父类构造方法
 * - 包含 成员内部类、静态内部类
 * - showInnerUsage 方法中演示局部内部类 & 匿名内部类
 */
public class Employee extends Person {
    private double salary;

    // final 变量：常量，一旦赋值后不能再修改
    public static final String COMPANY_NAME = "Java 核心科技有限公司";

    public Employee(String name, int age, double salary) {
        super(name, age); // super 调用父类构造方法
        this.salary = salary;
    }

    @Override
    public void introduce() {
        System.out.println("我是员工 " + name + "，年龄 " + age + "，工资 " + salary);
    }

    public double getSalary() {
        return salary;
    }

    /**
     * 成员内部类（非静态）：依赖外部类对象存在。
     */
    public class Address {
        private String city;
        private String area;

        public Address(String city, String area) {
            this.city = city;
            this.area = area;
        }

        public String fullAddress() {
            // 可以直接访问外部类的成员变量 name
            return city + " " + area + "，员工：" + name;
        }
    }

    /**
     * 静态内部类：类似“工具类”，不依赖外部类对象。
     */
    public static class IdGenerator {
        private static int currentId = 1000;

        public static int nextId() {
            return ++currentId;
        }
    }

    /**
     * 在方法内部再使用局部内部类、匿名内部类。
     */
    public void showInnerUsage() {
        System.out.println("\n[Employee.showInnerUsage] 内部类进一步演示：");

        // 局部内部类：只在当前方法中有效
        class BonusCalculator {
            double calculate() {
                return salary * 0.2;
            }
        }

        BonusCalculator bc = new BonusCalculator();
        System.out.println("局部内部类计算的奖金：" + bc.calculate());

        // 匿名内部类：实现 Operation 接口的临时对象（减法）
        Operation subtract = new Operation() {
            @Override
            public int apply(int a, int b) {
                System.out.println("Employee 中的匿名内部类（减法）");
                return a - b;
            }
        };

        int result = subtract.apply(50, 30);
        System.out.println("50 - 30 = " + result);
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age +
               ", salary=" + salary + ", company='" + COMPANY_NAME + "'}";
    }
}
