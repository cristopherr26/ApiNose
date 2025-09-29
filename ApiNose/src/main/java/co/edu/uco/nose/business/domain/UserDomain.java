package co.edu.uco.nose.business.domain;

import java.util.UUID;

import co.edu.uco.nose.crosscuting.helper.BooleanHelper;
import co.edu.uco.nose.crosscuting.helper.TextHelper;
import co.edu.uco.nose.crosscuting.helper.UUIDHelper;

public class UserDomain extends Domain {
	 
	private UUID identificationTypeId;
	private String identificationNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private String secondLastName;
	private UUID residenceCityId;
	private String email;
	private String cellPhoneNumber;
	private boolean emailConfirmed;
	private boolean cellPhoneNumberConfirmed;
	
	public UserDomain() {
		super(UUIDHelper.getUUIDHelper().getDefault());
		setIdentificationTypeId(UUIDHelper.getUUIDHelper().getDefault());
		setIdentificationNumber(TextHelper.getDefault());;
		setFirstName(TextHelper.getDefault());
		setMiddleName(TextHelper.getDefault());
		setLastName(TextHelper.getDefault());
		setSecondLastName(TextHelper.getDefault());
		setResidenceCityId(UUIDHelper.getUUIDHelper().getDefault());
		setEmail(TextHelper.getDefault());
		setCellPhoneNumber(TextHelper.getDefault());
		setCellPhoneNumberConfirmed(BooleanHelper.getDefault());
		setEmailConfirmed(BooleanHelper.getDefault());
	}
	
	public UserDomain(final UUID id) {
		super(id);
		setIdentificationTypeId(UUIDHelper.getUUIDHelper().getDefault());
		setIdentificationNumber(TextHelper.getDefault());;
		setFirstName(TextHelper.getDefault());
		setMiddleName(TextHelper.getDefault());
		setLastName(TextHelper.getDefault());
		setSecondLastName(TextHelper.getDefault());
		setResidenceCityId(UUIDHelper.getUUIDHelper().getDefault());
		setEmail(TextHelper.getDefault());
		setCellPhoneNumber(TextHelper.getDefault());
		setCellPhoneNumberConfirmed(BooleanHelper.getDefault());
		setEmailConfirmed(BooleanHelper.getDefault());
	}
	
	
	public UserDomain(final UUID id, final UUID identificationTypeId, final String identificationNumber, final String firstName,
			final String middleName, final String lastName, final String secondLastName, final UUID residenceCityId, final String email,
			final String cellPhoneNumber, final boolean emailConfirmed, final boolean cellPhoneNumberConfirmed) {
		super(id);
		this.identificationTypeId = identificationTypeId;
		this.identificationNumber = identificationNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.secondLastName = secondLastName;
		this.residenceCityId = residenceCityId;
		this.email = email;
		this.cellPhoneNumber = cellPhoneNumber;
		this.emailConfirmed = emailConfirmed;
		this.cellPhoneNumberConfirmed = cellPhoneNumberConfirmed;
	}

	public UUID getIdentificationTypeId() {
		return identificationTypeId;
	}
	
	public void setIdentificationTypeId(final UUID identificationTypeId) {
		this.identificationTypeId = UUIDHelper.getUUIDHelper().getDefault(identificationTypeId);
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
	
	public UUID getResidenceCityId() {
		return residenceCityId;
	}
	
	public void setResidenceCityId(final UUID residenceCityId) {
		this.residenceCityId = UUIDHelper.getUUIDHelper().getDefault(residenceCityId);
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
