package pl.vinterdo.geometry;

import pl.vinterdo.geometry.interfaces.IMovable;

public class Line implements IMovable<Line>{
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

        return new Line(-a / b, c / b);
    }

    public boolean isOnLine(Vector2 point) {
        return Math.abs(point.y - (a * point.x + b)) < EPSILON;
    }

    @Override
    public Line move(Vector2 vector) {
        double toAdd = vector.y + a * vector.x;
        return new Line(a, b + toAdd);
    }

    public boolean isCollateral(Line other) {
        return a == other.a;
    }

    public boolean isPerpendicular(Line other) {
        return a * other.a == -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (Double.compare(line.a, a) != 0) return false;
        return Double.compare(line.b, b) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(a);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(b);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
