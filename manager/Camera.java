package manager;

import java.awt.Dimension;

public class Camera {
    private int width ;
    private int height;
    
    private double x,y;
    private Dimension dimension = new Dimension(width, height);
    public Camera(){
        this.x=0;
        this.y=0;
        
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void moveCamera(double xValue,double yValue){
        x+= xValue;
        y+=yValue;

    }
}
