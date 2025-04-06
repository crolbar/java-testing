package leetcode.String;

public class _6
{
    public String convert(String s, int numRows)
    {
        if (numRows == 1)
            return s;

        StringBuilder[] lines = new StringBuilder[numRows];
        for (int r = 0; r < numRows; r++) {
            lines[r] = new StringBuilder();
        }

        int j = 0; // next row idx to place in

        // construct by colums, not by rows
        for (int i = 0; i < s.length();) {
            // full column
            if (j == 0) {
                for (int r = 0; r < numRows && i < s.length(); r++) {
                    // lines[r].setCharAt(c, s.charAt(i++));
                    lines[r].append(s.charAt(i++));
                }

                j = (numRows - 1) - 1;
                continue;
            }

            if (i >= s.length())
                break;

            for (int r = 0; r < numRows; r++) {
                if (r == j) {
                    lines[j].append(s.charAt(i++));
                    continue;
                }

                lines[r].append(" ");
            }
            j--;
        }

        for (int r = 0; r < numRows; r++) {
            System.out.println(lines[r].toString());
        }

        StringBuilder out = new StringBuilder();
        for (StringBuilder line : lines) {
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (ch != ' ')
                    out.append(ch);
            }
        }
        return out.toString();
    }
}
