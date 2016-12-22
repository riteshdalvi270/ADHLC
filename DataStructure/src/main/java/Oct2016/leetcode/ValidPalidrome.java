package Oct2016.leetcode;

public class ValidPalidrome
{
    public static void main(String args[])
    {

        final String input = "A man, a plan, a canal: Panama";

        System.out.println(validPalidrome(input));
    }

    public static boolean validPalidrome(final String palidrome)
    {

        if (palidrome.isEmpty())
        {
            return true;
        }

        String palidromeLowerCase = palidrome.toLowerCase();
        char inputs[] = palidromeLowerCase.toCharArray();

        int j = inputs.length - 1;

        for (int i = 0; i < inputs.length; i++)
        {
            if (i > j)
            {
                break;
            }

            if (checkAscii(inputs[i]))
            {

                continue;
            }
            else if (checkAscii(inputs[j]))
            {
                i--;
                j--;
                continue;
            }

            if (inputs[i] != inputs[j])
            {
                return false;
            }
            else
            {
                j--;
            }
        }

        return true;
    }

    private static boolean checkAscii(final char input)
    {
        int asciiValue = (int) input;
        if ((asciiValue < 65 && asciiValue > 31) || (asciiValue > 90 && asciiValue < 97))
        {
            return true;
        }

        return false;
    }

}
