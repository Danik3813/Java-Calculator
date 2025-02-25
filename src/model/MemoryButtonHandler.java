package model;

public class MemoryButtonHandler{
    final private int COUNT_HANDLERS = 5;
    private ButtonHandler[] buttonHandlers;

    public MemoryButtonHandler(){
        buttonHandlers = new ButtonHandler[COUNT_HANDLERS];
        buttonHandlers[0] =  new memoryResponse();
        buttonHandlers[1] = new memoryClear();
        buttonHandlers[2] = new memoryAdd();
        buttonHandlers[3] = new memorySubtract();
        buttonHandlers[4] = new memorySet();
    }

    public String memoryApply(String text, int positionX){
        return buttonHandlers[positionX].apply(text);
    }
}

class memoryResponse implements ButtonHandler{
    public String apply(String text)
    {
        return null;
    }   
}

class memoryClear implements ButtonHandler{
    public String apply(String text){
        return null;
    }
}

class memoryAdd implements ButtonHandler{
    public String apply(String text){
        return null;
    }
}

class memorySubtract implements ButtonHandler{
    public String apply(String text){
        return null;
    }
}

class memorySet implements ButtonHandler{
    public String apply(String text){
        return null;
    }
}
