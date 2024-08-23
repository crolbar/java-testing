import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Hello {
    public static String encode(List<String> strs) {
        String res = new String();
        for (int i = 0; i < strs.size(); i++) {
            res += "\"";
            res += strs.get(i);
            res += "\\n\"";
        }
        return res;
    }

    public static List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            int end = i;
            while (!str.substring(end, end+3).equals("\\n\"")) end++;
            res.add(str.substring(i+1, end));
            i = end+2;
        }
        return res;
    }

    public static void main(String[] args) {
        ArrayList<String> strs = new ArrayList<>(Arrays.asList("neet","code","love","you"));

        String enc = encode(strs);
        System.out.printf("enc: '%s'\n", enc);
        System.out.println(decode(enc));
    }
}
