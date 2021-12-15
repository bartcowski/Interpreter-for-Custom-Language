package parser.tree.node.expression;

import lombok.Getter;
import lombok.ToString;
import parser.tree.Expression;

@Getter
@ToString
public class DoubleLiteral implements Expression {

    private final double value;

    public DoubleLiteral(double value) {
        this.value = value;
    }
}
