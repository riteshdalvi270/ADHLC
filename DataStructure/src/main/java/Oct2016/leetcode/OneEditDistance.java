package Oct2016.leetcode;

/**
 * Given two strings S and T, determine if they are both one edit distance apart.
 * Created by ritesh on 12/12/16.
 */
public class OneEditDistance {

    public static void main(String args[]) {

        final String source = "hello";
        final String target = "yello";

        System.out.println(isOneEditDistance(source,target));
    }

    private static boolean isOneEditDistance(final String source, final String target) {

        int counter = editDistance(source,target,source.length(),target.length());

        if(counter == 1) {
            return true;
        }

        return false;
    }

    private static int editDistance(final String source, final String target, int sourceLength, int targetlength) {

        if(sourceLength == 0) {
            return targetlength;
        }

        if(targetlength == 0) {
            return sourceLength;
        }

        if(source.charAt(sourceLength-1) == (target.charAt(targetlength-1))) {
           return editDistance(source,target,sourceLength-1,targetlength-1);
        }

        return 1+ min(editDistance(source,target,sourceLength,targetlength-1), // insert
                editDistance(source,target,sourceLength-1,targetlength), // remove
                editDistance(source,target,sourceLength-1,targetlength-1)); // replace
    }

    private static int min(int x, int y, int z) {

        if(x<y && x<z) {
            return x;
        }else if(y<x && y<z) {
            return y;
        }

        return z;
    }
}
