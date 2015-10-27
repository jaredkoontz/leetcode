package pow;

import org.junit.Test;

/**
 * Created by jared on 10/26/15.
 */
public class powTest {

    @Test
    public void testMethod() {
        pow p = new pow();
        System.out.println(p.powIter(1, 2));
        System.out.println(p.powRecurse(1, 2));

    }

}
