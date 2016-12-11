package Oct2016.tree;

import assistant.Tree;
import assistant.TreeAssistant;

/**
 * Determine if t2 is a subtree of T1.
 * Created by ritesh on 10/22/16.
 */
public class T2SubtreeofT1 {

    public static void main(String args[]) {

        final TreeAssistant treeAssistant = new TreeAssistant();

        int[] input1 = new int[] {2,3,4,5,6,7,8,9,10};
        int[] input2 = new int[] {7,8,9,10};

        final Tree T1 = treeAssistant.createBinarySearchTree(input1, 0, input1.length - 1);
        final Tree T2 = treeAssistant.createBinarySearchTree(input2, 0, input2.length - 1);

        System.out.print(isSubtree(T1,T2));
    }









    //wrong solution (Ignore).
    public static boolean isSubtree(final Tree T1, final Tree T2) {

        if(T2 == null) {
            return true;
        }

        if(T1 == null) {
            return false;
        }

        boolean side = false;

        if(T1.data != T2.data) {
            side = isSubtree(T1.left,T2) || isSubtree(T1.right, T2);
        }

        if(side) {
           return isSubtree(T1.left, T2.left) || isSubtree(T1.right, T2.right);
        }

        return false;
    }
}
