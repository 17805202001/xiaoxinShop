package com.czxy.xxs;

public class test {


//    public static void main(String[] args) {
//        for(int i=1;i<10;i++){
//
//            for(int a=1;a<i+1;a++){
//                System.out.print(i*a+" ");
//            }
//            System.out.println(" ");
//        }
//
//    }

    public static void main(String[] args) {

        int[] a = {20, 10, 55, 40, 30, 70, 60, 80, 90, 100};

        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]<a[j+1]){
                    Integer b=a[j];
                    a[j]=a[j+1];
                    a[j+1]=b;
                }

            }

           
        }

       for(int s=0;s<a.length;s++){
           System.out.println(a[s]);
       }


    }
}
