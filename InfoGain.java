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
        int posR=0,negR=0;
        Map<String,Integer> arr=new HashMap<>();
        for(int i=0;i<data.size();i++){
            if(data.get(i).get(5).equals("Yes"))
              posR++;
            else
              negR++;
            if(!arr.containsKey(data.get(i).get(4)))
                arr.put(data.get(i).get(4),0);
            arr.put(data.get(i).get(4),arr.get(data.get(i).get(4))+1);    
               
                
            
        }
        Map<String,double[]> arr2=new HashMap<>();
        for(int i=0;i<data.size();i++){
            if(!arr2.containsKey(data.get(i).get(4)))
                 arr2.put(data.get(i).get(4),new double[3]);
            if(data.get(i).get(4).equals("Yes"))
                 arr2.get(data.get(i).get(4))[0]++;
            else
                 arr2.get(data.get(i).get(4))[1]++;     
        }
        double totRecord=data.size();
        double entropy = -((1.0 *posR/totRecord)*(Math.log(1.0 *posR/totRecord))/Math.log(2)) - ((1.0 * negR/totRecord)*(Math.log(1.0 *negR/totRecord)/Math.log(2)));
        
          for(Map.Entry<String,double[]> x:arr2.entrySet()){
            double posRes=x.getValue()[0];
            double negRes=x.getValue()[1];
            double totRes=posRes+negRes;
            double ent = -((posRes/totRes)*(Math.log(posRes/totRes)/Math.log(2))) - ((negRes/totRes)*(Math.log(negRes/totRes)/Math.log(2)));
            System.out.println(""+ent+posRes+negRes+totRes);
            x.getValue()[2]=ent;             
          }
          double ent_sum = 0;

          for(Map.Entry<String,double[]> x:arr2.entrySet()){
              double rec = x.getValue()[0] + x.getValue()[1];
              ent_sum += (1.0 * rec/totRecord)*(x.getValue()[2]);
              System.out.println(""+ent_sum+ rec+x.getValue()[2]);

            }

          // console.log("Ent Sum : " + ent_sum);
       double infogain = entropy - ent_sum;
       System.out.println("Info Gain(S,Wind) :" +infogain);
     



        

    }
}
