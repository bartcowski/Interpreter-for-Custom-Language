package parser.tree.node.statement.dataoperation;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class SelectDO {

    private final List<String> dataIds = new ArrayList<>();

    public void addDataId(String id) {
        dataIds.add(id);
    }
}
