package co.edu.uco.nose.business.domain;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public class CityDomain extends Domain{
	
	private String name;
	private UUID stateId;
	
	public CityDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setStateId(UUIDHelper.getUUIDHelper().getDefault());
	}
	
	public CityDomain(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
		setStateId(UUIDHelper.getUUIDHelper().getDefault());
	}
	
	public CityDomain(final UUID id, final String name, final UUID stateId) {
		super(id);
		this.name = name;
		this.stateId = stateId;
	}

	public String getName() {
		return name;
	}
	
	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	
	public UUID getStateId() {
		return stateId;
	}
	
	public void setStateId(final UUID stateId) {
		this.stateId = UUIDHelper.getUUIDHelper().getDefault(stateId);
	}
	

}
