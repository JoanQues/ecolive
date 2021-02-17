package com.ecolive.dto;

public class Client {
	private int id;
	private String dni;
	private String name;
	private String surname;
	private int phone;
	private String email;
	
	
	public Client() {
		super();
	}
	
	public Client(String dni, String name, String surname, int phone, String email) {
		super();
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
	}

	public Client(int id) {
		super();
		this.id = id;
	}

	public Client(int id, String dni, String name, String surname, int phone, String email) {
		super();
		this.id = id;
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", dni=" + dni + ", name=" + name + ", surname=" + surname + ", phone=" + phone
				+ ", email=" + email + "]";
	}



	
	
}
