import java.util.HashSet;

public class Filter {
    HashSet<Node> Fiction (HashSet<Node> root){
        HashSet<Node> fiction= new HashSet<>();
        for (Node node:root){
            if(node.getGenre().equals("Fiction")){
                fiction.add(node);
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
    HashSet<Node> Both(HashSet<Node> root) {

        return root;
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

    HashSet<Node> SourceUrduBazar (HashSet<Node> root){
        HashSet<Node> UB= new HashSet<>();
        for(Node node: root){
            if(node.getSource().equals("Urdu Bazar")){
                UB.add(node);
            }
        }
        return UB;
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
