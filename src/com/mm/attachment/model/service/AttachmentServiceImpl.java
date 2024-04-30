package com.mm.attachment.model.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.mm.attachment.model.dao.AttachmentDao;
import com.mm.attachment.model.vo.Attachment;
import com.mm.common.template.Template;

public class AttachmentServiceImpl implements AttachmentService{

	private AttachmentDao attachmentDao = new AttachmentDao();

	public ArrayList<Attachment> getAttachmentList(int mtoNo) {
		SqlSession session = Template.getSqlSession();
		ArrayList<Attachment> list = attachmentDao.getAttachmentList(session, mtoNo);
		session.close();
		return list;
	}

	public ArrayList<Attachment> portfolioAttachmentList(int refPno) {
		SqlSession session = Template.getSqlSession();
		ArrayList<Attachment> list = attachmentDao.portfolioAttachmentList(session, refPno);
		session.close();
		return list;
	}
}
