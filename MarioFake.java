
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import manager.EnemyManager;
import manager.HeroManager;
import manager.MapManager;
import manager.ScreenManager;
import manager.TileManager;

public class MarioFake{
    public static void main(String[] args) {
        MapManager mapM = new MapManager();
        TileManager tileM = new TileManager();
        EnemyManager enemyM=new EnemyManager();
        HeroManager heroM = new HeroManager();
        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);
        window.setTitle("Mario");
        
        ScreenManager screenM = new ScreenManager(window);

        window.pack();
        window.setSize(614 , 637);
        window.setMinimumSize(new Dimension(600, 600));
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        

    }
}