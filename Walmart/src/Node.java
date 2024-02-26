public class Node{
    public Node left;
    public Node right;

    public int value;
    Node(int value){
        this.value = value;
        left = right = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
