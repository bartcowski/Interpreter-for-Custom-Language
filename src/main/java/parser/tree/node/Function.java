package parser.tree.node;

import lombok.Getter;
import lombok.ToString;
import parser.tree.Node;
import util.FunctionReturnType;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Function implements Node {

    private final FunctionReturnType returnType;

    private final StatementsBlock statementsBlock;

    private final List<FunctionParameter> parameters = new ArrayList<>();

    public Function(FunctionReturnType returnType, StatementsBlock statementsBlock) {
        this.returnType = returnType;
        this.statementsBlock = statementsBlock;
    }

    public void addParameter(FunctionParameter functionParameter) {
        parameters.add(functionParameter);
    }
}
