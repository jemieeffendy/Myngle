package com.example.myngle;
/*	SOME DISCREPANCIES FROM CLASS DIAGRAM. HAVE LABELLED THESE WITH COMMENTS. */
public class ChatRoom {
	//TODO: create a global variable named currentUser so as the system knows who sending the message
	//TODO: create a loop on a separate thread to poll the database for new messages. SHOULD WE CREATE ONE PER CHAT ROOM OR ONE TO CHECK FOR ALL CHATROOMS?
	private User user1;
	private User user2;
	private Message[] messages;
	
	public ChatRoom(User user1, User user2){//This is used to create a chat. Any new chats must be initialised by the startChat() void
		
		this.user1 = user1;
		this.user2 = user2;
		
		messages = new Message[0];
		
	}
	
	//TODO: Do we need a void for savintg and a void for loading the chat? 
	
	public static ChatRoom startChat(User user1, User user2){//Is used for creating a new instance of the chat room.
		
		//TODO: connect to the database and check to see if this chat already exists. If it does, retreive it.
		ChatRoom result = new ChatRoom(user1, user2);
		//TODO: save result to database
		return result;
		
	}
	
	public void initializeMessage(String message){//I see no reason why this won't work, so I will leave it as a void, not a boolean
		
		Message[] newMessageArray = new Message[messages.length + 1];
		for(int i = 0; i != messages.length; i++)
			newMessageArray[i] = messages[i];
		
//		newMessageArray[newMessageArray.length - 1] = new Message(currentUser, (currentUser == user1)?user2:user1, message);
		
		messages = newMessageArray;
		
		//TODO: Send new message to database.
		
	}
	
}
