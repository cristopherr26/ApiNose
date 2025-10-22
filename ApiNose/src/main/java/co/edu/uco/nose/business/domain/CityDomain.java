package co.edu.uco.nose.business.domain;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class CityDomain extends Domain{
	
	private String name;
	private StateDomain state;
	
	 CityDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setState(StateDomain.getDefaultValue());
	}
	
	public CityDomain(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
		setState(StateDomain.getDefaultValue());
	}
	
	public CityDomain(final UUID id, final String name, final StateDomain state) {
		super(id);
		setName(name);
		setState(state);
	}
	
	static CityDomain getDefaultValue() {
		return new CityDomain();
	}
	
	static CityDomain getDefaultValue(final CityDomain city) {
		return ObjectHelper.getDefault(city, getDefaultValue());
	}

	public String getName() {
		return name;
	}
	
	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	
	public StateDomain getState() {
		return state;
	}
	
	public void setState(final StateDomain state) {
		this.state = ObjectHelper.getDefault(state, StateDomain.getDefaultValue());
	}
	

}
