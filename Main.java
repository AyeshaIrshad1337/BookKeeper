import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
class general{
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
public class Main {

    class Node{
        String BookName,Author,Source,Genre;
        float UserRating,Price;
        int Reviews,PurchaseRatio,height,Sno;

        Node left, right;
        Node(int Sno,String BookName,String Author,float UserRating,int Reviews,float Price,String Genre,String Source,int PurchaseRatio){
            this.BookName = BookName;
            this.Author=Author;
            this.Source = Source;
            this.Genre = Genre;
            this.Price = Price;
            this.UserRating= UserRating;
            this.PurchaseRatio = PurchaseRatio;
            this.Reviews = Reviews;
            this.height=0;
            this.Sno=Sno;
        }

    }   Node root;
    int height(Node N) {
        if (N == null)
            return 0;

        return N.height;
    }
    int max(int a, int b) {
        return (a > b) ? a : b;
    }
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }
Node leftRotate(Node x) {
    Node y = x.right;
    Node T2 = y.left;

    // Perform rotation
    y.left = x;
    x.right = T2;

    // Update heights
    x.height = max(height(x.left), height(x.right)) + 1;
    y.height = max(height(y.left), height(y.right)) + 1;

    // Return new root
    return y;
}
    int getBalance(Node N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }
    Node insert(Node node,int Sno,String BookName,String Author,float UserRating,int Reviews,float Price,String Genre,String Source,int PurchaseRatio) {

           if (node == null)
            return (new Node(Sno,BookName,Author,UserRating,Reviews,Price,Genre,Source,PurchaseRatio));

        if (Sno < node.Sno)
            node.left = insert(node.left, Sno,BookName,Author,UserRating,Reviews,Price,Genre,Source,PurchaseRatio);
        else if (Sno > node.Sno)
            node.right = insert(node.right,Sno,BookName,Author,UserRating,Reviews,Price,Genre,Source,PurchaseRatio);
        else // Duplicate keys not allowed
            return node;

        node.height = 1 + max(height(node.left),
                height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && Sno < node.left.Sno)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && Sno > node.right.Sno)
            return leftRotate(node);

        if (balance > 1 && Sno > node.left.Sno) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && Sno < node.right.Sno) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }
    void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.Sno+ " "+node.BookName+ " "+node.Author+ " "+node.UserRating+ " "+node.Reviews+ " "+node.Price+ " "+node.Genre+ " "+node.Source+ " "+node.PurchaseRatio + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

       general obj= new general();
       String[] A= obj.filing("amazon.csv");
       String sp0[][]=obj.extract(A);
        String[] B= obj.filing("UrduBazar.csv");
        String sp1[][]=obj.extract(B);
        String[] C= obj.filing("ZStore.csv");
        String sp2[][]=obj.extract(C);
        String sp[][]=obj.Fi(sp0,sp1,sp2);
        Main o= new Main();
        Node n = null;
        for (int j = 0; j < 49; j++) {
            n=o.insert(n,Integer.parseInt(sp[j][0]),sp[j][1],sp[j][2],Float.parseFloat(sp[j][3]), Integer.parseInt(sp[j][4]),Float.parseFloat(sp[j][5]),sp[j][6],sp[j][7],Integer.parseInt(sp[j][8]));

        }
       o.preOrder(n);
    }
}