//**************************************************************************************************
// CLASS: P03.Sorter (Sorter.java)
//
// CSE205 Object Oriented Programming and Data Stuctures, Fall B 2019
//Project Number: 3
// AUTHOR: Christopher Barcelon, clbarcel, clbarcel@asu.edu
//**************************************************************************************************
package P03;

import java.util.ArrayList;

public class Sorter {
    /**
     * partition method of quickSort, picks a pivot and sorts all the objects smaller than the pivot into one partition
     * of the list and all the greater objects in the other partition.
     * @param pList The list to be partitioned
     * @param pFromIdx  The lower bound of the partition
     * @param pToIdx    The upper bound of the partition
     * @return
     */
    private static int partition(ArrayList<Student> pList, int pFromIdx, int pToIdx) {
        String pivot = pList.get(pFromIdx).getLastName();
        pFromIdx--;
        pToIdx++;
        while(pFromIdx < pToIdx) {
            pFromIdx++;
            while(pList.get(pFromIdx).getLastName().compareTo(pivot) < 0) {
                pFromIdx++;
            }
            pToIdx--;
            while (pList.get(pToIdx).getLastName().compareTo(pivot) > 0) {
                pToIdx--;
            }
            if(pFromIdx < pToIdx) {
                swap(pList, pFromIdx, pToIdx);
            }
        }
        return pToIdx;
    }

    /**
     * swaps two students in an ArrayList of students
     * @param pList the list of students
     * @param i the index of the first student to be swapped
     * @param j the index of the second student to be swapped
     */
    private static void swap(ArrayList<Student> pList, int i, int j) {
        Student temp = pList.get(i);
        pList.set(i, pList.get(j));
        pList.set(j, temp);
    }

    /**
     * A recursive qucksort method utilizing the partition method
     * @param pList The list to be sorted
     * @param pFromIdx  The lower bound the of the list that will be looked at
     * @param pToIdx    The uppper bound of the list that will be looked at
     */
    private static void quickSort(ArrayList<Student> pList, int pFromIdx, int pToIdx) {
        if (pFromIdx < pToIdx) {
            int partIdx = partition(pList, pFromIdx, pToIdx-1);

            quickSort(pList, pFromIdx, partIdx);
            quickSort(pList, partIdx+1, pToIdx);
        }
    }

    /**
     * public sort method that will utilize the private quicksort method
     * @param pList the list to be sorted
     */
    public static void sort(ArrayList<Student> pList) {
        if(pList.size() == 0) {
            return;
        }
        quickSort(pList, 0, pList.size());
    }
}

