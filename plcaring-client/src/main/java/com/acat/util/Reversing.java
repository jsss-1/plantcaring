package com.acat.util;

import java.util.Scanner;

public class Reversing {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        reverse(s);
    }

    private static void reverse(String s) {
        int t = s.length();
       //首先反转整个字符串abcde
        StringBuilder sb = new StringBuilder(s);
        String newS=sb.reverse().toString();
       // System.out.println(newS);
        //edcba局部反转
        StringBuilder sb1 =new StringBuilder();
        for(int i=0;i<t;i++){
            int m =Math.min(i,s.length());
            String tmp=newS.substring(0,m);
           // 删去已经处理过的tmp
            StringBuilder tsb=new StringBuilder(tmp);
            sb1.append(tsb.reverse());
            newS=newS.replace(tmp,"");
           // System.out.println(newS);
            if(newS.length()<=i){
                break;
            }
        }
        StringBuilder tsb= new StringBuilder(newS);

        //处理最后剩下的一小段字符
        sb1.append(tsb.reverse());
        System.out.println(sb1);
    }
}
