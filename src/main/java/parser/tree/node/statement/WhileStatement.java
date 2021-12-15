package parser.tree.node.statement;

import lombok.Getter;
import lombok.ToString;
import parser.tree.Node;
import parser.tree.Statement;
import parser.tree.node.StatementsBlock;
import parser.tree.node.expression.operand.OperandsExpression;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class WhileStatement implements Node, Statement {

    private final List<OperandsExpression> operands = new ArrayList<>();

    private final StatementsBlock whileBlock;

    public WhileStatement(StatementsBlock whileBlock) {
        this.whileBlock = whileBlock;
    }

    public void addOperand(OperandsExpression expression) {
        operands.add(expression);
    }
}
