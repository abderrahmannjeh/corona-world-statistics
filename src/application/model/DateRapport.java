package application.model;

import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class DateRapport {
	
	private  String continent;
	private TreeMap<Date, Integer> values;
	public DateRapport() {
		super();
	}
	





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
		DateRapport other = (DateRapport) obj;
		return Objects.equals(continent, other.continent);
	}
	@Override
	public String toString() {
		return "DateRapport [continent=" + continent + ", values=" + values + "]";
	}
	
	

}
