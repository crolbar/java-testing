package pkgs;

import java.util.ArrayList;
import java.util.Arrays;

public class Recursion {
    public enum RecursionType {
        Pow,
        PathFind
    };

    public static double pow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        return (n < 0) ? 1 / (x * pow(x, -n - 1)) : x * pow(x, n - 1);
    }

    public static void call(RecursionType rt) {
        if (rt == RecursionType.Pow) {
            double x = 20;
            int n = 10;

            double my = pow(x, n);
            double builtin = Math.pow(x, n);
            System.out.println(my);
            System.out.println(builtin);
            System.out.println(my == builtin);
        } else if (rt == RecursionType.PathFind) {
            PathFind.pathFind();
        }
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Point point = (Point) obj;
        return x == point.x && y == point.y;
    }
}

class PathFind {
    public static void pathFind() {
        String[] maze = {
            "xxxxxxxxxx x",
            "x        x x",
            "x        x x",
            "x xxxxxxxx x",
            "x          x",
            "x xxxxxxxxxx",
        };

        ArrayList<ArrayList<Boolean>> seen = new ArrayList<>();
        ArrayList<Point> listPath = new ArrayList<>();

        // fill with false
        for (int i = 0; i < maze[0].length(); i++) {
            ArrayList<Boolean> list = new ArrayList<>(maze[0].length());
            for (int j = 0; j < maze[0].length(); j++) {
                list.add(false);
            }
            seen.add(list);
        }

        walk(maze, 'x', new Point(10, 0), new Point(1, 5), seen, listPath);

        for (int i = 0; i < listPath.size(); i++) {
            System.out.printf("i: %d, x: %d, y: %d\n", i, listPath.get(i).x, listPath.get(i).y);
        }

        // convert to an [] for assertion
        Point[] path = new Point[listPath.size()];
        for (int i = 0; i < listPath.size(); i++) {
            path[i] = listPath.get(i);
        }

        Point[] mazeTestCase = {
            new Point(10, 0),
            new Point(10, 1),
            new Point(10, 2),
            new Point(10, 3),
            new Point(10, 4),
            new Point(9, 4),
            new Point(8, 4),
            new Point(7, 4),
            new Point(6, 4),
            new Point(5, 4),
            new Point(4, 4),
            new Point(3, 4),
            new Point(2, 4),
            new Point(1, 4),
            new Point(1, 5),
        };
        assert Arrays.equals(path, mazeTestCase);
    }

    public static boolean walk(
            String[] maze,
            char wall,
            Point curr,
            Point end,
            ArrayList<ArrayList<Boolean>> seen,
            ArrayList<Point> path) {
        return false;
    }
}
