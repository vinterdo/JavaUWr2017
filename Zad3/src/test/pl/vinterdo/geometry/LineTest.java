package pl.vinterdo.geometry;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LineTest {
    @Test
    public void perpendicularCheckTest() {
        Line a = new Line(0.5, 20);
        Line b = new Line(-2, 999);
        assertTrue(a.isPerpendicular(b));
    }

    @Test
    public void collateralCheckTest() {
        Line a = new Line(0.5, 20);
        Line b = new Line(0.5, 999);
        assertTrue(a.isCollateral(b));
    }

    @Test
    public void lineFromPointsTest1() {
        Vector2 p1 = new Vector2(10, 10);
        Vector2 p2 = new Vector2(20, 20);
        assertThat(Line.getFromPoints(p1, p2), is(new Line(1, 0)));
    }

    @Test
    public void lineFromPointsTest2() {
        Vector2 p1 = new Vector2(0, 10);
        Vector2 p2 = new Vector2(10, 50);
        assertThat(Line.getFromPoints(p1, p2), is(new Line(4, 10)));
    }

    @Test
    public void checkIfPointIsOnLineTest() {
        Line l = new Line(2, 10);
        Vector2 p = new Vector2(10, 30);
        assertTrue(l.isOnLine(p));
    }
}