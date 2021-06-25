package addTwoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.Math;

public class AddTwoNumbers {
  public static void main(String[] args) {
    // Defining input
    ListNode x2 = new ListNode(3);
    ListNode x1 = new ListNode(4, x2);
    ListNode x = new ListNode(2, x1);

    ListNode y1 = new ListNode(4);
    ListNode y2 = new ListNode(6, y1);
    ListNode y = new ListNode(5, y2);

    Solution sol = new Solution();
    ListNode result = sol.addTwoNumbers(x, y);
    System.out.println(result.val);
    // System.out.println(result.next.val);
    // System.out.println(result.next.next.val);
    // System.out.println(result.next.next.next.val);
  }
}

class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // List<Integer> base1 = new ArrayList<Integer>();
    // List<Integer> base2 = new ArrayList<Integer>();
    // List<Integer> result = new ArrayList<Integer>();
    ListNode nodeBase = new ListNode();
    ListNode current = new ListNode();
    int pass = 0;
    int counter = 0;
    while (l1 != null || l2 != null) {
      int digit1 = 0;
      int digit2 = 0;
      int result = 0;
      int digitResult = 0;
      if (l1 != null) {
        // base1.add(l1.val);
        digit1 = l1.val;
        l1 = l1.next;
      } else {
        digit1 = 0;
      }
      if (l2 != null) {
        // base2.add(l2.val);
        digit2 = l2.val;
        l2 = l2.next;
      } else {
        digit2 = 0;
      }
      result = digit1 + digit2 + pass;
      digitResult = result % 10;
      pass = result / 10;
      if (counter == 0) {
        nodeBase = new ListNode(digitResult);
        current = nodeBase;
      } else {
        current.next = new ListNode(digitResult);
        current = current.next;
      }
      counter += 1;
    }

    if (pass > 0) {
      current.next = new ListNode(pass);
    }

    return nodeBase;
  }
}
