package com.iban.support;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class IncomingMessage {

	@NotNull(message = "Email address cannot be missing or empty")
	private String email;
	private String firstName;
	private String gender;
	@NotNull(message = "DateOfBirth cannot be missing or empty")
	private String dateOfBirth;
	@NotNull(message = "Consent cannot be missing or empty")
	private String consent;
	@NotNull(message = "NewsletterId cannot be missing or empty")
	private String newsletterId;

	public IncomingMessage(String email, String firstName, String gender, String dateOfBirth, String consent, String newsletterId) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.consent = consent;
		this.newsletterId = newsletterId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getBody(IncomingMessage obj) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonString;

	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getConsent() {
		return consent;
	}

	public void setConsent(String consent) {
		this.consent = consent;
	}

	public String getNewsletterId() {
		return newsletterId;
	}

	public void setNewsletterId(String newsletterId) {
		this.newsletterId = newsletterId;
	}

}
