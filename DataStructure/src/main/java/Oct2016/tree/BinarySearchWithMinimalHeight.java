package Oct2016.tree;

/**
 * Created by ritesh on 10/10/16.
 */
public class BinarySearchWithMinimalHeight {

    public static void main(String args[]) {

        int[] inputValue = new int[] {10,15,17,19,21,23,25};
        binaryTreeWithMinimalHeight(inputValue,0,inputValue.length-1);
    }

    public static Tree binaryTreeWithMinimalHeight(final int inputValue[], int left, int right) {

        if(right<left) {
            return null;
        }

        int mid = (left+right)/2;

        final Tree root = new Tree();
        root.data = inputValue[mid];

        root.left = binaryTreeWithMinimalHeight(inputValue,left, right-1);
        root.right = binaryTreeWithMinimalHeight(inputValue, left+1, right);

        return root;
    }

    static class Tree {

        int data;
        Tree left;
        Tree right;

        public Tree() {

        }

        Tree(int data, Tree left, Tree right) {

            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
