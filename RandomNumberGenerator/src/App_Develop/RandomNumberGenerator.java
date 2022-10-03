package App_Develop;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;


public class RandomNumberGenerator implements ActionListener{

	//initilize window size, frame, GUI, Etc. 
	JFrame frame;
	JPanel panel;
	JTextField textSpace1, textSpace2, textSpace3;
	Font appFont = new Font("Arial", Font.PLAIN, 11);
	Font labelFont = new Font("Arial", Font.PLAIN, 15);
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[4];
	JButton generateButton, deleteButton, enterButton, clearButton;
	JLabel label1, label2, label3;
	 
	//initialize variables
	double numRange1, numRange2, genNumber;
	
	boolean enterPressed = false, generateNumber = false;
	
	public RandomNumberGenerator() {
		
		//making window
		frame = new JFrame("Random Number Generator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(410, 236);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);

		
		//create textSpace1
		JLabel label1 = new JLabel("From: ");
		label1.setFont(labelFont);
		label1.setBounds(26, 0, 120, 30);
		frame.add(label1);
		textSpace1 = new JTextField();
		textSpace1.setBounds(25, 28, 140, 30);
		textSpace1.setHorizontalAlignment(JTextField.RIGHT);
		textSpace1.setFont(labelFont);
		textSpace1.setEditable(false);
		frame.add(textSpace1);
		
		//create textSpace2
		JLabel label2 = new JLabel("To: ");
		label2.setFont(labelFont);
		label2.setBounds(26, 58, 120, 30);
		frame.add(label2);
		textSpace2 = new JTextField();
		textSpace2.setBounds(25, 88, 140, 30);
		textSpace2.setHorizontalAlignment(JTextField.RIGHT);
		textSpace2.setFont(labelFont);
		textSpace2.setEditable(false);
		frame.add(textSpace2);
		
		//create textSpace3
		JLabel label3 = new JLabel("Random Number: ");
		label3.setFont(labelFont);
		label3.setBounds(26, 118, 120, 30);
		frame.add(label3);
		textSpace3 = new JTextField();
		textSpace3.setBounds(25, 148, 140, 30);
		textSpace3.setHorizontalAlignment(JTextField.RIGHT);
		textSpace3.setFont(labelFont);
		textSpace3.setEditable(false);
		frame.add(textSpace3);
		
		//function buttons
		generateButton = new JButton("GENERATE");
		deleteButton = new JButton("DEL");
		enterButton = new JButton("ENT");
		clearButton = new JButton("CLR");

		
		functionButtons[0] = generateButton;
		functionButtons[1] = deleteButton;
		functionButtons[2] = enterButton;
		functionButtons[3] = clearButton;


		//setting for function buttons
		for(int i = 0; i < 4; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setFont(appFont);
		}
		
		//number Buttons
		for(int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(appFont);
			numberButtons[i].setFocusable(false);
			}
		
		//add buttons, gui
		panel = new JPanel();
		panel.setBounds(175, 46, 175, 134);
		panel.setLayout(new GridLayout(4, 4, 5, 5));

		generateButton.setBounds(235, 10, 115, 32);
		clearButton.setBounds(175, 10, 55, 32 );
		
		frame.add(panel);
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(deleteButton);
		panel.add(numberButtons[3]);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(numberButtons[0]);
		panel.add(enterButton);

		frame.add(generateButton);
		frame.add(clearButton);
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		RandomNumberGenerator randomGenerator = new RandomNumberGenerator();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//display number whenever the numberButton is pressed
		for(int i = 0; i < 10; i++) {
			//number displayed in first text box first then to the second after enterButton is pressed
			if(e.getSource() == numberButtons[i] && enterPressed == false && generateNumber == false) {
				textSpace1.setText(textSpace1.getText().concat(String.valueOf(i)));
			}
			else if (e.getSource() == numberButtons[i] && enterPressed == true && generateNumber == false) {
				textSpace2.setText(textSpace2.getText().concat(String.valueOf(i)));
			}
		}
		//delete number in a text box
		if(e.getSource() == deleteButton && enterPressed == false && generateNumber == false) {
			String string = textSpace1.getText();
			textSpace1.setText("");
			for(int i = 0; i<string.length() -1; i++) {
				textSpace1.setText(textSpace1.getText() + string.charAt(i));
			}
		}
		else if (e.getSource() == deleteButton && enterPressed == true && generateNumber == false) {
			String string = textSpace2.getText();
			textSpace2.setText("");
			for (int i = 0; i < string.length() - 1; i++) {
				textSpace2.setText(textSpace2.getText() + string.charAt(i));
			}
		}
		//enter button is pressed, number in first text box will be stored and go to next text box
		if(e.getSource() == enterButton && enterPressed == false && generateNumber == false) {
			numRange1 = Double.parseDouble(textSpace1.getText());
			textSpace1.setText(""+ numRange1);
			enterPressed = true;
		}
		else if(e.getSource() == enterButton && enterPressed == true && generateNumber == false) {
			numRange2 = Double.parseDouble(textSpace2.getText());
			textSpace2.setText("" + numRange2);
			generateNumber = true;
		}
		//generateNumber when there is enough information
		if(e.getSource() == generateButton && generateNumber == true) {
			genNumber = (int)(Math.random() * ((numRange2 - numRange1) + 1)) + numRange1;
			textSpace3.setText(String.valueOf(genNumber));
		}
		//clear all and do with another numbers, continue the application.
		if(e.getSource() == clearButton) {
			enterPressed = false;
			generateNumber = false;
			textSpace1.setText("");
			textSpace2.setText("");
			textSpace3.setText("");
		}
	}
}
