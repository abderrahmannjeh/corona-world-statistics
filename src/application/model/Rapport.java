package application.model;

import java.util.Date;
import java.util.Objects;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Rapport {

	private StringProperty contry;
	private IntegerProperty total;
	private IntegerProperty newCases;
	private IntegerProperty totalDeaths;
	private IntegerProperty newdeath;
	private IntegerProperty population;
	private FloatProperty mortaility;
	private FloatProperty attackRate;
	private StringProperty continent;

	public Rapport(StringProperty contry, IntegerProperty total, IntegerProperty newCases, IntegerProperty totalDeaths,
			IntegerProperty newdeath, IntegerProperty population, FloatProperty mortaility, FloatProperty attackRate) {
		super();
		this.contry = contry;
		this.total = total;
		this.newCases = newCases;
		this.totalDeaths = totalDeaths;
		this.newdeath = newdeath;
		this.population = population;
		this.mortaility = mortaility;
		this.attackRate = attackRate;
	}

	public Rapport() {
		contry = new SimpleStringProperty();
		total = new SimpleIntegerProperty();
		newCases = new SimpleIntegerProperty();

		totalDeaths = new SimpleIntegerProperty();

		newdeath = new SimpleIntegerProperty();

		population = new SimpleIntegerProperty();

		mortaility = new SimpleFloatProperty();
		attackRate = new SimpleFloatProperty();

		continent = new SimpleStringProperty();

	}

	public final StringProperty contryProperty() {
		return this.contry;
	}

	public final String getContry() {
		return this.contryProperty().get();
	}

	public final void setContry(final String contry) {
		this.contryProperty().set(contry);
	}

	public final IntegerProperty totalProperty() {
		return this.total;
	}

	public final int getTotal() {
		return this.totalProperty().get();
	}

	public final void setTotal(final int total) {
		this.totalProperty().set(total);
	}

	public final IntegerProperty newCasesProperty() {
		return this.newCases;
	}

	public final int getNewCases() {
		return this.newCasesProperty().get();
	}

	public final void setNewCases(final int newCases) {
		this.newCasesProperty().set(newCases);
	}

	public final IntegerProperty totalDeathsProperty() {
		return this.totalDeaths;
	}

	public final int getTotalDeaths() {
		return this.totalDeathsProperty().get();
	}

	public final void setTotalDeaths(final int totalDeaths) {
		this.totalDeathsProperty().set(totalDeaths);
	}

	public final IntegerProperty newdeathProperty() {
		return this.newdeath;
	}

	public final int getNewdeath() {
		return this.newdeathProperty().get();
	}

	public final void setNewdeath(final int newdeath) {
		this.newdeathProperty().set(newdeath);
	}

	public final IntegerProperty populationProperty() {
		return this.population;
	}

	public final int getPopulation() {
		return this.populationProperty().get();
	}

	public final void setPopulation(final int population) {
		this.populationProperty().set(population);
	}

	public final FloatProperty mortailityProperty() {
		return this.mortaility;
	}

	public final float getMortaility() {
		return this.mortailityProperty().get();
	}

	public final void setMortaility(final float mortaility) {
		this.mortailityProperty().set(mortaility);
	}

	public final FloatProperty attackRateProperty() {
		return this.attackRate;
	}

	public final float getAttackRate() {
		return this.attackRateProperty().get();
	}

	public final void setAttackRate(final float attackRate) {
		this.attackRateProperty().set(attackRate);
	}




	@Override
	public int hashCode() {
		return Objects.hash(contry.get());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rapport other = (Rapport) obj;
		return Objects.equals(contry.get(), other.contry.get());
	}

	public final StringProperty continentProperty() {
		return this.continent;
	}

	public final String getContinent() {
		return this.continentProperty().get();
	}

	public final void setContinent(final String continent) {
		this.continentProperty().set(continent);
	}

}
