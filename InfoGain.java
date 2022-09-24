import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
class InfoGain {
    public static void main(String[] args)throws Exception {
        BufferedReader br=new BufferedReader(new FileReader("C://Users/91766/Desktop/Extract/infogaindata.txt"));
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
        System.out.println("Entropy"+entropy);
         double spos=0.0,sneg=0.0,wpos=0.0,wneg=0.0;
         for(ArrayList<String> s:data){
             if(s.get(4).equals("Strong"))
             {
                 if(s.get(5).equals("Yes"))
                     spos++;
                 else
                     sneg++;
             }
             else{
                 if(s.get(5).equals("Yes"))
                     wpos++;
                 else
                     wneg++;
             }
         }
         double wtotal=wpos+wneg;
         double stotal=spos+sneg;
        double wentropy = -((1.0 *wpos/wtotal)*(Math.log(1.0 *wpos/wtotal))/Math.log(2)) - ((1.0 * wneg/wtotal)*(Math.log(1.0 *wneg/wtotal)/Math.log(2)));
        System.out.println(wentropy);
        double sentropy = -((1.0 *spos/stotal)*(Math.log(1.0 *spos/stotal))/Math.log(2)) - ((1.0 * sneg/stotal)*(Math.log(1.0 *sneg/stotal)/Math.log(2)));
        System.out.println(sentropy);


        double infogain = entropy-(1.0* wtotal/totRecord)*wentropy-(1.0*stotal/totRecord)*sentropy;
        System.out.println("Info Gain(S,Wind) :" +infogain);
    }
}
