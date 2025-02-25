package model;

import controller.file_handlers.ConfigHandler;;

public class MemoryButtonHandler{
    final private int COUNT_HANDLERS = 5;
    private ButtonHandler[] buttonHandlers;

    public MemoryButtonHandler(){
        buttonHandlers = new ButtonHandler[COUNT_HANDLERS];
        buttonHandlers[0] = new MemoryClear();
        buttonHandlers[1] =  new MemoryResponse();
        buttonHandlers[2] = new MemoryAdd();
        buttonHandlers[3] = new MemorySubtract();
        buttonHandlers[4] = new MemorySet();
    }

    public String memoryApply(String text, int positionX, ConfigHandler configHandler){
        return buttonHandlers[positionX].apply(text, configHandler);
    }
}

class MemoryClear implements ButtonHandler{
    public String apply(String text, ConfigHandler configHandler){
        configHandler.setMemoryData(0);
        return "0";
    }
}

class MemoryResponse implements ButtonHandler{
    public String apply(String text, ConfigHandler configHandler)
    {
        return "" + configHandler.getMemoryData();
    }   
}

class MemoryAdd implements ButtonHandler{
    public String apply(String text, ConfigHandler configHandler){
        return null;
    }
}

class MemorySubtract implements ButtonHandler{
    public String apply(String text, ConfigHandler configHandler){
        return null;
    }
}

class MemorySet implements ButtonHandler{
    public String apply(String text, ConfigHandler configHandler){
        return null;
    }
}
