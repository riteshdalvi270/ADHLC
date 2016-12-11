package third.crackingcode.linkedlist;

import assistant.LinkedList;
import assistant.LinkedListAssistant;

/**
 * Remove duplicates from unsorted linked list.
 * Created by ritesh on 12/16/15.
 */
public class RemoveDuplicates {

    public static void main(String args[]) {

        final String unsortedString = "FOLLOWUP";

        LinkedListAssistant.printLinkedList(removeDuplicatesNoTempBuffer(LinkedListAssistant.createLinkedList(unsortedString)));
    }

    public static LinkedList removeDuplicatesNoTempBuffer(final LinkedList<Character> node) {

        LinkedList<Character> head = node;
        LinkedList<Character> slowRunner = head;
        LinkedList<Character> fastRunner = head.next;

        while(slowRunner.next!=null) {

            if(fastRunner==null) {
                slowRunner = slowRunner.next;
                fastRunner = slowRunner.next;
            }

            if(fastRunner!=null) {
                if (slowRunner.val == fastRunner.val) {

                    LinkedList<Character> temp = slowRunner;

                    while (temp.next != fastRunner) {
                        temp = temp.next;
                    }

                    temp.next = fastRunner.next;
                    fastRunner = temp.next;
                } else {

                    fastRunner = fastRunner.next;
                }
            }
        }
        return head;
    }
}
