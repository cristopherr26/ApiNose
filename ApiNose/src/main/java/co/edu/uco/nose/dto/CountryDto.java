package co.edu.uco.nose.dto;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class CountryDto extends Dto {

	private String name;


	public CountryDto() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
	}

	public CountryDto(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
	}

	public CountryDto(final UUID id, final String name) {
		super(id);
		setName(name);
	}
	
	static CountryDto getDefaultValue() {
		return new CountryDto();
	}
	
	static CountryDto getDefaultValue(final CountryDto country) {
		return ObjectHelper.getDefault(country, getDefaultValue());
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
}
