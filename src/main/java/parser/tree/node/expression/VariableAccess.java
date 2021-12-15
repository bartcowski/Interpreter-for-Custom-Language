package parser.tree.node.expression;

import lombok.Getter;
import lombok.ToString;
import parser.tree.Expression;

@Getter
@ToString
public class VariableAccess implements Expression {

    private final String id;

    public VariableAccess(String id) {
        this.id = id;
    }
}
