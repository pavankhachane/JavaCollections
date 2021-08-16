package com.pavan;

public class StringTest {

    public static void main(String[] args) {
        Object o = new Object();
        String s1 = "Pavan";

        String s2 = new String("Pavan");

        System.out.println("s1 = " + s1 + ", s2 = " + s2);


        System.out.println("s1 == s2 : " + s1 == s2);

        System.out.println(s1.equals(s2));


        String s3 = "Pavan";
        System.out.println("s1 == s3 : " + s1 == s3);

        String s4 = "Pavan";

        char[] ch = s4.toCharArray();

        System.out.println(s4);


        String s5 = new String("Pavan");

        String s6 = new String("Pavan");


        System.out.println("===============");

        String s="Sachin";
        s.concat(" Tendulkar");//concat() method appends the string at the end
        System.out.println(s);//will print Sachin because strings are immutable objects

        StringBuffer sb= new StringBuffer("Hello "); // char[21]

        StringBuffer sb2 = new StringBuffer(); // char[16]

        sb2.append("Prasanna");

        System.out.println(sb2);


        StringBuilder sb3 = new StringBuilder("Pavan");

        sb3.append(" Khachane"); // t2

        System.out.println(sb3); // t1
    }
}
