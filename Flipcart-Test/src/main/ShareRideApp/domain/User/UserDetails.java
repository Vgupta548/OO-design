package main.ShareRideApp.domain.User;

import main.ShareRideApp.Constants.UserStatus;

public class UserDetails extends User{

	private char gender;
	private int age;
	private UserStatus status;
	
	public UserDetails(String name, char gender, int age){
		super(name);
		this.gender =  gender;
		this.age = age;
		this.status = UserStatus.ACTIVE;
	}
	
	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}
	
	

}
