

public class Quaternion
{
	private double a,b,c,d;

	public Quaternion()
	{
		a = 0.0;
		b = 0.0;
		c = 0.0;
		d = 0.0;
	}

	public Quaternion(
		double w, double i, double j, double k)
	{
		a = w;
		b = i;
		c = j;
		d = k;
	}

	public Quaternion add(Quaternion other)
	{
		double aSum = a + other.a;
		double bSum = b + other.b;
		double cSum = c + other.c;
		double dSum = d + other.d;

		return new Quaternion(aSum, bSum, cSum, dSum);
	}

	public Quaternion neg()
	{
		return new Quaternion(-1*a, -1*b, -1*c, -1*d);
	}

	public Quaternion sub(Quaternion other)
	{
		return add(other.neg());
	}

	
}
