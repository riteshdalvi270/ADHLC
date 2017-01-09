package Oct2016.leetcode;

import assistant.LinkedList;
import assistant.LinkedListAssistant;

/**
 * Reverse singly linked list
 * Created by ritesh on 12/13/16.
 */
public class ReverseLinkedList {

    public static void main(String args[]) {

        LinkedList linkedList = LinkedListAssistant.createLinkedList(new int[]{2, 3, 4, 5, 6});

        LinkedList runner = linkedList;

        reverseLinkedList(linkedList,runner);
    }

    public static void reverseLinkedList(LinkedList linkedListNode, LinkedList runner) {

        if(runner.next == null) {
            runner.next =  linkedListNode;

            return;

        }else {

            runner.next = linkedListNode.next;
            linkedListNode = runner;

            reverseLinkedList(linkedListNode,runner);

            runner.next =  linkedListNode;
        }
    }
}
