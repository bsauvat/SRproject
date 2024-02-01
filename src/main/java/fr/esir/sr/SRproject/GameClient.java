package fr.esir.sr.SRproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.Naming;			//Import the rmi naming - so you can lookup remote object
import java.rmi.RemoteException;	//Import the RemoteException class so you can catch it
import java.net.MalformedURLException;	//Import the MalformedURLException class so you can catch it
import java.rmi.NotBoundException;	//Import the NotBoundException class so you can catch it
import java.util.HashMap;
import java.util.Map;

public class GameClient extends JFrame implements KeyListener {

    int cellSize;
    int gridSize;
    Map<Integer,int[]> moveTable = new HashMap<Integer,int[]>() ;
    Player player;
    Container myContainer ;
    Coin[][] coinMap;

    public GameClient(){
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
        addKeyListener(this);
    }

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
    }

    public void setCellSize(int size){
        this.cellSize = size;
    }

    public void setGridSize(int size){
        this.cellSize = size;
    }

    public void setCoinMap(Coin[][] map){
        this.coinMap = map;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    public static void main(String[] args) {

        try {
            GameImpl g = (GameImpl)
                    Naming.lookup("rmi://localhost/game");
            g.InitClient();
        }
        // Catch the exceptions that may occur - rubbish URL, Remote exception
        // Not bound exception or the arithmetic exception that may occur in
        // one of the methods creates an arithmetic error (e.g. divide by zero)
        catch (MalformedURLException murle) {
            System.out.println();
            System.out.println("MalformedURLException");
            System.out.println(murle);
        }
        catch (RemoteException re) {
            System.out.println();
            System.out.println("RemoteException");
            System.out.println(re);
        }
        catch (NotBoundException nbe) {
            System.out.println();
            System.out.println("NotBoundException");
            System.out.println(nbe);
        }
        catch (java.lang.ArithmeticException ae) {
            System.out.println();
            System.out.println("java.lang.ArithmeticException");
            System.out.println(ae);
        }
    }
}
