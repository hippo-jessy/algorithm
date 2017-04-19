package datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *  This class provide the postorder traversal of a binary tree in both a recursive way and iterative ways.
 */
public class PostorderTraveral {

    public static List<Integer> recursivePostorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(recursivePostorderTraversal(root.left));
        result.addAll(recursivePostorderTraversal(root.right));
        result.add(root.val);
        return result;
    }

    public static List<Integer> iterativePostorderTraversal(TreeNode root){
        LinkedList<Integer> result = new LinkedList<>();
        if(root == null){
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            result.addFirst(tmp.val);
            if(tmp.left != null){
                stack.push(tmp.left);
            }
            if(tmp.right != null){
                stack.push(tmp.right);
            }
        }
        return result;
    }
}
