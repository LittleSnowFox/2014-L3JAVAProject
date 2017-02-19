package core;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class TestInterface extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		// Create a window (frame)
		final JFrame frame = new JFrame("Search for repeated sequencies.");
		frame.setSize(500, 400);
		frame.setVisible(true);

		// Create a menu who contains different actions
		JMenu menu = new JMenu();
		menu.setText("Menu");

		JMenuBar menuBar = new JMenuBar();
		menuBar.setSize(new Dimension(800, 600));
		frame.setJMenuBar(menuBar);
		menuBar.add(menu);
		JMenuItem menuItemQuit = new JMenuItem("Exit");


		menuItemQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		JMenuItem menuItemLoad1 = new JMenuItem("Open File FASTA");
		JMenuItem menuItemLoad2 = new JMenuItem("Open File Matrix");
		JMenuItem menuItemLoad3 = new JMenuItem("Save File Result");

		menu.add(menuItemLoad1);
		menu.add(menuItemLoad2);
		menu.add(menuItemLoad3);
		menu.add(menuItemQuit);

		// Create the different panels in the window.
		JPanel jpanelMatrix = new JPanel();
		GridLayout layoutMatrixSequence = new GridLayout(4, 1);  // window with 4 lines and 1 column
		layoutMatrixSequence.setVgap(10); // space between the panels
		jpanelMatrix.setLayout(layoutMatrixSequence);
		jpanelMatrix.setBackground(new Color(100, 100, 200));

		// Create the text areas in the corresponding panel.
		final JTextArea jta1 = new JTextArea(8, 70);
		jta1.setText("Insert your Sequence");
		jpanelMatrix.add(jta1);

		final JTextArea jta2 = new JTextArea(8, 70);
		jta2.setText("Insert your Matrix");
		jpanelMatrix.add(jta2);

		final JTextArea jta3 = new JTextArea(8, 70);
		jta3.setText("Results");
		jpanelMatrix.add(jta3);

		// Create the buttons in the corresponding panel.
		JPanel jpanelButtons = new JPanel();
		jpanelButtons.setBackground(new Color(150, 150, 150));
		GridLayout layoutButtons = new GridLayout(1, 4);
		jpanelButtons.setLayout(layoutButtons);

		Button button1 = new Button("Start");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// method to create...
			}
		});
		jpanelButtons.add(button1);

		Button button2 = new Button("Pause");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// method to create...
			}
		});
		jpanelButtons.add(button2);

		Button button3 = new Button("Stop");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// method to create...
			}
		});
		jpanelButtons.add(button3);

		jpanelMatrix.add(jpanelButtons);
		

		// To import a FASTA file sequence.
		menuItemLoad1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JFileChooser dialogbox = new JFileChooser();
				int returnVal = dialogbox.showOpenDialog(frame);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					System.out.println("File opened : " + dialogbox.getSelectedFile().getName());
					List<String> lines = null;
					try { 
						lines = Files.readAllLines(dialogbox.getSelectedFile().toPath(), Charset.defaultCharset());
					} catch (IOException e) {
						e.printStackTrace();
					}
					String total = "";
					for(String line : lines)
					{
						total += line + "\n";
					}
					jta1.setText(total);
				}
			}
		});


		// To import a matrix file.
		menuItemLoad2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JFileChooser dialogbox = new JFileChooser();
				int returnVal = dialogbox.showOpenDialog(frame);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					System.out.println("You chose to open this file: " +
							dialogbox.getSelectedFile().getName());
					List<String> lines = null;
					try {
						lines = Files.readAllLines(dialogbox.getSelectedFile().toPath(), Charset.defaultCharset());
					} catch (IOException e) {
						e.printStackTrace();
					}
					String total = "";
					//List<Integer> values = null;
					//List<String> string_values =null;
					//MutablePositiveIntegerMatrix matrix = new MutablePositiveIntegerMatrix(lines.size(),lines.get(0).length());
					for(String line: lines)
					{
						//string_values = line.split(" ");

						total += line + "\n";

					}
					jta2.setText(total);


				}
			}
		});


		// To save the result in a file.
		menuItemLoad3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFileChooser dialogbox = new JFileChooser();
				int returnVal = dialogbox.showSaveDialog(frame);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					try {
						PrintWriter writer = new PrintWriter(dialogbox.getSelectedFile().toPath().toString(), "UTF-8");
						writer.write(jta3.getText());
						writer.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		  
		frame.add(jpanelMatrix);
		frame.pack();
	}
}
