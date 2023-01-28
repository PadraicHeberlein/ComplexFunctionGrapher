public class VectorR3 extends Quaternion
{
	public static final int X = 0;
	public static final int Y = 1;
	public static final int Z = 2;
	public static final int DIM = 3;

	public VectorR3() { super(0.0, 0.0, 0.0, 0.0); }
	
	public VectorR3(double x, double y, double z)
	{
		super(0.0, x, y, z);
	} 

	public VectorR3(VectorR3 other)
	{
		set(Quaternion.B, other.get(Quaternion.B));
	}
	
	public VectorR3(Quaternion other) { super(other); }
}
