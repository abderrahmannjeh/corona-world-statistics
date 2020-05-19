package application.model;

import java.util.Date;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Record {

	private Date ddateRep;
	private Integer day;
	private Integer month;
	private Integer year;
	private Integer cases;
	private Integer deaths;
	private String countriesAndTerritories;
	private String geoId;
	private String countryterritoryCode;
	private Integer popData2018;
	private String continentExp;
	public Date getDdateRep() {
		return ddateRep;
	}
	public void setDdateRep(Date ddateRep) {
		this.ddateRep = ddateRep;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public Integer getMonth() {
		return month;
	}
	public void setMonth(Integer month) {
		this.month = month;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getCases() {
		return cases;
	}
	public void setCases(Integer cases) {
		this.cases = cases;
	}
	public Integer getDeaths() {
		return deaths;
	}
	public void setDeaths(Integer deaths) {
		this.deaths = deaths;
	}
	public String getCountriesAndTerritories() {
		return countriesAndTerritories;
	}
	public void setCountriesAndTerritories(String countriesAndTerritories) {
		this.countriesAndTerritories = countriesAndTerritories;
	}
	public String getGeoId() {
		return geoId;
	}
	public void setGeoId(String geoId) {
		this.geoId = geoId;
	}
	public String getCountryterritoryCode() {
		return countryterritoryCode;
	}
	public void setCountryterritoryCode(String countryterritoryCode) {
		this.countryterritoryCode = countryterritoryCode;
	}
	public Integer getPopData2018() {
		return popData2018;
	}
	public void setPopData2018(Integer popData2018) {
		this.popData2018 = popData2018;
	}
	public String getContinentExp() {
		return continentExp;
	}
	public void setContinentExp(String continentExp) {
		this.continentExp = continentExp;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryterritoryCode == null) ? 0 : countryterritoryCode.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record other = (Record) obj;
		if (countryterritoryCode == null) {
			if (other.countryterritoryCode != null)
				return false;
		} else if (!countryterritoryCode.equals(other.countryterritoryCode))
			return false;
		return true;
	}
	





}
