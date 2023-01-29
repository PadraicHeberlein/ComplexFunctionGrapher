import java.lang.Math;

public class Quaternion
{
	public static final int A = 0;
	public static final int B = 1;
	public static final int C = 2;
	public static final int D = 3;
	
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

	// Scalar product r = s sX q
	public Quaternion sX(double s)
	{
		return new Quaternion(s*a, s*b, s*c, s*d);
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

	// r = q^(-1) = q* / ||q||^2
	public Quaternion inv()
	{
		return conj().sX(1/(norm()*norm()));
	}

	public double get(int part)
	{
		double result = 0.0;

		switch (part)
		{
			case A:
				result = a;
				break;
			case B:
				result = b;
				break;
			case C:
				result = c;
				break;
			case D:
				result = d;
				break;				
		}

		return result;
	}

	public void set(int part, double value)
	{
		switch (part)
		{
			case A:
				a = value;
				break;
			case B:
				b = value;
				break;
			case C:
				c = value;
				break;
			case D:
				d = value;
				break;
		}
	}

	public Quaternion conj() 		// r = q* = (a, -b, -c, -d)
	{ 
		return new Quaternion(a, -1*b, -1*c, -1*d);
	}

	public double norm() 
	{ 
		return Math.sqrt(a*a + b*b + c*c + d*d); 
	}	

	public double scalarPart() { return a; }

	public VectorR3 vectorPart() { return new VectorR3(b, c, d); }

	

	@Override
	public String toString() 
	{ 
		return "(" + a + ", " + b + ", " + c + ", " + d + ")";
	}
}
