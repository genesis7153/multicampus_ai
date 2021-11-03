package com.example.sba.service.impl;

import com.example.sba.domain.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sba.mapper.MemberMapper;
import com.google.gson.Gson;
import com.example.sba.ai.APIExamFace;
import com.example.sba.dto.CelebrityFace;
import com.example.sba.dto.CelebrityFace.Info.Faces;
@Service
public class AIDataServiceImpl {
	@Autowired
	private MemberMapper mapper;
	public List<Member> faceData(String filenNme) throws Exception{
		String jsonData = new APIExamFace().resultJsonData();
//		String jsonData = new APIExamFace().resultJsonData(filnNme);
		return dataProc(jsonData);
	}
	public List<Member> dataProc(String jsonData) throws Exception{
		Gson gson = new Gson();
		Faces[] faces = gson.fromJson(jsonData.substring(jsonData.indexOf("["), jsonData.indexOf("]")+1), Faces[].class);
		//데이터를 잘라서 bean에 넣어줌
		CelebrityFace cf = gson.fromJson(jsonData, CelebrityFace.class);
		cf.getInfo().setFaces(faces);
		List<Member> memberList = new ArrayList<>();
		for(Faces facesObj : cf.getInfo().getFaces()) {
			memberList.add(mapper.getUserInfoByName(facesObj.getCelebrity().getValue()));
//			facesObj.getCelebrity().getValue();
//			mapper.createMember(null);
			
		}
		return memberList;
	}
	
}
