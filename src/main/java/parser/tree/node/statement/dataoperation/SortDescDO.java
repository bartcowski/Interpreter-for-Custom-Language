package parser.tree.node.statement.dataoperation;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SortDescDO {

    private final String argument;

    public SortDescDO(String argument) {
        this.argument = argument;
    }
}
