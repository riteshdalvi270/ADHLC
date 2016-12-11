package Oct2016.GeeksForGeeks.binary;

import assistant.Tree;
import assistant.TreeAssistant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Width of the tree is the maximum of width (leaf nodes) all all levels
 * Created by ritesh on 11/5/16.
 */
public class MaximumWidthOFBinaryTree {

    public static void main(String args[]){

        final TreeAssistant treeAssistant = new TreeAssistant();
        int data[] = new int[] {1,2,3,4,5,6,7,8};

        final Tree binarySearchTree = treeAssistant.createBinarySearchTree(data, 0, data.length - 1);

        treeAssistant.printTree(binarySearchTree);

        final HashMap<Integer,List<Tree>> nodesByLevel = new HashMap<>();

        System.out.println(maximumWidthOfTree(binarySearchTree,nodesByLevel));
    }

    public static  int maximumWidthOfTree(final Tree root, final HashMap<Integer, List<Tree>> nodesBylevel) {

        if(root == null) {

            return 0;
        }

        findMaximumWidth(root,0,nodesBylevel);

        int count = 0;
        int max = 0;

        for(final List<Tree> nodes : nodesBylevel.values()) {

            count = nodes.size();

            if(count > max) {
                max = count;
            }
        }

        return max;
    }

    public static void findMaximumWidth(final Tree node, int height, final HashMap<Integer, List<Tree>> nodesBylevel) {

        if(node == null) {

            return;
        }

        if(nodesBylevel.get(height) != null) {

            final List<Tree> nodes = nodesBylevel.get(height);
            nodes.add(node);
        }else {

            final List<Tree> nodes = new ArrayList<>();
            nodes.add(node);

            nodesBylevel.put(height,nodes);
        }

        height = height + 1;

        findMaximumWidth(node.left,height,nodesBylevel);
        findMaximumWidth(node.right, height, nodesBylevel);
    }
}
