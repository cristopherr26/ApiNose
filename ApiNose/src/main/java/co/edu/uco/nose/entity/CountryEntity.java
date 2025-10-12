package co.edu.uco.nose.entity;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class CountryEntity{

	private UUID id;
	private String name;


	public CountryEntity() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
	}

	public CountryEntity(final UUID id) {
	setId(id);
		setName(TextHelper.getDefault());
	}

	public CountryEntity(final UUID id, final String name) {
		setId(id);
		setName(name);
	}
	
	static CountryEntity getDefaultValue() {
		return new CountryEntity();
	}
	
	static CountryEntity getDefaultValue(final CountryEntity country) {
		return ObjectHelper.getDefault(country, getDefaultValue());
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
}
