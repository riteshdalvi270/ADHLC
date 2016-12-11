package Oct2016.GeeksForGeeks.binary;

import assistant.Tree;
import assistant.TreeAssistant;

/**
 * find kth smallest element
 * Created by ritesh on 11/7/16.
 */
public class FindKthSmallesElementInBST {

    public static void main(String args[]) {

        final TreeAssistant treeAssistant = new TreeAssistant();
        int data[] = new int[] {4,8,10,12,14,20,22};
        final Tree binarySearchTree = treeAssistant.createBinarySearchTree(data, 0, data.length - 1);

        int min = 0;
        int k = 3;
        kthSmallest(binarySearchTree,k);
    }

    // this wont work. if root is larger element, fail.
    public static int kthSmallestElement(final Tree root, int min, int k) {

        if(root == null) {
            return min;
        }

        if(k<0) {
            return min;
        }

        if(root.data>min && k>0) {
            min = root.data;
        }

        return Math.min(kthSmallestElement(root.left,min,k-1), kthSmallestElement(root.right,min,k-1));
    }

    // fail. not possible recursively
    public static int kthSmallest(final Tree root,int k) {

        if(root == null) {
            return 0;
        }

        int left = kthSmallest(root.left,k);

        if(k == left+1) {
            System.out.println(root.data);
            return 1;
        }

        return 1 + left + kthSmallest(root.right,k);
    }
}
