package fr.esir.sr.SRproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Display extends JFrame implements KeyListener {
    int cellSize = 20 ;
    int gridSize = 20 ;
    Map<Integer,int[]> moveTable = new HashMap<Integer,int[]>() ;
    Player player = new Player(this) ;
    Container myContainer ;
    int numberOfCoins = 10 ;

    /* gameMap contains the plan of the sweets to collect initialized to
     * null by default */
    Coins[][] CoinsMap = new Coins[gridSize][gridSize];

    public Display() {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(30, 30);
        myContainer = getContentPane();
        myContainer.setPreferredSize(new Dimension(cellSize * (gridSize + 1), cellSize * (gridSize + 1) ));
        pack();

        // adding the red circles for a bit of landscape
        Random rand = new Random();

        for(int i = 0; i < numberOfCoins; i++) {
            int j, k;
            do {
                j = rand.nextInt(gridSize);
                k = rand.nextInt(gridSize);
            } while (CoinsMap[j][k]!=null);

            CoinsMap[j][k] = new Coins(this);
            CoinsMap[j][k].setGridPos(j,k);
        } // EndFor i

        setVisible(true);

        moveTable.put(KeyEvent.VK_DOWN ,new int[] { 0,+1});
        moveTable.put(KeyEvent.VK_UP   ,new int[] { 0,-1});
        moveTable.put(KeyEvent.VK_LEFT ,new int[] {-1, 0});
        moveTable.put(KeyEvent.VK_RIGHT,new int[] {+1, 0});
        addKeyListener(this);

    } // EndConstructor ExampleDisplay

    /* needed to implement KeyListener */
    public void keyTyped   (KeyEvent ke){}
    public void keyReleased(KeyEvent ke){}

    /* where the real work happens: reacting to key being pressed */
    public void keyPressed (KeyEvent ke){
        int keyCode = ke.getKeyCode();
        if (!moveTable.containsKey(keyCode)) return ;
        player.moveRect(moveTable.get(keyCode));
        if (CoinsMap[player.x][player.y]!=null) {
            Coins c = CoinsMap[player.x][player.y];
            myContainer.remove(c);
            pack();
            CoinsMap[player.x][player.y]=null;
            numberOfCoins--;
            if (numberOfCoins ==0) {
                System.out.println("You've won. Congratulations!");
                System.exit(0);
            }
            System.out.println("Only "+ numberOfCoins +" coin(s) remaining...");
        }
        repaint();
    } // EndMethod keyPressed

    public static void main(String[] a) {
        JFrame window = new fr.esir.sr.SRproject.ExampleDisplay();
    } // EndMethod main
}

