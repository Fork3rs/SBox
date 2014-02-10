package com.ladhari.objects;

public class Equipement {
String name ;
String status;
String data;
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Equipement(String name, String status ,String data) {
	super();
	this.name = name;
	this.status = status;
	this.data=data;
}


}
