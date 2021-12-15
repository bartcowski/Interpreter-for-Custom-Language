package parser.tree.node.statement;

import lombok.Getter;
import lombok.ToString;
import parser.tree.Expression;
import parser.tree.Node;
import parser.tree.Statement;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class FunctionCall implements Node, Statement, Expression {

    private final String id;

    private final List<Expression> arguments = new ArrayList<>();

    public FunctionCall(String id) {
        this.id = id;
    }

    public void addArgument(Expression argument) {
        arguments.add(argument);
    }
}
