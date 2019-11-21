//**************************************************************************************************
// CLASS: P03.GradebookReader (GradebookReader.java)
//
// CSE205 Object Oriented Programming and Data Stuctures, Fall B 2019
//Project Number: 3
// AUTHOR: Christopher Barcelon, clbarcel, clbarcel@asu.edu
//**************************************************************************************************
package proj3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * P03.GradebookReader() reads the gradebook info from the file whose name is passed to the ctor.
 * Once the input file has been read, it will return a P03.Roster object containing the list of
 * Students in the course.
 */
public class GradebookReader  {

    /**
     * mIn is used to read from the input file.
     */
    private Scanner mIn;

    /**
     * Attempts to open the gradebook file for reading. If successful, mIn will be used to read
     * from the file. If the file cannot be opened, a FileNotFoundException will be thrown.
     *
     * Note that this  method does not actually read the information from the file. That is done
     * lated when readRoster() is called from P03.Main.run().
     *
     * @throws FileNotFoundException
     *
     * @param pFname The name of the file to be opened for reading. For this project it will be
     *               "gradebook.dat"
     */
    public GradebookReader(String pFname) throws FileNotFoundException {
        mIn = new Scanner(new File(pFname));
    }

    /**
     * Reads the exam scores for a P03.Student.
     *
     * The number of exams is retrieved by calling the static getNumExams() method in P03.Main.
     *
     * @param pStudent The student for whom we are going to read the exam scores from the input
     *                 file.
     */
    private void readExam(Student pStudent) {
        for (int n = 0; n < Main.getNumExams(); ++n) {
            pStudent.addExam(mIn.nextInt());
        }
    }

    /**
     * Called to read the gradebook information. Calls readRoster() to read the student records and
     * then sorts the roster by last name.
     *
     * Called from P03.Main.run().
     *
     * @return The roster of students that was read from the input file.
     */
    public Roster readGradebook() {
        Roster roster = readRoster();
        roster.sortRoster();
        return roster;
    }

    /**
     * Reads the homework scores for a P03.Student.
     *
     * The number of homework assignments is retrieved by calling the static getNumHomeworks()
     * method in P03.Main.
     *
     * @param pStudent The student for whom we are going to read the homework scores from the input
     *                 file.
     */
    private void readHomework(Student pStudent) {
        for (int n = 0; n < Main.getNumHomeworks(); ++n) {
            pStudent.addHomework(mIn.nextInt());
        }
    }

    /**
     * Reads the student information for each student in the input file, adding each student to
     * the roster.
     *
     * Called from readGradebook().
     *
     * @return The roster of students that was read from the input file.
     */
    private Roster readRoster() {
        Roster roster = new Roster();
        while (mIn.hasNext()) {
            // See §2 Background for the format of each P03.Student record in the input file.
            String lastName = mIn.next();
            String firstName = mIn.next();
            Student student = new Student(firstName, lastName);
            readExam(student);
            readHomework(student);
            roster.addStudent(student);
        }
        return roster;
    }
}