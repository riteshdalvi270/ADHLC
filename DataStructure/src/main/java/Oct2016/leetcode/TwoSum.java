package Oct2016.leetcode;

/**
 * @author Ritesh Dalvi (rd026600).
 */
public class TwoSum
{
    public static void main(String args[])
    {

        int[] input = new int[] {5,75,25};

        int[] output = twoSum(input, 100);

        for (int data : output)
        {
            System.out.println(data);
        }
    }

    public static int[] twoSum(int[] nums, int target)
    {

        for (int i = 0; i < nums.length; i++)
        {

            int sourceValue = nums[i];

            for (int j = i + 1; j < nums.length; j++)
            {

                int targetValue = nums[j];

                if (targetValue > 0 && sourceValue > targetValue)
                {
                    break;
                }

                if (sourceValue > 0 && targetValue > target)
                {
                    continue;
                }

                int sum = sourceValue + targetValue;

                if (sum == target)
                {
                    return new int[] {i, j};
                }
            }
        }

        return new int[] {0, 0};
    }
}
