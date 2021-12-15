package parser.tree.node.statement;

import lombok.Getter;
import lombok.ToString;
import parser.tree.Expression;
import parser.tree.Node;
import parser.tree.Statement;

@Getter
@ToString
public class ReturnStatement implements Node, Statement {

    private final Expression returnExpression;

    public ReturnStatement(Expression returnExpression) {
        this.returnExpression = returnExpression;
    }
}
