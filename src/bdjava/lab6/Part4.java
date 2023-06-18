package bdjava.lab6;

import java.util.*;

import static java.lang.System.out;

public class Part4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        out.print("Введите количество отрезков: ");
        int n = scanner.nextInt();
        TreeMap<Integer, List<Segment>> map = new TreeMap<>();

        for (int i = 1; i <= n; i++) {
            out.print("Введите координаты начала и конца отрезка №" + i + ": ");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            Segment s = new Segment(a, b, c, d);
            int minX = Math.min(a, c);
            if (!map.containsKey(minX)) {
                map.put(minX, new ArrayList<>());
            }
            map.get(minX).add(s);
        }

        Point minPoint = null;
        List<Segment> segments = null;
        Map.Entry<Integer, List<Segment>> entry = map.firstEntry();
        while (entry != null) {
            List<Segment> currentSegments = entry.getValue();
            if (currentSegments.size() > 1) {
                for (int i = 0; i < currentSegments.size(); i++) {
                    for (int j = i + 1; j < currentSegments.size(); j++) {
                        Point p = currentSegments.get(i).intersect(currentSegments.get(j));
                        if (minPoint == null || p.x < minPoint.x) {
                            minPoint = p;
                            segments = new ArrayList<>();
                            segments.add(currentSegments.get(i));
                            segments.add(currentSegments.get(j));
                        }
                    }
                }
            }
            entry = map.higherEntry(entry.getKey());
        }

        if (minPoint != null) {
            out.println("Точка пересечения двух отрезков с минимальной абсциссой: " + minPoint);
            out.println("Отрезки, содержащие данную точку:");
            for (Segment s : segments) {
                out.println(s);
            }
        } else {
            out.println("Таких отрезков нет.");
        }
    }

    static class Point {
        float x, y;

        public Point(float x, float y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    static class Segment {
        int x1, y1, x2, y2;

        public Segment(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
        public Point intersect(Segment other) {
            ArrayList<Integer> lx = new ArrayList<Integer>(Arrays.asList(x1,x2,other.x1,other.x2));
            ArrayList<Integer> ly = new ArrayList<Integer>(Arrays.asList(y1,y2,other.y1,other.y2));
            float k1 = (y2-y1)/(x2-x1);
            float k2 = (other.y2-other.y1)/(other.x2-other.x1);
            float x = (y1 - other.y1 + k2 * other.x1 - k1 * x1) / (k2 - k1);
            float y = k1 * (x - x1) + y1;
            if ((x >= Collections.min(lx) || x <= Collections.max(lx)) && (y >= Collections.min(ly) || y <= Collections.max(ly)))
                return new Point(x, y);
            else
                return null;
        }
        @Override
        public String toString() {
            return "(" + x1 + ", " + y1 + ") - (" + x2 + ", " + y2 + ")";
        }
    }
}