package alvaroycarlos.estela;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Lienzo extends JPanel{
    
    private final Color colours[] = {Color.WHITE, Color.RED, Color.BLUE, Color.BLACK};
    private Position points[] = {new Position(-50,-50), new Position(-50,-50), new Position(-50,-50), new Position(-50,-50), new Position(-50,-50)};
    
    //posicion de las coordenadas a actualizar
    private int positionPos = 0;
    
    //posicion de color a usar
    private int estelaPos = 0;
    private int backgroundPos = 3;
    
    //indica la figura que se usa
    private int shape = 0;
    
    private int count = 0;
    
    public void setEstelaPos(int pos){
        estelaPos = pos;
    }
    
    public void setBackgroundPos(int pos){
        backgroundPos = pos;
    }
    
    public void setShape(int shape){
        this.shape = shape;
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(colours[backgroundPos]);
        this.setForeground(colours[estelaPos]);
        
        for (Position point : points) {
            switch(shape){
                case 0:
                    g.drawOval(point.getX()-10, point.getY()-10, 15, 15);
                    break;
                case 1:
                    g.fillOval(point.getX()-10, point.getY()-10, 15, 15);
                    break;
                case 2:
                    g.drawRect(point.getX()-10, point.getY()-10, 15, 15);
                    break;
                case 3:
                    g.fillRect(point.getX()-10, point.getY()-10, 15, 15);
                    break;
            }
        }
        
    }

    public void drawEstela(int x, int y) {
        
        //cuenta para que no se solapen las figuras
        if(count < 5){
            count++;
            return;
        }
        
        count = 0;
        
        points[positionPos].setX(x);
        points[positionPos].setY(y);
        
        positionPos++;
        
        if(positionPos >= points.length){
            positionPos = 0;
        }
        
        this.repaint();
    }
}
