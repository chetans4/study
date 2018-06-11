package rooms;


/**
 * Class name - RoomAllocation
 * Below class allocates rooms to the user on the basis of their age using Hashing technique.
 */
public class RoomAllocation {
	Guest [] allocatedRooms;							//Array of Guest to store the details of Guest to whom room is alloted.
	int totalNumberOfRooms;								//Stores total number of rooms.
	
	public RoomAllocation(int totalNumberOfRooms) {
		this.totalNumberOfRooms = totalNumberOfRooms;
		this.allocatedRooms = new Guest[totalNumberOfRooms];
	}
	
	/**
	 * Below method generates room on the basis of age of Guest.
	 * @param age
	 * @return
	 */
	public int generateRoomNUmber(int age) {
		return age % totalNumberOfRooms;
	}
	
	/**
	 * Below functions stores the details of the Guest to whom room is alloted.
	 * @param guest
	 * @return
	 */
	public Guest[] allocateRooms(Guest guest) {
		int roomNumber = 0;							//Stores room number of particular Guest
		int flag = 0;
		while(allocatedRooms[flag] != null ) {
			flag++;
		}
		
		if(flag == totalNumberOfRooms) {
		//throw new ArrayIndexOutOfBoundsException("Total number of rooms available are : " +totalNumberOfRooms);
        throw new ArrayIndexOutOfBoundsException(); 		//If there is no room available for more Guestss
		//throw new ArrayIndexOutOfBoundsException(roomNumber);
		}
		
		else{
			roomNumber = generateRoomNUmber(guest.getAge());
			while(allocatedRooms[roomNumber] != null) {
				roomNumber = (roomNumber + 1) % totalNumberOfRooms;  
			}
		allocatedRooms[roomNumber] = guest;
		guest.setRoomNumber(roomNumber);
		return allocatedRooms;
		}
	}
}	

