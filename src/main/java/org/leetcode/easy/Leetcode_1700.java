package org.leetcode.easy;

/*
    The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively.
    All students stand in a queue. Each student either prefers square or circular sandwiches.

    The number of sandwiches in the cafeteria is equal to the number of students.
    The sandwiches are placed in a stack. At each step:

    If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.
    Otherwise, they will leave it and go to the queue's end.
    This continues until none of the queue students want to take the top sandwich and are thus unable to eat.

    You are given two integer arrays students and sandwiches where sandwiches[i] is the type of the ith
    sandwich in the stack (i = 0 is the top of the stack) and students[j] is the preference of the jth
    student in the initial queue (j = 0 is the front of the queue).

    Return the number of students that are unable to eat.


    Example 1:

    Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
    Output: 0
    Explanation:
    - Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].
    - Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].
    - Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
    - Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].
    - Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
    - Front student leaves the top sandwich and returns to the end of the line making students = [0,1].
    - Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].
    - Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
    Hence all students are able to eat.


    Example 2:
    Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]

    (0) [1,1,0,0,1]  ---  [0,0,0,1,1]
    (1) [1,0,0,1 , 1]  ---  [0,0,0,1,1]
    (2) [0,0,1 , 1,1]  ---  [0,0,0,1,1]
    (3) [0,1 , 1,1]  ---  [0,0,1,1]
    (4) [1 , 1,1]  ---  [0,1,1]

    Output: 3

    Constraints:

    1 <= students.length, sandwiches.length <= 100
    students.length == sandwiches.length
    sandwiches[i] is 0 or 1.
    students[i] is 0 or 1.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Leetcode_1700 {

    private static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentsQueue = new LinkedList<>();
        for (int i = 0; i < students.length; i++) {
            studentsQueue.add(students[i]);
        }

        Stack<Integer> sandwichesStack = new Stack<>();
        for (int i = 0; i < sandwiches.length; i++) {
            sandwichesStack.push(sandwiches[i]);
        }

        // System.out.println("students : " + studentsQueue);
        // System.out.println("sandwichesStack : " + sandwichesStack);

        System.out.println("=============================================");

        while (!sandwichesStack.empty()) {

            Integer student = studentsQueue.peek();
            Integer sandwich = sandwichesStack.get(0);

            // System.out.println("studentsQueue >>> " + studentsQueue);
            // System.out.println("sandwichesStack >>> " + sandwichesStack);
            // System.out.println("student = " + student);
            // System.out.println("sandwich = " + sandwich);
            // System.out.println("-------------------");

            if (sandwich.equals(student)) {
                sandwichesStack.removeElementAt(0);
                studentsQueue.remove();
            } else {
                if (!studentsQueue.contains(sandwich)) {
                    return studentsQueue.size();
                }
                studentsQueue.remove();
                studentsQueue.offer(student);
            }
        }

        // System.out.println("students : " + studentsQueue);
        // System.out.println("sandwichesStack : " + sandwichesStack);
        return studentsQueue.size();
    }

    private static void moveElemToRight(int arr[]){
        int tmp = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1){
                arr[i] = tmp;
                break;
            }
            arr[i] = arr[i+1];
        }
    }

    private static boolean isContains(int[] arr1, int target){
        boolean isContainsTarget = false;
        for (int elem : arr1) {
            if (elem == target){
                isContainsTarget = true;
                break;
            }
        }
        return isContainsTarget;
    }

    private static int countStudentsB(int[] students, int[] sandwiches) {
        int result = students.length;
        for (int i = 0; i < sandwiches.length; i++) {
            int sandwich = sandwiches[i];

            // --------------------------------
            if(isContains(students, sandwich) == false){
                return result;
            }
            // --------------------------------

            while(students[0] != sandwich){
                moveElemToRight(students);
            }
            if(students[0] == sandwich){
                students = Arrays.copyOfRange(students, 1, students.length);
                sandwiches = Arrays.copyOfRange(sandwiches, 1, sandwiches.length);
                i--;
                result--;
            }

        }
        return result;
    }

    public static void main(String[] args) {

        int[] stuArr = new int[]{1, 1, 0, 0};
        int[] sandwichesArr = new int[]{0, 1, 0, 1};

        // int[] stuArr = new int[]{1, 1, 1, 0, 0, 1};
        // int[] sandwichesArr = new int[]{1, 0, 0, 0, 1, 1};

        // System.out.println("ans = " + countStudents(stuArr, sandwichesArr));
        System.out.println("ans = " + countStudentsB(stuArr, sandwichesArr));

        ////////////////////////////////////////////////////////////////////////////
        // int[] arr1 = new int[]{1, 2, 3, 4, 5, 6};
        // moveElemToRight(arr1);
        // Arrays.stream(arr1).boxed().forEach(x -> System.out.printf("%s ", x));
    }

}
