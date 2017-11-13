package pl.vinterdo.rpn;

public interface IFunction {
    int arguments();
    int missingArguments();
    void addArgument(double val) throws RpnException;
}

