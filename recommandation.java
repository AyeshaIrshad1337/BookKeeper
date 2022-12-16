import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class recommandation {

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
                System.out.print("Enter the numbers of books: ");
                n=sc.nextInt();

                for(int i=1;i<=n;i++){
                    if(i== result.size()){break;}
                    System.out.println(result.get(i));
                }
                break;
        } }


    public HashSet<Node> TopBest(HashSet<Node> root,int NumberOfBooks){
        HashSet<Node> Top=new HashSet<>();
        int i=1;
        for (Node node:root){
            if(node.getUserRating()>=4.5f&& node.getPurchaseRatio() >= 85&&NumberOfBooks>=i){
                Top.add(node);
                i++;
            }
        }
        return Top;
    }

}
