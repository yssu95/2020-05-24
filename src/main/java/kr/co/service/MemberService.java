package kr.co.service;


import kr.co.vo.MemberVO;

public interface MemberService {

	public void register(MemberVO vo) throws Exception;
	
	public MemberVO login(MemberVO vo) throws Exception;
	
	public void memberUpdate(MemberVO vo) throws Exception;
	
	public void memberDelete(MemberVO vo) throws Exception;
	
	public int passChk(MemberVO vo) throws Exception;
	
	public int idChk(MemberVO vo) throws Exception;
	
	public int checkEmail(MemberVO vo) throws Exception;
<<<<<<< HEAD
=======
	
>>>>>>> branch 'master' of https://github.com/yssu95/2020-05-24.git
	public boolean checkPw(String userId, String userPass) throws Exception;

}
