package q1;

/**
 * A class for calculating and displaying the Fibonacci series, defined by the
 * recursive formula F(n) = F(n-1) + F(n-2). An iterative and recursive
 * algorithm are both used. F(0) and F(1) are given on the command line.
 *
 * @author Mike Sherman
 */
public class Fib {

    /**
     * Constructs a Fib object that can calculate and display the Fibonacci
     * series.
     *
     * @param f0 the first number in the Fibonacci series, F(0)
     * @param f1 the second number in the Fibonacci series, F(1)
     */
    public Fib(int f0, int f1) {
        fib0 = f0;
        fib1 = f1;
    }

    /**
     * Calculates F(n) using an iterative algorithm.
     *
     * @param n the n in F(n)
     * @return the result F(n)
     */
    public int f(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        int result = 0;
        int x = fib0;
        int y = fib1;
        for (int i = 0; i <= n; i++) {
            result = x;
            x = y;
            y = result + x;
        }
        return result;
    }

    /**
     * Calculates F(n) using a recursive algorithm.
     *
     * @param n the n in F(n)
     * @return the result F(n)
     */
    public int fRec(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            return fib0;
        }
        if (n == 1) {
            return fib1;
        }
        return fRec(n - 1) + fRec(n - 2);
    }

    /**
     * The main method where the Fibonacci series is calculated and displayed
     * using both algorithms.
     *
     * @param args the command line arguments given for F(0), F(1), and n.
     */
    public static void main(String[] args) {
        try {
            // get numbers F(0) and F(1) from args[0] and args[1].
            int f0 = Integer.parseInt(args[0]);
            int f1 = Integer.parseInt(args[1]);

            // get n from args[2]:
            int n = Integer.parseInt(args[2]);

            if (n < 0) {
                throw new IllegalArgumentException();
            }

            // create a Fib object with params F(0) and F(1)
            Fib fibTester = new Fib(f0, f1);

            // calculate F(0), ..., F(n) and display them using
            // the iterative method
            System.out.println("----------");
            System.out.println("Iterative:");
            System.out.println("----------");

            for (int i = 0; i <= n; i++) {
                System.out.println(fibTester.f(i));
            }

            // calculate F(0), ..., F(n) and display them using
            // the recursive method
            System.out.println("----------");
            System.out.println("Recursive:");
            System.out.println("----------");

            for (int i = 0; i <= n; i++) {
                System.out.println(fibTester.fRec(i));
            }

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Program must be run with 3 arguments: F(0), F(1), and n.");
        } catch (NumberFormatException ex) {
            System.out.println("Arguments F(0) and F(1) must be integers.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Argument n must be a positive integer.");
        } catch (Exception ex) {
            System.out.println("Something went wrong.");
        }

    }

    // instance variables store F(0) and F(1)
    private int fib0;
    private int fib1;
}
