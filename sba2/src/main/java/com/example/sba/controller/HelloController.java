package com.example.sba.controller;

import java.lang.reflect.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.sba.mapper.MemberMapper;

@Controller
//@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String hello() {
		return "main";
	}
	@RequestMapping("/helloJson")	//물리적 페이지 따로 만들지 않아도 메시지전송하는 역할 할수있다.
	public String helloJson() {
		String msg="스프링부트는 rest방식으로 데이터를 전송한다.";
		return msg;
	}
	@RequestMapping("/paramValueTest/{id}")
	public ResponseEntity<Member> paramValueTest(@PathVariable String id){
		System.out.println(id);
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST.OK);
	}
	@Autowired
	private MemberMapper mapper;
	@GetMapping("requestlist")
	public ModelAndView list() {
		ModelAndView mav = null;
		try {
			mav = new ModelAndView("list");
			mav.addObject("members", mapper.getMemberList());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mav; 
		
	}
}
