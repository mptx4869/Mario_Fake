package manager;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import screen.Intro_Screen;

public class ScreenManager {
    public static GameState gameState = GameState.Intro;
    private static JFrame window;
    private Intro_Screen intro ;

    public ScreenManager (JFrame window){
        this.window=window;
        
        Intro_Screen intro= new Intro_Screen(window);
        GameState.Intro.setScreen(intro);
        this.addPanel(gameState, intro);

    }
    public static void addPanel(GameState gameState,JPanel newPanel){
        gameState.setScreen(newPanel);
        window.add(gameState.getScreen());
    }
    public static void removePanel(GameState gameState){
        window.remove(gameState.getScreen());
        gameState.setScreen(null);

    }
    public static void changeState(GameState gameState){
        ScreenManager.gameState.getScreen().hide();
        ScreenManager.gameState = gameState;
        ScreenManager.gameState.getScreen().show();
    }
}
