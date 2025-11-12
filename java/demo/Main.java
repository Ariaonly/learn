package demo;

/**
 * 主程序:依次演示
 * 1）异常的抛出、捕获、throws
 * 2）继承、抽象类、接口、多态
 * 3）内部类（成员、静态、局部、匿名）和 Lambda
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("==== Java 核心知识点综合小项目 ====");

        try {
            exceptionDemo();          // 1. 异常演示
        } catch (InvalidAgeException e) {
            System.out.println("在 main 中再次捕获到 InvalidAgeException: " + e.getMessage());
        } finally {
            System.out.println("main 的 finally:异常演示结束。\n");
        }

        polymorphismDemo();           // 2. 抽象类、接口、多态、super/this
        innerClassAndLambdaDemo();    // 3. 各种内部类 + Lambda
    }

    /**
     * 演示:
     * - throw 手动抛出异常
     * - throws 向上声明可能抛出的异常
     * - 编译时异常 / 运行时异常
     * - try / catch / finally
     */
    private static void exceptionDemo() throws InvalidAgeException {
        System.out.println("---- 1. 异常处理演示 ----");

        try {
            // 这里可能抛出“编译时异常”，必须要么捕获，要么继续 throws
            Employee e = createEmployee("张三", 15, 8000);
            System.out.println("创建成功:" + e);
        } catch (InvalidAgeException e) { // 捕获编译时异常
            System.out.println("在 exceptionDemo 中捕获到年龄异常:" + e.getMessage());
            // 抛给上一级 main 再处理一次
            throw e;
        } catch (NegativeSalaryException e) { // 捕获运行时异常，可捕获也可以不捕获
            System.out.println("工资异常:" + e.getMessage());
        } finally {
            System.out.println("exceptionDemo 的 finally:无论是否异常都会执行。");
        }

        // 演示运行时异常（除数为 0）
        try {
            int x = 10 / 0; // 会抛出 ArithmeticException（运行时异常）
        } catch (ArithmeticException e) {
            System.out.println("捕获到 ArithmeticException（除数为 0）:" + e.getMessage());
        }
    }

    /**
     * 创建 Employee 的工厂方法:
     * - 年龄非法时，throw 一个编译时异常 InvalidAgeException
     * - 工资为负时，throw 一个运行时异常 NegativeSalaryException
     */
    private static Employee createEmployee(String name, int age, double salary)
            throws InvalidAgeException {

        if (age < 18 || age > 65) {
            // 编译时异常，必须 throws
            throw new InvalidAgeException("年龄必须在 18~65 之间，当前为:" + age);
        }
        if (salary < 0) {
            // 运行时异常，不强制 throws
            throw new NegativeSalaryException("工资不能为负数:" + salary);
        }
        return new Employee(name, age, salary);
    }

    /**
     * 演示抽象类、接口、多态、super、方法重写等
     */
    private static void polymorphismDemo() {
        System.out.println("\n---- 2. 抽象类 / 接口 / 多态 演示 ----");

        // 抽象类 Person 不能直接 new，只能通过子类实例
        Person p1 = new Employee("李四", 30, 12000);
        Person p2 = new Student("王五", 20, "计算机专业");

        p1.introduce(); // 运行时多态:实际调用 Employee 的实现
        p2.introduce(); // 实际调用 Student 的实现

        // 接口多态:同一个 Animal 引用指向不同实现类
        Animal a1 = new Cat("小花");
        Animal a2 = new Dog("大黄");
        a1.makeSound();
        a2.makeSound();

        // Vehicle 抽象类 + Truck 子类
        Vehicle truck = new Truck("重型卡车", 10);
        truck.start();
        truck.run();
        truck.stop();
    }

    /**
     * 演示:
     * - 成员内部类、静态内部类
     * - 局部内部类
     * - 匿名内部类
     * - Lambda 表达式（函数式接口）
     */
    private static void innerClassAndLambdaDemo() {
        System.out.println("\n---- 3. 内部类 + Lambda 演示 ----");

        Employee emp = new Employee("赵六", 28, 15000);

        // 3.1 使用成员内部类（非静态）
        Employee.Address addr = emp.new Address("北京", "海淀区");
        System.out.println("员工地址:" + addr.fullAddress());

        // 3.2 使用静态内部类
        int newId = Employee.IdGenerator.nextId();
        System.out.println("通过静态内部类生成的员工编号:" + newId);

        // 3.3 局部内部类（在方法内部定义类）
        class SimpleLogger {
            void log(String msg) {
                System.out.println("[局部内部类 Logger] " + msg);
            }
        }
        SimpleLogger logger = new SimpleLogger();
        logger.log("这是局部内部类的示例。");

        // 3.4 匿名内部类:用接口直接 new 一个没有名字的实现类
        Operation multiply = new Operation() {
            @Override
            public int apply(int a, int b) {
                System.out.println("匿名内部类实现 Operation（乘法）");
                return a * b;
            }
        };
        int r1 = multiply.apply(3, 4);
        System.out.println("3 * 4 = " + r1);

        // 3.5 Lambda 表达式:实现同一个函数式接口（加法）
        Operation add = (a, b) -> {
            System.out.println("Lambda 实现 Operation（加法）");
            return a + b;
        };
        int r2 = add.apply(10, 20);
        System.out.println("10 + 20 = " + r2);

        // 3.6 使用 Employee 中的方法，内部再创建局部/匿名内部类
        emp.showInnerUsage();
    }
}
