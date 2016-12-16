package Oct2016.leetcode;

import assistant.LinkedList;
import assistant.LinkedListAssistant;

/**
 * @author Ritesh Dalvi (rd026600).
 */
public class ReverseLinkedList
{

    public static void main(String args[])
    {

        final LinkedList<Integer> linkedList = LinkedListAssistant.createLinkedList(new int[] {3, 4, 5, 6});

        reverseLinkedList(linkedList);
    }

    public static void reverseLinkedList(final LinkedList<Integer> head) {

    }

    //wrong
    public static void reverseLinkedList1(final LinkedList<Integer> head)
    {

        final LinkedList runner = head;

        LinkedList<Integer>[] linkedLists = new LinkedList[10];

        int i = 0;
        while (head.next != null)
        {

            linkedLists[i] = head;

            i++;
        }

        int j = linkedLists.length - 1;

        for (int k = 0; k < linkedLists.length; k++)
        {

            swap(linkedLists[i], linkedLists[j]);
        }
    }

    private static void swap(final LinkedList<Integer> node1, final LinkedList<Integer> node2)
    {
        int temp = node1.val;

        node1.val = node2.val;

        node2.val = temp;
    }
}
