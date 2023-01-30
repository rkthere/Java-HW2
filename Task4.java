import java.util.logging.Level;
import java.util.logging.Logger;

public class Task4 {
    private static final Logger logger = Logger.getLogger(Task3.class.getName());

    public static void main(String[] args) {
        int a;
        int b;
        String op;

        System.out.println("Please enter two numbers:");
        a = Integer.parseInt(System.console().readLine());
        b = Integer.parseInt(System.console().readLine());
        System.out.println("Please enter an operation (+ - / *):");
        op = System.console().readLine();

        int result = 0;
        if (op.equals("+")) {
            result = a + b;
        } else if (op.equals("-")) {
            result = a - b;
        } else if (op.equals("/")) {
            result = a / b;
        } else if (op.equals("*")) {
            result = a * b;
        } else {
            System.out.println("Invalid operation!");
            logger.log(Level.WARNING, "Invalid operation entered: {0}", op);
        }
        System.out.println("Result: " + result);
        logger.log(Level.INFO, "Result of operation {0} on numbers {1} and {2}: {3}", new Object[]{op, a, b, result});
    }
}
