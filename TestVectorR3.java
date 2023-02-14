import linearAlgebra.Quaternion;
import linearAlgebra.VectorR3;

public class TestVectorR3
{
	public static void main(String[] args)
	{
		Quaternion q = new Quaternion(1.1, 1.2, 1.3, 1.4);
		System.out.println("q = new Quaternion(1.1, 1.2, 1.3, 1.4)");
		VectorR3 v = new VectorR3(q);
		System.out.println("v = new VectorR3(q)");

		System.out.println("v.add(v) = " + v.add(v));
		System.out.println("v.get(X) = " + v.get(VectorR3.X));
	}
}
