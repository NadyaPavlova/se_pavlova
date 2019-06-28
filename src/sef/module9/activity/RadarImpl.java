package sef.module9.activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implementation of a Radar 
 * 
 *
 */
public class RadarImpl implements Radar{


	private List <RadarContact> RadarContacts= new ArrayList<>();

	/**
	 *  Constructs a new Radar 
	 */
	public RadarImpl(){
	}
	
	
	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#addContact(sef.module8.activity.RadarContact)
	 */
	public RadarContact addContact(RadarContact contact) {
		for(int i=0; i<RadarContacts.size(); i++) {
			if (contact.getContactID().equals(RadarContacts.get(i).getContactID())) {
				RadarContacts.remove(i);
				RadarContacts.set(i, contact);
				return contact;
			}
		}
		RadarContacts.add(contact);
		return contact;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#getContact(java.lang.String)
	 */
	public RadarContact getContact(String id) {
		for(int i=0; i<RadarContacts.size(); i++) {
			if (id.equals(RadarContacts.get(i).getContactID()))
				return RadarContacts.get(i);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#getContactCount()
	 */
	public int getContactCount() {
		
		return RadarContacts.size();
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#removeContact(java.lang.String)
	 */
	public RadarContact removeContact(String id) {
		for(int i=0; i<RadarContacts.size(); i++) {
			if (id == RadarContacts.get(i).getContactID()) {
				RadarContact str = RadarContacts.get(i);
				RadarContacts.remove(RadarContacts.get(i));
				return str;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#returnContacts()
	 */
	public List<RadarContact> returnContacts() {
		List  <RadarContact> newArrayList = new ArrayList<RadarContact>(RadarContacts);
		return newArrayList;
	}

	/* (non-Javadoc)
	 * @see sef.module8.activity.Radar#returnContacts(java.util.Comparator)
	 */
	public List<RadarContact> returnContacts(Comparator<RadarContact> comparator) {
		List  <RadarContact> newArrayList = new ArrayList<RadarContact>(RadarContacts);
		Collections.sort(newArrayList, comparator);
		return newArrayList;
	}
	
}
