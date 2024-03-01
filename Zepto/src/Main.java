import java.util.*;

// https://leetcode.com/problems/smallest-string-starting-from-leaf/description/
public class Main {
    private static String ans ="";
    public static void main(String[] args) {
        TreeNode first = new TreeNode(3);
        TreeNode second = new TreeNode(9);
        TreeNode third = new TreeNode(20);
        TreeNode sixth = new TreeNode(15);
        TreeNode seventh = new TreeNode(7);
        first.left = second;
        first.right = third;
        third.left = sixth;
        third.right = seventh;
        dfs(first, new StringBuilder());

        System.out.println(ans);
    }
//    [6,6,1,null,null,6,6]

    public static void dfs(TreeNode node, StringBuilder sb){
        sb.append((char) ('a'+node.val));
        if(node.left != null) dfs(node.left,sb);
        if(node.right != null) dfs(node.right,sb);
        if(node.left == null && node.right == null){
            String temp = sb.reverse().toString();
            if(ans.equals("") || temp.compareTo(ans)<0){ ans = temp; }
            sb.reverse();
        }
        sb.deleteCharAt(sb.length() -1);
    }

    public static String smallestFromLeaf(TreeNode root) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        List<TreeNode> leafs = new ArrayList<>();
        createParentMap(parentMap, leafs, root);
        StringBuilder s = new StringBuilder();
        s.append((char) ('a' + leafs.get(0).val));
        List<TreeNode> parentsForConsideration = extracted(leafs, parentMap);
        outer:while (!parentsForConsideration.isEmpty()) {
            s.append((char) ('a' + parentsForConsideration.get(0).val));
            for (TreeNode treeNode : parentsForConsideration) {
                if(parentMap.get(treeNode) == null){
                    break outer;
                }
            }
            parentsForConsideration = extracted(parentsForConsideration, parentMap);
        }
        return s.toString();
    }

    private static List<TreeNode> extracted(List<TreeNode> leafs, Map<TreeNode, TreeNode> parentMap) {
        List<TreeNode> parentsForConsideration = new ArrayList<>();
        int val = 0;
        for (TreeNode leaf : leafs) {
            TreeNode parent = parentMap.get(leaf);
            if (parent != null) {
                // leaf node
                if (parentsForConsideration.isEmpty()) {
                    // no leaves so far
                    parentsForConsideration.add(parent);
                    val = parent.val;
                } else {
                    // leaves existing
                    if (val > parent.val) {
                        parentsForConsideration = Arrays.asList(parent);
                    } else if(val == parent.val){
                        parentsForConsideration.add(parent);
                    }
                }
            }

        }
        return parentsForConsideration;
    }

    public static void createParentMap(Map<TreeNode, TreeNode> parentMap, List<TreeNode> leafs, TreeNode currentNode) {
        if (currentNode.right == null && currentNode.left == null) {
            // leaf node
            if (leafs.isEmpty()) {
                // no leaves so far
                leafs.add(currentNode);
            } else {
                // leaves existing
                TreeNode leaf = leafs.get(0);
                if (leaf.val > currentNode.val) {
                    leafs.clear();
                    leafs.add(currentNode);
                } else if(leaf.val == currentNode.val){
                    leafs.add(currentNode);
                }
            }
        } else {
            if (currentNode.left != null) {
                parentMap.put(currentNode.left, currentNode);
                createParentMap(parentMap, leafs, currentNode.left);
            }
            if (currentNode.right != null) {
                parentMap.put(currentNode.right, currentNode);
                createParentMap(parentMap, leafs, currentNode.right);
            }
        }
    }
}