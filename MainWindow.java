import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EnumMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

// Bonus points: Create an icon (or find a public domain icon. Keep in mind federal Copyright law and TAMU's plagiarism policy and add it to the home screen window.

public class MainWindow {

	private final JFrame mainFrame = new JFrame(Config.APPLICATIONNAME);
	private final JDialog selectWorkout = new JDialog(mainFrame, "Select Workout");
	private JComboBox<String> cboType, cboGoal;
	private JSpinner spnDuration;
	private final Workouts workouts;
	private final EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> muscleGroups;
	private JPanel panel = new JPanel();
	private JButton upperBodyButton = new JButton("UpperBody");
	private JButton lowerBodyButton = new JButton("LowerBody");
	private JButton wholeBodyButton = new JButton("WholeBody");

	MainWindow(Workouts workouts, EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> muscleGroups) {
		this.muscleGroups = muscleGroups;
		this.workouts = workouts;
		launchHomeScreen();
	}

	private void launchHomeScreen() {
		mainFrame.setVisible(true);
		mainFrame.setSize(600,400);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setLayout(null);
		mainFrame.add(panel);
		
		upperBodyButton.setBounds(0, 0, 600, 122);
		upperBodyButton.addActionListener(new ButtonListener());
		panel.add(upperBodyButton);

		lowerBodyButton.setBounds(0,122,600,122);
		lowerBodyButton.addActionListener(new ButtonListener());
		panel.add(lowerBodyButton); 

		wholeBodyButton.setBounds(0, 232, 600, 122);
		wholeBodyButton.addActionListener(new ButtonListener());
		panel.add(wholeBodyButton);

	}


	// This is the method your actionlistener should call. It should create and display a WorkoutsPanel.
	private void showWorkouts(ArrayList<Config.Muscle> muscles) 
	{
		WorkoutsPanel wP = new WorkoutsPanel(muscles, this.workouts);
		mainFrame.getContentPane().removeAll();
		mainFrame.setLayout(new BorderLayout());
		mainFrame.add(wP);
		mainFrame.pack();
	}

	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource() == upperBodyButton)
			{
				showWorkouts(muscleGroups.get(Config.MuscleGroup.UPPERBODY));
			}
			
			else if(e.getSource() == lowerBodyButton)
			{
				showWorkouts(muscleGroups.get(Config.MuscleGroup.LOWERBODY));
			}
			
			else
			{
				showWorkouts(muscleGroups.get(Config.MuscleGroup.WHOLEBODY));
			}

		}
	}


}

