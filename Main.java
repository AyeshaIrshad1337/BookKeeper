import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
class Items{
    String BookName,Author,Source,Genre;
    float UserRating;
    int Reviews,PurchaseRatio,Price,Sno;

    Items(int Sno,String BookName,String Author,float UserRating,int Reviews,int Price,String Genre,String Source,int PurchaseRatio){
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

    public float getPrice() {
        return Price;
    }

    public int getReviews() {
        return Reviews;
    }

    public int getPurchaseRatio() {
        return PurchaseRatio;
    }

    public int getSno() {
        return Sno;
    }

    public String toString()
    {
        return "\n[Sno]: " +this.Sno+" \n[Book Name]: "+this.BookName+ " \n[Author]: "+this.Author+ " \n[User Rating]: "+this.UserRating+ " \n[Reviews]: "+this.Reviews+ " \n[Price]: "+this.Price+ " \n[Genre]: "+this.Genre+ " \n[Source]: "+this.Source+ " \n[Purchase Rate]: "+this.PurchaseRatio + "\n----------------------------------------------------------------------------------------------------------------\n";
    }

}

class general{
    public HashSet<Node> o=null;
    void display(HashSet<Node> root){
        System.out.println(root);
    }
    public void setO(HashSet<Node> o) {
        this.o = o;
    }

    void search(HashSet<Node> book){
        int choice =0;
        Scanner sc =new Scanner(System.in);
        Search search=new Search();
        HashSet<Node> a;

        do {
            System.out.println(" \n(1)By Author Name \n(2)By Book Name\n(3)Back\n(4)Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
        }while(choice<1 || choice>4);

        String result;
        switch (choice) {
            case 1:
                System.out.print("Enter Author Name or any Alphabet that is in Author Name: ");
                String author = sc.next();
                a=search.AuthorName(book, author);
                if(a==null){BAckExit();}
                System.out.println(search.AuthorName(book, author));
                System.out.print("Do you want its Recommadation(y/if no enter anything): ");
                result = sc.next();
                if(result.equals("y")){recommend(a);}
                else{
                    BAckExit();
                }break;
            case 2:

                System.out.print("Enter Book Name or any Alphabet that is in Author Name: ");
                String BookName = sc.next();
                a=search.BookName(book, BookName);
                if(a==null){BAckExit();}
                System.out.println(search.BookName(book, BookName));
                System.out.print("Do you want its Recommadation(y/if no enter anything): ");
                result = sc.next();
                if(result.equals("y")){recommend(a);}
                else{

                    BAckExit();
                }
                break;
            case 3:
                    recommendSearch(book);
                break;
            case 4:
                System.exit(0);
                break;
        }
    }
    void opt(){
        HashSet<Node>book=filter(o);
        recommendSearch(book);
    }
    void recommendSearch(HashSet<Node> book){
        Scanner sc = new Scanner(System.in);

        int choice=0;
        System.out.println("Select One of the Choices: \n(1)Search \n(2)Recommadation\n(3) Display Books \n(4)Back\n(5)Exit");
        do {
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
        } while (choice < 1 || choice > 4);
        switch (choice) {
            case 1:
                search(book);
                break;
            case 2:
                recommend(book);
                break;
            case 3:
                display(book);
                BAckExit();
                break;
            case 4:
                filter(book);
                break;
            case 5:
                System.exit(0);
                break;
        }
    }
    void recommend(HashSet<Node> book){
        recommendation recommendation =new recommendation();
        System.out.println(recommendation.TopBest(book));
        System.out.println("\n\nRecommendation on Basis of Score : \n\n\n");
        recommendation.RecommanderScore(book);
        BAckExitSearchRecommand(book);

    }
    int check(int size){
       Scanner sc =new Scanner(System.in);
        int numberofBooks=0;
        if (size == 0){
            BAckExit();
        }
        System.out.print("How many book you are willing to buy: ");
        numberofBooks = sc.nextInt();
        if(numberofBooks==0){
            BAckExit();
        }
        return numberofBooks;
    }
    HashSet<Node> filter(HashSet<Node> o){

        HashSet<Node> book=null;
        Filter filter = new Filter();
        Scanner sc = new Scanner(System.in);
        int choice =0,numberofBooks=0;
        int size=0;
        double rating=0;
        System.out.println("Select One of the Choices: \n(1)Fiction \n(2)Non Fiction\n(3)Amazon Book\n(4)Urdu Bazar\n(5)ZStore\n(6)Rating Factor \n(7)All\n(8)Exit");
        do {
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
        } while (choice < 1 || choice > 8);
        switch (choice) {
            case 1:
                size=filter.Fiction(o).size();
                System.out.println("Total Books of Fiction: " + size);
                numberofBooks =check(size);
                book = new HashSet<>();
                book.addAll(filter.Fiction(o, numberofBooks));
                System.out.println();
                System.out.print(book);

                break;
            case 2:
                size=filter.NonFiction(o).size();
                System.out.println("Total Books of Non Fiction: " + size);
                numberofBooks = check(size);
                book = new HashSet<>();
                book.addAll(filter.NonFiction(o, numberofBooks));
                System.out.print(book);
                break;
            case 3:
                size =filter.SourceAmazon(o).size();
                System.out.println("Total Books of Amazon Book: " + size);
               numberofBooks= check(size);
        book = new HashSet<>();
                book.addAll(filter.SourceAmazon(o, numberofBooks));
                System.out.print(book);
                break;
            case 4:
                size=filter.SourceUrduBazar(o).size();
                System.out.println("Total Books of Urdu Bazar Book: " + size);
                 numberofBooks = check(size);
                book = new HashSet<>();
                book.addAll(filter.SourceUrduBazar(o, numberofBooks));
                System.out.print(book);
                break;
            case 5:
                size=filter.SourceZstore(o).size();
                System.out.println("Total Books of ZStore Book: " + size);
                numberofBooks = check(size);
                book = new HashSet<>();
                book.addAll(filter.SourceZstore(o, numberofBooks));
                System.out.print(book);
                break;
            case 6:
                System.out.println("Enter the book rating: ");
                rating = sc.nextDouble();
                size=filter.RatingFilter(o, rating).size();
                System.out.println("Total Books of having that rating are : " + size);
                numberofBooks = check(size);
                book = new HashSet<>();
                book.addAll(filter.RatingFilter(o,rating,numberofBooks));
                System.out.print(book);
                break;
            case 7:
                size=filter.Both(o).size();
                System.out.println("Total Books of Both: " + size);
                numberofBooks = check(size);
                book = new HashSet<>();
                book.addAll(filter.Both(o, numberofBooks));
                System.out.print(book);
                break;
            case 8:
                System.exit(0);
                break;
        }
    return book;
    }

    void BAckExit(){
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Do you want to (1)Go back or (2)exit");
            choice = sc.nextInt();
        }while(choice != 1 && choice != 2);
        if(choice==1){
            opt();
        } else if (choice==2) {
            System.exit(0);
        }
    }

    void BAckExitSearchRecommand(HashSet<Node> book){

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Do you want to (1)Go back or (2)exit");
            choice = sc.nextInt();
        }while(choice != 1 && choice != 2);
        if(choice==1){
            recommendSearch(book);
        } else if (choice==2) {
            System.exit(0);
        }
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

        public float getPrice() {
            return Price;
        }

        public int getReviews() {
            return Reviews;
        }

        public int getPurchaseRatio() {
            return PurchaseRatio;
        }

        public int getSno() {
            return Sno;
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
        return ", score=" + score +
                "Book=" + Book;
    }
}
class recommendation  {
        void RecommanderScore(HashSet<Node> book){
           Scanner sc = new Scanner(System.in);
           int choice=0,n=0;
            ArrayList<re> result = new ArrayList<>();
            for(Node root:book){
                double score = root.UserRating * Math.log(root.Reviews + 1);
                re recomander = new re(root,score);
                result.add(recomander);
            }
            result.sort((r1, r2) -> Double.compare(r2.score, r1.score));
            System.out.println("Choose anyone : \n(1)Score of all Books \n(2)Score on few books ");
            do{
                System.out.println("Enter your choice: ");
                choice = sc.nextInt();

            }while(choice != 1 && choice !=2);
            switch(choice){
                case 1:

                    for(re recomander : result){
                        System.out.println(recomander);
                    }break;
                case 2:
                    System.out.println("If you dont want any recommandation just enter any negative value i.e -1");
                    System.out.println("Enter the numbers of books: ");
                    n=sc.nextInt();

                    for(int i=0;i<=n;i++){
                        if(i== result.size()){break;}
                        System.out.println(result.get(i));
                    }
                    break;
            } }


        public HashSet<Node> TopBest(HashSet<Node> root){
            HashSet<Node> Top=new HashSet<>();
            int i=1;
            for (Node node:root){
                if(node.getUserRating()>=4.5f&& node.getPurchaseRatio() >= 85){
                    Top.add(node);
                    i++;
                }
            }
            return Top;
        }

}
class Filter{
    HashSet<Node> Fiction (HashSet<Node> root){
        HashSet<Node> fiction= new HashSet<>();
           for (Node node:root){
            if(node.getGenre().equals("Fiction")){
                fiction.add(node);
            }
        }
        return fiction;
    }
   HashSet<Node> Fiction (HashSet<Node> root,int NumberOfBOOks){
       HashSet<Node> fiction= new HashSet<>();
        int i=1;
       for (Node node:root){
           if(node.getGenre().equals("Fiction")&&NumberOfBOOks>=i){
               fiction.add(node);
                i++;
           }
       }
       return fiction;
   }

    HashSet<Node> NonFiction (HashSet<Node> root){
        HashSet<Node> Nonfiction= new HashSet<>();
        for (Node node:root){
            if(node.getGenre().equals("Non Fiction")){
                Nonfiction.add(node);
            }
        }
        return Nonfiction;
    }
    HashSet<Node> NonFiction (HashSet<Node> root,int NumberOfBOOks){
        HashSet<Node> Nonfiction= new HashSet<>();
        int i =1;
        for (Node node:root){
            if(node.getGenre().equals("Non Fiction")&&NumberOfBOOks>=i){
                Nonfiction.add(node);
                i++;
            }
        }
        return Nonfiction;
    }
    HashSet<Node> Both(HashSet<Node> root){
        HashSet<Node> Both= new HashSet<>();
        for (Node node:root){

                Both.add(node);


        }
        return Both;

    }
    HashSet<Node> Both(HashSet<Node> root,int NumberOfBOOks){
    HashSet<Node> Both= new HashSet<>();
    int i =1;
    for (Node node:root){
        if(NumberOfBOOks>=i){
            Both.add(node);
            i++;
        }
    }
    return Both;

}
HashSet<Node> RatingFilter (HashSet<Node> root,double rating,int NumberOfBOOks){
           HashSet<Node> Rate= new HashSet<>();
           int i=1;
           for (Node node:root){
               if(node.getUserRating()>=rating&&NumberOfBOOks>=i){
                   Rate.add(node);
                   i++;
               }
           }
           return Rate;
       }

    HashSet<Node> RatingFilter (HashSet<Node> root,double rating){
        HashSet<Node> Rate= new HashSet<>();
        int i=1;
        for (Node node:root){
            if(node.getUserRating()>=rating){
                Rate.add(node);
                i++;
            }
        }
        return Rate;
    }
       HashSet<Node> SourceUrduBazar (HashSet<Node> root, int NumberOfBOOks){
       HashSet<Node> UB= new HashSet<>();
       int i=1;
       for(Node node: root){
           if(node.getSource().equals("Urdu Bazar")&&NumberOfBOOks>=i){
               UB.add(node);
               i++;
           }
       }
       return UB;
       }

    HashSet<Node> SourceUrduBazar (HashSet<Node> root){
        HashSet<Node> UB= new HashSet<>();
        for(Node node: root){
            if(node.getSource().equals("Urdu Bazar")){
                UB.add(node);
            }
        }
        return UB;
    }
    HashSet<Node> SourceAmazon (HashSet<Node> root, int NumberOfBOOks){
        HashSet<Node> Amazzon= new HashSet<>();
        int i =1;
        for(Node node: root){
            if(node.getSource().equals("Amazon")&&NumberOfBOOks>=i){
                Amazzon.add(node);
                i++;
            }
        }
        return Amazzon;
    }

    HashSet<Node> SourceAmazon (HashSet<Node> root){
        HashSet<Node> Amazzon= new HashSet<>();
        for(Node node: root){
            if(node.getSource().equals("Amazon")){
                Amazzon.add(node);
            }
        }
        return Amazzon;
    }
    HashSet<Node> SourceZstore (HashSet<Node> root, int NumberOfBOOks){
        HashSet<Node> Zstore= new HashSet<>();
       int i =1;
        for(Node node: root){
            if(node.getSource().equals("Zstore") && NumberOfBOOks>=i){
                Zstore.add(node);
                i++;
            }
        }
        return Zstore;
    }

    HashSet<Node> SourceZstore (HashSet<Node> root){
        HashSet<Node> Zstore= new HashSet<>();
        for(Node node: root){
            if(node.getSource().equals("Zstore") ){
                Zstore.add(node);
            }
        }
        return Zstore;
    }
}
class Search{
//    char[] StringToChar(String str){
//        char[] ch= new char[str.length()];
//        for (int i = 0; i < str.length(); i++) {
//            ch[i] = str.charAt(i);
//        }
//        return ch;
//    }
 HashSet<Node> AuthorName(HashSet<Node> root, String str){
        HashSet<Node> AuthorName=null;

        for (Node node:root){
                if(node.getAuthor().contains(str)){
                    AuthorName.add(node);
                }


            }
        return AuthorName;
 }
    HashSet<Node> BookName(HashSet<Node> root, String str){
        HashSet<Node> BookName=null;
        for (Node node:root){

                if(node.getBookName().contains(str)){
                    BookName.add(node);
            }
        }
        return BookName;
    }
}
public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        general obj = new general();
        Search search = new Search();
        Scanner sc = new Scanner(System.in);
        String[] A = obj.filing("amazon.csv");
        String sp0[][] = obj.extract(A);
        String[] B = obj.filing("UrduBazar.csv");
        String sp1[][] = obj.extract(B);
        String[] C = obj.filing("ZStore.csv");
        String sp2[][] = obj.extract(C);
        String sp[][] = obj.Fi(sp0, sp1, sp2);
        HashSet<Node> o = new HashSet<>();
        Items[] node = new Items[49];
        for (int j = 0; j < 49; j++) {
            node[j]= new Items(Integer.parseInt(sp[j][0]),sp[j][1], sp[j][2], Float.parseFloat(sp[j][3]), Integer.parseInt(sp[j][4]), (int)Float.parseFloat(sp[j][5]), sp[j][6], sp[j][7], Integer.parseInt(sp[j][8]));
            o.add(new Node(Integer.parseInt(sp[j][0]), sp[j][1], sp[j][2], Float.parseFloat(sp[j][3]), Integer.parseInt(sp[j][4]), Float.parseFloat(sp[j][5]), sp[j][6], sp[j][7], Integer.parseInt(sp[j][8])));
        }
        int numberofBooks = 0, choice = 0;
        HashSet<Node> book = null;
        obj.setO(o);
        System.out.println("---------------------------------------------------------------------------------\n|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n\t\t\t\t\t\t\t Welcome To BookKeeper\n|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n---------------------------------------------------------------------------------");

        obj.opt();


    }
}
