import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;


    class Node{
        String BookName,Author,Source,Genre;
        float UserRating,Price;
        int Reviews,PurchaseRatio,Sno;
        Node(int Sno,String BookName,String Author,float UserRating,int Reviews,float Price,String Genre,String Source,int PurchaseRatio){
             this.BookName = BookName;
            this.Author=Author;
            this.Source = Source;
            this.Genre = Genre;
            this.Price = Price;
            this.UserRating= UserRating;
            this.PurchaseRatio = PurchaseRatio;
            this.Reviews = Reviews;
            this.Sno=Sno;
        }

        public String getBookName() {
            return BookName;
        }

        public String getAuthor() {
            return Author;
        }

        public String getSource() {
            return Source;
        }

        public String getGenre() {
            return Genre;
        }

        public float getUserRating() {
            return UserRating;
        }


        public int getPurchaseRatio() {
            return PurchaseRatio;
        }

        public String toString()
        {
            return "\n[Sno]: " +this.Sno+" \n[Book Name]: "+this.BookName+ " \n[Author]: "+this.Author+ " \n[User Rating]: "+this.UserRating+ " \n[Reviews]: "+this.Reviews+ " \n[Price]: "+this.Price+ " \n[Genre]: "+this.Genre+ " \n[Source]: "+this.Source+ " \n[Purchase Rate]: "+this.PurchaseRatio + "\n----------------------------------------------------------------------------------------------------------------\n";
        }

    }
class re{
    Node Book;
    double score;
    re(Node Book, double score){
        this.Book=Book;
        this.score=score;
    }

    @Override
    public String toString() {
        return "score=" + score +
                "\nBook details:\n" + Book;
    }
}

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        general obj = new general();
        Option option=new Option();
        Scanner sc = new Scanner(System.in);
        String[] A = obj.filing("amazon.csv");
        String sp0[][] = obj.extract(A);
        String[] B = obj.filing("UrduBazar.csv");
        String sp1[][] = obj.extract(B);
        String[] C = obj.filing("ZStore.csv");
        String sp2[][] = obj.extract(C);
        String sp[][] = obj.Fi(sp0, sp1, sp2);
        HashSet<Node> o = new HashSet<>();
        for (int j = 0; j < 49; j++) {
            o.add(new Node(Integer.parseInt(sp[j][0]), sp[j][1], sp[j][2], Float.parseFloat(sp[j][3]), Integer.parseInt(sp[j][4]), Float.parseFloat(sp[j][5]), sp[j][6], sp[j][7], Integer.parseInt(sp[j][8])));
        }
        int numberofBooks = 0, choice = 0;
        HashSet<Node> book = null;
        option.setO(o);
        System.out.println("---------------------------------------------------------------------------------\n|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n\t\t\t\t\t\t\t Welcome To BookKeeper\n|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n---------------------------------------------------------------------------------");

        option.opt(o);


    }
}
