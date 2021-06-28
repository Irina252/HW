package com.company;

public class Main {
    static class StringArray {
        private String[] arr;

        public StringArray(String... values) {
            arr = new String[values.length];
            for (int i = 0; i < values.length; i++) {
                arr[i] = values[i];
            }

        }

        public String arrayToString() {
            String res = "";
            int i = 0;
            for (; ; ) {
                res += "" + i + ": " + arr[i]+"; ";
                i++;
                if(i < arr.length){
                    break;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
       StringArray sa=new StringArray("First","Second");
        System.out.println(sa.arrayToString());
    }


}
