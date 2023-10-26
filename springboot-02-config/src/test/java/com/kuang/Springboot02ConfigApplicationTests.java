package com.kuang;

import com.kuang.poro.Dog;
import com.kuang.poro.DogTwo;
import com.kuang.poro.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02ConfigApplicationTests {
   @Autowired//将狗狗自动注入进来
	private Dog dog;
  @Autowired
    private Person person;
  @Autowired
  private DogTwo dogTwo;
	@Test
	void contextLoads() {
		System.out.println(dog);
	}
   @Test
   void contextLoads1() {
	   System.out.println(person);
   }
   @Test
   void contextLoads2() {
       System.out.println( dogTwo);
   }
}
