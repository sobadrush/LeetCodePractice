package org.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/*
Input
    ["OrderedStream", "insert", "insert", "insert", "insert", "insert"]
    [[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]
    Output
    [null, [], ["aaaaa"], ["bbbbb", "ccccc"], [], ["ddddd", "eeeee"]]

    Explanation
    // Note that the values ordered by ID is ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"].
    OrderedStream os = new OrderedStream(5);
    os.insert(3, "ccccc"); // Inserts (3, "ccccc"), returns [].
    os.insert(1, "aaaaa"); // Inserts (1, "aaaaa"), returns ["aaaaa"].
    os.insert(2, "bbbbb"); // Inserts (2, "bbbbb"), returns ["bbbbb", "ccccc"].
    os.insert(5, "eeeee"); // Inserts (5, "eeeee"), returns [].
    os.insert(4, "ddddd"); // Inserts (4, "ddddd"), returns ["ddddd", "eeeee"].
    // Concatentating all the chunks returned:
    // [] + ["aaaaa"] + ["bbbbb", "ccccc"] + [] + ["ddddd", "eeeee"] = ["aaaaa", "bbbbb", "ccccc", "ddddd", "eeeee"]
    // The resulting order is the same as the order above.
 */
class OrderedStream {

    private String[] resultArr;
    private int ptr = 0;

    public OrderedStream(int n) {
        this.resultArr = new String[n];
    }

    public List<String> insert(int id, String value) {
        List<String> list = new LinkedList<>();
        this.resultArr[id - 1] = value;

        for (int i = 0; i < resultArr.length; i++) {
            if (resultArr[i] != null) {
                if (i >= this.ptr){
                    list.add(resultArr[i]);
                }
            } else {
                this.ptr = i;
                System.out.println("list : " + list + ", ptr = " + ptr);
                return list;
            }
        }
        System.out.println("list : " + list + ", ptr = " + ptr);
        return list;
    }
}


public class Leetcode_1656 {

    /**
     * Your OrderedStream object will be instantiated and called as such:
     * OrderedStream obj = new OrderedStream(n);
     * List<String> param_1 = obj.insert(id,value);
     */
    public static void main(String[] args) {
        OrderedStream obj = new OrderedStream(5/*n*/);
        List<String> param_1 = obj.insert(3, "ccccc");
        List<String> param_2 = obj.insert(1, "aaaaa");
        List<String> param_3 = obj.insert(2, "bbbbb");
        List<String> param_4 = obj.insert(5, "eeeee");
        List<String> param_5 = obj.insert(4, "ddddd");
    }

}
