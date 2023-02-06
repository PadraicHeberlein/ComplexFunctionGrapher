import java.awt.Color;

public interface ShapeR3
{
	public VectorR3 centerOfMass();

	public boolean intersectsWith(LineR3 ray);

	public LineR3 reflect(LineR3 ray);

	public VectorR3 normalAt(VectorR3 onSurface);

	public VectorR3 intersection(LineR3 ray);

	public Color colorAt(VectorR3 onSurface);
}
