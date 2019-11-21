package P03;
//**************************************************************************************************
// CLASS: P03.Student (Student.java)
//
// CSE205 Object Oriented Programming and Data Stuctures, Fall B 2019
//Project Number: 3
// AUTHOR: Christopher Barcelon, clbarcel, clbarcel@asu.edu
//**************************************************************************************************

import java.util.ArrayList;

/**
 * The P03.Student class stores the gradebook information for one P03.Student.
 *
 * Note that P03.Student implements the java.lang.Comparable<P03.Student> interface because we are going
 * to be sorting the roster of students by last name so we need to be able to compare the last
 * names of two students A and B to determine if A < B, or if A = B, or if A > B. See the
 * compareTo() method.
 */
public class Student implements Comparable<Student> {

    /**
     * mCurrStudent is a reference to the P03.Student object which is currently being displayed and
     * edited in the P03.View. It should only be accessed via accessor/mutator methods.
     */
    private static Student mCurrStudent;

    /**
     * mExamList is an ArrayList of Integers storing the student's exam scores.
     */
    private ArrayList<Integer> mExamList;
    
    /**
     * The student's first name.
     */
    private String mFirstName;

    /**
     * mHomework List is an ArrayList of Integers storing the student's homework scores.
     */
    private ArrayList<Integer> mHomeworkList;

    /**
     * The student's lst name.
     */
    private String mLastName;

    /**
     * P03.Student()
     *
     * PSEUDOCODE:
     * method P03.Student(pFirstName : String, pLastName : String)
     *     save parameters pFirstName and pLastName to instance variables by calling mutators
     *     -- Note that we only create the exam list here, it will be populated later
     *     create an ArrayList<Integer> and pass it off to setExamList()
     *     -- Note that we only create the homework list here, it will be populated later
     *     create an ArrayList<Integer> and pass it off to setHomeworkList()
     * end P03.Student()
     */
    public Student(String pFirstName, String pLastName) {
        setFirstName(pFirstName);
        setLastName(pLastName);
        ArrayList<Integer> pHomeworkList = new ArrayList<Integer>();
        ArrayList<Integer> pExamList = new ArrayList<Integer>();
        setExamList(pExamList);
        setHomeworkList(pHomeworkList);
    }

    /**
     * addExam()
     *
     * Adds an exam score pScore to the exam list
     *
     * @param pScore
     *
     * PSEUDOCODE:
     * method addExam(pScore : int) : void
     *     call add(pScore) on getExamList() to add a new exam score to the list of exam scores.
     * end addExam
     */
    public void addExam(int pScore) {
        getExamList().add(pScore);
    }

    /**
     * addHomework()
     *
     * Adds a homework score pScore to the homework list
     *
     * @param pScore
     *
     * PSEUDOCODE:
     * method addHomework(pScore : int) : void
     *     call add(pScore) on getHomeworkList() to add a new homework score to the list of
     *     homework scores
     * end addHomework
     */
    public void addHomework( int pScore) {
        getHomeworkList().add(pScore);
    }

    /**
     * compareTo()
     *
     * @param pStudent is a P03.Student
     *
     * This method compares the last name of 'this' P03.Student to the last name of pStudent to
     * determine if the last name of 'this' P03.Student is <, =, or > the last name of pStudent.
     * It is called during the quick sort routine in Sorter.partition().
     *
     * Provide the annotation that prevents accidental overloading since we are overriding the
     * String.compareTo() method.
     *
     * PSEUDOCODE:
     * method compareTo(pStudent : P03.Student) : int
     *     return: negative int if the last name of this P03.Student is < the last name of pStudent
     *     return: zero if the last name of this P03.Student is = the last name of pStudent
     *     return: positive int if the last name of this P03.Student is > the last name of pStudent
     *     hint: the last names are Strings and String already implements compareTo().
     * end compareTo
     */
    @Override
    public int compareTo(Student pStudent) {
        return this.getLastName().compareTo(pStudent.getLastName());
    }
    
    /**
     * Accessor method for mCurrStudent.
     */ 
    public static Student getCurrStudent() {
        return mCurrStudent;
    }

    /**
     * getExam()
     *
     * Accessor method to retrieve an exam score from the list of exams.
     *
     * @param pNum The exam number for which we wish to retrieve the score.
     *
     * @return The exam score.
     *
     * Hint: Call getExamList() to get the ArrayList<Integer> object storing the exam scores.
     * Since that object is an ArrayList<Integer>, we next call the get(index) method to retrieve
     * the correct exam score.
     */
    public int getExam(int pNum) {
        return getExamList().get(pNum);
    }

    /**
     * getExamList()
     *
     * Accessor method for mExamList.
     */
    private ArrayList<Integer> getExamList() {
        return mExamList;
    }

    /**
     * getFirstName()
     *
     * Accessor method for mFirstName.
     */
    public String getFirstName() {
        return mFirstName;
    }

    /**
     * getFullName()
     *
     * Returns the student's full name in the format: "lastname, firstname".
     */
    public String getFullName() {
        return getLastName() +", "+getFirstName();
    }
    
    /**
     * getHomework()
     *
     * Accessor method to retrieve a homework score from the list of homeworks.
     *
     * @param pNum The homework number for which we wish to retrieve the score.
     *
     * @return The homework score.
     *
     * Hint: Call getHomeworkList() to get the ArrayList<Integer> object storing the hw scores.
     * Since that object is an ArrayList<Integer>, we next call the get(index) method to retrieve
     * the correct hw score.
     */
    public int getHomework(int pNum) {
        return getHomeworkList().get(pNum);
    }

    /**
     * getHomeworkList()
     *
     * Accessor method for mHomeworkList.
     */
    private ArrayList<Integer> getHomeworkList() {
        return mHomeworkList;
    }

    /**
     * getLastname()
     *
     * Accessor method for mLastName.
     */
    public String getLastName() {
        return mLastName;
    }

    /**
     * Mutator method for mCurrStudent.
     */ 
    public static void setCurrStudent(Student pCurrStudent) {
        mCurrStudent = pCurrStudent;
    }

    /**
     * setExam()
     *
     * Mutator method to store an exam score into the list of exam scores.
     *
     * @pNum is the index into the list of exams, where 0 is the index of the first exam score.
     *
     * See the hint for getExam(). This method will be similar, but rather than calling get()
     * on the ArrayList<Integer> object to get a score, we need to call set(index, value) method
     * to set the value in the ArrayList<Integer> at index 'index' to 'value'.
     */
    public void setExam(int pNum, int pScore) {
        getExamList().set(pNum, pScore);
    }

    /**
     * setExamList()
     *
     * Mutator method for mExamList.
     */
    private void setExamList(ArrayList<Integer> pExamList) {
        mExamList = pExamList;
    }

    /**
     * setFirstName()
     *
     * Mutator method for mFirstName.
     */
    public void setFirstName(String pFirstName) {
        mFirstName = pFirstName;
    }

    /**
     * setHomework()
     *
     * Mutator method to store a homework score into the list of homework scores.
     *
     * @pNum is the index into the list of homeworks, where 0 is the index of the first hw score.
     *
     * See the hint for getHomework(). This method will be similar, but rather than calling get()
     * on the ArrayList<Integer> object to get a score, we need to call set(index, value) method
     * to set the value in the ArrayList<Integer> at index 'index' to 'value'.
     */
    public void setHomework(int pNum, int pScore) {
        getHomeworkList().set(pNum, pScore);
    }

    /**
     * setHomeworkList()
     *
     * Mutator method for mHomeworkList.
     */
    private void setHomeworkList(ArrayList<Integer> pHomeworkList) {
        mHomeworkList = pHomeworkList;
    }

    /**
     * setLastname()
     *
     * Mutator method for mLastName.
     */
    public void setLastName(String pLastName) {
        mLastName = pLastName;
    }

    /**
     * toString()
     *
     * Returns a String representation of this P03.Student. The format of the returned string shall be
     * such that the P03.Student information can be printed to the output file in this format:
     *
     *     lastname firstname exam1 exam2 exam2 hw1 hw2 hw3 hw4 hw5
     *
     * where the fields are separated by spaces, except there is not space following hw5.
     *
     * Hint: The String class has a method named trim() that removes leading and trailing white-
     * space from a string.
     *
     * Hint: use enhanced for loops
     */
    @Override
    public String toString() {
        String result = getLastName() + " " + getFirstName() + " ";
        for (Integer exam : getExamList()) {
            result += exam + " ";
        }
        for (Integer hw : getHomeworkList()) {
            result += hw + " ";
        }
        return result.trim();
    }
}
