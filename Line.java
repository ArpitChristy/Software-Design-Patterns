package Patterns;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;


public class Line implements interface_Component{
	
	int radius = 25;			

				// the code is for drawing a line.				
	@Override
	public void drawTheShape(int x, int y, Object source, boolean fill) {
		// TODO Auto-generated method stub
		
		if(source instanceof JPanel) {
        	
            Graphics g = ((JComponent) source).getGraphics();
            g.drawLine(x - radius, y - radius, x - radius, y);
            g.setColor(Color.BLACK);
        }
		
	}
}
