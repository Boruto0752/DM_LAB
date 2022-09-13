import java.util.*;
import java.io.*;
class MaxMinNormalization{
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new FileReader("C://Users/it/Documents/Visual Studio 2022/DM_LAB 60/input.text"));
        String input[]=br.readLine().trim().split(" ") ;
        int[] arr=new int[input.length] ;
        int i=0;
        for(String x:input){1
            arr[i++]=Integer.parseInt(x);
        } 
        System.out.println("Data :");
        System.out.println(Arrays.toString(arr));
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int x:arr){
            max=Math.max(max,x);
            min=Math.min(min,x);
        }
        int min1=0;
        int max1=1;
        double[] normArr=new double[arr.length];
        i=0;
        for(int x:arr){
              normArr[i++]=(double)(x-min)/(max-min) * 1.0 + min1;

        }
        System.out.println("Data After Normalization:");
        for(i=0;i<arr.length;i++){
                  System.out.println(arr[i]+" data After Norm ---->"+normArr[i]);
        }
        double  mean = 0.0;
        double sum=0.0;
        for(int x:arr)
           sum+=x;
        mean=sum/arr.length;
        double sqrsum=0.0;
        double sd=0.0;
        for(int x:arr){
            sqrsum+=Math.pow(x-mean,2);
        }   
        sqrsum=sqrsum/arr.length;
        sd=Math.sqrt(sqrsum);
        System.out.printf("\nMean = %.4f and sd = %.4f\n\n",mean ,sd);
        double zscore[]=new double[arr.length];

        for( i=0;i<arr.length;i++)
        {
         zscore[i]=(arr[i]-mean)/sd;
        }
        for(i=0;i<arr.length;i++){
            System.out.printf("Data item "+ arr[i] +" and zscore %.4f\n",zscore[i]);
        }


    }
}

