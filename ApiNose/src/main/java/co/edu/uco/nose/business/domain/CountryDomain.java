package co.edu.uco.nose.business.domain;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class CountryDomain extends Domain {

	private String name;


	public CountryDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
	}

	public CountryDomain(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
	}

	public CountryDomain(final UUID id, final String name) {
		super(id);
		setName(name);
	}
	
	static CountryDomain getDefaultValue() {
		return new CountryDomain();
	}
	
	static CountryDomain getDefaultValue(final CountryDomain country) {
		return ObjectHelper.getDefault(country, getDefaultValue());
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
}
