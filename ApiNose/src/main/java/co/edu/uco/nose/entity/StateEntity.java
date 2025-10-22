package co.edu.uco.nose.entity;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class StateEntity {
	
	private UUID id;
	private String name;
	private CountryEntity country;
	
	public StateEntity() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setCountry(CountryEntity.getDefaultValue());
	}
	
	public StateEntity(final UUID id) {
		setId(id);
		setName(TextHelper.getDefault());
		setCountry(CountryEntity.getDefaultValue());
	}
	
	public StateEntity(final UUID id, final String name, final CountryEntity country) {
		setId(id);
		setName(name);
		setCountry(country);
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

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}

	public CountryEntity getCountry() {
		return country;
	}

	public void setCountry(final CountryEntity country) {
		this.country = ObjectHelper.getDefault(country, CountryEntity.getDefaultValue());
	}

	
	
	
	
	

}
