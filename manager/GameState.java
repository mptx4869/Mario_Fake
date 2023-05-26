package manager;
import javax.swing.JPanel;

public enum GameState {
    Intro(null),
    ChooseMap(null),
    Play(null),
    Pause(null),
    GameOver(null);
     
    JPanel screen;
    GameState(JPanel Screen){
        this.screen = screen;
    }
    public void setScreen(JPanel screen) {
        this.screen = screen;
    }
    public JPanel getScreen() {
        return screen;
    }
}
