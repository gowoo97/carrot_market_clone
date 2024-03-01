package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {
	
	
	@Query(value = "select * from friend AS f WHERE f.from_user = :userId or f.to_user = :userId" , nativeQuery = true)
	public List<Friend> getFriendsByUserId(@Param("userId") Long userId);
	
	
}
