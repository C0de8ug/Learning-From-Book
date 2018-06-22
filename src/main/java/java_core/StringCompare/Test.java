package java_core.StringCompare;

public class Test {
    static String oneThousandStatic = "1000";
    public static void main(String[] args){
        String one = "1";
        String two = "2";
        String one2 = "1";
        String oneThousand = "1000";
        String newStr = new String("1");
        String plusStr = one + "000";
        String longStr = "ajklsdjfklasdjfkl;sdjf;aklsdfja;lksdfjalsdk;jdslkghoiquroi";
        String longStr2 = "ajklsdjfklasdjfkl;sdjf;aklsdfja;lksdfjalsdk;jdslkghoiquroi";

        System.out.println(one == one2);
        System.out.println(one == two);
        System.out.println(one == newStr);
        System.out.println(oneThousand == plusStr);
        System.out.println(oneThousand == oneThousandStatic);
        System.out.println(longStr == longStr2);

    }
}
