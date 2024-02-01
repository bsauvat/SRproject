package fr.esir.sr.SRproject;

import java.awt.*;

public class Coin extends Map{

    public Coin(Display display) {
        super(display);
    }
    public void drawShape(Graphics g, int x, int y, int w, int h) {
        g.setColor(Color.YELLOW);
        g.fillOval(x,y,w,h);
    }
}
