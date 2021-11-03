package com.example.sba.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;



import com.example.sba.domain.Member;

public interface MemberMapper {
	@Select("select * from bank where id=#{email}")
	public Member getLoginInfo(@Param("email")String email) throws Exception;
	
	@Select("select * from members where mname=#{mname}")
	public Member getUserInfoByName(@Param("mname")String mname) throws Exception;
	
	@Select("select * from members limit 100")
	public List<Member> getMemberList() throws Exception;
	
	@Insert("insert into members(email,pwd,mname, cre_date, mod_date) values(#{email},#{pwd},#{mname},NOW(),NOW())")
	public boolean insertMember(Member member)throws Exception;
	public Member getMember(@Param("email")String email)throws Exception;
	public void createMember(Map<String, String> map)throws Exception;
}
