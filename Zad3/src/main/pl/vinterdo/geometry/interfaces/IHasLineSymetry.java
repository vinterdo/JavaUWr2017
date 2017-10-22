package pl.vinterdo.geometry.interfaces;

import pl.vinterdo.geometry.Line;

public interface IHasLineSymetry<T> {
    T flip(Line around);
}
