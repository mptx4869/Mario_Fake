package screen;


import java.awt.Color;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;

//import java.awt.GraphicsEnvironment;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import manager.GameState;
import manager.ScreenManager;


public class Intro_Screen extends JPanel {
    JFrame window;
    Buttons focusButton = Buttons.START;
    private final ImageIcon backgroundImageIcon ;
    public Intro_Screen(JFrame window){
        super(null);
        this.window = window;
        backgroundImageIcon =new ImageIcon( loadImage(new File("media/backgrounds/intro_background.png")));

        Font marioFont = new Font("Arial", Font.PLAIN, 5);

        try {
            marioFont = Font.createFont(Font.TRUETYPE_FONT, new File("media/fonts/mario-font.ttf")).deriveFont(Font.BOLD, 40);
            //GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            marioFont = marioFont.deriveFont(Font.BOLD, 12);
            // ge.registerFont(marioFont);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel tileText = new JLabel("MARIO");
        tileText.setFont(marioFont);

        tileText.setForeground(Color.WHITE);
        
        
        GameButton startButton = new GameButton() {

            @Override
            public void clickOn() {
                System.out.println("choose start");
                GamePanel gp = new GamePanel();
                GameState.Play.setScreen(gp);
                ScreenManager.addPanel(GameState.Play, gp);
                ScreenManager.changeState(GameState.Play);
                
                
            }
            
        };
        startButton.setText("START");
        startButton.setForeground(Color.WHITE);
        Buttons.START.button=startButton;
        GameButton quitButton = new GameButton() {

            @Override
            public void clickOn() {
                System.out.println("choose quit");
            }
            
        };
        quitButton.setForeground(Color.WHITE);
        quitButton.setText("QUIT");
        Buttons.QUIT.button=quitButton;
        this.add(tileText);
        this.add(startButton);
        this.add(quitButton);
        
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                //System.out.println(getSize());
                setPreferredSize(getPreferredSize());
                float fontSize = getWidth()/7 <= getHeight()/4 ?(float)( getWidth()/7):(float)(getHeight()/4);

                tileText.setFont(tileText.getFont().deriveFont(fontSize));
                tileText.setBounds((getWidth()-tileText.getPreferredSize().width)/2,
                                    (getHeight()/2-tileText.getPreferredSize().height)/2
                                    ,tileText.getPreferredSize().width, 
                                    tileText.getPreferredSize().height);

                fontSize = getWidth()/10 < getHeight()/9 ?(float) (getWidth()/10):(float)(getHeight()/9);
                Font font = startButton.getFont().deriveFont(fontSize);
                startButton.setFont(font);
                quitButton.setFont(font);
                startButton.setBounds((getWidth() - startButton.getPreferredSize().width)/2, getHeight()/2,
                                        startButton.getPreferredSize().width, 
                                        startButton.getPreferredSize().height);

                quitButton.setBounds((getWidth() - quitButton.getPreferredSize().width)/2, 
                                        startButton.getLocation().y + startButton.getPreferredSize().height+10,
                                        quitButton.getPreferredSize().width , 
                                        quitButton.getPreferredSize().height);
            }
                


        });

        this.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                if(code ==  KeyEvent.VK_UP || code == KeyEvent.VK_W) {
                    switch (focusButton) {
                        case START:
                            focusButton.button.stopFocus();
                            focusButton=Buttons.QUIT;
                            focusButton.button.focusing();
                            break;
                        case QUIT:
                            focusButton.button.stopFocus();
                            focusButton = Buttons.START;
                            focusButton.button.focusing();
                            break;
                        default:
                            
                            break;
                    }
                }

                if(code == KeyEvent.VK_DOWN || code == KeyEvent.VK_S) {
                    switch (focusButton) {
                        case START:
                            focusButton.button.stopFocus();
                            focusButton=Buttons.QUIT;
                            focusButton.button.focusing();
                            break;
                        case QUIT:
                            focusButton.button.stopFocus(); 
                            focusButton = Buttons.START;
                            focusButton.button.focusing();
                            break;
                        default:
                            
                            break;
                    }
                }

                if(code == KeyEvent.VK_ENTER || code ==KeyEvent.VK_SPACE){
                    focusButton.button.clickOn();
                }   

            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
            
        });
        this.setFocusable(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        g.drawImage(backgroundImageIcon.getImage(), 0  , 0, this.getWidth(),this.getHeight(),null);
    }

    public BufferedImage loadImage(File file){
        BufferedImage image =null ;
        try {
            image = ImageIO.read(file);
        } catch (Exception e) {
            System.out.println("ERRO: can not load file "+ file + e.getMessage());
        }
        return image;
    }
 

}
