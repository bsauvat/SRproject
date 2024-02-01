package fr.esir.sr.SRproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Display extends JFrame {
    int cellSize = 20 ;
    int gridSize = 20 ;
    Map<Integer,int[]> moveTable = new HashMap<Integer,int[]>() ;
    Player player = new Player(this) ;
    Container myContainer ;
    /* gameMap contains the plan of the sweets to collect initialized to
     * null by default */
    Coin[][] coinMap = new Coin[gridSize][gridSize];

    public Display() {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocation(30, 30);
        myContainer = getContentPane();
        myContainer.setPreferredSize(new Dimension(cellSize * (gridSize + 1), cellSize * (gridSize + 1) ));
        pack();

        setVisible(true);

        moveTable.put(KeyEvent.VK_DOWN ,new int[] { 0,+1});
        moveTable.put(KeyEvent.VK_UP   ,new int[] { 0,-1});
        moveTable.put(KeyEvent.VK_LEFT ,new int[] {-1, 0});
        moveTable.put(KeyEvent.VK_RIGHT,new int[] {+1, 0});

    } // EndConstructor ExampleDisplay

    /* needed to implement KeyListener */
    public void keyTyped   (KeyEvent ke){}
    public void keyReleased(KeyEvent ke){}

    /* where the real work happens: reacting to key being pressed */
    public void keyPressed (KeyEvent ke){
        int keyCode = ke.getKeyCode();
        if (!moveTable.containsKey(keyCode)) return ;
        player.moveRect(moveTable.get(keyCode));
        if (coinMap[player.x][player.y]!=null) {
            Coin c = coinMap[player.x][player.y];
            myContainer.remove(c);
            pack();
            coinMap[player.x][player.y]=null;
        }
        repaint();
    } // EndMethod keyPressed

    public static void main(String[] a) {
        JFrame window = new fr.esir.sr.SRproject.ExampleDisplay();
    } // EndMethod main
}

