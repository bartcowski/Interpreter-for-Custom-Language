package parser.tree.node.expression;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class StringLiteral {

    private final String value;

    public StringLiteral(String value) {
        this.value = value;
    }
}
