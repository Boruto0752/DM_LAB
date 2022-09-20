import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class BoxPlot {
    public static void main(String[] args)throws Exception {
        BufferedReader br=new BufferedReader(new FileReader("C://Users/it/Documents/Visual Studio 2022/DM_LAB 60/Boxplot.txt"));
        String str[]=br.readLine().trim().split(" ");
        int arr[]=new int[str.length];
        int i=0;
        for(String s:str){
            arr[i++]=Integer.parseInt(s);
        }
        System.out.println("Input data");
        System.out.println(Arrays.toString(arr));
        System.out.println("Sorted data");
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int n=arr.length;
        System.out.println("1.MAX VALUE--------->"+arr[n-1]);
        System.out.println("2.MIN VALUE--------->"+arr[0]);
        System.out.println("3.MEDIAN---------->"+arr[(n+1)/2-1]);
        System.out.println("4.QUARTILE 1--------->"+arr[(n+1)/4-1]);
        System.out.println("5.QUARTILE 3--------->"+arr[3*(n+1)/4-1]);
        


    }
}
