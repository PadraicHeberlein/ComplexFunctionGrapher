public class VectorR3 extends Quaternion
{
	public static final int X = 0;
	public static final int Y = 1;
	public static final int Z = 2;
	public static final int DIM = 3;

	public VectorR3() { super(); }
	
	public VectorR3(double x, double y, double z) { super(0.0, x, y, z); } 

	public VectorR3(VectorR3 other)
	{
		set(Quaternion.B, other.get(Quaternion.B));
		set(Quaternion.C, other.get(Quaternion.C));
		set(Quaternion.D, other.get(Quaternion.D));
	}
	
	public VectorR3(Quaternion other) 
	{ 
		super(other);
		set(Quaternion.A, 0.0); 
	}

	public double get(int i) { return super.get(i + 1); }

	public VectorR3 add(VectorR3 other)
	{
		Quaternion q_1 = new Quaternion(this);
		Quaternion q_2 = new Quaternion(other);
	
		return new VectorR3(q_1.add(q_2));
	}
	
	

	@Override
	public String toString()
	{
		double x = get(X);
		double y = get(Y);
		double z = get(Z);

		return "(" + x + ", " + y + ", " + z + ")";
	}
}
