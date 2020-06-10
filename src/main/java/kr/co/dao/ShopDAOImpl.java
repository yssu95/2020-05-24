package kr.co.dao;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import kr.co.vo.CartListVO;
import kr.co.vo.CartVO;
import kr.co.vo.GoodsViewVO;
import kr.co.vo.OrderDetailVO;
import kr.co.vo.OrderListVO;
import kr.co.vo.OrderVO;
import kr.co.vo.ReplyVO;

@Repository
public class ShopDAOImpl implements ShopDAO {

	@Inject
	private SqlSession sql;

	// 매퍼
	private static String namespace = "shopMapper";

	// 카테고리별 상품 리스트 : 1차 분류
	@Override
	public List<GoodsViewVO> list(int cateCode, int cateCodeRef) throws Exception {

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("cateCode", cateCode);
		map.put("cateCodeRef", cateCodeRef);

		return sql.selectList(namespace + ".list_1", map);
	}

	// 카테고리별 상품 리스트 : 2차 분류
	@Override
	public List<GoodsViewVO> list(int cateCode) throws Exception {

		return sql.selectList(namespace + ".list_2", cateCode);
	}

	/*
	 * 메서드명은 list 로 똑같지만, 매개변수가 다르기 떄문에 오버로딩 가능
	 */

	// 상품 조회
	@Override
	public GoodsViewVO goodsView(int gdsNum) throws Exception {
		return sql.selectOne("adminMapper" + ".goodsView", gdsNum);
	}

	// 상품 소감(댓글) 작성
	@Override
	public void registReply(ReplyVO reply) throws Exception {
		sql.insert(namespace + ".registReply", reply);
	}

	/*
	 * // 상품 소감(댓글) 리스트
	 * 
	 * @Override public List<ReplyListVO> replyList(int gdsNum) throws Exception {
	 * return sql.selectList(namespace + ".replyList", gdsNum); }
	 */
	// 상품 소감(댓글) 삭제
	@Override
	public void deleteReply(ReplyVO reply) throws Exception {
		sql.delete(namespace + ".deleteReply", reply);
	}

	// 아이디 체크
	@Override
	public String idCheck(int repNum) throws Exception {
		return sql.selectOne(namespace + ".replyUserIdCheck", repNum);
	}

	// 상품 소감(댓글) 수정
	@Override
	public void modifyReply(ReplyVO reply) throws Exception {
		sql.update(namespace + ".modifyReply", reply);
	}

	// 카트 담기
	@Override
	public void addCart(CartListVO cart) throws Exception {
		sql.insert(namespace + ".addCart", cart);
	}

	// 카트 리스트
	@Override
	public List<CartListVO> cartList(String userId) throws Exception {
		return sql.selectList(namespace + ".cartList", userId);
	}

	// 카트 삭제
	@Override
	public void deleteCart(CartVO cart) throws Exception {
		sql.delete(namespace + ".deleteCart", cart);
	}

	// 주문 정보
	@Override
	public void orderInfo(OrderVO order) throws Exception {
		sql.insert(namespace + ".orderInfo", order);
	}

	// 주문 상세 정보
	@Override
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception {
		sql.insert(namespace + ".orderInfo_Details", orderDetail);
	}

	// 카트 비우기
	@Override
	public void cartAllDelete(String userId) throws Exception {
		sql.delete(namespace + ".cartAllDelete", userId);
	}

	// 주문 목록
	@Override
	public List<OrderVO> orderList(OrderVO order) throws Exception {
		return sql.selectList(namespace + ".orderList", order);
	}

	// 특정 주문 목록
	@Override
	public List<OrderListVO> orderView(OrderVO order) throws Exception {
		return sql.selectList(namespace + ".orderView", order);
	}

	// 검색별 상품 리스트
	@Override
	public List<GoodsViewVO> list(GoodsViewVO vo) throws Exception {
		return sql.selectList(namespace + ".list_3", vo);
	}

}