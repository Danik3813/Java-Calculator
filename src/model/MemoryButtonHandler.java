package model;

import controller.file_handlers.ConfigHandler;;

public class MemoryButtonHandler{
    final private int COUNT_HANDLERS = 5;
    private MemoryHandler[] memoryHandlers;

    public MemoryButtonHandler(){
        memoryHandlers = new MemoryHandler[COUNT_HANDLERS];
        memoryHandlers[0] = new MemoryClear();
        memoryHandlers[1] = new MemoryResponse();
        memoryHandlers[2] = new MemoryAdd();
        memoryHandlers[3] = new MemorySubtract();
        memoryHandlers[4] = new MemorySet();
    }

    public String memoryApply(String text, int positionX, ConfigHandler configHandler){
        return memoryHandlers[positionX].apply(text, configHandler);
    }
}

class MemoryClear implements MemoryHandler{
    public String apply(String text, ConfigHandler configHandler){
        configHandler.setMemoryData(null);
        return "0";
    }
}

class MemoryResponse implements MemoryHandler{
    public String apply(String text, ConfigHandler configHandler)
    {
        return "" + configHandler.getMemoryData();
    }   
}

class MemoryAdd implements MemoryHandler{
    public String apply(String text, ConfigHandler configHandler){
        return null;
    }
}

class MemorySubtract implements MemoryHandler{
    public String apply(String text, ConfigHandler configHandler){
        return null;
    }
}

class MemorySet implements MemoryHandler{
    public String apply(String text, ConfigHandler configHandler){
        return null;
    }
}
