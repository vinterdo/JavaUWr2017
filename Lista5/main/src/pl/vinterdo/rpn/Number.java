package pl.vinterdo.rpn;

public class Number implements IHasValue {

    private final double value;

    public Number(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }
}
