package model;

import java.util.function.Function;

public class MemoryButtonHandler implements {
    Function<String, String>[] memoryFunctions;
    final int COUNT_BUTTONS = 5;

    public MemoryButtonHandler(){
        memoryFunctions = new Function[COUNT_BUTTONS];
    }

    public void initializeFunctions(String text){
        memoryFunctions[0] = memoryResponse(text);
    }

    private String memoryResponse(String text){
        return "56";
    }
}
