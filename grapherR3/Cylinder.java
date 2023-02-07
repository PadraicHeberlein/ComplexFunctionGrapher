package grapherR3.shapes;

import java.awt.Color;

public class Cylinder implements ShapeR3
{
	public VectorR3 centerOfMass() { return new VectorR3(); }

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
	
	public VectorR3 intersection(LineR3 ray) 
	{ 
		return new VectorR3(); 
	}

	public Color colorAt(VectorR3 onSurface) 
	{ 
		return Color.red;
	}
}
