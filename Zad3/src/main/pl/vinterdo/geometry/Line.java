package pl.vinterdo.geometry;

public class Line {
    private static final double EPSILON = 0.0001;
    // equation: y = ax + b
    public final double a;
    public final double b;

    @Override
    public String toString() {
        return "Line{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    public Line(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public static Line getFromPoints(Vector2 vec1, Vector2 vec2) {
        double a = vec2.y - vec1.y;
        double b = vec1.x - vec2.x;
        double c = a * (vec1.x) + b * (vec1.y);

        return new Line(a / b, c / b);
    }

    public boolean isOnLine(Vector2 point) {
        return Math.abs(point.y - (a * point.x + b)) < EPSILON;
    }
}
