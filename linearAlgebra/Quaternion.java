package linearAlgebra;

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

	public Quaternion(double w, double i, double j, double k)
	{
		a = w;
		b = i;
		c = j;
		d = k;
	}

	public Quaternion(Quaternion q)
	{
		a = q.a;
		b = q.b;
		c = q.c;
		d = q.d;
	}

	public Quaternion(VectorR3 v)
	{
		a = 0.0;
		b = v.get(VectorR3.X);
		c = v.get(VectorR3.Y);
		d = v.get(VectorR3.Z);
	}

	// r = q + p= (q.a+p.a, q.b+p.b, q.c+p.c, q.d+p.d)
	public Quaternion add(Quaternion q)
	{
		double aSum = a + q.a;
		double bSum = b + q.b;
		double cSum = c + q.c;
		double dSum = d + q.d;

		return new Quaternion(aSum, bSum, cSum, dSum);
	}

	public Quaternion neg()						// r = -q
	{
		return new Quaternion(-1*a, -1*b, -1*c, -1*d);
	}

	public Quaternion sub(Quaternion q) { return add(q.neg()); }

	// Scalar product r = s sX q
	public Quaternion x(double s)
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
		return conj().x(1/(norm()*norm()));
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

	public static Quaternion exp(Quaternion q)
	{
		Quaternion expQ = new Quaternion();
		Quaternion v = new Quaternion(q);

		v.set(Quaternion.A, 0.0);

		double normV = v.norm();
		double cosV = Math.cos(normV);
		double sinV = Math.sin(normV);

		expQ.set(Quaternion.A, cosV);
		expQ = expQ.add(v.x(sinV / normV));		
	
		double a = q.get(Quaternion.A);

		return expQ.x(Math.exp(a));
	}

	public static Quaternion ln(Quaternion q)
	{
		Quaternion lnQ = new Quaternion();
		Quaternion v = new Quaternion(q);

		v.set(Quaternion.A, 0.0);

		double normV = v.norm();
		double a = q.get(Quaternion.A);
		double normQ = q.norm();
		double acosV = Math.acos(a / normQ);

		lnQ.set(Quaternion.A, Math.log(normQ));
		lnQ = lnQ.add(v.x(acosV / normV));

		return lnQ;
	}	

	public double scalarPart() { return a; }

	public VectorR3 vectorPart() { return new VectorR3(b, c, d); }
	
	public Quaternion rotate(double angle, VectorR3 axis)
	{
		Quaternion rotationQ = new Quaternion();

		rotationQ.a = Math.cos(angle/2);

		rotationQ = rotationQ.add(new Quaternion(
			axis.x(Math.sin(angle/2))
		));
		
		return rotationQ.hX(this.hX(rotationQ.inv()));
	}		

	@Override
	public String toString() 
	{ 
		return "(" + a + ", " + b + ", " + c + ", " + d + ")";
	}
}
