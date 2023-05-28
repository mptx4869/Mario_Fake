package entity;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
//import java.util.spi.ToolProvider;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;



public class Load_Entity <T> {
    public static ArrayList<BufferedImage> listImages;

    public File classFile;
    public File imageFile;
    public Load_Entity(){
        listImages = new ArrayList<>();
        
    }
    public void getImage(File imageFile){

        File listImageTile [] = imageFile.listFiles();
        if(listImageTile == null) System.out.println(this.getClass()+"ERRO: listFIle null");

        for(File file : listImageTile){
            try {
                BufferedImage image = ImageIO.read(file);
                this.listImages.add(image);
            } catch (IOException e) {
                System.out.println(this.getClass()+"ERRO: Could not load file name:"+file.getName() +" ::: "+e.getMessage() );
            }
        }

    }

    public boolean complieClassFile(File folder){
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        File [] listTileClass = folder.listFiles(new FilenameFilter(){
            @Override
            public boolean accept(File folder,String name) {
                return name.toLowerCase().endsWith(".java");
            }
        });

        for(File file : listTileClass){
            int compilationResult = compiler.run(null, null, null, "-d", ".", file.getPath());
            if(compilationResult != 0 ) System.out.println("\nERRO: Can't complie file "+file.getName());
            if(compilationResult != 0)return false;
        }
        return true;
    }


    public ArrayList<T> getClass(File classFile,String pathPrefix){
        // File folder = new File(pathFolder);
        // if(!folder.exists()) System.out.println("\nERRO folder "+pathFolder+ " does not exit");
        
        ArrayList<T> listInstance = new ArrayList<>();

        if(!complieClassFile(classFile)) System.out.println("ERRO: fail to complie class file: " + classFile);

        File[] listClassFile = classFile.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".class");
            }
        });

        
        if(listClassFile.length==0) System.out.println("ERRO: listClassFile is null : "+classFile);
        
        for(File file : listClassFile){
            String className = file.getName().replace(".class", "");
            String fullClassName = pathPrefix + className;
            try {
                URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{classFile.toURI().toURL()});
                        
                Class<?> cls = classLoader.loadClass(fullClassName);
                //System.out.println(cls);
                Constructor<?> constructor = cls.getConstructor();
                T instance =(T) cls.getDeclaredConstructor().newInstance();     
                listInstance.add(instance);
                System.out.println(instance.getClass());
            } catch (Exception e) {
                System.out.println("ERRO: fail to create an instance of "+file+"::::"+e.getMessage()+'\n');
            }
        }
        return listInstance;
    }
}
