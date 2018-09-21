package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here
        public int fab(num){
            int sum = 1;
            while (num > 1) {
                sum = sum * num;
                num--;
            }
            return sum;
        }


        public int stringSumX(int stringSize,int sumSize) {
            int leftP = (stringSize + sumSize) / 2;
            int rightP = (stringSize - sumSize) / 2;
            int up = 1;
            int down = 1;

            if ((stringSize + sumSize) % 2 != 0) {
                return 0;
            } else {
                up = fab(leftP);
                down = fab(leftP - rightP);
                return up / down;
            }
        }

        System.out.println(stringSumX(4,2))
    }
}

