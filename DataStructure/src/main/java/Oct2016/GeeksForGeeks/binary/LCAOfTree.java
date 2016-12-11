package Oct2016.GeeksForGeeks.binary;

import assistant.Tree;
import assistant.TreeAssistant;

/**
 * Lowest common ancestor of binary tree
 * Created by ritesh on 11/16/16.
 */
public class LCAOfTree {

    public static void main(String args[]) {

        final TreeAssistant treeAssistant = new TreeAssistant();

        int data[] = new int[]{4,8,10,12,14,20,22};

        final Tree binarySearchTree = treeAssistant.createBinarySearchTree(data, 0, data.length - 1);

        int key1=8;
        int key2=10;
        System.out.println(LCAOfTree(binarySearchTree,key1,key2));
    }

    // not an efficient algorithm. WOnt work when one of the value in tree is 0.
    public static int LCAOfTree(final Tree root, int key1, int key2) {

        if(root==null) {
            return 0;
        }

        if(root.data<=key1 || root.data<=key2) {

            return root.data;
        }

        if(root.data>key1 && root.data<key2) {
            return root.data;
        }

        int leftValue = LCAOfTree(root.left,key1,key2);
        int rightValue = LCAOfTree(root.right, key1, key2);

        if(leftValue == 0) {
            return rightValue;
        }else if(rightValue == 0) {
            return leftValue;
        }

        return Math.min(leftValue,rightValue);
    }
}
