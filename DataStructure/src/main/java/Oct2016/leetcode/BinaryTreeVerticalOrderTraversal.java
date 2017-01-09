package Oct2016.leetcode;

import assistant.Tree;
import assistant.TreeAssistant;

/**
 * Created by ritesh on 12/12/16.
 */
public class BinaryTreeVerticalOrderTraversal {

    public static void main(String args[]) {

        final TreeAssistant treeAssistant = new TreeAssistant();
        int data[] = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

        Tree treeNode = treeAssistant.createBinarySearchTree(data, 0, data.length);


    }
}
