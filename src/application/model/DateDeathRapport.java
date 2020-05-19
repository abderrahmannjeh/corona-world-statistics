package application.model;

import java.util.Date;
import java.util.Objects;
import java.util.TreeMap;

public class DateDeathRapport {

	private  String continent;
	private TreeMap<Date, Integer> values;
	
	







	public String getContinent() {
		return continent;
	}


	public void setContinent(String continent) {
		this.continent = continent;
	}


	public TreeMap<Date, Integer> getValues() {
		return values;
	}


	public void setValues(TreeMap<Date, Integer> values) {
		this.values = values;
	}


	@Override
	public int hashCode() {
		return Objects.hash(continent);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DateDeathRapport other = (DateDeathRapport) obj;
		return Objects.equals(continent, other.continent);
	}


	@Override
	public String toString() {
		return "DateRapport [continent=" + continent + ", values=" + values + "]";
	}
	
	
}
