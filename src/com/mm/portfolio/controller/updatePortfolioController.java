package com.mm.portfolio.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.mm.attachment.model.vo.Attachment;
import com.mm.common.fileRenamePolicy;
import com.mm.portfolio.model.service.PortfolioService;
import com.mm.portfolio.model.service.PortfolioServiceImpl;
import com.mm.portfolio.model.vo.Portfolio;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class UpdatePortfolioController
 */
@WebServlet("/update.po")
public class updatePortfolioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updatePortfolioController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PortfolioService service = new PortfolioServiceImpl();

		int result = 0;
		if (ServletFileUpload.isMultipartContent(request)) {
			int maxSize = 100 * 1024 * 1024;
			String savePath = request.getSession().getServletContext().getRealPath("resources/portfolio_upfiles/");

			MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, "UTF-8", new fileRenamePolicy());

			int ptfNo = Integer.parseInt(multi.getParameter("refPno"));
			String introduce = multi.getParameter("introduce");
			String ptfContent = multi.getParameter("ptfContent");
			int sigunguNo = Integer.parseInt(multi.getParameter("sigunguNo"));
			String status = multi.getParameter("status") == null ? "N" : multi.getParameter("status");
			int mtoNo = Integer.parseInt(multi.getParameter("mtoNo"));
			int subCategoryNo = Integer.parseInt(multi.getParameter("subCategoryNo"));
			
			if (ptfNo == 0) {
				new Portfolio();
				Portfolio p = Portfolio.builder().introduce(introduce).ptfContent(ptfContent).sigunguNo(sigunguNo)
						.status(status).mtoNo(mtoNo).subCategoryNo(subCategoryNo).build();
				ArrayList<Attachment> list = new ArrayList<Attachment>();
				Map<String, Object> map = new HashMap<String, Object>();
				
				for (int i = 0; i < 9; i++) {
					String key = "file" + i;
					if (multi.getOriginalFileName(key) != null) {
						new Attachment();
						Attachment at = Attachment.builder().originName(multi.getOriginalFileName(key))
								.changeName(multi.getFilesystemName(key)).filePath("resources/portfolio_upfiles/").fileType(2).build();
						if(i == 0) {
							at.setFileLevel(1);
						} else {
							at.setFileLevel(2);
						}
						list.add(at);
					}
					map.put("list", list);
				}
				result = service.insertPortfolio(p, map);
			} else {
				new Portfolio();
				Portfolio p = Portfolio.builder().introduce(introduce).ptfContent(ptfContent).sigunguNo(sigunguNo)
						.status(status).mtoNo(mtoNo).subCategoryNo(subCategoryNo).ptfNo(ptfNo).build();

				ArrayList<Attachment> existingList = new ArrayList<Attachment>();
				ArrayList<Attachment> newList = new ArrayList<Attachment>();
				Map<String, Object> map = new HashMap<String, Object>();
				
				for (int i = 0; i < 9; i++) {
					String key = "file" + i;
					String keyNo = "fileNo" + i;
					String keyName = "fileName" + i;
					String keyChangeName = "fileChangeName" + i;
					
					if(multi.getParameter(keyNo) != null) {
						new Attachment();
						Attachment at1 = Attachment.builder().originName(multi.getParameter(keyName))
						.filePath(savePath).refBno(ptfNo).fileNo(Integer.parseInt(multi.getParameter(keyNo))).build();
						if(multi.getOriginalFileName(key) != null) {
							at1.setOriginName(multi.getOriginalFileName(key));
						} else {
							at1.setOriginName(multi.getParameter(keyName));
						}
						if(multi.getFilesystemName(key) != null) {
							at1.setChangeName(multi.getFilesystemName(key));
						} else {
							at1.setChangeName(multi.getParameter(keyChangeName));
						}
						if(i == 0) {
							at1.setFileLevel(1);
						} else {
							at1.setFileLevel(2);
						}
						existingList.add(at1);
						new File(savePath+multi.getParameter(keyName)).delete();
						
					} else if (multi.getOriginalFileName(key) != null) {
						new Attachment();
						Attachment at2 = Attachment.builder().originName(multi.getOriginalFileName(key))
								.changeName(multi.getFilesystemName(key)).filePath("resources/portfolio_upfiles/").refBno(ptfNo).fileType(2).build();
						if(i == 0) {
							at2.setFileLevel(1);
						} else {
							at2.setFileLevel(2);
						}
						newList.add(at2);
					}
					map.put("existingList", existingList);
					map.put("newList", newList);
				}
				result = service.updatePortfolio(p, map);
			}
			if (result > 0 && ptfNo == 0) {
				request.setAttribute("alertMsg", "등록이 성공적으로 완료되었습니다");
			} else if (result > 0 && ptfNo != 0) {
				request.setAttribute("alertMsg", "수정이 성공적으로 완료되었습니다");
			} else if (result <= 0 && ptfNo == 0) {
				request.setAttribute("alertMsg", "등록에 실패했습니다");
			} else {
				request.setAttribute("alertMsg", "수정에 실패했습니다");
			}
			response.sendRedirect(request.getContextPath()+"/mentorMypage?boardNo=1");
		}
	}
}