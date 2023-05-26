package screen;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

    public class GamePanel extends JPanel implements Runnable {
        final Dimension maxScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final Dimension testDimension = new Dimension(1000, 700);
        public static int tileSize ;
        public  static int tilePerScreen =60;
        
        Thread gameThread;
        public final int FPS = 60;

        InputHandler keyH = new InputHandler();

        
        public GamePanel(){
            //this.setPreferredSize(testDimension);
            //this.setSize(testDimension);
            this.setBackground(Color.BLACK);
            this.setDoubleBuffered(true);//ko biet la cai gi
            this.addKeyListener(keyH);
            this.setFocusable(true);

            this.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    //setPreferredSize(getPreferredSize());
                    tileSize = (getWidth())/tilePerScreen;
                    System.out.println(tileSize);
                    super.componentResized(e);
                }
            });
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
            
            
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon image = new ImageIcon("onepiece.png");
            g.drawImage(image.getImage(), 0, 0, this.getWidth(),this.getHeight(),null);
            
        }
    }
