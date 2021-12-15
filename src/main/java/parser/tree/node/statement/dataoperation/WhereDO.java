package parser.tree.node.statement.dataoperation;

import lombok.Getter;
import lombok.ToString;
import parser.tree.node.expression.operand.OperandsExpression;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class WhereDO {

    private final List<OperandsExpression> operands = new ArrayList<>();

    public void addOperand(OperandsExpression expression) {
        operands.add(expression);
    }
}
