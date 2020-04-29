package model;

import java.io.Serializable;

public class EmailAlert implements Serializable{

	private String admin; //to
	private String title; //subject
	private String alert; //text
	
	public EmailAlert() {
		super();
	}

	public EmailAlert(String admin, String title, String alert) {
		super();
		this.admin = admin;
		this.title = title;
		this.alert = alert;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	@Override
	public String toString() {
		return "EmailAlert [admin=" + admin + ", title=" + title + ", alert=" + alert + "]";
	}
	
	
	
	
}
