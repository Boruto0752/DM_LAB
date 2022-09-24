import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
class InfoGain {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("C://Users/91766/Desktop/Extract/infogaindata.txt"));
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        int n = br.readLine().trim().split(" ").length;


        while (true) {
            String str[] = new String[n];
            try {
                str = br.readLine().trim().split(" ");
            } catch (NullPointerException e) {
                break;
            }
            ArrayList<String> temp = new ArrayList<>();
            for (String s : str)
                temp.add(s);
            data.add(temp);
        }
        int posR = 0, negR = 0;
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).get(5).equals("Yes"))
                posR++;
            else
                negR++;
        }
        double totRecord = data.size();
        double entropy = -((1.0 * posR / totRecord) * (Math.log(1.0 * posR / totRecord)) / Math.log(2)) - ((1.0 * negR / totRecord) * (Math.log(1.0 * negR / totRecord) / Math.log(2)));
        for(int i=0;i<data.get(0).size()-1;i++){
            System.out.println(findAllEntropy(i,entropy,data));
        }
    }

    private static double findAllEntropy(int i, double entropy, ArrayList<ArrayList<String>> data) {
        Set<String> attribute=new HashSet<>();
        for(ArrayList<String>x:data)
           attribute.add(x.get(i));
        Map<String,double[]>total=new HashMap<>();
        for(String x:attribute){
            total.put(x,new double[2]);
        }
        for(ArrayList<String> x:data){
            if(x.get(5).equals(("Yes")))
             total.get(x.get(i))[0]++;
            else
             total.get(x.get(i))[1]++;

        }
        double totalE=0.0;
        for(Map.Entry<String,double[]> x:total.entrySet()){
            double total1=x.getValue()[0]+x.getValue()[1];
            if(x.getValue()[0]==0||x.getValue()[1]==0)
                 continue;
            double temp= -((1.0 * x.getValue()[0] / total1) * (Math.log(1.0 * x.getValue()[0] / total1)) / Math.log(2)) - ((1.0 * x.getValue()[1]/ total1) * (Math.log(1.0 * x.getValue()[1] / total1) / Math.log(2)));
             totalE+=(total1/ data.size())*temp;
        }

        double finalE=entropy-totalE;
        return finalE;
    }


}
