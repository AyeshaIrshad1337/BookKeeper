import java.util.HashSet;

public class Search {
    HashSet<Node> AuthorName(HashSet<Node> root, String str){
        HashSet<Node> AuthorName=new HashSet<>();

        for (Node node:root){
            if(node.getAuthor().contains(str)){
                AuthorName.add(node);
            }


        }
        return AuthorName;
    }
    HashSet<Node> BookName(HashSet<Node> root, String str){
        HashSet<Node> BookName=new HashSet<>();
        for (Node node:root){

            if(node.getBookName().contains(str)){
                BookName.add(node);
            }
        }
        return BookName;
    }

}
