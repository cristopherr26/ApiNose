package co.edu.uco.nose.dto;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class IdentificationTypeDto {
	
	private UUID id;
	private String name;
	
	public IdentificationTypeDto() {
		setId(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
	}
	
	public IdentificationTypeDto(final UUID id) {
		setId(id);
		setName(TextHelper.getDefault());
	}
	

	public IdentificationTypeDto(final UUID id, final String name) {
		setId(id);
		setName(name);
	}
	
	static IdentificationTypeDto getDefaultValue() {
		return new IdentificationTypeDto();
	}
	
	static IdentificationTypeDto getDefaultValue(final IdentificationTypeDto identifiactionType) {
		return ObjectHelper.getDefault(identifiactionType, getDefaultValue());
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
