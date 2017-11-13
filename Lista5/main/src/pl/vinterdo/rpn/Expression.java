package pl.vinterdo.rpn;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Expression {
    private final Queue<IHasValue> symbols;
    private final Stack<Double> evaluated;
    private final HashMap<String, Double> variables;

    private Expression(Queue<IHasValue> symbols, HashMap<String, Double> variables) {
        this.symbols = symbols;
        this.variables = variables;
        this.evaluated = new Stack<>();
    }

    public double evaluate() {
        return 0;
    }

    public static Expression parse(String rpn, HashMap<String, Double> variables) {
        Queue<IHasValue> symbols = new PriorityQueue<>();

        return new Expression(symbols, variables);
    }
}
