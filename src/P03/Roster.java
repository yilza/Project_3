//**************************************************************************************************
// CLASS: P03.Roster (Roster.java)
//
// CSE205 Object Oriented Programming and Data Stuctures, Fall B 2019
//Project Number: 3
// AUTHOR: Christopher Barcelon, clbarcel, clbarcel@asu.edu
//**************************************************************************************************
package P03;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * The P03.Roster class encapsulates an ArrayList<P03.Student> object named mStudentList which stores the
 * information for each student that was read from "gradebook.dat" when the app started.
 */
public class Roster {

    /**
     * Declare mStudentList as ArrayList<P03.Student>
     */
    private ArrayList<P03.Student> mStudentList;

    /**
     * P03.Roster()
     *
     * PSEUDOCODE:
     * method P03.Roster()
     *     -- Note that mStudentList was already declared so we do not need to declare it here.
     *     -- What we need to do here is create the ArrayList<P03.Student> object that mStudentList
     *     -- will refer to.
     *     create an ArrayList<P03.Student> object and then pass that object as the argument to
     *     setStudentList() to make mStudentList refer to the ArrayList
     * end P03.Roster
     */
    public Roster() {
        ArrayList<Student> list = new ArrayList<Student>();
        setStudentList(list);
    }

    /**
     * addStudent()
     *
     * Adds pstudent to the ArrayList
     *
     * PSEUDOCODE:
     * method addStudent(pStudent : P03.Student) : void
     *     add (will append) pStudent to mStudentList
     * end method
     */
    public void addStudent(P03.Student pStudent) {
        mStudentList.add(pStudent);

    }

    /**
     * getStudent()
     *
     * Searches mStudentList for a P03.Student with pLastName.
     *
     * PSEUDOCODE:
     * method getStudent(pLastName : String) : P03.Student
     *     -- Get the index of the student in the student list
     *     index = call Searcher.search(getStudentList(), pLastName)
     *     -- If index is -1 then no student with that last name could be found so we return
     *     -- null. Otherwise, we get the P03.Student from the student list at the index and return
     *     -- the P03.Student.
     *     if index == -1 then return null
     *     else return the P03.Student object in getStudentList() at index 'index'
     * end getStudent
     */
    public Student getStudent(String pLastName) {
        int index = Searcher.search(getStudentList(), pLastName);
        if(index == -1) {
            return null;
        }
        else {
            return getStudentList().get(index);
        }
    }

    /**
     * getStudentList()
     *
     * Accessor method for mStudentList.
     *
     * Note: it is extremely sleazy to provide public access to the entire private student list
     * (mStudentList) in this way because it gives whoever calls this method the ability to
     * modify any P03.Student in the roster. It would be better to have the P03.Roster class implement an
     * iterator that would permit other objects to iterate over the elements of the list, but in an
     * effort to keep the project as simple as possible, I am taking the sleazy route.
     *
     * If you are so inclinded, by all means, implement the iterator.
     */
    public ArrayList<Student> getStudentList() {
        return mStudentList;
    }

    /**
     * setStudentList()
     *
     * Mutator method for mStudentList.
     */
    private void setStudentList(ArrayList<Student> pStudentList) {
        mStudentList = pStudentList;
    }

    /**
     * sortRoster()
     * Called to sort the roster by last name.
     *
     * PSEUDOCODE:
     * method sortRoster()
     *     -- Note that all of the methods in Sorter are class methods, so we call the sort()
     *     -- method on the class Sorter.
     *     call Sorter.sort() passing the list of students returned from getStudentList()
     * end sortRoster
     */
    public void sortRoster() {
        Sorter.sort(getStudentList());
    }

    /**
     * Returns a String representation of this P03.Roster. toString() methods are very handy for
     * debugging because given access to a P03.Roster object, say named roster, then you can print
     * the entire roster in one statement: System.out.println(roster);
     */
    @Override
    public String toString() {
        String result = "";
        for (Student student : getStudentList()) {
            result += student + "\n";
        }
        return result;
    }
}
