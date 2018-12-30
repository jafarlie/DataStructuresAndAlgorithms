package BinarySearchTree;

public class BST {
    Node root;

    public BST(){
        root = null;
    }

    void insert(int key){
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key){
        if(root == null){
            this.root = new Node(key);
            return this.root;
        }
        if(key < this.root.value){
            root.left = insertRec(root.left, key);
        }else if (key > this.root.value){
            root.right = insertRec(root.right, key);
        }
        return this.root;
    }
    void inorder(){
        inorderTraversal(root);
    }

    void inorderTraversal(Node root){
        if(root != null){
            inorderTraversal(root.left);
            System.out.println(root.value);
            inorderTraversal(root.right);
        }
    }

    void preorder(){
        preorderTraversal(this.root);
    }

    void preorderTraversal(Node root){
        if(root != null){
            System.out.println(this.root.value);
            preorderTraversal(this.root.left);
            preorderTraversal(this.root.right);
        }
    }

    void postorder(){
        postorderTraversal(this.root);
    }

    void postorderTraversal(Node root){
        if(root != null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            System.out.println(root.value);
        }
    }

    void deleteKey(int value){
        root = deleteRecursively(this.root, value);
    }

    // Worst-case time complexity O(h), where h -> height of the tree
    Node deleteRecursively(Node root, int key){
        if(this.root == null){
            return null;
        }
        if(key < this.root.value){
            root.left = deleteRecursively(root.left, key);
        }
        else if(key > this.root.value){
            root.right = deleteRecursively(root.right, key);
        }
        else{
            if(this.root.left == null){
                return this.root.right;
            } else if (this.root.right == null){
                return this.root.left;
            }
            // node with 2 successor, get smallest element in the right subtree
            root.value = minValue(root.right);
            root.right = deleteRecursively(root.right, key);
        }
        return this.root;
    }

    int minValue(Node root){
        int minValue = root.value;
        while(root.left != null){
            minValue = root.left.value;
            root = root.left;
        }
        return minValue;
    }

    public static void main(String[] args){
        BST tree = new BST();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Inorder traversal of the given tree");
        tree.inorder();
        System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 30");
        tree.deleteKey(30);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nDelete 50");
        tree.deleteKey(50);
        System.out.println("Inorder traversal of the modified tree");
        tree.inorder();
    }
}
