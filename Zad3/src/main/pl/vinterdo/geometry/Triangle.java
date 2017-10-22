package pl.vinterdo.geometry;

import pl.vinterdo.geometry.interfaces.IHasLineSymetry;
import pl.vinterdo.geometry.interfaces.IMovable;
import pl.vinterdo.geometry.interfaces.IRotatable;

public class Triangle implements IMovable<Triangle>, IRotatable<Triangle>, IHasLineSymetry<Triangle> {
    public final Vector2 a;
    public final Vector2 b;
    public final Vector2 c;

    public Triangle(Vector2 a, Vector2 b, Vector2 c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public Triangle flip(Line around) {
        Vector2 newA = a.flip(around);
        Vector2 newB = b.flip(around);
        Vector2 newC = c.flip(around);

        return new Triangle(newA, newB, newC);
    }

    @Override
    public Triangle move(Vector2 vector) {
        Vector2 newA = a.move(vector);
        Vector2 newB = b.move(vector);
        Vector2 newC = c.move(vector);

        return new Triangle(newA, newB, newC);
    }

    @Override
    public Triangle rotate(Vector2 around, double angle) {
        Vector2 newA = a.rotate(around, angle);
        Vector2 newB = b.rotate(around, angle);
        Vector2 newC = c.rotate(around, angle);

        return new Triangle(newA, newB, newC);
    }
}
