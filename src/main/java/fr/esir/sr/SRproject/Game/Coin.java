package fr.esir.sr.SRproject.Game;

import Display;
import fr.esir.sr.SRproject.Map;
import fr.esir.sr.SRproject.Server.Map;

import java.awt.*;

public class Coin extends Map {

    public Coin(Display display) {
        super(display);
    }
    public void drawShape(Graphics g, int x, int y, int w, int h) {
        g.setColor(Color.YELLOW);
        g.fillOval(x,y,w,h);
    }
}
