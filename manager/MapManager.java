package manager;


import java.io.BufferedReader;
import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;




public class MapManager {
    public ArrayList<Map> maps= new ArrayList<Map>();
    public MapManager(){
        System.out.println("chay");
        getMap();
    }

    public void getMap(){
        String pathFolder = "media/maps";
        File folder = new File(pathFolder);
        if(!folder.exists()) System.out.println("\nERRO folder does not exit");
        
        File listFile[] = folder.listFiles();
        if(listFile == null) System.out.println("\nERRO: listFIle null");

        for(File file : listFile)
        try {
            ArrayList<ArrayList<Integer>> map = new ArrayList<>();

            InputStream is = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line = br.readLine();
            String numbers[]=line.split(" ");
            int spawnPositionX=0; 
            int spawnPositionY=0;
            if(numbers.length >=2 ){
                spawnPositionX=Integer.parseInt( numbers[0]);
                spawnPositionY=Integer.parseInt(numbers[1]);
            }
            else
                System.out.println("\nERRO: erro at first line file map name"+file);

            line = br.readLine();
            while(line!=null){
                ArrayList<Integer> lineMap = new ArrayList<>();
                numbers = line.split(" ");
                for(String num : numbers){
                    lineMap.add(Integer.parseInt(num));
                }
                map.add(lineMap);
                line=br.readLine();
            }
            maps.add(new Map(map, spawnPositionX, spawnPositionY));
            //maps.get(maps.size()-1).displayMap();
            System.gc();
            System.out.println("Created map "+file.getName());


        } catch (IOException e) {
            System.out.println("\nERRO: Could not load file name:"+file.getName() );
        }
    }
    public Map chooseMap(){
        return maps.get(0);
    }
}
