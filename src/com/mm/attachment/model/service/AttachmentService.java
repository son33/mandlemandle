package com.mm.attachment.model.service;

import java.util.ArrayList;

import com.mm.attachment.model.vo.Attachment;
import com.mm.portfolio.model.vo.Portfolio;
import com.mm.portfolio.model.vo.Review;

public interface AttachmentService {
	ArrayList<Attachment> getAttachmentList(int mtoNo);
	
	ArrayList<Attachment> portfolioAttachmentList(int no);
}
