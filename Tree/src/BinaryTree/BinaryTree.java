package BinaryTree;

public class BinaryTree {
    Node root;

    BinaryTree(){
        root=null;
    }

    void inorderTraversal(Node node){
        if(node!=null){
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    void preorderTraversal(Node node){
        if(node!=null){
            System.out.print(node.data + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    // post-apocalypse
    void postOrderTraverse(Node node){
        if(node!=null){
            postOrderTraverse(node.left);
            postOrderTraverse(node.right);
            System.out.print(node.data + " ");
        }
    }
}
