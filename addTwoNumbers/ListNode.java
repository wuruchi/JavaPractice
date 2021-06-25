package addTwoNumbers;

/* ListedNode
* Simple definition
* Next?
*/
public class ListNode {
  int val;
  ListNode next;

  ListNode() {
    // Main constructor
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
