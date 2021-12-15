package parser.tree.node;

import lombok.Getter;
import lombok.ToString;
import parser.tree.Node;
import parser.tree.Statement;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class StatementsBlock implements Node {

    private final List<Statement> statements = new ArrayList<>();

    public void addStatement(Statement statement) {
        statements.add(statement);
    }
}
