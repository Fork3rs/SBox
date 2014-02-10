package com.ladhari.objects;

public class Room {
	int id;
	String name;
	int devices_number;
	int notifications_number;
	
	public Room(int id, String name, int devices_number , int notification_number) {
		super();
		this.id = id;
		this.name = name;
		this.devices_number = devices_number;
		this.notifications_number = notification_number;

	}
	
	public int getNotifications_number() {
		return notifications_number;
	}

	public void setNotifications_number(int notifications_number) {
		this.notifications_number = notifications_number;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDevices_number() {
		return devices_number;
	}
	public void setDevices_number(int devices_number) {
		this.devices_number = devices_number;
	}
	
	
}
