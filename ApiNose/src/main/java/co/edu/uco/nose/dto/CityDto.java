package co.edu.uco.nose.dto;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class CityDto {
	
	private UUID id;
	private String name;
	private StateDto state;
	
	public CityDto() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
		setState(StateDto.getDefaultValue());
	}
	
	public CityDto(final UUID id) {
		setId(id);
		setName(TextHelper.getDefault());
		setState(StateDto.getDefaultValue());
	}
	
	public CityDto(final UUID id, final String name, final StateDto state) {
		setId(id);
		setName(name);
		setState(state);
	}
	
	static CityDto getDefaultValue() {
		return new CityDto();
	}
	
	static CityDto getDefaultValue(final CityDto city) {
		return ObjectHelper.getDefault(city, getDefaultValue());
	}

	public String getName() {
		return name;
	}
	
	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	
	public StateDto getState() {
		return state;
	}
	
	public void setState(final StateDto state) {
		this.state = ObjectHelper.getDefault(state, StateDto.getDefaultValue());
	}

	public UUID getId() {
		return id;
	}

	public void setId(final UUID id) {
		this.id = UUIDHelper.getUUIDHelper().getDefault(id);
	}
	

}
