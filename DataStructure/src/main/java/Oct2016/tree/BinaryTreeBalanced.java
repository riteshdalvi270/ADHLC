package Oct2016.tree;

/**
 * Created by ritesh on 10/10/16.
 */
public class BinaryTreeBalanced {

    public static void main(String args[]) {

        final Tree root = new Tree();
        isBalanced(root);
    }

    public static boolean isBalanced(final Tree root) {

        if(root == null) {
            return true;
        }

        int height = Math.abs(getHeight(root.left) - getHeight(root.right));

        if(height>1) {
            return false;
        }else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public static int getHeight(final Tree node) {

        if(node == null) {
            return 0;
        }

        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
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
