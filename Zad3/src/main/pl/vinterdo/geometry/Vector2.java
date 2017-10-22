package pl.vinterdo.geometry;

import pl.vinterdo.geometry.interfaces.IHasLineSymetry;
import pl.vinterdo.geometry.interfaces.IMovable;
import pl.vinterdo.geometry.interfaces.IRotatable;

public final class Vector2 implements IMovable<Vector2>, IRotatable<Vector2>, IHasLineSymetry<Vector2> {
    public final double x;
    public final double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Vector2 flip(Line around) {
        double d = (x + (y - around.b) * around.a) / (1 + around.a * around.a);
        double newX = 2 * d - x;
        double newY = 2 * d * around.a - y + 2 * around.b;
        return new Vector2(newX, newY);
    }

    @Override
    public Vector2 move(Vector2 vector) {
        return new Vector2(x + vector.x, y + vector.y);
    }

    @Override
    public Vector2 rotate(Vector2 around, double angle) {
        double sin = Math.sin(angle);
        double cos = Math.cos(angle);

        double originX = x - around.x;
        double originY = y - around.y;

        double xRotated = originX * cos - originY * sin;
        double yRotated = originX * sin + originY * cos;

        double xNew = xRotated + around.x;
        double yNew = yRotated + around.y;

        return new Vector2(xNew, yNew);
    }
}
