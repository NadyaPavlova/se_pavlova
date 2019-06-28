package sef.module6.activity;

/**
 * @author  John Doe
 * 
 * This class represents a point in 3D space.  The coordinates are represented by
 * a set of values x, y an z that represents the coordinates along each plane
 */
public class Point3DImpl extends Point2DImpl implements Point3D{
	
	@SuppressWarnings("unused")
	private double z;
	
	/**
	 * Creates a Point3D object with the default coordinate of 0,0,0 
	 *
	 */
	public Point3DImpl(){
		this.setX(0);
		this.setY(0);
		z = 0;
	}
	
	/**
	 * Creates a Point3D object at the specified coordinates
	 * 
	 * @param x coordinate along the x axis
	 * @param y coordinate along the y axis
	 * @param z coordinate along the z axis
	 */
	public Point3DImpl(double x, double y, double z){
		this.setX(x);
		this.setY(y);
		this.z = z;
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#setZ(double)
	 */
	public final void setZ(double z){
		this.z=z;
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#getZ()
	 */
	public final double getZ(){

		return z;
	}
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#move(double, double, double)
	 */
	public void move(double x2, double y2, double z2){
		this.setX(x2);
		this.setY(y2);
		this.z = z2;
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#translate(double, double, double)
	 */
	public void translate(double x2, double y2, double z2){
		this.setX(this.getX()+x2);
		this.setY(this.getY()+y2);
		this.z +=z2;
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#equals(double, double, double)
	 */
	public boolean equals(double x2, double y2, double z2){
		if((x2==this.getX())&&(y2==this.getY())&&(z2==z)){
			return true;
		}else
			return false;
	}
	
	
	/**
	 * Compares if the coordinates are equal to the coordinates specified by the parameter
	 * 
	 * @param p the coordinates to compare
	 * 
	 * @return true if the parameter is an instance of Point3D and contain the same coordinates, false otherwise
	 */
	public boolean equals(Object p){
		if((((Point3DImpl) p).getX()==this.getX())&&(((Point3DImpl) p).getY()==this.getY())&&(((Point3DImpl) p).z==z)){
			return true;
		}else
			return false;
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#getDistance(sef.module5.activity.Point3D)
	 */
	public double getDistance(Point3D p){
		double dist;
		dist=Math.sqrt(Math.pow(((Point3DImpl) p).getX() - this.getX(), 2)+Math.pow(((Point3DImpl) p).getY() - this.getY(), 2)+Math.pow(((Point3DImpl) p).z-z, 2));
		return dist;
	}
	

	/* (non-Javadoc)
	 * @see sef.module5.activity.Point3D#getDistance(double, double, double)
	 */
	public double getDistance(double x2, double y2, double z2){
		double dist;
		dist=Math.sqrt(Math.pow((x2 -this.getX()), 2)+Math.pow((y2-this.getY()), 2)+Math.pow((z2-z), 2));
		return dist;
	
	}
	

}
