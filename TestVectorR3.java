public class TestVectorR3
{
	public static void main(String[] args)
	{
		Quaternion q = new Quaternion(0.5, 0.5, 0.5, 0.5);
		VectorR3 v = new VectorR3(q);

		System.out.println((VectorR3)v.add(v));
	}
}