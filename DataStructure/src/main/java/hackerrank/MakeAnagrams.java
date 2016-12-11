package hackerrank;

import java.util.Scanner;

/**
 * @author Ritesh Dalvi (RD026600)
 */
public class MakeAnagrams
{
    public static void main(String[] args) {
/*
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();*/

        String s1 = "fcrxzwscanmligyxyvym";
        String s2 = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";

        int count = makeItAnagram(s1,s2);
        System.out.println(count);
    }

    public static int makeItAnagram(String s1, String s2) {

        int[] asciiValue = new int[128];

        int i = 0;
        int j = 0;

        int count=0;

        while(true) {

            if(i< s1.length()) {
                char c1 = s1.charAt(i);
                asciiValue[c1] = asciiValue[c1]+1;
                i++;
            }

            if(j< s2.length()) {
                char c2 = s2.charAt(j);
                asciiValue[c2] = asciiValue[c2]+1;
                j++;
            }

            if(i >= s1.length() && j>=s2.length()) {
                break;
            }
        }

        i=0;
        j=0;

        while(true) {

            if(i<s1.length()) {

                if(asciiValue[s1.charAt(i)]%2!=0) {
                    count++;
                }

                i++;
            }

            if(j<s2.length()) {

                if(asciiValue[s2.charAt(j)]%2!=0) {
                    count++;
                }

                j++;
            }

            if(i>=s1.length() && j>=s2.length()) {
                break;
            }
        }

        return count;
    }

/*
    static LinkedListNode updateRoute(LinkedListNode initialRoute, String[] citiesToSkip) {

        LinkedListNode slowRunner = initialRoute;
        LinkedListNode fastRunner = initialRoute.next;

        final List<String> citiesToSkipList = new ArrayList<>();

        for(final String citiesToAvoid: citiesToSkip) {
            citiesToSkipList.add(citiesToAvoid);
        }

        if(citiesToSkipList.contains(slowRunner.val)) {

            initialRoute = slowRunner.next;
            slowRunner = initialRoute;

            // Contains only one node
            if(slowRunner != null) {
                fastRunner = slowRunner.next;
            }else {
                fastRunner = slowRunner;
            }
        }

        if(slowRunner!=null) {
            while (fastRunner.next != null) {

                if (citiesToSkipList.contains(fastRunner.val)) {

                    slowRunner.next = fastRunner.next;
                    fastRunner.next = null;
                    fastRunner = slowRunner.next;
                } else {
                    slowRunner.next = fastRunner;
                    fastRunner = fastRunner.next;
                }
            }
        }

        return initialRoute;
    }
    **/


}
