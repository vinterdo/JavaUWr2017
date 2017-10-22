package pl.vinterdo.geometry;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class Vector2Test {
    @Test
    public void moveTest1() {
        Vector2 p1 = new Vector2(10, 20);
        Vector2 p2 = new Vector2(10, 10);

        assertThat(p1.move(p2), is(new Vector2(20, 30)));
    }

    @Test
    public void moveTest2() {
        Vector2 p1 = new Vector2(10, 20);
        Vector2 p2 = new Vector2(-10, -10);

        assertThat(p1.move(p2), is(new Vector2(0, 10)));
    }

    @Test
    public void moveTest3() {
        Vector2 p1 = new Vector2(10, 20);
        Vector2 p2 = new Vector2(0, 0);

        assertThat(p1.move(p2), is(new Vector2(10, 20)));
    }

    @Test
    public void flipTest1() {
        Vector2 p1 = new Vector2(10, 20);
        Line around = new Line(1, 10);
        assertThat(p1.flip(around), is(new Vector2(10, 20)));
    }

    @Test
    public void flipTest2() {
        Vector2 p1 = new Vector2(10, 10);
        Line around = new Line(1, 10);
        assertThat(p1.flip(around), is(new Vector2(0, 20)));
    }

    @Test
    public void flipTest3() {
        Vector2 p1 = new Vector2(-10, -20);
        Line around = new Line(0, 10);
        assertThat(p1.flip(around), is(new Vector2(-10, 40)));
    }

    @Test
    public void rotateTest1() {
        Vector2 p1 = new Vector2(10, 10);
        Vector2 around = new Vector2(0, 0);
        assertThat(p1.rotate(around, Math.PI / 2.0), is(new Vector2(-10, 10)));
    }

    @Test
    public void rotateTest2() {
        Vector2 p1 = new Vector2(10, 10);
        Vector2 around = new Vector2(0, 0);
        assertThat(p1.rotate(around, 0), is(new Vector2(10, 10)));
    }

    @Test
    public void rotateTest3() {
        Vector2 p1 = new Vector2(10, -10);
        Vector2 around = new Vector2(0, 0);
        assertThat(p1.rotate(around, -Math.PI), is(new Vector2(-10, 10))); // this fail due to numerical error, rewrite to use assert.equals with doubles
    }
}