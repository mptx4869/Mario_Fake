package entity;


import java.awt.Graphics2D;


import manager.TileManager;
import screen.GamePlayScreen;

public abstract class  Character extends Entity implements Cloneable {

    public int mapX,mapY; // position on map (unit : pixel)
    public int mapX2,mapY2;// retangle crate by (x,y)(x2,y2)

    public int screenX,screenY  ; // position on the screen ( unit pixel)

    public double jumping ;
    public boolean canJump ;
    public int jumpHeight ;
    
    public boolean canMove;
    public boolean down;



    public int blood ;

    public double speed = 0.1;// speed of character
    public String direction;// move direction
    public void action(){

    }
    public  void atack(){};
    
    public boolean checkCollision(int mapX1,int mapX2,int mapY1,int mapY2 ){
        return true;
    }
    public void leftMove(){
        mapX -= speed ;//* GamePlayScreen.tileSize;
        
    }
    public void rightMove(){
        mapX += speed;// * GamePlayScreen.tileSize;
    }
    public void downMove(){
       mapY += speed;//*GamePlayScreen.tileSize;
    }
    public void upMove() {
        mapY-=speed ;//* GamePlayScreen.tileSize;
        
    }
    public void updateMapX2AndY2(){
        mapX2 = mapX +(int) this.scale.width-1;
        mapY2 = mapY +(int) this.scale.height-1;
    }
    public void setMapXY(int mapX,int mapY){
        this.mapX = mapX;
        this.mapY = mapY;
    }
    
    public void setMapX(int mapX) {
        this.mapX = mapX;
    }
    public void setMapY(int mapY) {
        this.mapY = mapY;
    }
    public int getMapX() {
        return mapX;
    }
    public int getMapY() {
        return mapY;
    }
    @Override
    public Character clone() throws CloneNotSupportedException {
        return (Character) super.clone();
    }
}
