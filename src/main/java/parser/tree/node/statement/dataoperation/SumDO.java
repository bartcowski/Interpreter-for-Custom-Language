package parser.tree.node.statement.dataoperation;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SumDO {

    private final String argument;

    public SumDO(String argument) {
        this.argument = argument;
    }
}
