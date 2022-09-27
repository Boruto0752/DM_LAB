import java.util.*;
import java.io.*;

public class TandDWeight {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("C://Users/91766/IdeaProjects/untitled15/src/Tweight.csv"));
        String[] col = br.readLine().trim().split(",");
        int[][] data = new int[2][2];
        for(int i = 0; i < 2; i++) {
            String[] row = br.readLine().trim().split(",");
            int j = 0;
            for(int k = 1; k <= 2; k++  ) {
                data[i][j++] = Integer.parseInt(row[k]);
            }
        }
        int c1_tot = 0;
        int c2_tot = 0;
        int r1_tot = 0;
        int r2_tot = 0;
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j ++) {
                if(i == 0)
                    r1_tot += data[i][j];
                if(i == 1)
                    r2_tot += data[i][j];
                if(j == 0)
                    c1_tot += data[i][j];
                if(j == 1)
                    c2_tot += data[i][j];
            }
        }
        System.out.println("row 1 total: " + r1_tot);
        System.out.println("row 2 total: " + r2_tot);
        System.out.println("col 1 total: " + c1_tot);
        System.out.println("col 2 total: " + c2_tot);

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                if(i == 0)
                    System.out.printf("\nt-weight for data " + data[i][j] + "is---> %.4f", (1.0 * data[i][j] / r1_tot) * 100);
                if(i == 1)
                    System.out.printf("\nt-weight for data " + data[i][j] + "is---> %.4f", (1.0 * data[i][j] / r2_tot) * 100);
                if(j == 0)
                    System.out.printf("\nd-weight for data " + data[i][j] + "is---> %.4f", (1.0 * data[i][j] / c1_tot) * 100);
                if(j == 1)
                    System.out.printf("\nd-weight for data " + data[i][j] + "is---> %.4f", (1.0 * data[i][j] / c2_tot) * 100);
            }
        }
    }
}

