package BinarySearchTree;

public class BinarySearchTree {
    protected Node root;

    void insert(int data){
        this.root = insert(root,data);
    }

    private Node insert(Node node, int data) {
        if(node == null){
            return new Node(data);
        }
        if(data > node.data){
            node.right = insert(node.right,data);
        }
        else if(data < node.data){
            node.left = insert(node.left,data);
        }
        return node;
    }

    public void inorderTraversal(){
        inorderTraversal(root);
    }

    private void inorderTraversal (Node node){
        if (node != null)
        {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    void delete(int data){
       this.root = delete(root,data);
    }

    private Node delete(Node node, int data) {
        if(node == null){
            return null;
        }
        if(data > node.data){
            node.right = delete(node.right, data);
        }
        else if(data < node.data){
            node.left = delete(node.left,data);
        }
        else{
            if(node.right == null && node.left == null){
                return null;
            }
            else if(node.right != null && node.left == null){
                return node.right;
            }
            else if(node.right == null && node.left != null){
                return node.left;
            }
            else{
                node.data = getInorderSuccessor(node.right);
                node.right = delete(node.right,node.data);
            }
        }
        return node;
    }

    int getInorderSuccessor(Node node){
        while(node.left != null){
            node=node.left;
        }
        return node.data;
    }
}
