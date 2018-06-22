package java_core.NullException;

public class NullException {
    public static void main(String[] args) {
        show();
    }

    public static void show() {
        String test = null;
        test.toString();
    }
}
