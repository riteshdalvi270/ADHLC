package Oct2016.GeeksForGeeks.binary;

import assistant.Tree;
import assistant.TreeAssistant;

import java.util.ArrayList;
import java.util.List;

/**
 * Print ancestors of a given node in binary tree
 * Created by ritesh on 11/5/16.
 */
public class PrintAncestorsOfGivenNode {

    public static void main(String args[]) {

       final TreeAssistant treeAssistant = new TreeAssistant();

        int data[] = new int[] {2,4,6,8,9,10};

        final Tree binarySearchTree = treeAssistant.createBinarySearchTree(data, 0, data.length - 1);

        treeAssistant.printTree(binarySearchTree);

        List<Tree> ancestors = new ArrayList<>();

        int node = 7;

        //findAncestors(binarySearchTree, node, ancestors);

        for(final Tree ancestor : ancestors) {
            System.out.println(ancestor.data);
        }

        printAncestors(binarySearchTree,10);
    }

    public static void findAncestors(final Tree root, final int node , final List<Tree> ancestors) {

        if(root == null) {

            return;
        }

        if(root.data == node) {
            return;
        }

        findAncestors(root.left,node,ancestors);
        findAncestors(root.right,node,ancestors);

        ancestors.add(root);
    }

    static boolean printAncestors(Tree node, int target)
    {
         /* base cases */
        if (node == null)
            return false;

        if (node.data == target)
            return true;

        /* If target is present in either left or right subtree
           of this node, then print this node */
        if (printAncestors(node.left, target)
                || printAncestors(node.right, target))
        {
            System.out.print(node.data + " ");
            return true;
        }

        /* Else return false */
        return false;
    }
}
