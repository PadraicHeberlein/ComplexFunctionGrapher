package grapherR3.shapes;

import java.awt.Color;
import linearAlgebra.VectorR3;

public interface ShapeR3
{
	public VectorR3 centerOfMass();

	public boolean intersectsWith(VectorR3 ray);

	public VectorR3 reflect(VectorR3 ray);

	public VectorR3 normalAt(VectorR3 onSurface);

	public VectorR3 intersection(VectorR3 ray);

	public Color colorAt(VectorR3 onSurface);

	public ShapeR3 rotatateAround(double angle, VectorR3 axis); 
}
