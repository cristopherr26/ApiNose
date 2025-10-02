package co.edu.uco.nose.business.domain;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public class StateDomain extends Domain {
	
	private String name;
	private CountryDomain country;
	
	public StateDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setCountry(CountryDomain.getDefaultValue());
	}
	
	public StateDomain(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
		setCountry(CountryDomain.getDefaultValue());
	}
	
	public StateDomain(final UUID id, final String name, final CountryDomain country) {
		super(id);
		this.name = name;
		this.country = country;
	}
	
	static StateDomain getDefaultValue() {
		return new StateDomain();
	}
	
	static StateDomain getDefaultValue(final StateDomain state) {
		return ObjectHelper.getDefault(getDefaultValue(), state);
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}

	public CountryDomain getCountry() {
		return country;
	}

	public void setCountry(final CountryDomain country) {
		this.country = ObjectHelper.getDefault(CountryDomain.getDefaultValue(), country);
	}

	
	
	
	
	

}
