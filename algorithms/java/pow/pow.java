package pow;

//todo
public class pow {
	public double powIter(double x, int n) {
		if (n < 0) {
			n = -n;
			x = 1 / x;
		}
		double result = 1;
		for (double f = x; n > 0; n = n >> 1) {
			if (n % 2 == 1) {
				result *= f;
			}
			f = f * f;
		}
		return result;
	}

	public double powRecurse(double x, int m) {
		double temp = x;
		if (m == 0)
			return 1;
		temp = powRecurse(x, m / 2);
		if (m % 2 == 0)
			return temp * temp;
		else {
			if (m > 0)
				return x * temp * temp;
			else
				return (temp * temp) / x;
		}

	}
}
