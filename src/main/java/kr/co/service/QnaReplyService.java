package kr.co.service;

import java.util.List;

import kr.co.vo.QnaReplyVO;
<<<<<<< HEAD
=======
import kr.co.vo.ReviewReplyVO;
>>>>>>> branch 'master' of https://github.com/yssu95/2020-05-24.git

public interface QnaReplyService {

	//댓글 조회
	public List<QnaReplyVO> readReply(int bno) throws Exception;
	
	//댓글 작성
	public void writeReply(QnaReplyVO vo) throws Exception;
	
	//댓글 수정
	public void updateReply(QnaReplyVO vo) throws Exception;
	
	//댓글 삭제
	public void deleteReply(QnaReplyVO vo) throws Exception;
		
	//선택된 댓글 조회
	public QnaReplyVO selectReply(int rno) throws Exception;
}
