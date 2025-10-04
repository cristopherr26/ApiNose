package co.edu.uco.nose.entity;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.BooleanHelper;
import co.edu.uco.nose.crosscuting.helper.ObjectHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public final class UserEntity extends Entity {
	 
	private IdentificationTypeEntity identificationType;
	private String identificationNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private String secondLastName;
	private CityEntity residenceCity;
	private String email;
	private String cellPhoneNumber;
	private boolean emailConfirmed;
	private boolean cellPhoneNumberConfirmed;
	
	public UserEntity() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setIdentificationType(IdentificationTypeEntity.getDefaultValue());
		setIdentificationNumber(TextHelper.getDefault());;
		setFirstName(TextHelper.getDefault());
		setMiddleName(TextHelper.getDefault());
		setLastName(TextHelper.getDefault());
		setSecondLastName(TextHelper.getDefault());
		setResidenceCity(CityEntity.getDefaultValue());
		setEmail(TextHelper.getDefault());
		setCellPhoneNumber(TextHelper.getDefault());
		setCellPhoneNumberConfirmed(BooleanHelper.getDefault());
		setEmailConfirmed(BooleanHelper.getDefault());
	}
	
	public UserEntity(final UUID id) {
		super(id);
		setIdentificationType(IdentificationTypeEntity.getDefaultValue());
		setIdentificationNumber(TextHelper.getDefault());
		setFirstName(TextHelper.getDefault());
		setMiddleName(TextHelper.getDefault());
		setLastName(TextHelper.getDefault());
		setSecondLastName(TextHelper.getDefault());
		setResidenceCity(CityEntity.getDefaultValue());
		setEmail(TextHelper.getDefault());
		setCellPhoneNumber(TextHelper.getDefault());
		setCellPhoneNumberConfirmed(BooleanHelper.getDefault());
		setEmailConfirmed(BooleanHelper.getDefault());
	}
	
	
	public UserEntity(final UUID id, final IdentificationTypeEntity identificationType, final String identificationNumber, final String firstName,
			final String middleName, final String lastName, final String secondLastName, final CityEntity residenceCity, final String email,
			final String cellPhoneNumber, final boolean emailConfirmed, final boolean cellPhoneNumberConfirmed) {
		super(id);
		this.identificationType = identificationType;
		this.identificationNumber = identificationNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.secondLastName = secondLastName;
		this.residenceCity = residenceCity;
		this.email = email;
		this.cellPhoneNumber = cellPhoneNumber;
		this.emailConfirmed = emailConfirmed;
		this.cellPhoneNumberConfirmed = cellPhoneNumberConfirmed;
	}
	
	static UserEntity getDefaultValue() {
		return new UserEntity();
	}
	
	static UserEntity getDefaultValue(final UserEntity user) {
		return ObjectHelper.getDefault(user, getDefaultValue());
	}

	public IdentificationTypeEntity getIdentificationType() {
		return identificationType;
	}
	
	public void setIdentificationType(final IdentificationTypeEntity identificationType) {
		this.identificationType = ObjectHelper.getDefault(identificationType, IdentificationTypeEntity.getDefaultValue());
	}
	
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	
	public void setIdentificationNumber(final String identificationNumber) {
		this.identificationNumber = TextHelper.getDefaultWithTrim(identificationNumber);
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(final String firstName) {
		this.firstName = TextHelper.getDefaultWithTrim(firstName);
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(final String middleName) {
		this.middleName = TextHelper.getDefaultWithTrim(middleName);
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(final String lastName) {
		this.lastName = TextHelper.getDefaultWithTrim(lastName);
	}
	
	public String getSecondLastName() {
		return secondLastName;
	}
	
	public void setSecondLastName(final String secondLastName) {
		this.secondLastName = TextHelper.getDefaultWithTrim(secondLastName);
	}
	
	public CityEntity getResidenceCity() {
		return residenceCity;
	}
	
	public void setResidenceCity(final CityEntity residenceCity) {
		this.residenceCity = ObjectHelper.getDefault(residenceCity, CityEntity.getDefaultValue());
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(final String email) {
		this.email = TextHelper.getDefaultWithTrim(email);
	}
	
	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}
	
	public void setCellPhoneNumber(final String cellPhoneNumber) {
		this.cellPhoneNumber = TextHelper.getDefaultWithTrim(cellPhoneNumber);
	}
	
	public boolean isEmailConfirmed() {
		return emailConfirmed;
	}
	
	public void setEmailConfirmed(final boolean emailConfirmed) {
		this.emailConfirmed = BooleanHelper.getDeafult(emailConfirmed);
	}
	
	public boolean isCellPhoneNumberConfirmed() {
		return cellPhoneNumberConfirmed;
	}
	
	public void setCellPhoneNumberConfirmed(final boolean cellPhoneNumberConfirmed) {
		this.cellPhoneNumberConfirmed = BooleanHelper.getDeafult(cellPhoneNumberConfirmed);
	}
	
	
}
