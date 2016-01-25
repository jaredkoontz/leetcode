package divideTwoInt;

import org.junit.Test;


public class divideTwoIntsTest {

	@Test
	public void tests() {
		divideTwoInt d = new divideTwoInt();
		System.out.println("0/2=" + d.divide(0, 2));
		System.out.println("10/2=" + d.divide(10, 2));
		System.out.println("10/3=" + d.divide(10, 3));
		System.out.println("10/5=" + d.divide(10, 5));
		System.out.println("10/7=" + d.divide(10, 7));
		System.out.println("10/10=" + d.divide(10, 10));
		System.out.println("10/11=" + d.divide(10, 11));
		System.out.println("-1/1=" + d.divide(1, -1));
		System.out.println("1/-1=" + d.divide(1, -1));
		System.out.println("-1/-1=" + d.divide(-1, -1));
		System.out.println("2147483647/1=" + d.divide(2147483647, 1));
		System.out.println("-2147483647/1=" + d.divide(-2147483647, 1));
		System.out.println("2147483647/-1=" + d.divide(2147483647, -1));
		System.out.println("-2147483647/-1=" + d.divide(-2147483647, -1));
		System.out.println("2147483647/2=" + d.divide(2147483647, 2));
		System.out.println("2147483647/10=" + d.divide(2147483647, 10));
		System.out.println("-2147483648/1=" + d.divide(-2147483648, 1));
		System.out.println("-2147483648/-1=" + d.divide(-2147483648, -1));
	}
}
