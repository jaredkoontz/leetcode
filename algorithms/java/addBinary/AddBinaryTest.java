package addBinary;

import org.junit.Test;

//todo
public class AddBinaryTest {
	@Test
	public void addTest() {
		AddBinary addBinary = new AddBinary();
		String a = "11";
		String b = "1";

		System.out.println(a + "+" + b + "=" + addBinary.addBinary(a, b));

	}
}
