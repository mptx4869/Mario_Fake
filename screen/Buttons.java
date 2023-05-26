package screen;



public enum Buttons {
    START(null),
    QUIT(null);
    GameButton button ;
    Buttons(GameButton button){
        this.button = button;
    }
}
