package screen;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import manager.Camera;
import manager.GamePlay;

    public class GamePlayScreen extends JPanel implements Runnable {
        final Dimension maxScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final Dimension testDimension = new Dimension(1000, 700);
        public static int tileSize ;
        public  static int tilePerScreen =15;
        
        Thread gameThread;
        public final int FPS = 60;

        InputHandler keyH = new InputHandler();
        Camera camera = new Camera();

        public GamePlay gamePlay ;

        public GamePlayScreen(GamePlay gamePlay){

            this.gamePlay = gamePlay;
            this.setSize(100, 100);
            tileSize = (getWidth())/tilePerScreen;
            gamePlay.gamePlayScreen = this;
            this.gamePlay.setCamera(camera);
            gamePlay.setInputHandler(keyH);
            this.setBackground(Color.BLACK);
            this.setDoubleBuffered(true);//ko biet la cai gi
            this.addKeyListener(keyH);
            this.setFocusable(true);

            

            this.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    camera.setHeight(HEIGHT/2);
                    camera.setWidth(WIDTH/2);
                    //setPreferredSize(getPreferredSize());
                    tileSize = (getWidth())/tilePerScreen;
                    System.out.println(tileSize);
                    System.out.println(getSize());
                    gamePlay.setScreenPosition();
                    super.componentResized(e);
                }
            });
            startGameThread();
        }

        public void startGameThread(){
            gameThread = new Thread(this);
            gameThread.start();
        }
        public void run(){
            double drawInterval = 1e9 / FPS;
            double delta = 0;
            long lastTime = System.nanoTime();
            long currentTime ;
            while(gameThread != null){
                currentTime = System.nanoTime();
                delta += (currentTime-lastTime)/drawInterval;
                lastTime = currentTime;
                if(delta >= 1){
                    delta -= 1;
                    update();
                    repaint();
                }
            }
        }
        public void update(){
            gamePlay.update();
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            // ImageIcon image = new ImageIcon("onepiece.png");
            // g.drawImage(image.getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
            //g2.fillRect(0, 0, GamePlayScreen.tileSize, GamePlayScreen.tileSize);
            gamePlay.draw(g2);
            
        }
    }
