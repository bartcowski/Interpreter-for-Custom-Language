package parser.tree.node.statement;

import lombok.Getter;
import lombok.ToString;
import parser.tree.Expression;
import parser.tree.Node;
import parser.tree.Statement;
import util.VariableType;

@Getter
@ToString
public class InitStatement implements Node, Statement {

    private final VariableType type;

    private final String id;

    private final Expression assignedExpr;

    public InitStatement(VariableType type, String id, Expression assignedExpr) {
        this.type = type;
        this.id = id;
        this.assignedExpr = assignedExpr;
    }
}
