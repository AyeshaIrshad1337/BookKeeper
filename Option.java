import java.util.HashSet;
import java.util.Scanner;

public class Option {
    public HashSet<Node> o=null;

    public void setO(HashSet<Node> o) {
        this.o = o;
    }
    void display(HashSet<Node> root){
        System.out.println(root);
    }

    void opt(HashSet<Node> o){
        HashSet<Node>book=filter(o);
        recommendSearch(book);
    }


    HashSet<Node> filter(HashSet<Node> o){

        HashSet<Node> book=null;
        Filter filter = new Filter();
        Scanner sc = new Scanner(System.in);
        int choice =0,numberofBooks=0;
        int size=0;
        double rating=0;
        System.out.println("Select One of the Choices: \n(1)Fiction \n(2)Non Fiction\n(3)Amazon Book\n(4)Urdu Bazar\n(5)ZStore\n(6)Rating Factor \n(7)All\n(8)Reset\n(9)Exit");
        do {
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
        } while (choice < 1 || choice > 9);
        switch (choice) {
            case 1:
                size=filter.Fiction(o).size();
                System.out.println("Total Books of Fiction: " + size);
                numberofBooks =check(size);
                book = new HashSet<>();
                book.addAll(filter.Fiction(o));
                break;
            case 2:
                size=filter.NonFiction(o).size();
                System.out.println("Total Books of Non Fiction: " + size);
                numberofBooks = check(size);
                book = new HashSet<>();
                book.addAll(filter.NonFiction(o));
                break;
            case 3:
                size =filter.SourceAmazon(o).size();
                System.out.println("Total Books of Amazon Book: " + size);
                numberofBooks= check(size);
                book = new HashSet<>();
                book.addAll(filter.SourceAmazon(o));
                break;
            case 4:
                size=filter.SourceUrduBazar(o).size();
                System.out.println("Total Books of Urdu Bazar Book: " + size);
                numberofBooks = check(size);
                book = new HashSet<>();
                book.addAll(filter.SourceUrduBazar(o));
                break;
            case 5:
                size=filter.SourceZstore(o).size();
                System.out.println("Total Books of ZStore Book: " + size);
                numberofBooks = check(size);
                book = new HashSet<>();
                book.addAll(filter.SourceZstore(o));
                break;
            case 6:
                System.out.println("Enter the book rating: ");
                rating = sc.nextDouble();
                size=filter.RatingFilter(o, rating).size();
                System.out.println("Total Books of having that rating are : " + size);
                numberofBooks = check(size);
                book = new HashSet<>();
                book.addAll(filter.RatingFilter(o,rating));
                break;
            case 7:
                size=filter.Both(o).size();
                System.out.println("Total Books of Both: " + size);
                numberofBooks = check(size);
                book = new HashSet<>();
                book.addAll(filter.Both(o));
                break;
            case 8:
                opt(o);
                break;
            case 9:
                System.exit(0);
                break;
        }
        return book;
    }

    void recommendSearch(HashSet<Node> book){
        Scanner sc = new Scanner(System.in);

        int choice=0;
        System.out.println("Select One of the Choices: \n(1)Search \n(2)Recommadation\n(3) Display Books \n(4)Back to apply more filters on it\n(5)Back ro Main Menu \n(6)Exit");
        do {
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
        } while (choice < 1 || choice > 6);
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
                opt(book);
                break;
            case 5:
                opt(o);
                break;
            case 6:
                System.exit(0);
                break;
        }
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
                if(a==null||a.isEmpty()){BAckExitSearch(book);}
                System.out.println(search.AuthorName(book, author));
                System.out.print("Do you want its Recommadation(y/if no enter anything): ");
                result = sc.next();
                if(result.equals("y")){recommend(a);}
                else{

                    BAckExitSearch(book);
                }break;
            case 2:

                System.out.print("Enter Book Name or any Alphabet that is in Author Name: ");
                String BookName = sc.next();
                a=search.BookName(book, BookName);
                if(a==null||a.isEmpty()){BAckExitSearch(book);}
                System.out.println(search.BookName(book, BookName));
                System.out.print("Do you want its Recommadation(y/if no enter anything): ");
                result = sc.next();
                if(result.equals("y")){recommend(a);}
                else{

                    BAckExitSearch(book);
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


    void recommend(HashSet<Node> book){
        Scanner sc=new Scanner(System.in);
        recommandation recommendation =new recommandation();
        System.out.print("How many books you are looking for: ");
        int NumberOfBooks=sc.nextInt();
        if(NumberOfBooks==0) BAckExitSearchRecommand(book);
        System.out.println(recommendation.TopBest(book,NumberOfBooks));
        System.out.println("\n\nRecommendation on Basis of Score : \n");
        recommendation.RecommanderScore(book);
        BAckExitSearchRecommand(book);

    }


    int check(int size){
        Scanner sc =new Scanner(System.in);
        int numberofBooks=0;
        if (size == 0){
            BAckExit();
        }
        return numberofBooks;
    }

    void BAckExit(){
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.print("Do you want to (1)Go back or (2)exit: ");
            choice = sc.nextInt();
        }while(choice != 1 && choice != 2);
        if(choice==1){
            opt(o);
        } else if (choice==2) {
            System.exit(0);
        }
    }

    void BAckExitSearchRecommand(HashSet<Node> book){

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.print("Do you want to (1)Go back or (2)exit: ");
            choice = sc.nextInt();
        }while(choice != 1 && choice != 2);
        if(choice==1){
            recommendSearch(book);
        } else if (choice==2) {
            System.exit(0);
        }
    }

    void BAckExitSearch(HashSet<Node> book){

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.print("Do you want to (1)Go back or (2)exit: ");
            choice = sc.nextInt();
        }while(choice != 1 && choice != 2);
        if(choice==1){
           search(book);
        } else if (choice==2) {
            System.exit(0);
        }
    }
}
