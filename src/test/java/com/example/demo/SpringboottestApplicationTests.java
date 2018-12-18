package com.example.demo;

import com.example.demo.service.StringExtends;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringboottestApplicationTests {

	@Autowired
	StringExtends stringExtends;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testStringCout() throws UnsupportedEncodingException {
		stringExtends.getCharByByteCount("abc我是罗兰娇",8);
	}

	@Test
    public void testRecursion(){
	    ArrayList<Integer> numbers=new ArrayList<Integer>(){};
        numbers.add(1237);
        recursion(numbers);
    }

	public ArrayList<Integer> recursion(ArrayList<Integer> numbers){
	    int lastNum=numbers.get(numbers.size());
        int addNum= lastNum*2;
        numbers.add(addNum);
	    if(addNum>5000){
            for (int num:numbers
                 ) {
                System.out.println(num);
            }

	        return numbers;
        }
	    return recursion(numbers);
    }
}
