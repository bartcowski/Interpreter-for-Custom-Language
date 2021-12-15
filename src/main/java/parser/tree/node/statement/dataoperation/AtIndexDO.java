package parser.tree.node.statement.dataoperation;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AtIndexDO {

    private final int index;

    public AtIndexDO(int index) {
        this.index = index;
    }
}
