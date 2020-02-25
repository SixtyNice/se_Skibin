package sef.module9.activity;

/**
 * Implementation of a RadarContact
 *
 * @author John Doe
 */
public class RadarContactImpl implements RadarContact {


    private String contactID;
    private double bearing;
    private double distance;

    /**
     * Creates a RadarContact with the specified ID, bearing and distance.
     *
     * @param contactID the contact's ID
     * @param bearing   the contact's bearing
     * @param distance  the contact's distance
     */
    public RadarContactImpl(String contactID, double bearing, double distance) {
        this.contactID = contactID;
        if (bearing > 359.99 || bearing < 0) {
            this.bearing = bearingCalc(bearing);
            if (this.bearing < 0) {
                this.bearing += 360;
            }
        } else {
            this.bearing = bearing;
        }
        if (distance < 0) {
            this.distance = 0;
        } else {
            this.distance = distance;
        }

    }

    public static double roundAvoid(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    private static double bearingCalc(double bearing) {
        return roundAvoid((bearing - 360 * Math.round(bearing / 360)), 1);
    }

    /* (non-Javadoc)
     * @see sef.module8.activity.RadarContact#getBearing()
     */
    public final double getBearing() {

        return bearing;
    }


    /* (non-Javadoc)
     * @see sef.module8.activity.RadarContact#setBearing(double)
     */
    public final void setBearing(double bearing) {

        if (bearing > 359.99 || bearing < 0) {
            this.bearing = bearingCalc(bearing);
            if (this.bearing < 0) {
                this.bearing += 360;
            }
        } else {
            this.bearing = bearing;
        }
    }

    /* (non-Javadoc)
     * @see sef.module8.activity.RadarContact#getDistance()
     */
    public final double getDistance() {

        return distance;
    }

    /* (non-Javadoc)
     * @see sef.module8.activity.RadarContact#setDistance(double)
     */
    public final void setDistance(double distance) {
        if (distance < 0) {
            this.distance = 0;
        } else {
            this.distance = distance;
        }
    }

    /* (non-Javadoc)
     * @see sef.module8.activity.RadarContact#getContactID()
     */
    public final String getContactID() {

        return contactID;
    }

    /* (non-Javadoc)
     * @see sef.module8.activity.RadarContact#setContactID(java.lang.String)
     */
    public final void setContactID(String contactID) {
        this.contactID = contactID;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "ContactID: " + contactID + " Bearing: " + bearing + " Distance: " + distance;
    }
}
