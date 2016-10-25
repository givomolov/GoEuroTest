package com.umut.service.model;

import com.google.gson.annotations.SerializedName;

public class Location {
	@SerializedName("_id")
	private Integer id;
	private Object key;
	private String name;
	private String fullName;
	@SerializedName("iata_airport_code")
	private Object iataAirportCode;
	private String type;
	private String country;
	@SerializedName("geo_position")
	private GeoPosition geoPosition;
	@SerializedName("location_id")
	private Integer locationId;
	private boolean inEurope;
	private String countryCode;
	private Boolean coreCountry;
	private Object distance;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Object getKey() {
		return key;
	}
	public void setKey(Object key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Object getIataAirportCode() {
		return iataAirportCode;
	}
	public void setIataAirportCode(Object iataAirportCode) {
		this.iataAirportCode = iataAirportCode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public GeoPosition getGeoPosition() {
		return geoPosition;
	}
	public void setGeoPosition(GeoPosition geoPosition) {
		this.geoPosition = geoPosition;
	}
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	public boolean getInEurope() {
		return inEurope;
	}
	public void setInEurope(boolean inEurope) {
		this.inEurope = inEurope;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public Boolean getCoreCountry() {
		return coreCountry;
	}
	public void setCoreCountry(Boolean coreCountry) {
		this.coreCountry = coreCountry;
	}
	public Object getDistance() {
		return distance;
	}
	public void setDistance(Object distance) {
		this.distance = distance;
	}

}
