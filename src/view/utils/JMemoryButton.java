package view.utils;

import javax.swing.JButton;

public class JMemoryButton extends JButton {
    private int positionX;

    public JMemoryButton(String title, int positionX){
        super(title);
        this.positionX = positionX;
    }

    public void setPositionX(int positionX){
        this.positionX = positionX;
    }

    public int getPositionX(){
        return positionX;
    }
}