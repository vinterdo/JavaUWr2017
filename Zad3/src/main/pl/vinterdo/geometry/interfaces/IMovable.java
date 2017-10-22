package pl.vinterdo.geometry.interfaces;

import pl.vinterdo.geometry.Vector2;

public interface IMovable<T> {
    T move(Vector2 vector);
}
