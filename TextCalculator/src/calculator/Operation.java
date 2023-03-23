package calculator;

public class Operation
{
    public static int performOperation(final char op, final int left, final int right) {
        if (op == '+') {
            return left + right;
        }
        if (op == '-') {
            return left - right;
        }
        if (op == '*') {
            return left * right;
        }
        if (op == '/') {
            return left / right;
        }
        throw new IllegalArgumentException("operation needs either +, -, *, or /");
    }
}