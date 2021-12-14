import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;

public class Main {
		private JFrame frame;
	static double[] hourData = {2.0, 3.0, 5.0, 7.0,  9.0,  11.0, 14.0};
	static double[] bugData =  {4.0, 5.0, 7.0, 10.0, 15.0, 20.0, 30.0};
	
	private JTextField hours;
	private JTextPane textPane;
	private JTextPane fileName;
	
	File dataa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		//declare a linear regression object
		//x: hourData
		//y: bugData
		LinearRegression lR = new LinearRegression(hourData, bugData);
		int predictedBugs = lR.predictForValue(13);
		System.out.println("There will be " + predictedBugs + "\nbugs for 13 hours of coding."); //\n makes a new line while printint

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton selectFile = new JButton("Select the Data File");
		selectFile.setBounds(238, 45, 149, 23);
		frame.getContentPane().add(selectFile);
		selectFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectFile();
			}
		});


		JLabel hourLabel = new JLabel("Hours of coding expected");
		hourLabel.setBounds(87, 111, 149, 14);
		frame.getContentPane().add(hourLabel);

		fileName = new JTextPane();
		fileName.setBounds(43, 45, 165, 20);
		frame.getContentPane().add(fileName);

		hours = new JTextField();
		hours.setBounds(238, 108, 149, 20);
		frame.getContentPane().add(hours);
		hours.setColumns(10);

		JButton Regress = new JButton("Perform Linear Regression");
		Regress.setBounds(107, 161, 236, 23);
		frame.getContentPane().add(Regress);
		Regress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				linearRegress();
			}
		});

		textPane = new JTextPane();
		textPane.setBounds(43, 211, 344, 20);
		frame.getContentPane().add(textPane);
	}

	public void linearRegress() {
		LinearRegression lR = new LinearRegression(hourData, bugData);
		int hoursCoding = Integer.parseInt(hours.getText());
		textPane.setText("" + lR.predictForValue(hoursCoding) + " bugs are predicted for " + 
							hoursCoding + " hours of code.");
	}

	public void selectFile() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"Text Files", "txt");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: " +
					chooser.getSelectedFile().getName());
			dataa = chooser.getSelectedFile(); //the file location is formatted like this: C:\Users\Grace\OneDrive\Desktop\numbers.txt
		}
		fileName.setText(dataa.getName());
	}
}
