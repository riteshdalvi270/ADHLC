package Oct2016.leetcode;

/**
 * @author Ritesh Dalvi (rd026600).
 */
public class ImplementStrStr
{
    public static void main(String args[])
    {

        final String searchString = "issipi";

        final String tobeSearched = "mississippi";

        double start = System.currentTimeMillis();

        System.out.println(implemenStrStr(searchString, tobeSearched));

        double stop = System.currentTimeMillis();

        System.out.print(stop - start);
    }

    public static int implemenStrStr(final String searchString, final String toBeSearched)
    {

        boolean isSearchSuccessful = false;

        if (searchString.length() == 0)
        {
            return 0;
        }

        if (searchString.length() == 0 && toBeSearched.length() == 0)
        {
            return 0;
        }

        if (searchString.length() > toBeSearched.length())
        {
            return -1;
        }

        int i = 0;
        int j = -1;

        for (int a = 0; a < searchString.length(); a++)
        {
            while (i < toBeSearched.length())
            {
                if (searchString.charAt(a) == toBeSearched.charAt(i) && a == 0)
                {
                    j = i;
                    i++;
                    break;
                }
                else if (searchString.charAt(a) == toBeSearched.charAt(i))
                {
                    i++;
                    break;
                }
                else if (searchString.charAt(a) != toBeSearched.charAt(i) && a != 0)
                {
                    i = j + 1;

                    a = -1;
                    j = -1;

                    break;
                }

                i++;
            }

            if (i == toBeSearched.length() && a == searchString.length() - 1)
            {
                isSearchSuccessful = true;
            }
            else if (i == toBeSearched.length() && a != searchString.length() - 1)
            {
                isSearchSuccessful = false;
            }
            else if (a == searchString.length() - 1)
            {
                isSearchSuccessful = true;
            }
        }

        return isSearchSuccessful ? j : -1;
    }
}
