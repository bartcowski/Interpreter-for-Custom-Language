package parser.tree.node.statement.dataoperation;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AverageDO {

    private final String argument;

    public AverageDO(String argument) {
        this.argument = argument;
    }
}
