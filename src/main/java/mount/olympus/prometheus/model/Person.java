package mount.olympus.prometheus.model;

import java.util.List;

public class Person {

	private long pid;
	private String name;
	private PersonProfile personProfile;
	private List<PersonAddress> addressList;
	
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PersonProfile getPersonProfile() {
		return personProfile;
	}
	public void setPersonProfile(PersonProfile personProfile) {
		this.personProfile = personProfile;
	}
	public List<PersonAddress> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<PersonAddress> addressList) {
		this.addressList = addressList;
	}
	
	
}
