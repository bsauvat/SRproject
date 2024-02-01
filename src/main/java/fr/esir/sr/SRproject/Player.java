package fr.esir.sr.SRproject;

import java.awt.*;

public class Player extends Map {

    int id;
    public Player(Display display) {
        super(display);
    }

    public int getId(){ return id;}
    public void drawShape(Graphics g, int x, int y, int w, int h) {
        g.setColor(Color.BLUE);
        g.fillRect(x,y,w,h);
    }


}
