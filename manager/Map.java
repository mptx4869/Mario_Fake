package manager;
import java.util.ArrayList;


public class Map {
    public ArrayList<ArrayList<Integer> > map ;//= new ArrayList<>();
    public int screenX,screenY;
    public int spawnPositionX,spawnPosintionY;
    public Map(ArrayList<ArrayList<Integer> > map,int spawnPositionX,int spawnPosintionY){
        this.map=map;
        this.spawnPositionX = spawnPositionX;
        this.spawnPosintionY = spawnPosintionY;
    }
    public void displayMap(){
        for(ArrayList<Integer> lineMap : map ){
            for(Integer numTile : lineMap)
                System.out.print(numTile+" ");
            System.out.println();
        }
    }
    public void updateScreenPosition(int screenX,int screenY){
        this.screenX=screenX;
        this.screenY=screenY;
    }

}
