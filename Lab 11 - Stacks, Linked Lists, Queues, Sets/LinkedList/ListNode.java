package LinkedList;

public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val){
        this.val = val;
    }

    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public static int size(ListNode node){
        int count = 0;
        ListNode temp = node;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    /* using the reversed list of nodes to get the reversed value and change it in
    /* the original list, I use count to find the node of the specific indexes */
    public static ListNode reverseList(ListNode node, int start, int end){
        if(start < 0 || end > (size(node)-1)){
            System.out.println("Either the start or end is incorrect");
            return null;
        }
        ListNode reversed = reverseHelp(node);
        int count = 0;
        while(node.next != null){
            if(count == start || count == end){
                int changeValue = reversed.getValue();
                node.setValue(changeValue);
            }
            count++;
            node = node.next;
            reversed = reversed.next;
        }
        return node;
    }

    public static Boolean ifCycleInNode(ListNode node){

        return true;
    }
    public int getValue(){return val;}
    public ListNode getNext(){return next;}
    public void setValue(int v){val = v;}
    public void setNext(ListNode n){next = n;}

    public static ListNode reverseHelp(ListNode node){
        /* reversing by saving the next node, then
        /* making next pointer of the current node point to the
        /* node before it, then make the current node the saved next node  */

        ListNode newNode = null;
        ListNode current = node;
        ListNode next = null;
        while(current != null){
            next = current.next;
            current.next = newNode;
            newNode = current;
            current = next;
        }
        return newNode;
    }

}
