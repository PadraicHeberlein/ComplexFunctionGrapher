public class VectorR3 extends Quaternion
{
	public static final int X = 0;
	public static final int Y = 1;
	public static final int Z = 2;
	public static final int DIM = 3;

	public VectorR3() { super(); }
	
	public VectorR3(double x, double y, double z) { super(0.0, x, y, z); } 

	public VectorR3(VectorR3 v)
	{
		set(Quaternion.B, v.get(Quaternion.B));
		set(Quaternion.C, v.get(Quaternion.C));
		set(Quaternion.D, v.get(Quaternion.D));
	}
	
	public VectorR3(Quaternion q) 
	{ 
		super(q);
		set(Quaternion.A, 0.0); 
	}

	public double get(int i) { return super.get(i + 1); }

	public void set(int i, double value) { super.set(i + 1, value); }

	public VectorR3 add(VectorR3 v)
	{
		Quaternion q_1 = new Quaternion(this);
		Quaternion q_2 = new Quaternion(v);
	
		return new VectorR3(q_1.add(q_2));
	}
	
  	public VectorR3 neg() { return new VectorR3(-1*get(X), -1*get(Y), -1*get(Z)); }

	public VectorR3 sub(VectorR3 v) { return add(v.neg()); }

	// multiplication by a scalar value
	public VectorR3 x(double s) { return new VectorR3(s*get(X), s*get(Y), s*get(Z)); }
	
	// scalar product
	public double dot(VectorR3 v) 
	{ 
		return get(X)*v.get(X) + get(Y)*v.get(Y) + get(Z)* v.get(Z); 
	}

	public double sX(VectorR3 other) { return dot(other); }

	// cross product / vector product
	public VectorR3 cross(VectorR3 other)
	{
		double newXpart = get(Y)*other.get(Z) - get(Z)*other.get(Y);
		double newYpart = get(Z)*other.get(X) - get(X)*other.get(Z);
		double newZpart = get(X)*other.get(Y) - get(Y)*other.get(X);

		return new VectorR3(newXpart, newYpart, newZpart);
	}

	public VectorR3 vX(VectorR3 other) { return cross(other); }

	@Override
	public String toString()
	{
		return "(" + get(X) + ", " + get(Y) + ", " + get(Z) + ")";
	}
}
