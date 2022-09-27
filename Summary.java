import java.lang.*;
import java.util.*;
import java.io.*;
class BoxPlot
{

    public static double findMedian(int arr[],int start,int end)
    {
        int n=end-start+1;
        if(n%2==0)
        {
            return (arr[start+n/2-1]+arr[start+n/2])/2;
        }
        else
        {
            return arr[start+n/2];
        }

    }
    public static void main(String[] args) throws Exception
    {
        BufferedReader   br = new BufferedReader(new FileReader("C://Users/91766/IdeaProjects/untitled15/src/summary.csv"));


        String [] fields = br.readLine().trim().split(","); // Splits at the space
        int i=0;
        int [] arr=new int[fields.length];
        for(String str:fields){
            int x=Integer.parseInt(str); //prints out name
            arr[i++]=x;
        }
        System.out.println("---------The data set input from file-------");
        for(int a:arr)
        {
            System.out.print(a +"  ");
        }


        System.out.println();
        System.out.println("-------------Five Point Summary(Box Plot)--------");
        Arrays.sort(arr);
        System.out.println("Sorted Data");
        for(int a:arr)
        {
            System.out.print(a+" ");
        }
        System.out.println();
        int n=arr.length;
        double median=findMedian(arr,0,n-1);
        double q1=findMedian(arr,0,n/2-1);
        double q3=0;
        if(n%2==0)
        {
            q3=findMedian(arr,n/2,n-1);
        }
        else
        {
            q3=findMedian(arr,n/2+1,n-1);
        }

        System.out.println("1.MAX VALUE--------->"+arr[n-1]);
        System.out.println("2.MIN VALUE--------->"+arr[0]);
        System.out.println("3.MEDIAN---------->"+median);
        System.out.println("4.QUARTILE 1--------->"+q1);
        System.out.println("5.QUARTILE 3--------->"+q3);




    }
}
