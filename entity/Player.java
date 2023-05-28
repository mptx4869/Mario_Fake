package entity;

import java.awt.Graphics2D;

import manager.Camera;
import screen.GamePlayScreen;
import screen.InputHandler;

public class Player extends Character{
    public Character hero ;
    
    InputHandler inputHandler;
    private long drawTime =0;
    Camera playerCamera;
    public Player (Character character,InputHandler inputHandler){
        this.hero = character;
        this.inputHandler = inputHandler;
        this.images = hero.images;
        imageDraw = 0;
        this.screenX = 0;
        this.screenY = 0 ;
    }
    public void setInputHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }
    public void setPlayerCamera(Camera camera){
        this.playerCamera = camera;
    }
    @Override
    public void action() {
        if(inputHandler.leftPress) leftMove();
        if(inputHandler.rightPress) rightMove();
        if(inputHandler.jumpPress) upMove();
        if(inputHandler.downPress)downMove();
    }
    @Override
    public void leftMove() {
        if(imageDraw != 1 && imageDraw != 0 ) {
            imageDraw = 0;
            drawTime = System.nanoTime();
        }
        else
            if( System.nanoTime() - drawTime> 1e9/15 ){
                if(imageDraw == 0){
                    imageDraw =1;
                    drawTime = System.nanoTime();
                }
                else
                    imageDraw = 0;
                drawTime = System.nanoTime();
            }
        super.leftMove();
        playerCamera.moveCamera(-speed, 0);
    }
    @Override
    public void rightMove() {
        if(imageDraw != 2 && imageDraw != 3 ) {
            imageDraw = 3;
            drawTime = System.nanoTime();
        }
        else
            if( System.nanoTime() - drawTime> 1e9/15 ){
                if(imageDraw == 2)imageDraw =3;
                else
                    imageDraw = 2;
                drawTime = System.nanoTime();
            }
        super.rightMove();
        playerCamera.moveCamera(0, speed);
    }
    @Override
    public void upMove() {
        super.upMove();
    }
    @Override
    public void downMove() {
        super.downMove();
    }
    @Override
    public void draw(Graphics2D g2, int screenX, int screenY) {
        
        g2.drawImage(images[imageDraw],this.screenX,this.screenY,scale.width* GamePlayScreen.tileSize , scale.height*GamePlayScreen.tileSize,null);
        //System.out.println(this.screenX+" " +this.screenY);
    }
    
}
