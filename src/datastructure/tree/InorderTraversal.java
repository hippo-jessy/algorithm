package datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class provide the inorder traversal of a binary tree in both a recursive way and an iterative way.
 */
public class InorderTraversal {

    public static List<Integer> recursiveInorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        result.addAll(recursiveInorderTraversal(root.left));
        result.add(root.val);
        result.addAll(recursiveInorderTraversal(root.right));
        return result;
    }

    public static List<Integer> iterativeInorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode currentNode = root;
        while (!stack.isEmpty() || currentNode != null) {
            while(currentNode!=null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            currentNode = stack.pop();
            currentNode = currentNode.right;
        }
        return result;
    }


}
