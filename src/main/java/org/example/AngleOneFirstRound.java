package org.example;

public class AngleOneFirstRound {

    /*
    9,5,9
    9,9
     */

    public static void main(String[] args) {
        System.out.println("Hi");


        Nodes nodes5 = new Nodes(null, 9);
        Nodes nodes4 = new Nodes(nodes5, 9);
        Nodes nodes3 = new Nodes(nodes4, 9);
        Nodes nodes2 = new Nodes(nodes3, 9);
        Nodes nodes1 = new Nodes(nodes2, 9);


        Nodes nodes12 = new Nodes(null, 9);
        Nodes nodes11 = new Nodes(nodes12, 9);


        Nodes ans = addLists(nodes1, nodes11);

        while (ans !=null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

    public static int recurse(Nodes list1, Nodes list2) {
        if (list1.next == null && list2.next == null) {
            int val = (list1.val + list2.val)%10;
            int rem = (list1.val + list2.val)/10;
            list1.val = val;
            return rem;
        }

        int retRem = recurse(list1.next, list2.next);
        int val = (list1.val + list2.val + retRem )%10;
        int rem = (list1.val + list2.val + retRem)/10;
        list1.val = val;
        return rem;

    }

    public static Nodes addLists (Nodes list1, Nodes list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        int len1 = 0;
        int len2 = 0;
        Nodes head1 = list1;
        Nodes head2 = list2;
        Nodes firstNode = list1;
        Nodes secondNode = list2;

        while (head1 !=null) {
            len1++;
            head1 = head1.next;
        }
        while (head2 !=null) {
            len2++;
            head2 = head2.next;
        }
        if (len1 < len2) {
            int diff = len2 - len1;
            Nodes prevNode = null;
            for (int i=0; i<diff; i++) {
                Nodes nodes = new Nodes(null, 0);
                if (i ==0) {
                    firstNode = nodes;
                    prevNode = nodes;
                } else {
                    prevNode.next = nodes;

                }
                if (i == diff-1) {
                    nodes.next = list1;
                }
                prevNode = nodes;
            }
        } else if (len2 < len1){
            int diff = len1 - len2;
            Nodes prevNode = null;
            for (int i=0; i<diff; i++) {
                Nodes nodes = new Nodes(null, 0);
                if (i ==0) {
                    secondNode = nodes;
                    prevNode = nodes;
                } else {
                    prevNode.next = nodes;
                }
                if (i == diff-1) {
                    nodes.next = list2;
                }
                prevNode = nodes;
            }
        }

        int rem =  recurse(firstNode, secondNode);
        Nodes ans;
        if (rem > 0) {
            ans = new Nodes(firstNode, rem);
            ans.next = firstNode;
        } else {
            ans  = firstNode;
        }
        return ans;

    }

}

class Nodes {

    Nodes next;
    int val;

    public Nodes(Nodes next, int val) {
        this.next = next;
        this.val = val;
    }
}
