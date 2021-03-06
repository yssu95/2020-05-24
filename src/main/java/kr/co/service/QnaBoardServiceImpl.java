package kr.co.service;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.dao.QnaBoardDAO;
import kr.co.util.QnaFileUtils;
import kr.co.vo.QnaBoardVO;
import kr.co.vo.SearchCriteria;

@Service
public class QnaBoardServiceImpl implements QnaBoardService {

	@Resource(name="QnaFileUtils")
	private QnaFileUtils fileUtils;
	
	@Inject
	private QnaBoardDAO dao;
	
	// 게시글 작성
	@Override
	public void write(QnaBoardVO boardVO, MultipartHttpServletRequest mpRequest) throws Exception {
		dao.write(boardVO);
		
		List<Map<String,Object>> list = QnaFileUtils.parseInsertFileInfo(boardVO, mpRequest);
		int size = list.size();
		for(int i=0; i<size; i++) {
			dao.insertFile(list.get(i));
		}
	}
	// 게시물 목록 조회
	@Override
	public List<QnaBoardVO> list(SearchCriteria scri)  {
		try {
			return dao.list(scri);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 게시물 총 갯수
	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		return dao.listCount(scri);
	}

	// 게시물 조회
	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public QnaBoardVO read(Integer bno) throws Exception {
<<<<<<< HEAD
		return dao.read(bno);
	}

	// 게시물 수정
	@Override
	public void update(QnaBoardVO boardVO, 
						String[] files, 
						String[] fileNames,
						MultipartHttpServletRequest mpRequest) throws Exception {
					
		dao.update(boardVO);
		
		List<Map<String, Object>> list = QnaFileUtils.parseUpdateFileInfo(boardVO, files, fileNames, mpRequest);
		Map<String, Object> tempMap = null;
		int size = list.size();
		for(int i = 0; i<size; i++) {
			tempMap = list.get(i);
			if(tempMap.get("IS_NEW").equals("Y")) {
				dao.insertFile(tempMap);
			}else {
				dao.updateFile(tempMap);
			}
		}
	}

	// 게시물 삭제
	@Override
	public void delete(int bno) throws Exception {
		dao.delete(bno);
	}
	
	// 첨부파일 조회
	@Override
	public List<Map<String, Object>> selectFileList(int bno) throws Exception {
		return dao.selectFileList(bno);
	}
	
	@Override
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		return dao.selectFileInfo(map);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED)
	@Override
	public QnaBoardVO boardhit(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return  dao.boardHit(bno);
	}
=======
			 dao.boardHit(bno);
		return dao.read(bno);
	}

	// 게시물 수정
	@Override
	public void update(QnaBoardVO boardVO, 
						String[] files, 
						String[] fileNames,
						MultipartHttpServletRequest mpRequest) throws Exception {
					
		dao.update(boardVO);
		
		List<Map<String, Object>> list = QnaFileUtils.parseUpdateFileInfo(boardVO, files, fileNames, mpRequest);
		Map<String, Object> tempMap = null;
		int size = list.size();
		for(int i = 0; i<size; i++) {
			tempMap = list.get(i);
			if(tempMap.get("IS_NEW").equals("Y")) {
				dao.insertFile(tempMap);
			}else {
				dao.updateFile(tempMap);
			}
		}
	}

	// 게시물 삭제
	@Override
	public void delete(int bno) throws Exception {
		dao.delete(bno);
	}
	
	// 첨부파일 조회
	@Override
	public List<Map<String, Object>> selectFileList(int bno) throws Exception {
		return dao.selectFileList(bno);
	}
	
	@Override
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		return dao.selectFileInfo(map);
	}

	
>>>>>>> branch 'master' of https://github.com/yssu95/2020-05-24.git
	
}















