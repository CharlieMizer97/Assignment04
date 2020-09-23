public class Main {

    static class Node {
        int num;
        Node left, right;

        public Node(int key) {
            num = key;
            left = right = null;
        }
    }

    Node root;

    private boolean isEmpty(Node root){return root == null;}

    int sort(Node root)
    {
        int srtV = root.num;
        while (root.left != null)
        {
            srtV = root.left.num;
            root = root.left;
        }
        return srtV;
    }



    private void insertNode(int num){root = inNode(root, num);}

    Node inNode(Node root, int num){

        if (isEmpty(root)){
            root = new Node(num);
            return root;
        }

        if (num > root.num){root.right = inNode(root.right, num);}
        else if (num < root.num){root.left = inNode(root.left, num);}

        return root;

    }

    private boolean searchT(Node root, int num){

        if (isEmpty(root)){return false;}
        if (root.num == num){return true;}

        boolean chckL = searchT(root.left, num);
        if (chckL){return true;}

        return searchT(root.right, num);

    }

    private void deleteNode(int num){

        boolean temp = searchT(root, num);

        if (temp){
            root = delNode(root, num);}

        if (!temp)
        assert !temp : "Node Does Not Exist";

    }

    Node delNode(Node root, int num){

        if (isEmpty(root)){return null;}

        if (num > root.num){root.right = delNode(root.right, num);}
        else if (num < root.num){root.left = delNode(root.left, num);}
        else{

            if (root.right == null){return root.left;}
            else if(root.left == null){return root.right;}

            root.num = sort(root.right);
            root.right = delNode(root.right, root.num);
        }

        return root;

    }

    void printT()  {
        printBT(root);
    }

    void printBT(Node root) {
        if (root != null) {
            printBT(root.left);
            System.out.println(root.num);
            printBT(root.right);
        }
    }

    public static void main(String[] args) {

        Main main = new Main();

        main.insertNode(1);
        main.insertNode(10);
        main.insertNode(7);
        main.insertNode(3);
        main.insertNode(9);
        main.insertNode(8);

        main.printT();
        System.out.println("///Break///");

        main.deleteNode(3);
        main.deleteNode(1);
        main.printT();

        //System.out.println("///Will get assertion error right after this for 44///");
        //main.deleteNode(44);

        System.out.println("There is an assertion for looking for a node");
        System.out.println("Will only get here if passed assertions");
        System.out.println("Successful");


        System.out.println("JEALOUS");
    }

}
