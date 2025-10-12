package co.edu.uco.nose.entity;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class CityEntity {
	
	private UUID id;
	private String name;
	private StateEntity state;
	
	public CityEntity() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setState(StateEntity.getDefaultValue());
	}
	
	public CityEntity(final UUID id) {
		setId(id);
		setName(TextHelper.getDefault());
		setState(StateEntity.getDefaultValue());
	}
	
	public CityEntity(final UUID id, final String name, final StateEntity state) {
		setId(id);
		this.name = name;
		this.state = state;
	}
	
	static CityEntity getDefaultValue() {
		return new CityEntity();
	}
	
	static CityEntity getDefaultValue(final CityEntity city) {
		return ObjectHelper.getDefault(city, getDefaultValue());
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

	public StateEntity getState() {
		return state;
	}
	
	public void setState(final StateEntity state) {
		this.state = ObjectHelper.getDefault(state, StateEntity.getDefaultValue());
	}
	

}
