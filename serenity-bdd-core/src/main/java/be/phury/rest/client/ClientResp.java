package be.phury.rest.client;

import org.apache.commons.lang3.StringUtils;

public class ClientResp {

	private String firstname;
	private String lastname;
	private AddressResp address;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public AddressResp getAddress() {
		return address;
	}
	public void setAddress(AddressResp address) {
		this.address = address;
	}
	public String getAddressFull() {
		return StringUtils.join(new String[] {
				address.getStreetNumber()+" "+address.getStreetName(),
				address.getPostalCode(),
				address.getCity(),
				address.getProvince(),
				address.getCountry()}, ", ");
	}

	public static class AddressResp {
		
		private Integer streetNumber;
		private String streetName;
		private String postalCode;
		private String city;
		private String province;
		private String country;
		
		public Integer getStreetNumber() {
			return streetNumber;
		}
		public void setStreetNumber(Integer streetNumber) {
			this.streetNumber = streetNumber;
		}
		public String getStreetName() {
			return streetName;
		}
		public void setStreetName(String streetName) {
			this.streetName = streetName;
		}
		public String getPostalCode() {
			return postalCode;
		}
		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getProvince() {
			return province;
		}
		public void setProvince(String province) {
			this.province = province;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
	}
}
