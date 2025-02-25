package view.utils;

import javax.swing.JButton;

public class JCalculationButton extends JButton {
    private int positionX;
    private int positionY;

    public JCalculationButton(String title, int positionX, int positionY){
        super(title);
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX(){
        return positionX;
    }

    public int getPositionY(){
        return positionY;
    }

    public void setPositionX(int positionX){
        this.positionX = positionX;
    }

    public void setPositionY(int positionY){
        this.positionY = positionY;
    }
}
