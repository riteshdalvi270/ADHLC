package hackerrank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ritesh on 9/4/16.
 */
public class LinkedListOfRoutes {

    public static void main(String args[]) {

    }



class LinkedListNode {
    String val;
    LinkedListNode next;
}


    static LinkedListNode updateRoute(LinkedListNode initialRoute, String[] citiesToSkip) {

        LinkedListNode slowRunner = initialRoute;
        LinkedListNode fastRunner = initialRoute.next;

        final List<String> citiesToSkipList = new ArrayList<>();

        for(final String citiesToAvoid: citiesToSkip) {
            citiesToSkipList.add(citiesToAvoid);
        }

        // head to delete
        while(slowRunner!=null && citiesToSkipList.contains(slowRunner.val)) {

            initialRoute = slowRunner.next;
            slowRunner.next = null;
            slowRunner = initialRoute;

            // Contains only one node
            if(slowRunner != null) {
                fastRunner = slowRunner.next;
            }else {
                fastRunner = null;
            }
        }

            while (fastRunner != null) {

                if(citiesToSkipList.contains(fastRunner.val)) {

                        slowRunner.next = fastRunner.next;
                        fastRunner.next = null;
                        fastRunner = slowRunner.next;
                    } else {
                        slowRunner = fastRunner;
                        fastRunner = fastRunner.next;
                    }
                }



        return initialRoute;
    }
}
