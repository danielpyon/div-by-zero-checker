import org.checkerframework.checker.dividebyzero.qual.*;

class AdditionalTests {
    public static void testZeroSum() {
        int x = 21;
        int y = -21;
        
        // :: error: divide.by.zero
        int z = 42 / (x + y);

        int a = 32;
        int b = 32;
        // :: error: divide.by.zero
        int c = x / (a - b);

        // this is kind of a weird case, but there should be an error, because
        // ADD(positive, negative) = T, and there is a possibility of divide by
        // zero.
        a = 123;
        b = -456;
        // :: error: divide.by.zero
        int d = 0 / (a + b);
    }

    public static void testZeroByZero() {
        int x = 0;
        int y = 0;
        // :: error: divide.by.zero
        int z = x / y;

        // :: error: divide.by.zero
        int a = 0 / 0;
        // :: error: divide.by.zero
        int b = x / 0;
        // :: error: divide.by.zero
        int c = 0 / y;
    }

    public static void testUseBottom() {
        int x = 0;
        // :: error: divide.by.zero
        int y = x / x;

        // no error should be here
        int z = x / y;
    }
}
