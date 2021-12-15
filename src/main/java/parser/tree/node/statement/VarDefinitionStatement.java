package parser.tree.node.statement;

import lombok.Getter;
import lombok.ToString;
import parser.tree.Node;
import parser.tree.Statement;
import util.VariableType;

@Getter
@ToString
public class VarDefinitionStatement implements Node, Statement {

    private final VariableType type;

    private final String id;

    public VarDefinitionStatement(VariableType type, String id) {
        this.type = type;
        this.id = id;
    }
}
