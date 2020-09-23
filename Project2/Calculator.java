import javax.swing.*;


import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

public class Calculator extends JFrame implements ActionListener{
	final static boolean shouldFill = true; // determining how to fill in window space
	final static boolean shouldWeightX = true; // for left parentheses button
	final static boolean RIGHT_TO_LEFT = false; // for setting component orientation

	// declaring all the buttons and labels to be used
	JButton leftparenthesesButton;
	JButton rightparenthesesButton;
	JButton zeroButton;
	JButton equalsButton;
	JButton EButton;
	JButton FButton;
	JButton oneButton;
	JButton twoButton;
	JButton threeButton;
	JButton plusButton;
	JButton CButton;
	JButton DButton;
	JButton fourButton;
	JButton fiveButton;
	JButton sixButton;
	JButton minusButton;
	JButton AButton;
	JButton BButton;
	JButton sevenButton;
	JButton eightButton;
	JButton nineButton;
	JButton timesButton;
	JButton upArrowButton;
	JButton modButton;
	JButton CEButton;
	JButton CancelButton;
	JButton deleteButton;
	JButton divideButton;
	JButton LSHButton;
	JButton RSHButton;
	JButton OrButton;
	JButton XORButton;
	JButton NotButton;
	JButton AndButton;
	JButton hexButton;
	static JButton decButton;
	JButton octButton;
	JButton binButton;
	JLabel hexLabel;
	JLabel decLabel;
	JLabel octLabel;
	JLabel binLabel;
	JButton TenDotButton;
	JButton FiveDotButton;
	JButton WORDButton;
	JButton MSButton;
	JButton MButton;
	JButton threeBars;
	JLabel programmer;
	JLabel operation; 
	JLabel answer;
	
	String result; // holds the result as a String
	boolean answerFlag = false; // determines whether the next value will be appended to answer text
	boolean parenthesesFlag = false; // determines whether parentheses is used or not
	int parenthesesCounter = 0; // keeps track of parentheses entered
	boolean userFlag = false; // determines whether the value is user generated or systen generated
	String wordMode = new String ("QWORD"); // limits size of number entered depending on what mode is currently on
	static String baseMode = "DEC"; // default base is decimal for the calc
	static int radix = 10; // for parsing, default is 10
	static boolean equalsFlag = false; // if equals button is selected or not


	public Calculator() {
		JPanel pane = new JPanel(); // creating a JPanel to portray the calculator
		pane.setLayout(new GridBagLayout()); // setting it to a gridbag layout
		GridBagConstraints c = new GridBagConstraints();

		if (RIGHT_TO_LEFT) { // to set component orientation from right to left
			pane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		}

		if (shouldFill) { 
			// natural height, maximum width
			c.fill = GridBagConstraints.BOTH;
		}

		c.gridwidth = 1; // setting grid width of 1 for the following buttons

		// adding left parentheses button
		leftparenthesesButton = new JButton("("); 
		leftparenthesesButton.setPreferredSize(new Dimension(75, 60));
		if (shouldWeightX) {
			c.weightx = 0.5;
			c.weighty = 0.5;
		}
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 50;
		pane.add(leftparenthesesButton, c);

		// adding right parentheses button
		rightparenthesesButton = new JButton(")");
		rightparenthesesButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 50;
		pane.add(rightparenthesesButton, c);

		// add zero button
		zeroButton = new JButton("0");
		zeroButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 3;
		c.gridy = 50;
		pane.add(zeroButton, c);

		// add equals button
		equalsButton = new JButton("=");
		equalsButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 5;
		c.gridy = 50;
		pane.add(equalsButton, c);

		// add E button for hexadecimal operations
		EButton = new JButton("E");
		EButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 49;
		pane.add(EButton, c);

		// add F button for hexadecimal operations
		FButton = new JButton("F");
		FButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 49;
		pane.add(FButton, c);

		// add one button
		oneButton = new JButton("1");
		oneButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 49;
		pane.add(oneButton, c);

		// add two button 
		twoButton = new JButton("2");
		twoButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 3;
		c.gridy = 49;
		pane.add(twoButton, c);

		// add three button
		threeButton = new JButton("3");
		threeButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 4;
		c.gridy = 49;
		pane.add(threeButton, c);

		// add plus button
		plusButton = new JButton("+");
		plusButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 5;
		c.gridy = 49;
		pane.add(plusButton, c);

		// add C Button for hexadecimal operations
		CButton = new JButton("C");
		CButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 48;
		pane.add(CButton, c);

		// add D button for hexadecimal operations
		DButton = new JButton("D");
		DButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 48;
		pane.add(DButton, c);

		// add four button
		fourButton = new JButton("4");
		fourButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 48;
		pane.add(fourButton, c);

		// add five button
		fiveButton = new JButton("5");
		fiveButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 3;
		c.gridy = 48;
		pane.add(fiveButton, c);

		// add six button
		sixButton = new JButton("6");
		sixButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 4;
		c.gridy = 48;
		pane.add(sixButton, c);

		// add subtraction operator
		minusButton = new JButton("-");
		minusButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 5;
		c.gridy = 48;
		pane.add(minusButton, c);

		// add A button for hexadecimal operations
		AButton = new JButton("A");
		AButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 47;
		pane.add(AButton, c);

		// add B button for hexadecimal operations
		BButton = new JButton("B");
		BButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 47;
		pane.add(BButton, c);

		// add seven button
		sevenButton = new JButton("7");
		sevenButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 47;
		pane.add(sevenButton, c);

		// add eight button
		eightButton = new JButton("8");
		eightButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 3;
		c.gridy = 47;
		pane.add(eightButton, c);

		// add nine button
		nineButton = new JButton("9");
		nineButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 4;
		c.gridy = 47;
		pane.add(nineButton, c);

		// add multiplication button
		timesButton = new JButton("x");
		timesButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 5;
		c.gridy = 47;
		pane.add(timesButton, c);

		// add button with no functionality
		upArrowButton = new JButton("^");
		upArrowButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 46;
		pane.add(upArrowButton, c);

		// add mod button
		modButton = new JButton("Mod");
		modButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 46;
		pane.add(modButton, c);

		// CE button for clearing
		CEButton = new JButton("CE");
		CEButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 46;
		pane.add(CEButton, c);

		// C button for clearing 
		CancelButton = new JButton("C");
		CancelButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 3;
		c.gridy = 46;
		pane.add(CancelButton, c);

		// <-- delete button for deleting a digit
		deleteButton = new JButton("<--");
		deleteButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 4;
		c.gridy = 46;
		pane.add(deleteButton, c);

		// divide button for dividing
		divideButton = new JButton("/");
		divideButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 5;
		c.gridy = 46;
		pane.add(divideButton, c);

		// button with no functionality
		LSHButton = new JButton("Lsh");
		LSHButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 45;
		pane.add(LSHButton, c);

		// button with no functionality
		RSHButton = new JButton("Rsh");
		RSHButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 45;
		pane.add(RSHButton, c);

		// button with no functionality
		OrButton = new JButton("Or");
		OrButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 45;
		pane.add(OrButton, c);

		// button with no functionality
		XORButton = new JButton("Xor");
		XORButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 3;
		c.gridy = 45;
		pane.add(XORButton, c);

		// button with no functionality
		NotButton = new JButton("Not");
		NotButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 4;
		c.gridy = 45;
		pane.add(NotButton, c);

		// button with no functionality
		AndButton = new JButton("And");
		AndButton.setPreferredSize(new Dimension(75, 60));

		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 5;
		c.gridy = 45;
		pane.add(AndButton, c);

		// hex button to change mode to hexadecimal
		hexButton = new JButton("HEX");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.insets = (new Insets(0, 0, 5, 0));
		c.gridx = 0;
		c.gridy = 40;
		pane.add(hexButton, c);
		//	myButtonGroup.add(hexButton);

		// decbutton to change mode to decimal
		decButton = new JButton("DEC");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 41;
		pane.add(decButton, c);
		//	myButtonGroup.add(decButton);

		// oct button to change mode to octal
		octButton = new JButton("OCT");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 42;
		pane.add(octButton, c);
		//	myButtonGroup.add(octButton);

		// bin button to change mode to binary
		binButton = new JButton("BIN");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 43;
		pane.add(binButton, c);
		//	myButtonGroup.add(binButton);

		// hexLabel will display the hexadecimal version of the answer
		hexLabel = new JLabel("0");
		hexLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.insets = (new Insets(0, 0, 0, 0));
		c.gridx = 1;
		c.gridy = 40;
		c.gridwidth = GridBagConstraints.REMAINDER;
		pane.add(hexLabel, c);

		// decLabel will display the decimal version of the answer
		decLabel = new JLabel("0");
		decLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 41;
		pane.add(decLabel, c);

		// octLabel will display the octal version of the answer
		octLabel = new JLabel("0");
		octLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 42;
		pane.add(octLabel, c);

		// binLabel will display the binary version of the answer
		binLabel = new JLabel("0");
		binLabel.setFont(new Font("Serif", Font.PLAIN, 15));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 43;
		pane.add(binLabel, c);

		// button with no functionality
		TenDotButton = new JButton(":::::");
		TenDotButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 44;
		c.gridwidth = 1;
		pane.add(TenDotButton, c);

		// button with no functionality
		FiveDotButton = new JButton("::.");
		FiveDotButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 44;
		pane.add(FiveDotButton, c);

		// before adding word, adjust grid width
		c.gridwidth = 2;

		// Word button will change the max value entered by user
		WORDButton = new JButton("QWORD");
		WORDButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 2;
		c.gridy = 44;
		pane.add(WORDButton, c);

		// before adding MS, re-adjust grid width
		c.gridwidth = 1;

		// button with no functionality
		MSButton = new JButton("MS");
		MSButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 4;
		c.gridy = 44;
		pane.add(MSButton, c);

		// button with no functionality
		MButton = new JButton("M");
		MButton.setPreferredSize(new Dimension(75, 60));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 5;
		c.gridy = 44;
		pane.add(MButton, c);

		// operation label will keep track of the operations from the user
		operation = new JLabel("",SwingConstants.RIGHT);
		operation.setFont(new Font("Serif", Font.PLAIN, 20));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = (new Insets(0, 0, 5, 0));
		pane.add(operation, c);

		// answer label will display the answer of the operation
		answer = new JLabel("0", SwingConstants.RIGHT);
		answer.setFont(new Font("Serif", Font.PLAIN, 30));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		c.insets = (new Insets(0, 0, 10, 0));
		pane.add(answer, c);

		// setting gridwidth back to 1 for correct button size
		c.gridwidth = 1;

		// button with no functionality
		threeBars = new JButton("|||");
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = (new Insets(0, 0, 0, 0));
		pane.add(threeBars, c);

		// calculator mode(dummy label)
		programmer = new JLabel("Programmer");
		programmer.setFont(new Font("Serif", Font.PLAIN, 20));
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = GridBagConstraints.REMAINDER;
		pane.add(programmer, c);

		// adding panel to frame
		add(pane, BorderLayout.PAGE_END);

		// enabling actionlistener for the specified buttons
		zeroButton.addActionListener(this);
		oneButton.addActionListener(this);
		twoButton.addActionListener(this);
		threeButton.addActionListener(this);
		fourButton.addActionListener(this);
		fiveButton.addActionListener(this);
		sixButton.addActionListener(this);
		sevenButton.addActionListener(this);
		eightButton.addActionListener(this);
		nineButton.addActionListener(this);
		AButton.addActionListener(this);
		BButton.addActionListener(this);
		CButton.addActionListener(this);
		DButton.addActionListener(this);
		EButton.addActionListener(this);
		FButton.addActionListener(this);
		CancelButton.addActionListener(this);
		CEButton.addActionListener(this);
		deleteButton.addActionListener(this);
		divideButton.addActionListener(this);
		timesButton.addActionListener(this);
		minusButton.addActionListener(this);
		plusButton.addActionListener(this);
		modButton.addActionListener(this);
		equalsButton.addActionListener(this);
		leftparenthesesButton.addActionListener(this);
		rightparenthesesButton.addActionListener(this);
		hexButton.addActionListener(this);
		binButton.addActionListener(this);
		octButton.addActionListener(this);
		decButton.addActionListener(this);
		WORDButton.addActionListener(this);
		


	}

	public void setNumber(String expression) { // this function will set the first number to
		// the number entered by user, excluding the zero
		long result = 0;
		if (answer.getText() == "0") {
			// setting answerlabel to expression and calling the set functions to update labels
			answer.setText(expression); 
			setHex(answer.getText());
			setBin(answer.getText());
			setDec(answer.getText());
			setOct(answer.getText());
		}

		else {
			if (answerFlag == false) { // answerFlag false, so you can append at the end
				if (wordMode.compareTo("QWORD") == 0) { // if QWord, the following restrictions are applied
					
					// setting restriction for hex mode
					if (baseMode.compareTo("HEX")==0 && (answer.getText() + expression).length() <= 15 &&  !equalsFlag) {
						answer.setText(answer.getText() + expression);	
						setHex(answer.getText());
						setBin(answer.getText());
						setDec(answer.getText());
						setOct(answer.getText());
					}
					// setting restriction for dec mode
					if (baseMode.compareTo("DEC")==0 && (answer.getText() + expression).length() <= 17 &&  !equalsFlag) {
						answer.setText(answer.getText() + expression);	
						setHex(answer.getText());
						setBin(answer.getText());
						setDec(answer.getText());
						setOct(answer.getText());
					}
					// setting restriction for oct mode
					if (baseMode.compareTo("OCT")==0 && (answer.getText() + expression).length() <= 17 &&  !equalsFlag) {
						answer.setText(answer.getText() + expression);	
						setHex(answer.getText());
						setBin(answer.getText());
						setDec(answer.getText());
						setOct(answer.getText());
					}
					// setting restriction for bin mode
					if (baseMode.compareTo("BIN")==0 && (answer.getText() + expression).length() <= 63 &&  !equalsFlag) {
						answer.setText(answer.getText() + expression);	
						setHex(answer.getText());
						setBin(answer.getText());
						setDec(answer.getText());
						setOct(answer.getText());
					}
				}
				
				if (wordMode.compareTo("DWORD") == 0) { // if DWORD mode is on, set the following restrictions
					
					// setting restrictions for hex mode
					if (baseMode.compareTo("HEX")==0 && (answer.getText() + expression).length() <= 8 &&  !equalsFlag) {
						answer.setText(answer.getText() + expression);	
						setHex(answer.getText());
						setBin(answer.getText());
						setDec(answer.getText());
						setOct(answer.getText());
					}
					// setting restrictions for dec mode
					if (baseMode.compareTo("DEC")==0 && (answer.getText() + expression).length() <= 9 &&  !equalsFlag) {
						answer.setText(answer.getText() + expression);	
						setHex(answer.getText());
						setBin(answer.getText());
						setDec(answer.getText());
						setOct(answer.getText());
					}
					// setting restrictions for oct mode
					if (baseMode.compareTo("OCT")==0 && (answer.getText() + expression).length() <= 10 &&  !equalsFlag) {
						answer.setText(answer.getText() + expression);	
						setHex(answer.getText());
						setBin(answer.getText());
						setDec(answer.getText());
						setOct(answer.getText());
					}
					// setting restrictions for bin mode
					if (baseMode.compareTo("BIN")==0 && (answer.getText() + expression).length() <= 32 &&  !equalsFlag) {
						answer.setText(answer.getText() + expression);	
						setHex(answer.getText());
						setBin(answer.getText());
						setDec(answer.getText());
						setOct(answer.getText());
					}
				}
				
				if (wordMode.compareTo("WORD") == 0) { // if WORD is selected, apply restrictions
					
					// setting restrictions for hex mode
					if (baseMode.compareTo("HEX")==0 && (answer.getText() + expression).length() <= 4 &&  !equalsFlag) {
						answer.setText(answer.getText() + expression);	
						setHex(answer.getText());
						setBin(answer.getText());
						setDec(answer.getText());
						setOct(answer.getText());
					}
					// setting restrictions for dec mode
					if (baseMode.compareTo("DEC")==0 && (answer.getText() + expression).length() <= 4 &&  !equalsFlag) {
						answer.setText(answer.getText() + expression);	
						setHex(answer.getText());
						setBin(answer.getText());
						setDec(answer.getText());
						setOct(answer.getText());
					}
					// setting restrictions for oct mode
					if (baseMode.compareTo("OCT")==0 && (answer.getText() + expression).length() <= 6 &&  !equalsFlag) {
						answer.setText(answer.getText() + expression);	
						setHex(answer.getText());
						setBin(answer.getText());
						setDec(answer.getText());
						setOct(answer.getText());
					}
					// setting restriction for bin mode
					if (baseMode.compareTo("BIN")==0 && (answer.getText() + expression).length() <= 16 &&  !equalsFlag) {
						answer.setText(answer.getText() + expression);	
						setHex(answer.getText());
						setBin(answer.getText());
						setDec(answer.getText());
						setOct(answer.getText());
					}
				}
				
				if (wordMode.compareTo("BYTE") == 0) { // if BYTE is selected, apply following restrictions
					
					// setting restriction for hex mode
					if (baseMode.compareTo("HEX")==0 && (answer.getText() + expression).length() <= 2 &&  !equalsFlag) {
						answer.setText(answer.getText() + expression);	
						setHex(answer.getText());
						setBin(answer.getText());
						setDec(answer.getText());
						setOct(answer.getText());
					}
					// setting restriction for dec mode
					if (baseMode.compareTo("DEC")==0 && (answer.getText() + expression).length() <= 3 &&  !equalsFlag) {
						answer.setText(answer.getText() + expression);	
						setHex(answer.getText());
						setBin(answer.getText());
						setDec(answer.getText());
						setOct(answer.getText());
					}
					// setting restriction for oct mode
					if (baseMode.compareTo("OCT")==0 && (answer.getText() + expression).length() <= 3 &&  !equalsFlag) {
						answer.setText(answer.getText() + expression);	
						setHex(answer.getText());
						setBin(answer.getText());
						setDec(answer.getText());
						setOct(answer.getText());
					}
					// setting restriction for bin mode
					if (baseMode.compareTo("BIN")==0 && (answer.getText() + expression).length() <= 8 &&  !equalsFlag) {
						answer.setText(answer.getText() + expression);	
						setHex(answer.getText());
						setBin(answer.getText());
						setDec(answer.getText());
						setOct(answer.getText());
					}
				}
				
				
			
			}
			else {
				answer.setText(expression);	// if answerFlag is true, you cannot append, so the next number will now be the answer
			}
			if(equalsFlag) { // if equals flag is true, equals button must have been pressed, so:
				operation.setText(""); // clear operation text
				answer.setText(expression);// set answer label to the expression entered
				equalsFlag=false; // reset equals flag to false
			}
		}
		answerFlag=false;	
		userFlag = true;
	}

	public void setHex(String hex) { // converting decimal to hexadecimal
		long number = Long.parseLong(hex,radix); // parsing long to base radix of 16, which is later defined
		String Hex = Long.toHexString(number);
		hexLabel.setText(Hex);
	}

	public void setDec(String dec) { // showing the decimal version
		long number = Long.parseLong(dec,radix); // parsing long to base radix of 10, which is later defined
		String Dec = Long.toString(number);
		decLabel.setText(Dec);
	}

	public void setBin(String bin) { // converting decimal to binary
		long number = Long.parseLong(bin,radix); // parsing long to base radix of 2, which is later defined
		String Bin = Long.toBinaryString(number);
		binLabel.setText(Bin);
	}

	public void setOct(String oct) { // decimal to octal
		long number = Long.parseLong(oct,radix); // parsing long to base radix of 8, which is later defined
		String Oct = Long.toOctalString(number);
		octLabel.setText(Oct);
	}
	
	/** Evaluate an expression */
	public static int evaluateExpression(String expression) {
		equalsFlag=false;
		// Create operandStack to store operands
		Stack<Integer> operandStack = new Stack<>();

		// Create operatorStack to store operators
		Stack<Character> operatorStack = new Stack<>();

		// Insert blanks around (, ), +, -, /, and *
		expression = insertBlanks(expression);

		// Extract operands and operators
		String[] tokens = expression.split(" ");

		// Phase 1: Scan tokens
		for (String token: tokens) {
			if (token.length() == 0) // Blank space
				continue; // Back to the while loop to extract the next token
			else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
				// Process all +, -, *, / in the top of the operator stack 
				while (!operatorStack.isEmpty() &&
						(operatorStack.peek() == '+' || 
						operatorStack.peek() == '-' ||
						operatorStack.peek() == '*' ||
						operatorStack.peek() == '/' ||
						operatorStack.peek() == '%')) {
					processAnOperator(operandStack, operatorStack);
				}

				// Push the + or - operator into the operator stack
				operatorStack.push(token.charAt(0));
			}
			else if (token.charAt(0) == '*' || token.charAt(0) == '/' || token.charAt(0) == '%') {
				// Process all *, / in the top of the operator stack 
				while (!operatorStack.isEmpty() &&
						(operatorStack.peek() == '*' ||
						operatorStack.peek() == '/' ||
						operatorStack.peek() == '%')) {
					processAnOperator(operandStack, operatorStack);
				}

				// Push the * or / operator into the operator stack
				operatorStack.push(token.charAt(0));
			}
			else if (token.trim().charAt(0) == '(') {
				operatorStack.push('('); // Push '(' to stack
			}
			else if (token.trim().charAt(0) == ')') {
				// Process all the operators in the stack until seeing '('
				while (operatorStack.peek() != '(') {
					processAnOperator(operandStack, operatorStack);
				}

				operatorStack.pop(); // Pop the '(' symbol from the stack
			}
			else { // An operand scanned
				// Push an operand to the stack
				// in evalFunction, tokenResult will represent the entered values
				// and convert to the appropriate base from the radix defined
				int tokenResult = Integer.parseInt(token, radix);
				operandStack.push(tokenResult);
				
				
			}
		}

		// Phase 2: process all the remaining operators in the stack 
		while (!operatorStack.isEmpty()) {
			processAnOperator(operandStack, operatorStack);
		}

		// Return the result
		return operandStack.pop();
	}

	/** Process one operator: Take an operator from operatorStack and
	 *  apply it on the operands in the operandStack */
	public static void processAnOperator(
			Stack<Integer> operandStack, Stack<Character> operatorStack) {
		char op = operatorStack.pop();
		int op1 = operandStack.pop();
		int op2 = operandStack.pop();
		if (op == '+') 
			operandStack.push(op2 + op1);
		else if (op == '-') 
			operandStack.push(op2 - op1);
		else if (op == '*') 
			operandStack.push(op2 * op1);
		else if (op == '/') 
			operandStack.push(op2 / op1);
		else if (op == '%') 
			operandStack.push(op2 % op1);
	}

	public static String insertBlanks(String s) {
		String result = "";

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == ')' || 
					s.charAt(i) == '+' || s.charAt(i) == '-' ||
					s.charAt(i) == '*' || s.charAt(i) == '/' || 
					s.charAt(i) == '%')
				result += " " + s.charAt(i) + " ";
			else
				result += s.charAt(i);
		}

		return result;
	}
	
	
	
	public void updateUI(String type) { // UpdateUI will activate and remove functionality from certain buttons
										// when a specific mode is turned on or selected
		if (type == "DEC"){ // when dec mode is selected, activate and remove specified buttons
			AButton.setBackground(Color.lightGray);
			AButton.setEnabled(false);
			BButton.setBackground(Color.lightGray);
			BButton.setEnabled(false);
			CButton.setBackground(Color.lightGray);
			CButton.setEnabled(false);
			DButton.setBackground(Color.lightGray);
			DButton.setEnabled(false);
			EButton.setBackground(Color.lightGray);
			EButton.setEnabled(false);
			FButton.setBackground(Color.lightGray);
			FButton.setEnabled(false);
			twoButton.setBackground(getBackground());;
			twoButton.setEnabled(true);
			threeButton.setBackground(getBackground());;
			threeButton.setEnabled(true);
			fourButton.setBackground(getBackground());;
			fourButton.setEnabled(true);
			fiveButton.setBackground(getBackground());;
			fiveButton.setEnabled(true);
			sixButton.setBackground(getBackground());;
			sixButton.setEnabled(true);
			sevenButton.setBackground(getBackground());;
			sevenButton.setEnabled(true);
			eightButton.setBackground(getBackground());
			eightButton.setEnabled(true);
			nineButton.setBackground(getBackground());
			nineButton.setEnabled(true);
		}
		if (type == "HEX") { // if hex mode is selected, activate all buttons
			AButton.setBackground(getBackground());;
			AButton.setEnabled(true);
			BButton.setBackground(getBackground());;
			BButton.setEnabled(true);
			CButton.setBackground(getBackground());;
			CButton.setEnabled(true);
			DButton.setBackground(getBackground());;
			DButton.setEnabled(true);
			EButton.setBackground(getBackground());;
			EButton.setEnabled(true);
			FButton.setBackground(getBackground());;
			FButton.setEnabled(true);
			twoButton.setBackground(getBackground());;
			twoButton.setEnabled(true);
			threeButton.setBackground(getBackground());;
			threeButton.setEnabled(true);
			fourButton.setBackground(getBackground());;
			fourButton.setEnabled(true);
			fiveButton.setBackground(getBackground());;
			fiveButton.setEnabled(true);
			sixButton.setBackground(getBackground());;
			sixButton.setEnabled(true);
			sevenButton.setBackground(getBackground());;
			sevenButton.setEnabled(true);
			eightButton.setBackground(getBackground());;
			eightButton.setEnabled(true);
			nineButton.setBackground(getBackground());;
			nineButton.setEnabled(true);
			
		}
		if (type == "OCT") { // if oct mode is selected, activate and remove specified buttons
			AButton.setBackground(Color.lightGray);
			AButton.setEnabled(false);
			BButton.setBackground(Color.lightGray);
			BButton.setEnabled(false);
			CButton.setBackground(Color.lightGray);
			CButton.setEnabled(false);
			DButton.setBackground(Color.lightGray);
			DButton.setEnabled(false);
			EButton.setBackground(Color.lightGray);
			EButton.setEnabled(false);
			FButton.setBackground(Color.lightGray);
			FButton.setEnabled(false);
			eightButton.setBackground(Color.lightGray);
			eightButton.setEnabled(false);
			nineButton.setBackground(Color.lightGray);
			nineButton.setEnabled(false);
			twoButton.setBackground(getBackground());;
			twoButton.setEnabled(true);
			threeButton.setBackground(getBackground());;
			threeButton.setEnabled(true);
			fourButton.setBackground(getBackground());;
			fourButton.setEnabled(true);
			fiveButton.setBackground(getBackground());;
			fiveButton.setEnabled(true);
			sixButton.setBackground(getBackground());;
			sixButton.setEnabled(true);
			sevenButton.setBackground(getBackground());;
			sevenButton.setEnabled(true);
			
		}
		if (type == "BIN") { // if bin mode is selected, turn off all buttons but 1 and 0
			AButton.setBackground(Color.lightGray);
			AButton.setEnabled(false);
			BButton.setBackground(Color.lightGray);
			BButton.setEnabled(false);
			CButton.setBackground(Color.lightGray);
			CButton.setEnabled(false);
			DButton.setBackground(Color.lightGray);
			DButton.setEnabled(false);
			EButton.setBackground(Color.lightGray);
			EButton.setEnabled(false);
			FButton.setBackground(Color.lightGray);
			FButton.setEnabled(false);
			eightButton.setBackground(Color.lightGray);
			eightButton.setEnabled(false);
			nineButton.setBackground(Color.lightGray);
			nineButton.setEnabled(false);
			twoButton.setBackground(Color.lightGray);;
			twoButton.setEnabled(false);
			threeButton.setBackground(Color.lightGray);;
			threeButton.setEnabled(false);
			fourButton.setBackground(Color.lightGray);;
			fourButton.setEnabled(false);
			fiveButton.setBackground(Color.lightGray);;
			fiveButton.setEnabled(false);
			sixButton.setBackground(Color.lightGray);;
			sixButton.setEnabled(false);
			sevenButton.setBackground(Color.lightGray);;
			sevenButton.setEnabled(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) { // function which will describe what will occur
											// when a certain button is pressed
		
		if (e.getSource() == decButton) { // if decButton is pressed
			updateUI("DEC"); // call updateUI for proper button functionality
			baseMode = "DEC"; // set baseMode to DEC
			radix=10; // set the radix to 10, which will be the proper base to parse
			if(decLabel.getText().compareTo("0")!=0) // making sure the operation and answer text outputs right value 
			operation.setText(decLabel.getText());
			answer.setText(decLabel.getText());
			
		}

		if (e.getSource() == hexButton) { // if hexButton is pressed
			updateUI("HEX"); // call updateUI for HEX
			baseMode = "HEX"; // baseMode is now HEX
			radix=16; // base to parse is 16
			
			if(hexLabel.getText().compareTo("0")!=0) // making sure operation and answer text output right values
			operation.setText(hexLabel.getText());
			answer.setText(hexLabel.getText());
			
		}
		
		if (e.getSource() == octButton) { // if oct is pressed
			updateUI("OCT"); // call updateUI for OCT
			baseMode = "OCT"; // update baseMode to OCT
			radix=8; // parsing base is now 8
			
			if(octLabel.getText().compareTo("0")!=0) // making sure operation and answer text outputs are correct
			operation.setText(octLabel.getText());
			answer.setText(octLabel.getText());
		
		}
		
		if (e.getSource() == binButton) { // if bin is pressed
			updateUI("BIN"); // updateUI to BIN
			baseMode = "BIN"; // baseMode to BIN
			radix=2; // parsing base to 2
			
			if(binLabel.getText().compareTo("0")!=0) // making sure operation and answer text outputs are correct
			operation.setText(binLabel.getText());
			answer.setText(binLabel.getText());

		}
		
		if (e.getSource() == WORDButton) { // if the WORDButton is selected
			boolean updated = true; // set the updated flag to true, since there is a new limit
			if (wordMode.compareTo("BYTE")==0 && updated) { // if button was byte, now it is Qword
				wordMode = "QWORD";
				WORDButton.setText("QWORD");
				updated=false;
			}
			if (wordMode.compareTo("WORD")==0 && updated) { // if button was word, now it is byte
				wordMode = "BYTE";
				WORDButton.setText("BYTE");
				updated=false;
			}
			if (wordMode.compareTo("DWORD")==0 && updated) { // if button was dword, now it is word
				wordMode = "WORD";
				WORDButton.setText("WORD");
				updated=false;
			}
			if (wordMode.compareTo("QWORD")==0 && updated) { // if button is qword, now it is dword
				wordMode="DWORD";
				WORDButton.setText("DWORD");
				updated=false;
			}
		}

		if (e.getSource() == zeroButton) { // displaying zero
			setNumber("0");
			setHex("0");
		}

		if (e.getSource() == oneButton) { // displaying one
			setNumber("1");

		}

		if (e.getSource() == twoButton) { // displaying two
			setNumber("2");

		}

		if (e.getSource() == threeButton) { // displaying three
			setNumber("3");

		}

		if (e.getSource() == fourButton) { // displaying four
			setNumber("4");

		}

		if (e.getSource() == fiveButton) { // displaying five
			setNumber("5");


		}

		if (e.getSource() == sixButton) { // displaying six
			setNumber("6");

		}

		if (e.getSource() == sevenButton) { // displaying seven
			setNumber("7");

		}

		if (e.getSource() == eightButton) { // displaying eight
			setNumber("8");

		}

		if (e.getSource() == nineButton) { // displaying nine
			setNumber("9");

		}

		if (e.getSource() == AButton) { // displaying a
			setNumber("a");

		}

		if (e.getSource() == BButton) { // displaying b
			setNumber("b");

		}

		if (e.getSource() == CButton) { // displaying c
			setNumber("c");

		}

		if (e.getSource() == DButton) { // displaying d
			setNumber("d");

		}

		if (e.getSource() == EButton) { // displaying d
			setNumber("e");

		}

		if (e.getSource() == FButton) { // displaying f
			setNumber("f");

		}

		if (e.getSource() == CancelButton) { // if this button is clicked
			// the values entered will be cleared
			answer.setText("0");
			operation.setText("");
			hexLabel.setText("0");
			binLabel.setText("0");
			decLabel.setText("0");
			octLabel.setText("0");
		}

		if (e.getSource() == CEButton) { // if this button is clicked
			// user entry will be cleared
			answer.setText("0");
			hexLabel.setText("0");
			binLabel.setText("0");
			decLabel.setText("0");
			octLabel.setText("0");
		}

		if (e.getSource() == plusButton) { // inserting a +	
            
			try {
				// condition to see how operation and answer texts are set
				if(!answerFlag && userFlag) { // if answerflag is false and userflag is true
					// update the following
					operation.setText(operation.getText() + answer.getText() + "+");
					answer.setText(Integer.toString(evaluateExpression(operation.getText().substring(0, operation.getText().length()-1))));
					userFlag = false;
				}
				else { // to make sure a plus sign is entered
					
					if(operation.getText().charAt(operation.getText().length()-1) != '+' && 
					operation.getText().charAt(operation.getText().length()-1) != '-' && 
					operation.getText().charAt(operation.getText().length()-1) != '*' && 
					operation.getText().charAt(operation.getText().length()-1) != '/' &&
					operation.getText().charAt(operation.getText().length()-1) != '%') {
						operation.setText(operation.getText() + "+");
					}
					// setting answer text
					answer.setText(Integer.toString(evaluateExpression(operation.getText().substring(0, operation.getText().length()-1))));
					userFlag = false;	
				}
				// conditions for baseModes
				if(baseMode.compareTo("HEX")==0) {
					answer.setText(Integer.toHexString(Integer.parseInt(answer.getText())));
				}
				if(baseMode.compareTo("DEC")==0) {
					answer.setText(Integer.toString(Integer.parseInt(answer.getText())));
				}
				if(baseMode.compareTo("OCT")==0) {
					answer.setText(Integer.toOctalString(Integer.parseInt(answer.getText())));
				}
				if(baseMode.compareTo("BIN")==0) {
					answer.setText(Integer.toBinaryString(Integer.parseInt(answer.getText())));
				}
				answerFlag = true;
				System.out.println("answerFlag:");
				System.out.print(answerFlag);
			}
			catch (Exception ex) { // for bad input
				//operation.setText(answer.getText());
				System.out.print("Wrong!");
				answerFlag = true;
				userFlag = false;
			}

		}

		if (e.getSource() == minusButton) { // inserting a -
			// follows plus button logic
			try { 
				if(!answerFlag && userFlag) {
					operation.setText(operation.getText() + answer.getText() + "-");
					answer.setText(Integer.toString(evaluateExpression(operation.getText().substring(0, operation.getText().length()-1))));
					userFlag = false;
				}
				else {
					if(operation.getText().charAt(operation.getText().length()-1) != '+' && 
							operation.getText().charAt(operation.getText().length()-1) != '-' && 
							operation.getText().charAt(operation.getText().length()-1) != '*' && 
							operation.getText().charAt(operation.getText().length()-1) != '/' &&
							operation.getText().charAt(operation.getText().length()-1) != '%') {
						operation.setText(operation.getText() + "-");
					}
					answer.setText(Integer.toString(evaluateExpression(operation.getText().substring(0, operation.getText().length()-1))));
					userFlag = false;	
				}
				if(baseMode.compareTo("HEX")==0) {
					answer.setText(Integer.toHexString(Integer.parseInt(answer.getText())));
				}
				if(baseMode.compareTo("DEC")==0) {
					answer.setText(Integer.toString(Integer.parseInt(answer.getText())));
				}
				if(baseMode.compareTo("OCT")==0) {
					answer.setText(Integer.toOctalString(Integer.parseInt(answer.getText())));
				}
				if(baseMode.compareTo("BIN")==0) {
					answer.setText(Integer.toBinaryString(Integer.parseInt(answer.getText())));
				}
				answerFlag = true;
				System.out.println("answerFlag:");
				System.out.print(answerFlag);
			}
			catch (Exception ex) { // bad input
				//operation.setText(answer.getText());
				System.out.print("Wrong!");
				answerFlag = true;
			}


		}

		if (e.getSource() == divideButton) { // inserting a /
			// follows operator logic
			try {
				if(!answerFlag && userFlag) {
					operation.setText(operation.getText() + answer.getText() + "/");
					answer.setText(Integer.toString(evaluateExpression(operation.getText().substring(0, operation.getText().length()-1))));
					userFlag = false;
				}
				else {
					if(operation.getText().charAt(operation.getText().length()-1) != '+' && 
							operation.getText().charAt(operation.getText().length()-1) != '-' && 
							operation.getText().charAt(operation.getText().length()-1) != '*' && 
							operation.getText().charAt(operation.getText().length()-1) != '/' &&
							operation.getText().charAt(operation.getText().length()-1) != '%') {
						operation.setText(operation.getText() + "/");
					}
					answer.setText(Integer.toString(evaluateExpression(operation.getText().substring(0, operation.getText().length()-1))));
					userFlag = false;	
				}
				if(baseMode.compareTo("HEX")==0) {
					answer.setText(Integer.toHexString(Integer.parseInt(answer.getText())));
				}
				if(baseMode.compareTo("DEC")==0) {
					answer.setText(Integer.toString(Integer.parseInt(answer.getText())));
				}
				if(baseMode.compareTo("OCT")==0) {
					answer.setText(Integer.toOctalString(Integer.parseInt(answer.getText())));
				}
				if(baseMode.compareTo("BIN")==0) {
					answer.setText(Integer.toBinaryString(Integer.parseInt(answer.getText())));
				}
				answerFlag = true;
				System.out.println("answerFlag:");
				System.out.print(answerFlag);
			}
			catch (Exception ex) { // bad input
				//operation.setText(answer.getText());
				System.out.print("Wrong!");
				answerFlag = true;
			}

		}

		if (e.getSource() == timesButton) { // inserting a x
			// operator logic
			try {
				if(!answerFlag && userFlag) {
					operation.setText(operation.getText() + answer.getText() + "*");
					answer.setText(Integer.toString(evaluateExpression(operation.getText().substring(0, operation.getText().length()-1))));
					userFlag = false;
				}
				else {
					if(operation.getText().charAt(operation.getText().length()-1) != '+' && 
							operation.getText().charAt(operation.getText().length()-1) != '-' && 
							operation.getText().charAt(operation.getText().length()-1) != '*' && 
							operation.getText().charAt(operation.getText().length()-1) != '/' &&
							operation.getText().charAt(operation.getText().length()-1) != '%') {
						operation.setText(operation.getText() + "*");
					}
					answer.setText(Integer.toString(evaluateExpression(operation.getText().substring(0, operation.getText().length()-1))));
					userFlag = false;	
				}
				if(baseMode.compareTo("HEX")==0) {
					answer.setText(Integer.toHexString(Integer.parseInt(answer.getText())));
				}
				if(baseMode.compareTo("DEC")==0) {
					answer.setText(Integer.toString(Integer.parseInt(answer.getText())));
				}
				if(baseMode.compareTo("OCT")==0) {
					answer.setText(Integer.toOctalString(Integer.parseInt(answer.getText())));
				}
				if(baseMode.compareTo("BIN")==0) {
					answer.setText(Integer.toBinaryString(Integer.parseInt(answer.getText())));
				}
				answerFlag = true;
				System.out.println("answerFlag:");
				System.out.print(answerFlag);
			}
			catch (Exception ex) { // bad input
				//operation.setText(answer.getText());
				System.out.print("Wrong!");
				answerFlag = true;
			}

		}

		if (e.getSource() == deleteButton) { // this will delete the last number entered by user

			if (!(answer.getText().equals("0") || answer.getText().equals(""))) {
				String temp = answer.getText();
				temp = temp.substring(0, temp.length()-1);
				answer.setText(temp);
			}
			if (answer.getText().equals("")) {
				answer.setText("0");
			}
			setHex(answer.getText());
			setBin(answer.getText());
			setDec(answer.getText());
			setOct(answer.getText());


		}

		if (e.getSource() == modButton) { // inserting a %
			try {
				if(!answerFlag && userFlag) {
					operation.setText(operation.getText() + answer.getText() + "%");
					answer.setText(Integer.toString(evaluateExpression(operation.getText().substring(0, operation.getText().length()-1))));
					userFlag = false;
				}
				else {
					if(operation.getText().charAt(operation.getText().length()-1) != '+' && 
							operation.getText().charAt(operation.getText().length()-1) != '-' && 
							operation.getText().charAt(operation.getText().length()-1) != '*' && 
							operation.getText().charAt(operation.getText().length()-1) != '/' &&
							operation.getText().charAt(operation.getText().length()-1) != '%') {
						operation.setText(operation.getText() + "%");
					}
					answer.setText(Integer.toString(evaluateExpression(operation.getText().substring(0, operation.getText().length()-1))));
					userFlag = false;	
				}
				answerFlag = true;
				System.out.println("answerFlag:");
				System.out.print(answerFlag);
			}
			catch (Exception ex) { // bad input
				//operation.setText(answer.getText());
				System.out.print("Wrong!");
				answerFlag = true;
			}

		}

		if (e.getSource() == equalsButton) { // will show the result in the answer label
			//			JOptionPane.showMessageDialog(null, answer.getText());
			// try and catch block will make sure the operation entered when pressing equal
			// is logical and correct
			
			try {
				long result = 0;
				if (userFlag) { // if userFlag
					result = evaluateExpression(operation.getText() + answer.getText());
					userFlag=false;
				}
				else { // otherwise
					result = evaluateExpression(operation.getText());
				}
				System.out.println("\nresult");
				System.out.println(operation.getText());
				System.out.println(answer.getText());
				System.out.println(operation.getText() + answer.getText());
				System.out.println(Long.toString(result)); 
				// setting operation and answer texts appropriately
				answer.setText(Long.toString(result));
				operation.setText(Long.toString(result));
				if(baseMode.compareTo("HEX")==0) {
					answer.setText(Long.toHexString(result));
					operation.setText(Long.toHexString(result));
				}
				if(baseMode.compareTo("OCT")==0) {
					answer.setText(Long.toOctalString(result));
					operation.setText(Long.toOctalString(result));
				}
				if(baseMode.compareTo("BIN")==0) {
					answer.setText(Long.toBinaryString(result));
					operation.setText(Long.toBinaryString(result));
				}
				setHex(answer.getText());
				setBin(answer.getText());
				setOct(answer.getText());
				setDec(answer.getText());
				answerFlag=true;
				equalsFlag=true;
				
			}
			catch (Exception ex) { // bad input
				System.out.println("Wrong expression: " + operation.getText() + answer.getText());
				
			}
		}

		if (e.getSource() == leftparenthesesButton) { // left parentheses selected
			
			operation.setText(operation.getText() + "(");
			parenthesesCounter++; // update parentheses counter

		}

		if (e.getSource() == rightparenthesesButton) { // right parentheses selected
			System.out.print(operation.getText() + answer.getText());
			System.out.println("userflag:");
			System.out.print(userFlag);
			if (userFlag) {
				operation.setText(operation.getText() + answer.getText() + ")");
			}
			else {
				operation.setText(operation.getText() + ")");
			}
		
			parenthesesCounter--; // update parenthesescounter
			try {
				long result1 = 0;
				String result = "";
				if (parenthesesCounter == 0) { // if parentheses counter is 0, return
					result1 = evaluateExpression(operation.getText());
					result = Long.toString(result1);
					answer.setText(result);
					userFlag=false;
					setHex(result);
					setBin(result);
					setOct(result);
					setDec(result);
				}
				if (parenthesesCounter < 0) { // if less that 0, irrational
					operation.setText("");
					answer.setText("0");
					JOptionPane.showMessageDialog(null, "Irrational Expression");
					parenthesesCounter = 0;
				}
			
				answerFlag=true;
				
				
			}
			catch (Exception ex) { // bad input
				operation.setText("");
				answer.setText("0");
				JOptionPane.showMessageDialog(null, "Irrational Expression");
				

			}


		}

	}

	public static void main(String[] args) {
		// creating and showing this application's GUI
		Calculator calc = new Calculator();

		calc.setTitle("Calculator");
		calc.setVisible(true);
		calc.setSize(400, 600);
		calc.setResizable(true);
		calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		decButton.doClick();
		calc.pack();

	}




}	

