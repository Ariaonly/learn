package demo;

/**
 * 函数式接口：只有一个抽象方法的接口。
 * 可以被 Lambda、匿名内部类实现。
 */
@FunctionalInterface
public interface Operation {
    int apply(int a, int b);

    // 如果再多写一个抽象方法，就不再是函数式接口了。
}
