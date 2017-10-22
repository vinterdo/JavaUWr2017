package pl.vinterdo.geometry.interfaces;

import pl.vinterdo.geometry.Vector2;

public interface IRotatable<T> {
    T rotate(Vector2 around, double angle);
}
