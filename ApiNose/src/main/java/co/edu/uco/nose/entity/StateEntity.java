package co.edu.uco.nose.entity;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class StateEntity extends Entity {
	
	private String name;
	private CountryEntity country;
	
	public StateEntity() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setCountry(CountryEntity.getDefaultValue());
	}
	
	public StateEntity(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
		setCountry(CountryEntity.getDefaultValue());
	}
	
	public StateEntity(final UUID id, final String name, final CountryEntity country) {
		super(id);
		this.name = name;
		this.country = country;
	}
	
	static StateEntity getDefaultValue() {
		return new StateEntity();
	}
	
	static StateEntity getDefaultValue(final StateEntity state) {
		return ObjectHelper.getDefault(state, getDefaultValue());
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}

	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(final CountryEntity country) {
		this.country = ObjectHelper.getDefault(country, CountryEntity.getDefaultValue());
	}

	
	
	
	
	

}
