import org.w3c.dom.Node;

public class NodeTree {

    String data;
    NodeTree left;
    NodeTree right;


    NodeTree(String oper){

        this.data = oper;
        right =null;
        left=null;

    }


}
