package Oct2016.leetcode;

import assistant.LinkedList;
import assistant.LinkedListAssistant;

/**
 * Created by ritesh on 10/14/16.
 */
public class AddTwoNumbers {

public static void main(String args[]) {

    final LinkedList<Integer> linkedList1 = LinkedListAssistant.createLinkedList(new int[]{1,8});

    final LinkedList<Integer> linkedList2 = LinkedListAssistant.createLinkedList(new int[]{0});

    final LinkedList<Integer> linkedList = addTwoNumbers(linkedList1,linkedList2);

    LinkedListAssistant.printIntLinkedList(linkedList);
}
    public static LinkedList addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2) {

        LinkedList<Integer> runner1 = l1;

        LinkedList<Integer> runner2 = l2;

        LinkedList<Integer> l3 = null;

        LinkedList<Integer> runner3 = l3;

        int quotient = 0;

        while(runner1!=null && runner2!=null) {

            int sum = runner1.val + runner2.val;

            if(quotient!=0) {
                sum = sum + quotient;
            }

            int remainder = sum%10;

            quotient = sum/10;

            if(l3 == null) {
                l3 = new LinkedList<Integer>(remainder);
                runner3 = l3;
            }else {
                final LinkedList<Integer> temp = new LinkedList<Integer>(remainder);

                runner3.next = temp;

                runner3 = temp;
            }

            runner1 = runner1.next;
            runner2 = runner2.next;
        }

        while(runner1!=null) {

            int sum = 0;
            if(quotient!=0) {

                sum = runner1.val + quotient;
            }else {
                sum = runner1.val;
            }

            int remainder = sum%10;

            quotient = sum /10;

            final LinkedList<Integer> temp = new LinkedList<Integer>(remainder);

            runner3.next = temp;

            runner3 = temp;

            runner1 = runner1.next;
        }

        while(runner2!=null) {

            int sum = 0;
            if(quotient!=0) {

                sum = runner2.val + quotient;
            }else {
                sum = runner2.val;
            }

            int remainder = sum%10;

            quotient = sum /10;

            final LinkedList<Integer> temp = new LinkedList<Integer>(remainder);

            runner3.next = temp;

            runner3 = temp;

            runner2 = runner2.next;
        }

        if(quotient!=0) {

            final LinkedList<Integer> temp = new LinkedList<Integer>(quotient);

            runner3.next = temp;

            runner3 = temp;

            runner3.next = null;
        }

        return l3;
    }
}
