package demo;

/**
 * 自定义编译时异常（Checked Exception）
 * 需要在方法签名中通过 throws 声明，或者用 try...catch 捕获。
 */
public class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}
