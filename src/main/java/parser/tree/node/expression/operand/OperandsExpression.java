package parser.tree.node.expression.operand;

import lombok.Getter;
import parser.tree.Expression;

import java.util.ArrayList;
import java.util.List;

@Getter
public abstract class OperandsExpression implements Expression {

    protected final List<Expression> operands = new ArrayList<>();

    public void addOperand(Expression operand) {
        operands.add(operand);
    }
}
