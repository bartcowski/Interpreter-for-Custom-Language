package parser.tree.node;

import lombok.Getter;
import lombok.ToString;
import parser.tree.Node;

@Getter
@ToString
public class FunctionParameter implements Node {

    private final String type;

    private final String id;

    public FunctionParameter(String type, String id) {
        this.type = type;
        this.id = id;
    }
}
