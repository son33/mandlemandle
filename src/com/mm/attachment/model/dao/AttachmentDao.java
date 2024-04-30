package com.mm.attachment.model.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mm.attachment.model.vo.Attachment;

public class AttachmentDao {
//	맨토마이페이지 첨부파일 불러오기
	public ArrayList<Attachment> getAttachmentList(SqlSession session, int mtoNo) {
		return new ArrayList<>(session.selectList("attachmentMapper.getAttachmentList",mtoNo));
	}
//	포트폴리오 작성
	public int insertPortfolio(SqlSession session, Map<String, Object> map) {
		return session.insert("attachmentMapper.insertPortfolio",map);
	}
//	포트폴리오 수정
	public int updatePortfolio(SqlSession session, Map<String, Object> map) {
		ArrayList<?> existingList = (ArrayList<?>) map.get("existingList");
		System.out.println("existingList : "+existingList);
		ArrayList<?> newList = (ArrayList<?>) map.get("newList");
		System.out.println("newList : "+newList);
		int result1 = 1;
		int result2 = 1;
		if(!existingList.isEmpty()) {
			for(Object a : existingList) {
				result1 = session.update("attachmentMapper.updatePortfolio",a);
			}
		}
		if(!newList.isEmpty()) {
			result2 = session.update("attachmentMapper.newInsertPortfolio",newList);
		}
		System.out.println("dao 기존 사진 수정 결과 : "+result1);
		System.out.println("dao 새 사진 삽입 결과 : "+result2);
		return result1 * result2;
	}
//	포트폴리오 첨부파일 불러오기
	public ArrayList<Attachment> portfolioAttachmentList(SqlSession session, int refPno) {
		return new ArrayList<Attachment>(session.selectList("attachmentMapper.portfolioAttachmentList",refPno));
	}
}
