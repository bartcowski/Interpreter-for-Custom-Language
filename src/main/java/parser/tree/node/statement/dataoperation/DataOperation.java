package parser.tree.node.statement.dataoperation;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import parser.tree.Expression;
import parser.tree.Node;
import parser.tree.Statement;

@Builder
@Getter
@ToString
public class DataOperation implements Node, Statement, Expression {

    private final SelectDO select;

    private final WhereDO where;

    private final AtIndexDO atIndex;

    private final SortAscDO sortAsc;

    private final SortDescDO sortDesc;

    private final SumDO sum;

    private final AverageDO average;

    private final CountDO count;
}
