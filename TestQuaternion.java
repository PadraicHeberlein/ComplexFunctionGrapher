public class TestQuaternion
{
	public static void main(String[] args)
	{
		Quaternion q = new Quaternion(1,2,3,4);

		System.out.println("q = " + q);
		System.out.println("exp(q) = " + Quaternion.exp(q));		
	}
}
