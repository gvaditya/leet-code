import java.util.*;

/*
* Given a binary tree, a node in the binary tree and an integer value k,
print all the nodes that are at distance k from the given target node.

public List<Node> getNodes(Node head, Node target, int distance)
* */
public class Main {
    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.left = node2;
        node1.right = node3;
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node2.left = node4;
        node2.right = node5;
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        node3.left = node6;
        node3.right = node7;
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        node4.left = node8;
        node4.right = node9;
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        node5.left = node10;
        node5.right = node11;
        Node node13 = new Node(13);
        node6.right = node13;
        Node node14 = new Node(14);
        node7.left = node14;
        Node node15 = new Node(15);
        node10.left = node15;
        Node node16 = new Node(16);
        Node node17 = new Node(17);
        node11.left = node16;
        node11.right = node17;
        Node node18 = new Node(18);
        Node node19 = new Node(19);
        node15.left = node18;
        node15.right = node19;
        System.out.println(getNodes(node1,node5,3));

    }

    public static List<Node> getNodes(Node head, Node target, int distance){
        List<Node> parents = createParent(head,new ArrayList<>(), target);
        List<Node> output = getChildNodes(target, distance);
        int i =0;
        while (i<distance && i< parents.size()) {
            Node childToIgnore;
            if(i==0){
                childToIgnore = target;
            } else{
                childToIgnore = parents.get(parents.size()- i);
            }
            Node parent = parents.get(parents.size()- i -1);
            if(distance == (i+1)){
                output.add(parent);
            } else{
                if(parent.left != null && parent.right != null){
                    if( parent.left.value == childToIgnore.value ){
                        output.addAll(getChildNodes(parent.right, distance -i-2));
                    } else{
                        output.addAll(getChildNodes(parent.left, distance -i-2));
                    }
                }
            }
            i++;
        }
        return output;
    }

    public static List<Node> getChildNodes(Node current, int distance){
        if(distance == 0){
            return Collections.singletonList(current);
        }
        if(distance <0){
            return new ArrayList<>();
        }
        List<Node> output = new ArrayList<>();
        if(current.left !=null){
            output.addAll(getChildNodes(current.left,distance -1));
        }
        if(current.right != null){
            output.addAll(getChildNodes(current.right,distance -1));
        }
        return output;
    }

    public static List<Node> createParent(Node current, List<Node> parents, Node target){
        if(current.value == target.value){
            return parents;
        } else{
            List<Node> input = new ArrayList<>(parents);
            input.add(current);
            List<Node> output = new ArrayList<>();
            if(current.left !=null){
                output.addAll(createParent(current.left,input,target));
            }
            if(current.right != null){
                output.addAll(createParent(current.right,input,target));
            }
            return output;
        }
    }
}