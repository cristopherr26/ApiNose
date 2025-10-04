package co.edu.uco.nose.business.domain;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class IdentificationTypeDomain extends Domain {
	
	private String name;
	
	public IdentificationTypeDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setName(TextHelper.getDefault());
	}
	
	public IdentificationTypeDomain(final UUID id) {
		super(id);
		setName(TextHelper.getDefault());
	}
	

	public IdentificationTypeDomain(final UUID id, final String name) {
		super(id);
		this.name = name;
	}
	
	static IdentificationTypeDomain getDefaultValue() {
		return new IdentificationTypeDomain();
	}
	
	static IdentificationTypeDomain getDefaultValue(final IdentificationTypeDomain identifiactionType) {
		return ObjectHelper.getDefault(identifiactionType, getDefaultValue());
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = TextHelper.getDefaultWithTrim(name);
	}
	
	

}
