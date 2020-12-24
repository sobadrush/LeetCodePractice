package org.leetcode.easy;

class ParkingSystem {

    private int bigSpace;
    private int mediumSpace;
    private int smallSpace;

    public ParkingSystem(int big, int medium, int small) {
        this.bigSpace = big;
        this.mediumSpace = medium;
        this.smallSpace = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1: // big
                if (this.bigSpace - 1 >= 0) {
                    this.bigSpace--;
                    return true;
                } else {
                    return false;
                }
            case 2: // medium
                if (this.mediumSpace - 1 >= 0) {
                    this.mediumSpace--;
                    return true;
                } else {
                    return false;
                }
            case 3: // small
                if (this.smallSpace - 1 >= 0) {
                    this.smallSpace--;
                    return true;
                } else {
                    return false;
                }
        }
        return false;
    }

}

public class LeetCode_1603 {

    /**
     * Input
     * ["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
     * [[1, 1, 0], [1], [2], [3], [1]]
     * Output
     * [null, true, true, false, false]
     * <p>
     * 說明: [1,1,0] 停車系統 (大 中 小 車位)
     * [1] : 大車
     * [2] : 中車
     * [3] : 小車
     */
    public static void main(String[] args) {
        /**
         * Your ParkingSystem object will be instantiated and called as such:
         * ParkingSystem obj = new ParkingSystem(big, medium, small);
         * boolean param_1 = obj.addCar(carType);
         */

        ParkingSystem obj = new ParkingSystem(1, 1, 0);
        boolean param_1 = obj.addCar(1);
        boolean param_2 = obj.addCar(2);
        boolean param_3 = obj.addCar(3);
        boolean param_4 = obj.addCar(1);
        System.out.println("param_1 = " + param_1);
        System.out.println("param_2 = " + param_2);
        System.out.println("param_3 = " + param_3);
        System.out.println("param_4 = " + param_4);
    }
}
