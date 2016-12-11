package Oct2016.tree;

import assistant.Tree;
import assistant.TreeAssistant;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by ritesh on 10/20/16.
 */
public class LinkedListOfNodesAtEachDepth {

    public static void main(String args[]) {

       final TreeAssistant treeAssistant = new TreeAssistant();

        int input[] = new int[] {5,10,12,15,16,17,20,21,22,24,27};

        final Tree binarySearchTree = treeAssistant.createBinarySearchTree(input, 0, input.length - 1);

        treeAssistant.printTree(binarySearchTree);

        final HashMap<Integer, LinkedList<Tree>> linkedListOfNodesByHeight =  new HashMap<>();

        depthOfTheTree(binarySearchTree,0,linkedListOfNodesByHeight);


        for(final Map.Entry<Integer, LinkedList<Tree>> entrySet : linkedListOfNodesByHeight.entrySet()) {

            System.out.print("Level:"+entrySet.getKey());

            for(final Tree tree : entrySet.getValue()) {

                System.out.print(" Nodes" +tree.data);
            }

            System.out.println();
        }
    }

    public static void depthOfTheTree(final Tree node, int height, final HashMap<Integer, LinkedList<Tree>> linkedListOfNodesByHeight) {

        if(node == null) {

            return;
        }

        if(linkedListOfNodesByHeight.get(height) == null) {

            final LinkedList<Tree> child = new LinkedList<>();

            child.add(node);

            linkedListOfNodesByHeight.put(height,child);
        } else {

            final LinkedList<Tree> nodes = linkedListOfNodesByHeight.get(height);

            nodes.add(node);
        }

        depthOfTheTree(node.left,height+1,linkedListOfNodesByHeight);

        depthOfTheTree(node.right,height+1,linkedListOfNodesByHeight);
    }
}
