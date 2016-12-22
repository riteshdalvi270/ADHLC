package Oct2016.leetcode;

public class BackFrontLeapGame
{
    public static void main(String args[])
    {
        int[] input = new int[] {2, 1, 2, 2, 0, 4};
        int index = 3;

        System.out.println(backFrontLeap(input, index));
    }

    public static boolean backFrontLeap(int[] input, int index)
    {

        if (input.length == 0)
        {
            return false;
        }

        int value = input[index];

        if (value == 0)
        {
            return true;
        }

        int backIndex = index - value;
        int frontIndex = index + value;

        return find(input, backIndex, frontIndex, false, false);
    }

    public static boolean find(int[] input, int backIndex, int frontIndex, boolean backLeap, boolean frontLeap)
    {

        frontLeap = isOutOfBounds(frontIndex, input.length - 1);

        backLeap = isOutOfBounds(backIndex, input.length - 1);

        if (!backLeap)
        {
            int backValue = input[backIndex];

            if (backValue == 0)
            {
                return true;
            }

            frontIndex = backIndex + backValue;
            backIndex = backIndex - backValue;

            return find(input, backIndex,frontIndex , backLeap, frontLeap);
        }

        if (!frontLeap)
        {
            int frontValue = input[frontIndex];

            if (frontValue == 0)
            {
                return true;
            }

            return find(input, frontIndex - frontValue, frontIndex + frontValue, backLeap, frontLeap);
        }

        return false;
    }

    private static boolean isOutOfBounds(int index, int length)
    {
        if (index < 0 || index > length)
        {
            return true;
        }

        return false;
    }
}
