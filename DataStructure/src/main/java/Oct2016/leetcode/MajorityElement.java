package Oct2016.leetcode;

public class MajorityElement
{
    public static void main(String args[])
    {

        int input[] = new int[] {3, 5, 6, 6, 9, 6, 3, 4, 6, 6};

        System.out.println(majorityElement(input));
    }

    // left to do
    public static int majorityElement(final int[] input)
    {
        int[] output = new int[input.length];

        for (int i = 0; i < input.length; i++)
        {

            int value = input[i];
            output[value]++;
        }

        return 0;
    }
}
