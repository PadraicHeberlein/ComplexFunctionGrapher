package grapherR3.shapes;

import linearAlgebra.VectorR3;

public class Axis extends VectorR3 implements ShapeR3
{
	public Axis() { }

	public VectorR3 centerOfMass()
	{
		return new VectorR3();
	}

	public boolean intersectsWith(VectorR3 ray)
	{
		return false;
	}

	public VectorR3 reflect(VectorR3 ray)
	{
		return new VectorR3();
	}
	
	public VectorR3 normalAt(VectorR3 onSurface)
	{
		return new VectorR3();
	}
	
	public VectorR3 intersection(VectorR3 ray)
	{
		return new VectorR3();
	}
	
	public Color colorAt(VectorR3 onSurface)
	{
		return Color.red;
	}
	
	public ShapeR3 rotateAround(double angle, VectorR3 axis)
	{
		return new Axis();
	}
}
