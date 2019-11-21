//**************************************************************************************************
// CLASS: P03.Searcher (Searcher.java)
//
// CSE205 Object Oriented Programming and Data Stuctures, Fall B 2019
//Project Number: 3
// AUTHOR: Christopher Barcelon, clbarcel, clbarcel@asu.edu
//**************************************************************************************************
package P03;

import java.util.ArrayList;

public class Searcher {
    /**
     * Uses a recursive binary search to return the index of a student in a list of students
     * @param pList List of students to be searched
     * @param pKey  Student that is being searched for
     * @return returns index of student; -1 if student not found
     */
    public static int search(ArrayList<Student> pList,String pKey) {
        return recSearch(pList, pKey, 0, pList.size());
    }

    /**
     * Recursive binary search
     * @param pList
     * @param pKey
     * @param pLow
     * @param pHigh
     * @return
     */
    private static int recSearch(ArrayList<Student> pList, String pKey, int pLow, int pHigh) {
        if(pLow > pHigh) {
            return -1;
        }
        int middle = (pLow + pHigh)/2;
        if(pList.get(middle).getLastName().equals(pKey)) {
            return middle;
        }
        else if(pList.get(middle).getLastName().compareTo(pKey) < 0) {
            return recSearch(pList, pKey, middle+1, pHigh);
        }
        else {
            return recSearch(pList, pKey, pLow, middle-1);
        }
    }

}


