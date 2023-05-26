package entity;


import java.awt.Graphics2D;


import manager.TileManager;

public abstract class  Character extends Entity {

    public int mapX,mapY; // position on map (unit : pixel)
    public int mapX2,mapY2;// retangle crate by (x,y)(x2,y2)

    public int screenX,screenY  ; // position on the screen ( unit pixel)

    public double boxMapX1, boxMapY1;// position on map (unit: Tile) 1 tile = 30 pixel
    public double boxMapX2,boxMapY2;

    public double jumping ;
    public boolean canJump ;
    public int jumpHeight ;
    
    public boolean canMove;
    public boolean down;



    public int blood ;

    public int speed;// speed of character
    public String direction;// move direction
    public void action(){};
    public  void atack(){};
    
    public boolean checkCollision(int mapX1,int mapX2,int mapY1,int mapY2 ){
        return true;
    }
    public void leftMove(){
       
    }
    public void rightMove(){
        
    }
    public void downMove(){
       
    }
    public void upMove() {
        
        
    }
    public void updateMapX2AndY2(){
        mapX2 = mapX +(int) this.dimension.width-1;
        mapY2 = mapY +(int) this.dimension.height-1;
    }
    // @Override
    // public void abilitries(Character character,  collisionDirection, int mapX, int mapY) {

    // }
}
