package com.multi.mvc.jejuism.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multi.mvc.common.util.PageInfo;
import com.multi.mvc.jejuism.model.mapper.VisitJejuMapper;
import com.multi.mvc.jejuism.model.vo.Review;
import com.multi.mvc.jejuism.model.vo.VisitJeju;

@Service
public class VisitJejuService {

	@Autowired
	private VisitJejuMapper mapper;

	public double selectAvgRate(int vno) {
		return mapper.selectAvgRate(vno);
	}
	
	public List<VisitJeju> selectVList(PageInfo pageInfo, Map<String, Object> param){
		param.put("limit", "" + pageInfo.getListLimit());
		param.put("offset", "" + (pageInfo.getStartList() - 1));
		return mapper.selectVList(param);
	}
	
	public int selectVCount(Map<String, Object> param) {
		return mapper.selectVCount(param);
	}
	
	public List<VisitJeju> selectVListForO(PageInfo pageInfo, Map<String, Object> param){
		param.put("limit", "" + pageInfo.getListLimit());
		param.put("offset", "" + (pageInfo.getStartList() - 1));
		return mapper.selectVListForO(param);
	}
	
	public int selectVCountForO(Map<String, Object> param) {
		return mapper.selectVCountForO(param);
	}
	
	public List<VisitJeju> selectVListForM(PageInfo pageInfo, Map<String, Object> param){
		param.put("limit", "" + pageInfo.getListLimit());
		param.put("offset", "" + (pageInfo.getStartList() - 1));
		return mapper.selectVListForM(param);
	}
	
	public int selectVCountForM(Map<String, Object> param) {
		return mapper.selectVCountForM(param);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public VisitJeju selectVByNo(int visitJejuNo) {
		VisitJeju visitJeju = mapper.selectVByNo(visitJejuNo); 
		return visitJeju; 
	}

	@Transactional(rollbackFor = Exception.class)
	public int insertV(VisitJeju visitJeju) {
		int result = 0;
		result = mapper.insertV(visitJeju);
		return result;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int insertReview(Review review) {
		int result = 0;
		if(review.getNo() == 0) {
			result = mapper.insertReview(review);
		}else {
			result = mapper.updateReview(review);
		}
		return result;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public int deleteReview(int reviewNo) {
		return mapper.deleteReview(reviewNo);
	}

	public List<VisitJeju> selectVListHome(List<String> homeItem) {
		return mapper.selectVListHome(homeItem);
	}
	
}
