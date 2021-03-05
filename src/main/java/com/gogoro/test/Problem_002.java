package com.gogoro.test;

public class Problem_002 {

    public static void main(String[] args) {
        long goLong1 = 23971;
        Long goLong2 = goLong1;
        long[] aryLong = new long[] { goLong1, goLong2 };
        WrapLong wrap = new WrapLong(goLong1);
        wrap.add(goLong1);
        wrap.add(goLong2);
        wrap.add(aryLong);
        wrap.increase();
        System.out.println(goLong1);
        System.out.println(goLong2);
        System.out.println(wrap.realLong);
        System.out.println(goLong1 == wrap.realLong);
        System.out.println(goLong1 == aryLong[0]);
        System.out.println(goLong1 == aryLong[1]);
    }

    private static class WrapLong {
        public long realLong;
        public WrapLong(long initValue){
            realLong = initValue;
        }
        public void increase(){
            realLong += 1;
        }
        private static void add(Long add){
            add += 1;
        }
        private static void add(long[] add){
            for(long element: add){
                element += 1;
            }
        }
    }
}
