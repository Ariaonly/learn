package demo;

/**
 * 自定义运行时异常（Unchecked Exception）
 * 不强制要求在方法上声明 throws。
 */
public class NegativeSalaryException extends RuntimeException {
    public NegativeSalaryException(String message) {
        super(message);
    }
}
