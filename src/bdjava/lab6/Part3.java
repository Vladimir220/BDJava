package bdjava.lab6;
import java.io.File;
import java.io.FileWriter;
import java.util.*;

public class Part3 {
    public static void main(String[] args) throws Exception {
        int n = 5;
        Point[] points = new Point[n];
        points[0] = new Point(1, 3);
        points[1] = new Point(2, 2);
        points[2] = new Point(3, 1);
        points[3] = new Point(4, 4);
        points[4] = new Point(5, 5);

        Map<String, List<Point>> map = new HashMap<>();
        // перебираем все точки
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if(i != j) {
                    String key = getLineKey(points[i], points[j]); // ключ для прямой
                    if (!map.containsKey(key)) {
                        map.put(key, new ArrayList<>());
                    }
                    map.get(key).add(points[i]);
                    map.get(key).add(points[j]);
                }
            }
        }


        File file = new File("src/bdjava/lab6/lines.txt");
        FileWriter writer = new FileWriter(file);
        for (Map.Entry<String, List<Point>> entry : map.entrySet()) {
            List<Point> pointsLine = entry.getValue();
            getUniquePoints(pointsLine);
            int count = pointsLine.size();
            writer.write(entry.getKey() + " проходит через " + count + " точек: " + pointsLine.toString() + "\n");
        }
        writer.close();
    }

    public static String getLineKey(Point p1, Point p2) {
        double k = (double) (p1.y - p2.y) / (p1.x - p2.x);
        double b = p1.y - k * p1.x;
        return String.format("y = %.2f x + %.2f", k, b);
    }

    public static void getUniquePoints(List<Point> points) {
        Set<Point> set = new HashSet<>();
        for (Point point : points) {
            set.add(point);
        }
        points.clear();
        points.addAll(set);
    }

    public static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}