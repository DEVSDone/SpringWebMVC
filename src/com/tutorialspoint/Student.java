package com.tutorialspoint;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student{

	String name;
	int age;
	int id;
	String gender;

	public String getGender() {
		return gender;
	}
	@XmlElement
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName(){
		return name;
	}

	@XmlElement
	public void setName(String name){
		this.name = name;
	}

	public int getAge(){
		return age;
	}

	@XmlElement
	public void setAge(int age){
		this.age = age;
	}

	public int getId(){
		return id;
	}

	@XmlAttribute
	public void setId(int id){
		this.id = id;
	}

}
