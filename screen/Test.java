package screen;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicButtonUI;

class Intro extends JPanel {

    JButton startButton = new JButton("Start");

    public Intro() {
        this.setPreferredSize(new Dimension(300, 300));
        this.setLayout(null);

        JButton button = new JButton("Start");

        Font marioFont = new Font("Arial", Font.PLAIN, 5);

        try {
            marioFont = Font.createFont(Font.TRUETYPE_FONT, new File("media/fonts/mario-font.ttf")).deriveFont(Font.BOLD, 40);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            marioFont = marioFont.deriveFont(Font.BOLD, 12);
            ge.registerFont(marioFont);
            button.setFont(marioFont);
            button.setUI(new BasicButtonUI());

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        button.setBounds(0,0, button.getPreferredSize().width, button.getPreferredSize().height);
        this.add(button);
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
            setPreferredSize(getPreferredSize());
            System.out.println(getWidth()+" "+getHeight());
            Font marioFont = button.getFont().deriveFont((float)(getWidth()/10));
            button.setFont(marioFont);
            button.setBounds(0,0, button.getPreferredSize().width, button.getPreferredSize().height);
            System.out.println(button.getWidth()+" " +button.getHeight()+" "+button.getFont());
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("viet");
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(0,9);
        arr.add(9);
        arr.add(9);
        arr.add(9);
        arr.add(3,10);
        for(Integer i : arr)
            System.out.println(i+" ");
    }
}


class Handling extends JLabel implements MouseListener {
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        

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