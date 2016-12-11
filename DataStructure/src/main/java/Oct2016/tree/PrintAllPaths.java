package Oct2016.tree;

import assistant.Tree;
import assistant.TreeAssistant;

import java.util.LinkedList;

/**
 * Created by ritesh on 10/22/16.
 */
public class PrintAllPaths {

    public static void main(String args[]) {

        TreeAssistant treeAssistant = new TreeAssistant();
        int[] input1 = new int[] {2,3,4,5,6,7,8,9,10};

        final Tree binarySearchTree = treeAssistant.createBinarySearchTree(input1, 0, input1.length-1);

        final LinkedList<LinkedList<Tree>> paths = new LinkedList<>();

        int sum = 9;

        pathPrint(binarySearchTree, paths, sum);

        for(final LinkedList<Tree> path : paths) {

            for(final Tree node: path) {

                System.out.print(node.data);
                System.out.print("->");
            }

            System.out.println();
        }
    }

    public static void pathPrint(final Tree tree, LinkedList<LinkedList<Tree>> paths, int sum) {

        if(tree == null) {
            return;
        }

        final LinkedList<Tree> path = new LinkedList<>();

        if(!calculatePaths(tree,path,sum)) {

            paths = new LinkedList<>();
        }

        pathPrint(tree.left,paths,sum);

        pathPrint(tree.right,paths,sum);

        paths.add(path);
    }

    public static boolean calculatePaths(final Tree tree, LinkedList<Tree> paths, int sum) {

        if(tree == null) {
            return false;
        }

        paths.add(tree);

        int target = 0;

        for(final Tree node : paths) {

            target = target + node.data;
        }

        if(target == sum) {
            return true;
        }else {
            if (target >  sum) {
                paths = new LinkedList<>();
            }

            return calculatePaths(tree.left, paths, sum) || calculatePaths(tree.right,paths,sum);
        }
    }
}
