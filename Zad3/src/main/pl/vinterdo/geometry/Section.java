package pl.vinterdo.geometry;

import pl.vinterdo.geometry.interfaces.IHasLineSymetry;
import pl.vinterdo.geometry.interfaces.IMovable;
import pl.vinterdo.geometry.interfaces.IRotatable;

public class Section implements IMovable<Section>, IRotatable<Section>, IHasLineSymetry<Section> {
    public final Vector2 a;
    public final Vector2 b;

    public Section(Vector2 a, Vector2 b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Section flip(Line around) {
        Vector2 newA = a.flip(around);
        Vector2 newB = b.flip(around);
        return new Section(newA, newB);
    }

    @Override
    public Section move(Vector2 vector) {
        Vector2 newA = a.move(vector);
        Vector2 newB = b.move(vector);
        return new Section(newA, newB);
    }

    @Override
    public Section rotate(Vector2 around, double angle) {
        Vector2 newA = a.rotate(around, angle);
        Vector2 newB = b.rotate(around, angle);
        return new Section(newA, newB);
    }
}
