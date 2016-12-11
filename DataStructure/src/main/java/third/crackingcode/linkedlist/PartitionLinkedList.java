package third.crackingcode.linkedlist;

import assistant.LinkedList;
import assistant.LinkedListAssistant;

/**
 * Partition a LinkedList<Integer> around value x.
 * Created by ritesh on 12/17/15.
 */
public class PartitionLinkedList {

    public static void main(String args[]) {

        final int[] value = new int[]{0, 7, 8, 3, 2, 4, 9};

        int number = 3;

        try {
            LinkedListAssistant.printIntLinkedList(partitionNotInPlace(LinkedListAssistant.createLinkedList(value), number));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Wrong solution
    public static LinkedList<Integer> partitionWrong(final LinkedList<Integer> node, final int number) throws Exception {

        LinkedList<Integer> head = node;
        LinkedList<Integer> partitionNumber = head;
        LinkedList<Integer> temp = partitionNumber;

        while (temp != null) {

            if (temp.val == number) {
                break;
            }

            temp = temp.next;
        }

        if (temp == null) {
            throw new Exception("Number not found");
        }

        LinkedList<Integer> tail = temp.next;

        while(tail.next!=null) {
            tail = tail.next;
        }

        LinkedList<Integer> leftRunner = partitionNumber;
        LinkedList<Integer> rightRunner = partitionNumber;

        while(leftRunner!=null) {

            if(leftRunner.val > temp.val) {

                if(leftRunner == head) {

                    LinkedList<Integer> newNode = new LinkedList<>();
                    newNode.val = head.val;
                    newNode.next = null;

                    tail.next = newNode;
                }else {

                    LinkedList<Integer> newNode = new LinkedList<>();
                    newNode.val = leftRunner.val;
                    newNode.next = head.next;
                    head.next = newNode;
                }
            }

            leftRunner = leftRunner.next;
        }

        while(rightRunner!=null) {

            if(rightRunner.val < temp.val) {

                if(rightRunner ==  tail) {

                    LinkedList<Integer> newNode = new LinkedList<>();
                    newNode.val = tail.val;
                    newNode.next = head.next;
                    head.next = newNode;
                    tail = null;
                } else {


                }
            }
        }

        return head;
    }

    public static LinkedList<Integer> partitionNotInPlace(final LinkedList<Integer> linkedList, final int number) throws Exception {

        LinkedList<Integer> head = linkedList;

        LinkedList<Integer> runner = head;


        LinkedList<Integer> temp = head;

        while (temp != null) {

            if (temp.val == number) {
                break;
            }

            temp = temp.next;
        }

        if (temp == null) {
            throw new Exception("Number not found");
        }

        LinkedList<Integer> leftHeadLinkedList = null;
        LinkedList<Integer> leftPartition = null;
        LinkedList<Integer> rightHeadLinkedList = null;
        LinkedList<Integer> rightPartition = null;

        while(runner!=null) {

            if(runner.val < temp.val) {

                if(leftHeadLinkedList == null) {
                    leftHeadLinkedList = new LinkedList<>();
                    leftHeadLinkedList.val = runner.val;
                    leftHeadLinkedList.next = null;
                    leftPartition = leftHeadLinkedList;
                }else {
                    LinkedList<Integer> tempLinkedList= new LinkedList<>();
                    tempLinkedList.val = runner.val;
                    tempLinkedList.next = null;
                    leftPartition.next = tempLinkedList;
                    leftPartition = tempLinkedList;
                }
            }

            if(runner.val > temp.val) {

                if(rightHeadLinkedList == null) {
                    rightHeadLinkedList = new LinkedList<>();
                    rightHeadLinkedList.val = runner.val;
                    rightHeadLinkedList.next = null;
                    rightPartition = rightHeadLinkedList;
                }else {
                    LinkedList<Integer> tempLinkedList = new LinkedList<>();
                    tempLinkedList.val = runner.val;
                    tempLinkedList.next = null;
                    rightPartition.next = tempLinkedList;
                    rightPartition = tempLinkedList;
                }
            }

            runner = runner.next;
        }

        leftPartition.next = temp;
        temp.next = rightHeadLinkedList;

        return leftHeadLinkedList;
    }
}
