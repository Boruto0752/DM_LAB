import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
public class InfoGain {
    public static void main(String[] args)throws Exception {
        BufferedReader br=new BufferedReader(new FileReader("C://Users/it/Documents/Visual Studio 2022/DM_LAB 60/infogainData.txt"));
        ArrayList<ArrayList<String>> data=new ArrayList<>();
        int n=br.readLine().trim().split(" ").length;
        

        while(true){
            String str[]=new String[n];
            try{
                str=br.readLine().trim().split(" ");
            }
            catch(NullPointerException e){
                break;
            }
            ArrayList<String> temp=new ArrayList<>();
            for(String s:str)
               temp.add(s);
            data.add(temp);   
        }
        System.out.println(data);

    }
}
