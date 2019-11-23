package Patterns;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JPanel;
import Patterns.Circle;
import Patterns.Line;
import Patterns.Square;
public class gui_Controller{
	/**
	 * 
	 */
	/**
	 * 
	 */
	
	int x;
	int y;
	Circle circle = new Circle();
	Line line = new Line();
	Square square = new Square();
	
	
	int radius = 25;
	
	// create a list of actions that are createad. 
    List<MouseEvent> undoActionsmouse = new ArrayList<MouseEvent>();
    List<String> undoActions = new ArrayList<String>();
    // create a array of actions that are removed from the panel 
    List<MouseEvent> redoActionsmouse = new ArrayList<MouseEvent>();
    List<String> redoActions = new ArrayList<String>();
    
    
	// #######################################################################################
	// This method implements the CONTROLLER METHOD as all the request is handled through this method.
	//##########################################################################################
	public void ButtonController(MouseEvent e, int x, int y, String ClickButton) {
		
		// getting the x and y co-ordinates of the click event. 		
        // get the circle on canvas
		if(ClickButton == "circle"){
			undoActionsmouse.add(e);
			undoActions.add("circle");
			// ###### Expert Pattern. ######
			// calling method of particular class.
	        circle.drawTheShape(e.getX()-(radius/2), e.getY()-(radius/2), e.getSource(),false);

		}
		// get the line on canvas
		else if(ClickButton == "line"){
			undoActionsmouse.add(e);
			undoActions.add("line");
			// ###### Expert Pattern. ######
			// calling method of particular class.
	        line.drawTheShape(e.getX()-(radius/2), e.getY()-(radius/2), e.getSource(),false);

	        
		}
		// get the square on canvas
		else if(ClickButton == "square"){
			undoActionsmouse.add(e);
			undoActions.add("square");
			// ###### Expert Pattern. ######
			// calling method of particular class.
	        square.drawTheShape(e.getX()-(radius/2), e.getY()-(radius/2), e.getSource(),false);    

	        
		}
		// if the clicked button is undo..
		else if(ClickButton == "undo") {
			int length = undoActionsmouse.size();
			
			
			try {
				// get the last element and store it in redo list.
				MouseEvent e1 = undoActionsmouse.get(length-1);
				String ClickButton1 = undoActions.get(length-1);
				
				redoActionsmouse.add(e1);
				redoActions.add(ClickButton1);
				
				// remove the last element . 
				undoActionsmouse.remove(length-1);
				undoActions.remove(length-1);
				
				Iterator<MouseEvent> it1 = undoActionsmouse.iterator();
				Iterator<String> it2 = undoActions.iterator();
				
				
				
				// ########################## Iterator Pattern #######################################
				while(it1.hasNext() && it2.hasNext()) {
					MouseEvent e2 = it1.next();
					int x2 = e.getX();
					int y2 = e.getY();
					System.out.println("the value of x and y is "+x+y);
					String ClickButton2 = it2.next();
				
					ButtonController(e2, x2, y2, ClickButton2);
				}
				
				
			}catch(Exception ee) {
				System.out.println(ee);
			}
			
		}
		
		//ClickButton = "null";
	}
	public void undoController() {
		
			
		
	}
	public void redoController() {
		
	}
	
	
	
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
			
		    
}
