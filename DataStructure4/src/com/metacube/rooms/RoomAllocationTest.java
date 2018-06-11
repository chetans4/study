package com.metacube.rooms;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoomAllocationTest {

	Guest[] allocatedRoomsActual;
	Guest[] allocatedRoomsExpected;
	RoomAllocation room;
	
	@Test
	public void testAllotingRoomSuccess() {
		room = new RoomAllocation(5);
		Guest g1 = new Guest("a", 11);
	    room.allocateRooms(g1);
		Guest g2 = new Guest("b", 7);
		room.allocateRooms(g2);
		Guest g3 = new Guest("c", 17);
	    room.allocateRooms(g3);
		Guest g4 = new Guest("d", 14);
		allocatedRoomsActual = room.allocateRooms(g4);
		allocatedRoomsExpected = new Guest[]{null, g1, g2, g3, g4};
		assertArrayEquals(allocatedRoomsExpected, allocatedRoomsActual);
	}
	
	@Test
	public void testAllotingRoomFailure() {
		room = new RoomAllocation(5);
		Guest g1 = new Guest("a", 11);
		room.allocateRooms(g1);
		Guest g2 = new Guest("b", 7);
		room.allocateRooms(g2);
		Guest g3 = new Guest("c", 17);
		room.allocateRooms(g3);
		Guest g4 = new Guest("d", 14);
		allocatedRoomsActual = room.allocateRooms(g4);
		allocatedRoomsExpected = new Guest[]{g1, g2, g3, g4};
		assertNotEquals(allocatedRoomsExpected, allocatedRoomsActual);
	}
	
}
