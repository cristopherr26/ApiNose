package co.edu.uco.nose.business.domain;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public class StateDomain extends Domain {
	
	private String name;
	private UUID countryId;
	
	public StateDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setCountryId(UUIDHelper.getUUIDHelper().getDefault());
	}
	
	public StateDomain(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
		setCountryId(UUIDHelper.getUUIDHelper().getDefault());
	}
	
	public StateDomain(final UUID id, final String name, final UUID countryId) {
		super(id);
		this.name = name;
		this.countryId = countryId;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}

	public UUID getCountryId() {
		return countryId;
	}

	public void setCountryId(final UUID countryId) {
		this.countryId = UUIDHelper.getUUIDHelper().getDefault(countryId);
	}

	
	
	
	
	

}
