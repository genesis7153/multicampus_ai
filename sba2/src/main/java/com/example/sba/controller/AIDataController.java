package com.example.sba.controller;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.sba.domain.Member;
import com.example.sba.mapper.MemberMapper;
import com.example.sba.service.impl.AIDataServiceImpl;

@RestController
public class AIDataController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	MemberMapper mapper;
	@Autowired
	private AIDataServiceImpl aiservice;
	@PostMapping("/login")
	public ResponseEntity<Member> login(String email){
		try {
			logger.info(email);
			Member member = mapper.getLoginInfo(email);
			logger.info(member.toString());
			return new ResponseEntity<>(member,HttpStatus.BAD_REQUEST.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("aiface")
	public ResponseEntity<?> aiface(
			@Validated @RequestParam("mname")String mname,
			@Validated @RequestParam("content")String content,
			@Validated @RequestParam("files")MultipartFile file
			)throws Exception{
		try {
			logger.info(mname);
			logger.info(content);
			logger.info(file.getOriginalFilename());
			file.transferTo(new File(new File("").getAbsolutePath()+"\\"+file.getOriginalFilename()));
			return new ResponseEntity<>(aiservice.faceData(file.getOriginalFilename()), HttpStatus.BAD_REQUEST.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
	
