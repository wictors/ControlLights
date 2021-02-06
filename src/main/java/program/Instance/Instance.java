package program.Instance;

import program.Model.Variables;

public enum Instance {
    INSTANCE;
    private Variables variables;
    //todo - instance of OpenLab

    public Variables getVariables(){
        if(variables == null){
            variables = new Variables();
        }
        return variables;
    }
}
