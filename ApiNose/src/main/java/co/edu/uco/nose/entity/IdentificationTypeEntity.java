package co.edu.uco.nose.entity;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class IdentificationTypeEntity extends Entity {
	
	private String name;
	
	public IdentificationTypeEntity() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
	}
	
	public IdentificationTypeEntity(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
	}
	

	public IdentificationTypeEntity(final UUID id, final String name) {
		super(id);
		this.name = name;
	}
	
	static IdentificationTypeEntity getDefaultValue() {
		return new IdentificationTypeEntity();
	}
	
	static IdentificationTypeEntity getDefaultValue(final IdentificationTypeEntity identifiactionType) {
		return ObjectHelper.getDefault(identifiactionType, getDefaultValue());
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	
	

}
