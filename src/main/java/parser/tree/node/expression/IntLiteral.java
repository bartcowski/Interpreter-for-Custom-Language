package parser.tree.node.expression;

import lombok.Getter;
import lombok.ToString;
import parser.tree.Expression;

@Getter
@ToString
public class IntLiteral implements Expression {

    private final int value;

    public IntLiteral(int value) {
        this.value = value;
    }
}
