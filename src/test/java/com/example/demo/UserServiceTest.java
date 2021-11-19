package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.example.demo.user.model.User;
import com.example.demo.user.service.UserService;

@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	UserService userService;

	@Test
	@DisplayName("전체 조회")
	void test1() {
		List<User> userList = userService.getUserList();
		for (User user : userList) {
			System.out.println("user = " + user.toString());
		}
	}

	@Test 
	@Commit
	@DisplayName("생성")
	void test2() {
		User user = User.builder().name("Tom").part("A").build(); 
		int insertCnt = userService.createUser(user);
		assertThat(insertCnt).isEqualTo(1);
		
		User user2 = User.builder().name("Jon").part("B").build(); 
		int insertCnt2 = userService.createUser(user2);
		assertThat(insertCnt2).isEqualTo(1);
	}
	
	
	@Test
	@DisplayName("단건 조회")
	void test3() {
		User user = userService.getUser(10);
		System.out.println("user = " + user.toString());
	}

	

	@Test
	@Commit
	@DisplayName("삭제")
	void test4() {
		int deleteCnt = userService.removeUser(10);
		assertThat(deleteCnt).isEqualTo(1);
	}

	@Test
	@Commit
	@DisplayName("업데이트")
	void test5() {
		User user = User.builder().id(11).name("Jon").part("A").build();  
		int updateCnt = userService.modifyUser(user);
		assertThat(updateCnt).isEqualTo(1);
	}
	 

}
