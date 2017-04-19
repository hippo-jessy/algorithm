package datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This class provide the preorder traversal of a binary tree in both a recursive way and iterative ways.
 */
public class PreorderTraversal {

    public List<Integer> recursivePreorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.add(root.val);
        result.addAll(recursivePreorderTraversal(root.left));
        result.addAll(recursivePreorderTraversal(root.right));
        return result;
    }

    /**
     * This method use similar idea as iterative inorder traversal.
     * The only difference is that the node is added to the result list before pushed into the stack.
     * This method is less efficient comparing to the following two methods.
     *
     * @param root
     * @return
     */
    public List<Integer> iterativePreorderTraversalOne(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode currentNode = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || currentNode != null) {
            while (currentNode != null) {
                result.add(currentNode.val);
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            currentNode = currentNode.right;
        }
        return result;
    }

    /**
     * This method is more efficient than the last one.
     *
     * @param root
     * @return
     */
    public List<Integer> iterativePreorderTraversalTwo(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            result.add(tmp.val);
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
        }
        return result;
    }

    /**
     * This method only push right nodes into the stack.
     *
     * @param root
     * @return
     */
    public List<Integer> iterativePreorderTraversalThree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode currentNode = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                result.add(currentNode.val);
                if (currentNode.right != null) {
                    stack.push(currentNode.right);
                }
                currentNode = currentNode.left;
            } else {
                currentNode = stack.pop();
            }
        }
        return result;
    }

}
