package manager;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.text.Position;

import entity.Player;
import entity.Tile;
import screen.GamePlayScreen;
import screen.InputHandler;
import entity.Character;
public class GamePlay {
    
    InputHandler inputHandler;

    Map mapChoosen;
    

    Player player ;
    ArrayList<Character> dynamicEnity = new ArrayList<>();
    Camera camera ;
    public GamePlayScreen gamePlayScreen;
    public GamePlay(Map mapchoosen){
        this.mapChoosen = mapchoosen;
        player = new Player(HeroManager.heros.get(0),inputHandler);
        player.setMapXY(mapchoosen.spawnPositionX, mapchoosen.spawnPosintionY);
        


    }
    public void setScreenPosition(){
        player.screenX = gamePlayScreen.WIDTH/2;
        player.screenY = gamePlayScreen.WIDTH/2;
    }
    public void update(){
        player.action();
    }
     
    public void setDynamicEntity(){
        for(int i=0;i<mapChoosen.map.size();i++)
            for(int j=0;j<mapChoosen.map.get(i).size();j++){
                int enemyNum = mapChoosen.map.get(i).get(j);
                enemyNum = Math.abs(enemyNum);
                try {
                    Character newEnemy = EnemyManager.enemies.get(enemyNum).clone();
                    newEnemy.setMapXY(j, i);
                    dynamicEnity.add(newEnemy);
                } catch (CloneNotSupportedException e) {
                    System.out.println("ERRO: can not crate clone of enemynum" + enemyNum);
                    e.printStackTrace();
                }
            }

    }
    public void setCamera(Camera camera) {
        this.camera = camera;
        this.player.setPlayerCamera(camera);
    }
    public void setInputHandler(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
        this.player.setInputHandler(inputHandler);
    }
    public void draw(Graphics2D g2){
        
        player.draw(g2, 0, 0);
        int screenX =(int) ( (int) camera.getX() - camera.getX())*GamePlayScreen.tileSize;
        int screenY = (int) ((int)camera.getY()-camera.getY())*GamePlayScreen.tileSize;
        int mapX = (int) camera.getX();
        int mapY = (int) camera.getY();
        for(int i =screenY;i<=gamePlayScreen.getHeight();i+=GamePlayScreen.tileSize)
            for(int j = screenX ; j<=gamePlayScreen.getWidth();j+=GamePlayScreen.tileSize){
                Tile tile ;
                int tileNum;
                if(mapY<mapChoosen.map.size() && mapX < mapChoosen.map.get(mapY).size())tileNum = mapChoosen.map.get(mapY).get(mapX);
                else
                    tileNum = 0;
                if(tileNum >  0) tile = TileManager.tiles.get(tileNum);
                else
                    tile = TileManager.tiles.get(0);
                tile.draw(g2, j, i);
                //System.out.println(tile);
                mapX++;
                mapY++;
                //System.out.println(j+" " +i+ " "+ GamePlayScreen.tileSize);
                
            }
            
    }   
}

