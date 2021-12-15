package parser.tree.node.statement;

import lombok.Getter;
import lombok.ToString;
import parser.tree.Expression;
import parser.tree.Node;
import parser.tree.Statement;

@Getter
@ToString
public class AssignStatement implements Node, Statement {

    private final String id;

    private final Expression assignedExpr;

    public AssignStatement(String id, Expression assignedExpr) {
        this.id = id;
        this.assignedExpr = assignedExpr;
    }
}
