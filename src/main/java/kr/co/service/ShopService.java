package kr.co.service;

import java.util.List;

import kr.co.vo.CartListVO;
import kr.co.vo.CartVO;
import kr.co.vo.GoodsViewVO;
import kr.co.vo.OrderDetailVO;
import kr.co.vo.OrderListVO;
import kr.co.vo.OrderVO;
import kr.co.vo.ReplyVO;

public interface ShopService {

	// 카테고리별 상품 리스트
	public List<GoodsViewVO> list(int cateCode, int level) throws Exception;

	// 상품조회
	public GoodsViewVO goodsView(int gdsNum) throws Exception;

	/*
	 * // 상품 소감(댓글) 작성 public void registReply(ReplyVO reply) throws Exception;
	 */
	/*
	 * // 상품 소감(댓글) 리스트 public List<ReplyListVO> replyList(int gdsNum) throws
	 * Exception;
	 */
	/*
	 * // 상품 소감(댓글) 삭제 public void deleteReply(ReplyVO reply) throws Exception;
	 */
	// 아이디 체크
	public String idCheck(int repNum) throws Exception;

	/*
	 * // 상품 소감(댓글) 수정 public void modifyReply(ReplyVO reply) throws Exception;
	 */
	// 카트 담기
	public void addCart(CartListVO cart) throws Exception;

	// 카트 리스트
	public List<CartListVO> cartList(String userId) throws Exception;

	// 카트 삭제
	public void deleteCart(CartVO cart) throws Exception;

	// 주문 정보
	public void orderInfo(OrderVO order) throws Exception;

	// 주문 상세 정보
	public void orderInfo_Details(OrderDetailVO orderDetail) throws Exception;

	// 카트 비우기
	public void cartAllDelete(String userId) throws Exception;

	// 주문 목록
	public List<OrderVO> orderList(OrderVO order) throws Exception;

	// 특정 주문 목록
	public List<OrderListVO> orderView(OrderVO order) throws Exception;

	// 검색별 상품 리스트
	public List<GoodsViewVO> list(GoodsViewVO vo) throws Exception;
}