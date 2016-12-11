package Oct2016.GeeksForGeeks.binary;

import assistant.Tree;

/**
 * find successor and predeccessor of binary tree
 * Created by ritesh on 11/8/16.
 */
public class FindSuccessorPredeccesor {

    public static void main(String args[]) {

    }

    // Just a pseudocode
    public void findSuccPred(Tree root, int key) {

        if(root == null) {
            return;
        }

        if(key<root.data) {
            findSuccPred(root.left,key);
        }

        if(key>root.data) {
            findSuccPred(root.right,key);
        }

        findSuccPred(root,key);
        findSuccPred(root,key);
    }
}
