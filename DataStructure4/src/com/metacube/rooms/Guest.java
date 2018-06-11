package com.metacube.rooms;

/**
 * @author- Jaya Bapna
 * Class name - Guest
 * Below class reprsents Guest entity to whom rooms are allocated.
 */

public class Guest {
	String name;								//Stores name of the Guest
	int age;									//Stores age of the Guest
	int roomNumber;								//Stores the number of rooms alloted to the Guest
	
	public Guest(String name, int age) {
		this.name = name;
		this.age = age;
		this.roomNumber = -1;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
}
