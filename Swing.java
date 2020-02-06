import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Swing extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void createWindow()
	{
		JFrame frame = new JFrame(Config.APPLICATIONNAME);
	  frame.setVisible(true);
	  frame.setSize(600,400);
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	  JPanel panel = new JPanel();
	  panel.setLayout(null);
	  frame.add(panel);
	  
	  JButton upperBodyButton = new JButton("UpperBody");
    upperBodyButton.setBounds(200, 400, 100, 60);
    upperBodyButton.addActionListener(new ActionListener(){
    	
    	@Override
    	public void actionPerformed(ActionEvent e)
    	{
    		
    	}
    });
	  panel.add(upperBodyButton);

	  JButton lowerBodyButton = new JButton("LowerBody");
    lowerBodyButton.setBounds(200,145,100,60);
	  panel.add(lowerBodyButton); 
	  
	  JButton wholeBodyButton = new JButton("WholeBody");
    wholeBodyButton.setBounds(200, 250, 100, 60);
	  panel.add(wholeBodyButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
