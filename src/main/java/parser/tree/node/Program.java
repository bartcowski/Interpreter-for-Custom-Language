package parser.tree.node;

import lombok.Getter;
import lombok.ToString;
import parser.tree.Node;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Program implements Node {

    private final List<Function> functions = new ArrayList<>();

    public void addFunction(Function function) {
        functions.add(function);
    }
}
