package addTwoNumbers;

import common.ListNode;
import org.junit.Test;

//todo
public class AddTwoNumbersTest {

    @Test
    public void test(){
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode n1 = new ListNode(10);
        ListNode n2 = new ListNode(15);

        System.out.println(addTwoNumbers.addTwoNumbers(n1,n2).val);

    }
}
