

public class Quaternion
{
	private double a,b,c,d;				// q = (a, b, c, d)

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

	public Quaternion(Quaternion other)
	{
		a = other.a;
		b = other.b;
		c = other.c;
		d = other.d;
	}

	// r = q + p= (q.a+p.a, q.b+p.b, q.c+p.c, q.d+p.d)
	public Quaternion add(Quaternion other)
	{
		double aSum = a + other.a;
		double bSum = b + other.b;
		double cSum = c + other.c;
		double dSum = d + other.d;

		return new Quaternion(aSum, bSum, cSum, dSum);
	}

	public Quaternion neg()						// r = -q
	{
		return new Quaternion(-1*a, -1*b, -1*c, -1*d);
	}

	public Quaternion sub(Quaternion other)		// r = q - p
	{
		return add(other.neg());
	}

	// The Hamilton pruduct: r = q hX p
	public Quaternion hX(Quaternion other)
	{
		double aProd, bProd, cProd, dProd;

		aProd = 
			a*other.a - b*other.b - c*other.c - d*other.d;
		bProd =
			a*other.b + b*other.a + c*other.d - d*other.c;
		cProd =
			a*other.c - b*other.d + c*other.a + d*other.b;
		dProd =
			a*other.d + b*other.c - c*other.b + d*other.a;

		return new Quaternion(aProd, bProd, cProd, dProd);
	}

	@Override
	public String toString() 
	{ 
		return "(" + a + ", " + b + ", " + c + ", " + d + ")";
	}
}
