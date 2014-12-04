package com.MergeKList;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {

    @Test
    public void mergeTest(){
        Solution solution = new Solution();

        ListNode h1 = new ListNode(-1);
        ListNode h2 = new ListNode(-1);

        ListNode head1 = h1;
        for (int i=1; i<=50; i*=2){
            ListNode temp = new ListNode(i);
            head1.next = temp;
            head1 = temp;
        }

        ListNode head2 = h2;
        for (int i=1; i<=50; i = 2*i+1){
            ListNode temp = new ListNode(i);
            head2.next = temp;
            head2 = temp;
        }

        List<ListNode> lists = new ArrayList<ListNode>();
        lists.add(h1);lists.add(h2);

        ListNode end = solution.mergeKLists(lists);

        System.out.println("Print Sorted list:");
        ListNode tmp = end;
        while (tmp.next != null){
            System.out.println(tmp.val);
            tmp = tmp.next;
        }
    }
}