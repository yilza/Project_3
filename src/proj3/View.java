package proj3;
//**************************************************************************************************
// CLASS: P03.View (View.java)
//
// CSE205 Object Oriented Programming and Data Stuctures, Fall B 2019
//Project Number: 3
// AUTHOR: Christopher Barcelon, clbarcel, clbarcel@asu.edu
//**************************************************************************************************

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * The P03.View class implements the GUI. It is a subclass of JFrame and implements the ActionListener
 * interface so that we can respond to user-initiated GUI events.
 */
public class View extends JFrame implements ActionListener {

    /**
     * The width of the P03.View frame.
     */
    public static final int FRAME_WIDTH = 525;

    /**
     * The height of the P03.View frame.
     */
    public static final int FRAME_HEIGHT = 225;
    
    /**
     * When the P03.View() ctor is called from P03.Main.run() to create the P03.View, run() passes a reference
     * to the P03.Main object as the argument to P03.View(). We save that reference into mMain and then
     * later we can use mMain to communicate with the P03.Main class.
     *
     * mMain is made accessible within this class via accessor/mutator methods getMain() and
     * setMain(). It shall not be directly accessed.
     */
    private Main mMain;


    /**
     * Declare GUI related instance variables for the buttons and text fields.
     */
    private JButton mClearButton;
    private JTextField[] mExamText;
    private JButton mExitButton;
    private JTextField[] mHomeworkText;
    private JButton mSaveButton;
    private JButton mSearchButton;
    private JTextField mStudentName;
    
    /**
     * P03.View()
     *
     * The P03.View constructor creates the GUI interface and makes the frame visible at the end.
     *
     * @param pMain is an instance of the P03.Main class. This links the P03.View to the P03.Main class so
     * they may communicate with each other.
     */
    public View(Main pMain) {

        /**
         * Save a reference to the P03.Main object pMain into instance var mMain by calling setMain().
         */
        setMain(pMain);

        // PSEUDOCODE:
        // Create a JPanel named panelSearch which uses the FlowLayout
        // Add a JLabel "P03.Student Name: " to panelSearch
        // Create mStudentName and make the field 25 cols wide
        // Add mStudentName to the panel
        // Create mSearchButton with the label "Search"
        // Make this P03.View the action listener for the button
        // Add the button to the panel
        JPanel panelSearch = new JPanel();
        panelSearch.setLayout(new FlowLayout());
        JLabel label = new JLabel("P03.Student name: ");
        panelSearch.add(label);
        mStudentName = new JTextField(25);
        panelSearch.add(mStudentName);
        mSearchButton = new JButton("Search");
        mSearchButton.addActionListener(this);
        panelSearch.add(mSearchButton);

        // PSEUDOCODE:
        // Create a JPanel named panelHomework which uses the FlowLayout
        // Add a JLabel "Homework: " to the panel
        // Create mHomeworkText which is an array of JTextFields, one for each homework assignment
        // For i = 0 to the number of homework assignments Do
        //     Create a textfield mHomeworkText[i] displaying 5 cols
        //     Add mHomeworkText[i] to the panel
        // End For
        // Note: DO NOT HARDCODE THE NUMBER OF HOMEWORK ASSIGNMENTS
        JPanel panelHomework = new JPanel();
        panelHomework.setLayout(new FlowLayout());
        label = new JLabel("Homework");
        panelHomework.add(label);
        mHomeworkText = new JTextField[proj3.Main.getNumHomeworks()];
        for(int i = 0; i< proj3.Main.getNumHomeworks(); i++) {
            mHomeworkText[i] = new JTextField(5);
            panelHomework.add(mHomeworkText[i]);
        }
        // Create the exam panel which contains the "Exam: " label and the two exam text fields.
        // The pseudocode is omitted because this code is very similar to the code that creates the
        // panelHomework panel above.
        // Note: DO NOT HARDCODE THE NUMBER OF EXAMS
        JPanel panelExam = new JPanel();
        label = new JLabel("Exam");
        panelExam.add(label);
        mExamText = new JTextField[proj3.Main.getNumExams()];
        for(int i = 0; i< proj3.Main.getNumExams(); i++) {
            mExamText[i] = new JTextField(5);
            panelExam.add(mExamText[i]);
        }

        // PSEUDOCODE:
        // Create a JPanel named panelButtons using FlowLayout
        // Create the Clear button mClearButton labeled "Clear"
        // Make this P03.View the action listener for mClearButton
        // Add the  Clear button to the panel
        // Repeat the three above statements for the Save button
        // Repeat the three above statements for the Exit button
        JPanel panelButtons = new JPanel();
        mClearButton = new JButton("Clear");
        mClearButton.addActionListener(this);
        panelButtons.add(mClearButton);

        mSaveButton = new JButton("Save");
        mSaveButton.addActionListener(this);
        panelButtons.add(mSaveButton);

        mExitButton = new JButton("Exit");
        mExitButton.addActionListener(this);
        panelButtons.add(mExitButton);

        // PSEUDOCODE:
        // Create a JPanel named panelMain using a vertical BoxLayout
        // Add panelSearch to panelMain.
        // Add panelHomework to panelMain
        // Add panelExam to panelMain
        // Add panelButtons to panelMain
        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.add(panelSearch);
        panelMain.add(panelHomework);
        panelMain.add(panelExam);
        panelMain.add(panelButtons);

        // Set the title of the P03.View to whatever you want by calling setTitle()
        setTitle("Gred :: Gradebook Editor");
        
        // Set the size of the P03.View to FRAME_WIDTH x FRAME_HEIGHT
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        
        // Make the P03.View non-resizable
        setResizable(false);
        
        // Set the default close operation to JFrame.DO_NOTHING_ON_CLOSE. This disables the X close
        // button in the title bar of the P03.View so now the only way to exit the program is by click-
        // ing the Exit button. This ensures that P03.Main.exit() will be called so it will write the
        // student records back out to the gradebook database.
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        // Add panelMain to the P03.View.
        add(panelMain);
        
        // If you are a Mac user, you may need to call the pack() method which is inherited from
        // java.awt.Window() now to pack the P03.View before displaying it. Windows and Linux users do
        // not need to do this, although if you do, it will not cause any problems.
        // ???

        // Now display the P03.View by calling setVisible().
        setVisible(true);
    }

    /**
     * actionPerformed()
     *
     * Called when one of the JButtons is clicked. Detects which button was clicked and handles it.
     *
     * Make sure to write the @Override annotation to prevent accidental overloading because we are
     * overriding JFrame.actionPerformed().
     *
     * PSEUDOCOODE:
     * method actionPerformed(pEvent : ActionEvent) : void
     * If the source of the event was the Search button Then
     *     Clear the numbers in the homework and exam fields
     *     lastName = retrieve the text from the mStudentName text field
     *     If lastName is the empty string Then
     *         Call messageBox() to display "Please enter the student's last name."
     *     Else
     *         -- P03.Main contains a method named search() which given the last name of a student
     *         -- will search the P03.Roster for the student. search() either returns the P03.Student
     *         -- object if found, or if there is no student with that last name in the P03.Roster,
     *         -- then search() returns null.
     *         Call getMain().search(lastName) and pass the return value to P03.Student.setCurrStudent()
     *         If the curr student object saved in the P03.Student class is null Then
     *             Call messageBox() to display "P03.Student not found. Try again."
     *         Else
     *             Retrieve the curr student from the P03.Student class and pass it to displayStudent()
     *         End if
     *     End If
     *
     * Else if the source of the event was the Save button Then
     *     If P03.Student.getCurrStudent() is not null Then Call saveStudent(P03.Student.getCurrStudent())
     *
     * Else if the source of the event was the Clear button Then
     *     Call clear()
     *
     * Else if the source of the event was the Exit button Then
     *     If P03.Student.getCurrStudent() is not null Then Call saveStudent(P03.Student.getCurrStudent())
     *     Call getMain().exit() to terminate the application
     * End If
     * end actionPerformed
     */
    @Override
    public void actionPerformed(ActionEvent pEvent) {
        if(pEvent.getActionCommand().equals("Search")) {
            clearNumbers();
            String lastName = mStudentName.getText();
            if(lastName.equals("")) {
                messageBox("Please enter the students last name.");
            }
            else {
                proj3.Student.setCurrStudent(getMain().search(lastName));
                if(Student.getCurrStudent() == null) {
                    messageBox("P03.Student not found. Try again.");
                }
                else {
                    displayStudent(Student.getCurrStudent());
                }
            }
        }
        else if(pEvent.getActionCommand().equals("Save")) {
            if(proj3.Student.getCurrStudent() != null) {
                saveStudent(proj3.Student.getCurrStudent());
            }
        }
        else if(pEvent.getActionCommand().equals("Clear")) {
            clear();
        }
        else if(pEvent.getActionCommand().equals("Exit")) {
            if(proj3.Student.getCurrStudent() != null) {
                saveStudent(proj3.Student.getCurrStudent());
            }
            getMain().exit();
        }
    }

    /**
     * clear()
     *
     * Called when the Clear button is clicked. Clears all of the text fields by setting the
     * contents of each to the empty string.
     *
     * After clear() returns, no student information is being edited or displayed and mStudent
     * has been set to null.
     *
     * PSEUDOCODE:
     * method clear() : void
     *     Set the mStudentName text field to ""
     *     Clear the numbers in the homework and exam fields by calling clearNumbers()
     *     Set the current P03.Student object in the P03.Student class to null
     * end clear
     */
    private void clear(){
        mStudentName.setText("");
        clearNumbers();
        proj3.Student.setCurrStudent(null);
    }

    /**
     * clearNumbers()
     *
     * Clears the homework and exam fields.
     *
     * DO NOT HARCODE THE NUMBER OF HOMEWORKS AND EXAMS. Call the constant accessor methods in
     * P03.Main.
     */
    private void clearNumbers() {
        for(JTextField j : mHomeworkText) {
            j.setText("");
        }
        for(JTextField j : mExamText) {
            j.setText("");
        }
    }
    
    /**
     * displayStudent()
     *
     * Displays the homework and exam scores for a student in the mHomeworkText and mExamText text
     * fields.
     *
     * @param pStudent is the P03.Student who's scores we are going to use to populate the text fields.
     *
     * PSEUDOCODE:
     * method displayStudent(pStudent : P03.Student) : void
     *     For i = 0 to P03.Main.getNumHomeworks - 1 Do
     *         int hw = pStudent.getHomework(i)
     *         String hwstr = convert hw to a String (Hint: Integer.toString())
     *         mHomeworkText[i].setText(hwstr)
     *     End For
     *     Write a similar for loop to place the student's exams scores into the text fields
     * end displayStudent
     *
     * DO NOT HARCODE THE NUMBER OF HOMEWORKS AND EXAMS. Call the constant accessor methods in
     * P03.Main.
     */
    private void displayStudent(Student pStudent) {
        mStudentName.setText(pStudent.getLastName() +", " + pStudent.getFirstName());
        for(int i = 0; i< proj3.Main.getNumHomeworks(); i++) {
            int hw = pStudent.getHomework(i);
            String hwstr = Integer.toString(hw);
            mHomeworkText[i].setText(hwstr);
        }
        for(int i = 0; i< proj3.Main.getNumExams(); i++) {
            int ex = pStudent.getExam(i);
            String exstr = Integer.toString(ex);
            mExamText[i].setText(exstr);
        }
    }

    /**
     * Accessor method for mMain.
     */ 
    private Main getMain() {
        return mMain;
    }    

    /**
     * messageBox()
     *
     * Displays a message box containing some text. Note: read the Java 8 API page for JOptionPane
     * to see what the constructor arguments are to showMessageDialog(). You want to pass the 
     * appropriate "thing" for the first argument so your message dialog window will be centered
     * in the middle of the P03.View frame. If your P03.View frame is centered in the middle of your screen
     * then you did not pass the right "thing".
     *
     * PSEUDOCODE:
     * method messageBox(pMessage : String) : void
     *     Call JOptionPane.showMessageDialog() to display pMessage.
     * end messageBox
     */
    public void messageBox(String pMessage) {
        JOptionPane.showMessageDialog(this, pMessage, "Message", JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * saveStudent()
     *
     * Retrieves the homework and exam scores for pStudent from the text fields and writes the
     * results to the P03.Student record in the P03.Roster.
     *
     * PSEUDOCODE:
     * method saveStudent(pStudent : P03.Student) : void
     *     For i = 0 to P03.Main.getNumHomeworks - 1 Do
     *         String hwstr = mHomeworkText[i].getText()
     *         int hw = convert hwstr to an int (Hint: Integer.parseInt())
     *         Call pStudent.setHomework(i, hw)
     *     End For
     *     Write a similar for loop to save the exam scores in pStudent
     * end method saveStudent
     *
     * DO NOT HARDCODE THE NUMBER OF HOMEWORKS AND EXAMS
     */
    private void saveStudent(proj3.Student pStudent) {
        for(int i = 0; i< proj3.Main.getNumHomeworks(); i++) {
            String hwstr = mHomeworkText[i].getText();
            int hw = Integer.parseInt(hwstr);
            pStudent.setHomework(i, hw);
        }
        for(int i = 0; i< proj3.Main.getNumExams(); i++) {
            String exstr = mExamText[i].getText();
            int hw = Integer.parseInt(exstr);
            pStudent.setExam(i, hw);
        }

    }
    
    /**
     * Mutator method for mMain.
     */ 
    private void setMain(Main pMain) {
        mMain = pMain;
    }    

}
