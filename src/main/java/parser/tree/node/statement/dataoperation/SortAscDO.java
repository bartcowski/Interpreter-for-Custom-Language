package parser.tree.node.statement.dataoperation;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SortAscDO {

    private final String argument;

    public SortAscDO(String argument) {
        this.argument = argument;
    }
}
