import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.net.Socket;
import java.io.*;

public class ControlPanel extends JPanel {
	
	private ControlModel control = new ControlModel();
	private JButton[][] squares = new JButton[3][4];
	private PrintWriter output;
	

	public ControlPanel() {
		
		
		
		setLayout(new GridLayout(3,4));
		MouseHandler mouseHandler = new MouseHandler();
		

		for ( int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
			
				squares[i][j] = new JButton();
			
				squares[i][j].addMouseListener(mouseHandler);
				add(squares[i][j]);
			}
		}
			squares[0][0].setText("UP");
			squares[0][1].setText("TURN LEFT");
			squares[0][2].setText("FORWARD");
			squares[0][3].setText("TURN RIGHT");
			squares[1][0].setText("DOWN");
			squares[1][1].setText("LEFT");
			squares[1][2].setText("BACKWARD");
			squares[1][3].setText("RIGHT");
			squares[2][0].setText("FASTER");
			squares[2][1].setText("SLOWER");
			squares[2][2].setText("TAKEOFF");
			squares[2][3].setText("LAND");
		
	}
	
	
	
	

	private class MouseHandler extends MouseAdapter { 
		
		public void mousePressed(MouseEvent e) {
		Object source = e.getSource();
			
			for ( int i = 0; i < 3; i++) {
				for (int j = 0; j < 4; j++) {
					
						
					if(e.getSource() == squares[i][j]) {
							
							
							
						if(e.getButton() == MouseEvent.BUTTON1) {
							
							if(e.getSource() == squares[0][0]) {
									control.goUp();
								
								
							}
							
							if(e.getSource() == squares[0][1]) {
									control.turnLeft();
								
								
							}
							
							if(e.getSource() == squares[0][2]) {
									control.goForward();
									
								
							}
							
							if(e.getSource() == squares[0][3]) {
									control.turnRight();
								
								
							}
							
							if(e.getSource() == squares[1][0]) {
									control.goDown();
								
								
							}
							
							if(e.getSource() == squares[1][1]) {
									control.goLeft();
								
								
							}
							
							if(e.getSource() == squares[1][2]) {
									control.goBackward();
									
								
							}
							
							if(e.getSource() == squares[1][3]) {
									control.goRight();
								
								
							}
							
							if(e.getSource() == squares[2][0]) {
									control.goFaster();
								
								
							}
							
							if(e.getSource() == squares[2][1]) {
									control.goSlower();
								
								
							}
							
							if(e.getSource() == squares[2][2]) {
									control.Takeoff();
									
								
							}
							
							if(e.getSource() == squares[2][3]) {
									control.Land();
								
								
							}
							
						}
					}
					
				}
			}

	
		}
		
		public void mouseReleased(MouseEvent e) {
			
			control.Stop();
			
			
		}
	
	}
	
		

}