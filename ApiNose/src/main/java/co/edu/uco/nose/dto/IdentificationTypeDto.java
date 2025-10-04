package co.edu.uco.nose.dto;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class IdentificationTypeDto extends Dto {
	
	private String name;
	
	public IdentificationTypeDto() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
	}
	
	public IdentificationTypeDto(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
	}
	

	public IdentificationTypeDto(final UUID id, final String name) {
		super(id);
		this.name = name;
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
	
	

}
