package Patterns;
	import java.awt.EventQueue;
	import Patterns.gui_Controller;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.JTextArea;
	import javax.swing.JToggleButton;
	import javax.swing.event.ChangeEvent;
	import javax.swing.event.ChangeListener;
	import javax.swing.event.UndoableEditEvent;
	import javax.swing.event.UndoableEditListener;
	import javax.swing.undo.UndoManager;

	import java.awt.BorderLayout;
	import java.awt.Button;
	import javax.swing.BoxLayout;
	import javax.swing.JButton;
	import javax.swing.JComponent;

	import java.awt.event.ItemListener; 
	import java.awt.Color;
	import java.awt.Color;
	import java.awt.EventQueue;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.util.List;
	import java.awt.Point;
	import java.awt.RenderingHints;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.ItemEvent;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
	import java.util.ArrayList;
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	//implementing homework class with action listener, mouse listener for the click events. 
	// the class extends jpanel so that it can implement jpanel and extend the methods.
	public class homework_GUI extends JPanel implements ActionListener, ChangeListener, MouseListener{
		// the x and y is used to get the co-ordinates 
		int x,  y;
		// String that will identify which button is pressed. 
			String ClickButton = "null";
		
	    // Jframe, within which jpanel and buttons are implemented. 
		private JFrame frame;
		
		// circle radius that is pre-defined. 
	    int radius = 25;
	    
	    
	    gui_Controller guic = new gui_Controller();
		
	    
	    public String getbuttonvalue(String shape) {
	    	return ClickButton;
	    }

		/**
		 * Application starts from here. 
		 */
		public static void main(String[] args) {
			//posts an event (your Runnable) at the end of Swings event list and is processed after all previous GUI events are processed.
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						// creates the frame and sets visible. 
						homework_GUI window = new homework_GUI();
						window.frame.setVisible(true);
						// if there is an exception then it will be caught and printed. 
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		// construct the frame and initialize with the components. 
		 
		public homework_GUI() {
			initialize();
		}
		
		
		

		
		
		// intialzie all the components of the frame. 
		private void initialize() {
			frame = new JFrame();
			//specifying size and position.
			frame.setBounds(100, 100, 700, 400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			// create a panel to draw the shapes.
			JPanel draw_panel= new JPanel();
			draw_panel.setBackground(Color.WHITE);
			draw_panel.setBounds(100, 20, 400, 250);
			frame.getContentPane().add(draw_panel);
			draw_panel.addMouseListener(this);
			// this area will help implement the undoable edit listener
			JTextArea area = new JTextArea(5, 30);
			
			
			
			// all the buttons are in two states selected and unselected.
			//###################################################################################
			// Hence, it provides the STATE PATTERN. 
			//#####################################################################################
			// create a button line
			JToggleButton btnNewButton = new JToggleButton("Line");
			//specifying size and position of the button
			btnNewButton.setBounds(0, 32, 85, 21);
			
			// add a action listener on the button. 
			btnNewButton.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent itemEvent) {
					int state = itemEvent.getStateChange();
					if(state == itemEvent.SELECTED) {
						System.out.println("selected");
						ClickButton = "line";
					}else {
						System.out.println("unselected");
					}
				}
			});
			

			frame.getContentPane().add(btnNewButton);
			
			
			
			//create  a square button
			JToggleButton btnNewButton_1 = new JToggleButton("Square");

			//specifying size and postion of the button
			btnNewButton_1.setBounds(0, 74, 85, 21);
			// add a action listener on the button. 
			btnNewButton_1.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent itemEvent) {
							int state = itemEvent.getStateChange();
							if(state == itemEvent.SELECTED) {
								System.out.println("selected");
								ClickButton = "square";
							}else {
								System.out.println("unselected");
							}
						}
					});
			
			frame.getContentPane().add(btnNewButton_1);
			
			
			// create a circle button. 
			JToggleButton btnNewButton_2 = new JToggleButton("Circle");
			// add a action listener on the button. 
			btnNewButton_2.addItemListener(new ItemListener() {
						public void itemStateChanged(ItemEvent itemEvent) {
							int state = itemEvent.getStateChange();
							if(state == itemEvent.SELECTED) {
								System.out.println("selected");
								ClickButton = "circle";
							}else {
								System.out.println("unselected");
							}
						}
					});
			//specifying size and postion of the button
			btnNewButton_2.setBounds(0, 116, 85, 21);
			frame.getContentPane().add(btnNewButton_2);
			
			
			JToggleButton btnNewButton_4 = new JToggleButton("Redo");
			//specifying size and postion of the button
			btnNewButton_4.setBounds(0, 202, 85, 21);
			frame.getContentPane().add(btnNewButton_4);
			// add a action listener on the button. 
						btnNewButton_4.addItemListener(new ItemListener() {
									public void itemStateChanged(ItemEvent itemEvent) {
										int state = itemEvent.getStateChange();
										if(state == itemEvent.SELECTED) {
											System.out.println("selected");
											ClickButton = "redo";
											
										}else {
											System.out.println("unselected");
										}
									}
								});
			
			
			//specifying size and postion of the button
			JToggleButton btnNewButton_3 = new JToggleButton("Undo");
			btnNewButton_3.setBounds(0, 157, 85, 21);
			frame.getContentPane().add(btnNewButton_3);
			// add a action listener on the button. 
						btnNewButton_3.addItemListener(new ItemListener() {
									public void itemStateChanged(ItemEvent itemEvent) {
										int state = itemEvent.getStateChange();
										if(state == itemEvent.SELECTED) {
											System.out.println("selected");
											ClickButton = "undo";
											
											//guic.undoController();
										}else {
											System.out.println("unselected");
										}
									}
								});
			
			
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void stateChanged(ChangeEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			x = e.getX();
			y = e.getY();
			//#################### this is command pattern. As it will pass command to controller#############
			guic.ButtonController(e,x,y,ClickButton);
			repaint();
			System.out.println("here");
		}
		
	}


