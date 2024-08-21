public class Hello {
    public static void main(String[] args) {
        var num = 2;
        String str = "my str";
        byte b = (byte) 126;

        System.out.println(String.format("num: %d, str: %s, b: %d", num, str.charAt(0), b));

        for (int i = 0; i < str.length(); i++) {
            b = (byte) str.charAt(i);
            System.out.println(String.format("n: %d, b: %d, c: '%d'", i, b, (char) b));
        }
    }
}
