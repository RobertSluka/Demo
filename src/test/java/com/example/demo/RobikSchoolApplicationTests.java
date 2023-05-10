package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.model.School;
import com.example.demo.model.UserInfo;
import com.example.demo.repository.UserInfoRepository;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.services.PersonService;
import jakarta.transaction.Transactional;
import org.apache.catalina.User;
import org.aspectj.lang.annotation.Before;
import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.transaction.AfterTransaction;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class RobikSchoolApplicationTests {

	private UserInfo userMarek;
	JwtUtils jwtUtils;
	@Autowired
	UserInfoRepository userInfoRepository;
	String name = "test";
	String email = "xxx.xxx@gmail.com";
	int id = 8;

	@BeforeEach
	public void setUp() {
		String password = "04061998";
		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt()); // hash the password
		userMarek = new UserInfo(0,name,email , hashedPassword, "ROLE_ADMIN"); // use the hashed password
	}


	@Test
	@Transactional
	public void addUser() {
		//arrange
		jwtUtils = new JwtUtils();
		//act
		userInfoRepository.save(userMarek);
		jwtUtils.createToken(userMarek);
		Optional<UserInfo> savedUser = userInfoRepository.findById(userMarek.getId());
		//assert
		assertThat(savedUser).isPresent();
		assertThat(savedUser.get().getName()).isEqualTo(name);
	}

	@AfterTransaction
	public void TearDown(){
		userInfoRepository.delete(userMarek);
		userMarek= null;
	}

	@Test
	void deleteUser(){
		//arrange

		//act
		userInfoRepository.deleteById(id);
		//assert
		assertThat(userInfoRepository.existsById(id)).isFalse();
	}

	@Test
	@Transactional
	@Rollback(true)
	public void findByName(){
		//arrange

		//act
		Optional<UserInfo> foundUser = userInfoRepository.findByName(name);
		//assert
		assertThat(foundUser).isNotNull();
		assertThat(foundUser.get().getName()).isEqualTo(name);

	}
	@Test
	@Transactional
	public void findByEmail(){

		//act
		Optional<UserInfo> foundUserEmail= userInfoRepository.findByEmail(email);

		//assert
		assertThat(foundUserEmail).isNotEmpty();
		assertThat(foundUserEmail.get().getEmail()).isEqualTo(email);


	}


	@Test
	public void testUserExists() {

		//act
		Optional<UserInfo> exists = userInfoRepository.findByName(name);
		assertTrue(exists.isPresent());
		userMarek= exists.get();
		//arrange
		assertThat(userMarek.getName()).isEqualTo(userMarek.getName());
		assertThat(userMarek.getEmail()).isEqualTo(userMarek.getEmail());
		assertThat(userMarek.getPassword()).isEqualTo(userMarek.getPassword());
		assertThat(userMarek.getRoles()).isEqualTo(userMarek.getRoles());
	}

}





