package com.sogou.upd.ufo.lion.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sogou.upd.ufo.lion.Config;
import com.sogou.upd.ufo.lion.utils.Utils;
/**
 * 
 * @author yinyong
 *
 */
public class DataServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	private void doData(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		String path=req.getRequestURI();
		String jsonPath=path.replaceFirst("\\.data$",".json");
		resp.setContentType("text/json;charset=utf-8");
		resp.getWriter().print(Utils.getFileContent(Config.WD_DATA_DIR+jsonPath));
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doData(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doData(req, resp);
	}

	@Override
	public void init() throws ServletException {
		super.init();
	}

}
