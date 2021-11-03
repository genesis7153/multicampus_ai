package com.example.sba.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sba.domain.Member;
import com.example.sba.mapper.MemberMapper;

@RestController

public class MapperExController {
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MemberMapper mapper;
	
//	@RequestMapping(value="/noXmlMapperGet/{id}", method=RequestMethod.GET)
	@GetMapping(value="/noXmlMapperGet2")
	public ResponseEntity<Member> noXmlMapperGet(HttpServletRequest request){
		try {
			String id = request.getParameter("id");
			logger.info(id);
			Member member = mapper.getLoginInfo(id);
			logger.info(member.toString());
			return new ResponseEntity<>(member, HttpStatus.BAD_REQUEST.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST.OK);
	}
	@PostMapping("/noXmlMapperPost")
	public ResponseEntity<Member> noXmlMapperPost(String id){
		try {
			logger.info(id);
			Member member = mapper.getLoginInfo(id);
			logger.info(member.toString());
			return new ResponseEntity<>(member, HttpStatus.BAD_REQUEST.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/noXmlMapperPost2")
	public ResponseEntity<Member> noXmlMapperPost2(Member member){
		try {
			logger.info(member.toString());
			Member userInfo = mapper.getLoginInfo(member.getEmail());
			logger.info(member.toString());
			return new ResponseEntity<>(userInfo, HttpStatus.BAD_REQUEST.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("noXmlMapperList")
	public ResponseEntity<List<Member>> noXmlMapperList(){
		try {
			List<Member> members = mapper.getMemberList();
			return new ResponseEntity<>(members, HttpStatus.BAD_REQUEST.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/useXmlMapperGet/{id}")
	public ResponseEntity<Member> useXmlMapperGet(@PathVariable String id){
		try {
			logger.info(id);
			Member member = mapper.getMember(id);
			logger.info(member.getEmail());
			return new ResponseEntity<>(member, HttpStatus.BAD_REQUEST.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/useXmlMapperPost")
	public ResponseEntity<String> useXmlMapperPost(Member member){
		try {
			Map<String, String> map = new HashMap();
			map.put("EMAIL", member.getEmail());
			map.put("PWD", member.getPwd());
			map.put("MNAME", member.getMname());
			logger.info(member.toString()+"");
			mapper.createMember(map);
			logger.info(member.getEmail());
			return new ResponseEntity<>("가입되었습니다.", HttpStatus.BAD_REQUEST.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
