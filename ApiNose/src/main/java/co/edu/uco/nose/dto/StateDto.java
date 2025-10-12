package co.edu.uco.nose.dto;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class StateDto {
	
	private UUID id;
	private String name;
	private CountryDto country;
	
	public StateDto() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setCountry(CountryDto.getDefaultValue());
	}
	
	public StateDto(final UUID id) {
		setId(id);
		setName(TextHelper.getDefault());
		setCountry(CountryDto.getDefaultValue());
	}
	
	public StateDto(final UUID id, final String name, final CountryDto country) {
		setId(id);
		setName(name);
		setCountry(country);
	}
	
	static StateDto getDefaultValue() {
		return new StateDto();
	}
	
	static StateDto getDefaultValue(final StateDto state) {
		return ObjectHelper.getDefault(state, getDefaultValue());
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}

	public CountryDto getCountry() {
		return country;
	}

	public void setCountry(final CountryDto country) {
		this.country = ObjectHelper.getDefault(country, CountryDto.getDefaultValue());
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}

	
}
