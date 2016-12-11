package assistant;

import third.careercup.linkedin.CheckStringIsNumber;

/**
 * Created by ritesh on 12/16/15.
 */
public class LinkedListAssistant {

   public static LinkedList createLinkedList(final String stringValue) {

       LinkedList<Character> head = null;
       LinkedList<Character> node = null;


       for(int i = 0; i< stringValue.length(); i++) {

           if(head == null) {
               head = new LinkedList<>();
               head.val = stringValue.charAt(i);
               head.next = null;
               node = head;
           }else {
               LinkedList<Character> temp = new LinkedList<>();
               temp.val = stringValue.charAt(i);
               temp.next = null;
               node.next = temp;
               node = temp;
           }
       }

       return head;
   }

    public static LinkedList createLinkedList(final int value[]) {

        LinkedList<Integer> head = null;
        LinkedList<Integer> node = null;


        for(int i = 0; i< value.length; i++) {

            if(head == null) {
                head = new LinkedList<>();
                head.val = value[i];
                head.next = null;
                node = head;
            }else {
                LinkedList<Integer> temp = new LinkedList<>();
                temp.val = value[i];
                temp.next = null;
                node.next = temp;
                node = temp;
            }
        }

        return head;
    }

    public static void printLinkedList(LinkedList linkedList) {

        LinkedList temp = linkedList;
        while(temp.next!=null) {
            System.out.print(temp.val);
            temp = temp.next;
        }
        System.out.print(temp.val);
    }

    public static void printIntLinkedList(LinkedList linkedList) {

        LinkedList temp = linkedList;
        while(temp.next!=null) {
            System.out.print(temp.val);
            System.out.print("->");
            temp = temp.next;
        }
        System.out.print(temp.val);
    }
}
