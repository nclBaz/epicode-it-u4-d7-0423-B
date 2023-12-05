package entities;

import java.util.Random;

public class User {
	private String name;
	private String surname;
	private int age;
	private int id;

	public User(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		Random rndm = new Random();
		this.id = rndm.nextInt(1, 1000000);
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", age=" + age +
				", id=" + id +
				'}';
	}
}
