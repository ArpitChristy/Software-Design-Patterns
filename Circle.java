package Patterns;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Circle implements interface_Component{
	int radius = 25;
	// the code for drawing a circle. 
    
	@Override
	public void drawTheShape(int x, int y, Object source, boolean fill) {
		// TODO Auto-generated method stub
		if(source instanceof JPanel) {
            Graphics g = ((JComponent) source).getGraphics();
            g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
            g.setColor(Color.BLACK);
        }
		
	}

	
}
