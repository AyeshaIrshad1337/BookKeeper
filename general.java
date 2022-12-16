import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class general {
    String[] filing(String path) throws FileNotFoundException {
        String A[]=new String[51];
        int i =0;
        Scanner sc = new Scanner(new File(path));
        sc.useDelimiter(",");
        while (sc.hasNextLine())
        {
            A[i]=sc.nextLine();
            i++;
        }
        sc.close();
        return A;
    }
    String[][] extract(String A[]){
        int k=0;
        String[][] sp=new String[49][9];
        for (int i = 0; i <49; i++) {

            String[] splitted = A[++k].split(",");
            sp[i][0]=splitted[0];
            sp[i][1]=splitted[1];
            sp[i][2]=splitted[2];
            sp[i][3]=splitted[3];
            sp[i][4]=splitted[4];
            sp[i][5]=splitted[5];
            sp[i][6]=splitted[6];
            sp[i][7]=splitted[7];
            sp[i][8]=splitted[8];

        }
        return sp;
    }
    String max(int a,int b,int c){
        int m=a;
        if(m<b) m=b;
        if(m<c) m=c;
        return ""+m;
    }
    String max(float a,float b,float c){
        float m=a;
        if(m<b) m=b;
        if(m<c) m=c;
        return ""+m;
    }
    String[][] Fi(String[][] A,String[][] B,String[][] C){
        String[][] Array= new String[49][9];
        for (int i = 0; i < 49; i++) {
            Array[i][0]=A[i][0];
            Array[i][1]=A[i][1];
            Array[i][2]=A[i][2];
            Array[i][3]=max(Float.parseFloat(A[i][3]),Float.parseFloat(B[i][3]),Float.parseFloat(C[i][3]));
            Array[i][4]=max(Integer.parseInt(A[i][4]),Integer.parseInt(B[i][4]),Integer.parseInt(C[i][4]));
            Array[i][8]=max(Integer.parseInt(A[i][8]),Integer.parseInt(B[i][8]),Integer.parseInt(C[i][8]));
            float m=Float.parseFloat(A[i][5]);
            Array[i][7]=A[i][7];
            if(m>Float.parseFloat(B[i][5])){ m=Float.parseFloat(B[i][5]); Array[i][7]=B[i][7];}
            if(m>Float.parseFloat(C[i][5])){ m=Float.parseFloat(C[i][5]);Array[i][7]=C[i][7];}
            Array[i][5]=""+m;

            Array[i][6]=A[i][6];



        }
        return Array;
    }

}
