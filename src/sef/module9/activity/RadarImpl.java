package sef.module9.activity;

import java.util.*;

/**
 * Implementation of a Radar
 */
public class RadarImpl implements Radar {

    Map<String, RadarContact> radar = new TreeMap<>();

    /**
     * Constructs a new Radar
     */
    public RadarImpl() {

    }


    /* (non-Javadoc)
     * @see sef.module8.activity.Radar#addContact(sef.module8.activity.RadarContact)
     */
    public RadarContact addContact(RadarContact contact) {

        if (contact.equals(null)) {
            throw new IllegalArgumentException("Null is not adding");
        }

        radar.put(contact.getContactID(), contact);
        return contact;
    }

    /* (non-Javadoc)
     * @see sef.module8.activity.Radar#getContact(java.lang.String)
     */
    public RadarContact getContact(String id) {
        return radar.get(id);
    }

    /* (non-Javadoc)
     * @see sef.module8.activity.Radar#getContactCount()
     */
    public int getContactCount() {

        return radar.size();
    }

    /* (non-Javadoc)
     * @see sef.module8.activity.Radar#removeContact(java.lang.String)
     */
    public RadarContact removeContact(String id) {

        RadarContact removeRadarElement = radar.get(id);

        radar.remove(id);

        return removeRadarElement;
    }

    /* (non-Javadoc)
     * @see sef.module8.activity.Radar#returnContacts()
     */
    public List<RadarContact> returnContacts() {

        List<RadarContact> radarList = new ArrayList<>();

        for (RadarContact item : radar.values()) {
            radarList.add(item);
        }
        return radarList;

    }

    /* (non-Javadoc)
     * @see sef.module8.activity.Radar#returnContacts(java.util.Comparator)
     */
    public List<RadarContact> returnContacts(Comparator<RadarContact> comparator) {

        List<RadarContact> radarSortedList = returnContacts();
        radarSortedList.sort(comparator);
        return radarSortedList;

    }


}
