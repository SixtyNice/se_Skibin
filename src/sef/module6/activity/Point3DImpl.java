package sef.module6.activity;

/**
 * @author John Doe
 * <p>
 * This class represents a point in 3D space.  The coordinates are represented by
 * a set of values x, y an z that represents the coordinates along each plane
 */
public class Point3DImpl extends Point2DImpl implements Point3D {

    private double x;
    private double y;
    private double z;

    /**
     * Creates a Point3D object with the default coordinate of 0,0,0
     */
    public Point3DImpl() {
        super();
        z = 0;
    }

    /**
     * Creates a Point3D object at the specified coordinates
     *
     * @param x coordinate along the x axis
     * @param y coordinate along the y axis
     * @param z coordinate along the z axis
     */
    public Point3DImpl(double x, double y, double z) {

        super(x, y);
        this.z = z;

    }


    /* (non-Javadoc)
     * @see sef.module5.activity.Point3D#setZ(double)
     */
    public final void setZ(double z) {

        this.z = z;

    }


    /* (non-Javadoc)
     * @see sef.module5.activity.Point3D#getZ()
     */
    public final double getZ() {

        return z;

    }


    /* (non-Javadoc)
     * @see sef.module5.activity.Point3D#move(double, double, double)
     */
    public void move(double x2, double y2, double z2) {
        super.move(x2, y2);
        this.z = z2;

    }


    /* (non-Javadoc)
     * @see sef.module5.activity.Point3D#translate(double, double, double)
     */
    public void translate(double x2, double y2, double z2) {
        super.translate(x2, y2);
        z += z2;
    }


    /* (non-Javadoc)
     * @see sef.module5.activity.Point3D#equals(double, double, double)
     */
    @Override
    public boolean equals(double x2, double y2, double z2) {

        return super.equals(x2, y2) && this.z == z2;
    }


    /**
     * Compares if the coordinates are equal to the coordinates specified by the parameter
     *
     * @param p the coordinates to compare
     * @return true if the parameter is an instance of Point3D and contain the same coordinates, false otherwise
     */
    public boolean equals(Object p) {

        Point3DImpl point = (Point3DImpl) p;
        return super.equals(p) && this.z == point.getZ();

    }


    /* (non-Javadoc)
     * @see sef.module5.activity.Point3D#getDistance(sef.module5.activity.Point3D)
     */
    public double getDistance(Point3D p) {
        return super.getDistance(p) + Math.sqrt(Math.pow(p.getZ() - z, 2));

    }


    /* (non-Javadoc)
     * @see sef.module5.activity.Point3D#getDistance(double, double, double)
     */
    public double getDistance(double x2, double y2, double z2) {

        return super.getDistance(x2, y2) + Math.sqrt(Math.pow(z2 - z, 2));


    }


}
