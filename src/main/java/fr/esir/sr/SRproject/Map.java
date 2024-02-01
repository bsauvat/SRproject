package fr.esir.sr.SRproject;

import java.awt.Graphics;
import javax.swing.JComponent;

abstract class Map extends JComponent {

    /* Position of the shape in the grid */
    public int x = 0 ;
    public int y = 0 ;
    private final Display display ;

    public Map(Display dis) {
        display = dis ;
        display.add(this);
        display.pack(); // somehow needed or add does not work properly
    }

    /*
     * Set the positions of the shape in grid coordinates
     */
    public void setGridPos(int someX,int someY) {
        x = someX ; y = someY ;
    }

    abstract public void drawShape(Graphics g, int x, int y, int w, int h);

    /* delegates drawing proper to drawShape. Transform the grid
     * coordinates of the shape into pixel coordinates, using the cell
     * size of the ExampleDisplay associated with the AbstractGridShape */
    public void paint(Graphics g) {
        this.drawShape(g,
                display.cellSize/2 + x*display.cellSize,
                display.cellSize/2 + y*display.cellSize,
                display.cellSize, display.cellSize);
    }

    public void moveRect(int[] delta) {
        x = (x+delta[0]+display.gridSize)%display.gridSize ;
        y = (y+delta[1]+display.gridSize)%display.gridSize ;
    }
}
