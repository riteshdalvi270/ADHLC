package Oct2016.leetcode;

import assistant.Tree;
import assistant.TreeAssistant;

/**
 * @author Ritesh Dalvi (rd026600).
 */
public class SumFromRootToLeaf
{
    public static void main(String args[])
    {

        final TreeAssistant treeAssistant = new TreeAssistant();

        Tree tree2 = treeAssistant.createBinaryTree(11, 7, 2);

        Tree tree3 = treeAssistant.createBinaryTree(13, -1, -1);

        Tree tree4 = treeAssistant.createBinaryTree(4, -1, 1);

        Tree tree5 = treeAssistant.createBinaryTree(4, tree2, null);
        Tree tree6 = treeAssistant.createBinaryTree(8, tree3, tree4);

        Tree tree = treeAssistant.createBinaryTree(5, tree5, tree6);

        Tree treeSecondInput = treeAssistant.createBinaryTree(1, -1, 2);

        System.out.println(hasPathSum(tree, 18));
    }

    public static boolean hasPathSum(Tree root, int sum)
    {

        if (root == null)
        {
            return false;
        }

        return traverse(root, sum, 0);
    }

    public static boolean traverse(final Tree root, int sum, int targetValue)
    {
        if (root == null)
        {
            return false;
        }

        if (root.left == null && root.right == null)
        {

            if (sum == targetValue + root.data)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        targetValue = targetValue + root.data;

        return traverse(root.left, sum, targetValue) || traverse(root.right, sum, targetValue);
    }
}
