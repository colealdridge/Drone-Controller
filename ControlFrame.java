import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;



public class ControlFrame extends JFrame {
	
	

	public ControlFrame() {
		setTitle("Controller");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setSize(screenSize.width/2,screenSize.height/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JPanel panel = new ControlPanel();
		add(panel);
		setVisible(true);
		
		
		
		
		
		
	}


}