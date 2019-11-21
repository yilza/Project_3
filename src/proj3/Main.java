//**************************************************************************************************
// CLASS: P03.Main (Main.java)
//
// CSE205 Object Oriented Programming and Data Stuctures, Fall B 2019
//Project Number: 3
// AUTHOR: Christopher Barcelon, clbarcel, clbarcel@asu.edu
//**************************************************************************************************
package proj3;

import javax.swing.*;
import java.io.FileNotFoundException;

/**
 * The P03.Main class containing the main() and run() methods.
 */
public class Main {

    /**
     * The number of exams given in the course.
     */
    private static int NUM_EXAMS = 3;

    /**
     * The number of homework assignments in the course.
     */
    private static int NUM_HOMEWORKS = 5;
    
    /**
     * The P03.Roster of students that is read from the input file "gradebook.dat".
     */
    private Roster mRoster;

    /**
     * A reference to the P03.View object.
     */
    private View mView;

    /**
     * This is where execution starts. Instantiate a P03.Main object and then call run().
     */
    public static void main(String[] pArgs) {
        new proj3.Main().run();
    }

    /**
     * exit() is called when the Exit button in the P03.View is clicked. When we exit we have to write
     * the roster to the output file "gradebook.dat". Then we exit the program with a code of 0.
     *
     * We open the file and write the roster to it in a try-catch block, where we catch a
     * FileNotFoundException that will be thrown if for some reason, we cannot open "gradebook.dat"
     * for writing.
     *
     * PSEUDOCODE:
     * method exit() : void
     *     try
     *         instantiate a P03.GradebookWriter object named gbWriter, opening "gradebook.dat" for
     *         writing
     *         call writeGradebook(getRoster()) on gbWriter
     *         call System.exit(0) to terminate the application with an exit code of 0
     *     catch FileNotFoundException e
     *         call messageBox() on getView() to display a message box containing the text "Could
     *         not open gradebook.dat for writing. Exiting without saving."
     *         call System.exit(-1) to terminate the application with an error code of -1
     *     end try-catch
     * end exit
     */
    public void exit() {
        try {
            proj3.GradebookWriter gbWriter = new proj3.GradebookWriter("gradebook.dat");
            gbWriter.writeGradebook(getRoster());
            System.exit(0);
        }
        catch(FileNotFoundException e) {
            getView().messageBox("Could not open gradebook.dat for writing. Exiting without saving.");
            System.exit(-1);
        }
    }

    /**
     * This method returns the number of exams in the class by returning the constant NUM_EXAMS.
     */
    public static final int getNumExams() {
        return NUM_EXAMS;
    }

    /**
     * This method returns the number of homework assignments in the class by returning the
     * constant NUM_HOMEWORKS.
     */
    public static final int getNumHomeworks() {
        return NUM_HOMEWORKS;
    }
    
    /**
     * Accessor method for mRoster.
     */
    private Roster getRoster() {
        return mRoster;
    }

    /**
     * Accessor method for mView.
     */
    private View getView() {
        return mView;
    }

    /**
     * run() is the main routine and is called from main().
     *
     * PSEUDOCODE:
     * method run
     *     call JFrame.setDefaultLookAndFeelDecorated(true or false depending on your preference)
     *     -- Create the P03.View passing 'this' as the argument so the P03.View will be linked to the P03.Main
     *     -- class so they may communicate with each other. Then pass the newly created P03.View object
     *     -- to setView() to save the reference to the P03.View in our instance variable mView.
     *     call setView(new P03.View(this)) to create the P03.View and stored the returned object in mView
     *     try
     *         -- Note that when we try to open "gradebook.dat" for reading that P03.GradebookReader()
     *         -- may throw a FileNotFoundException which we catch here.
     *         create a GradbookReader object named gbReader opening "gradebook.dat" for reading
     *         -- Read the student roster from the input file.
     *         call readGradebook() on gbReader, which returns the P03.Roster
     *         call setRoster() on the P03.Roster returned from readGradebook() to save the roster in
     *         our instance variable mRoster
     *     catch
     *         call messageBox() on getView() to display the error message "Could not open
     *         gradebook.dat for reading. Exiting."
     *         call System.exit(-1) to terminate the application with an exit code of -1
     *     end try-catch
     * end run
     */
    private void run() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        setView(new proj3.View(this));
        try {
            GradebookReader gbReader = new GradebookReader("gradebook.dat");
            setRoster(gbReader.readGradebook());

        }
        catch(FileNotFoundException e) {
            getView().messageBox("Could not open gradebook.dat for reading. Exiting.");
            System.exit(-1);
        }
    }

    /**
     * search() is called when the Search button is clicked in the P03.View. The input parameter is
     * the last name of the P03.Student to search the roster for. Call getStudent(pLastName) on the
     * P03.Roster object (call getRoster() to get the reference to the P03.Roster) to get a reference to
     * the P03.Student with that last name. If the student is not located, getStudent() returns null.
     *
     * @param pLastName The last name of the student who we will search the P03.Roster for.
     *
     * PSEUDOCODE:
     * method search(pLastName : String) : P03.Student
     *     call getRoster().getStudent(pLastName) and return what getStudent() returns
     * end search
     */
    public proj3.Student search(String pLastName) {
        return getRoster().getStudent(pLastName);
    }

    /**
     * Mutator method for mRoster.
     */
    private void setRoster(Roster pRoster) {
        mRoster = pRoster;
    }

    /**
     * Mutator method for mView.
     */
    private void setView(View pView) {
        mView = pView;
    }
}
