public interface ShapeR3
{
	public VectorR3 centerOfMass();

	public boolean intersectsWith(LineR3 ray);

	public LineR3 reflect(LineR3 ray);
}
