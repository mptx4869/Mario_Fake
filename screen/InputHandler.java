package screen;



import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;

public class InputHandler  implements KeyListener,MouseListener{

    public boolean jumpPress=false,downPress=false,leftPress=false,rightPress=false,escPress = false;
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W|| code == KeyEvent.VK_UP) jumpPress=true;
        if(code == KeyEvent.VK_S||code == KeyEvent.VK_DOWN) downPress=true;
        if(code == KeyEvent.VK_A||code == KeyEvent.VK_LEFT) leftPress=true;
        if(code == KeyEvent.VK_D||code == KeyEvent.VK_RIGHT) rightPress=true;
        if(code == KeyEvent.VK_ESCAPE)escPress = true;
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W|| code == KeyEvent.VK_UP) jumpPress=false;
        if(code == KeyEvent.VK_S||code == KeyEvent.VK_DOWN) downPress=false;
        if(code == KeyEvent.VK_A||code == KeyEvent.VK_LEFT) leftPress=false;
        if(code == KeyEvent.VK_D||code == KeyEvent.VK_RIGHT) rightPress=false;
        if(code == KeyEvent.VK_ESCAPE) escPress = false;
    }
    

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }
}
