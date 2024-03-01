package com.example.demo.Service;

import java.util.List;

import com.example.demo.entity.Friend;

public interface FriendService {


	public Friend addFriend(String userId1,String userId2);

	public List<Friend> getFriends(long seq);
	
	
}
