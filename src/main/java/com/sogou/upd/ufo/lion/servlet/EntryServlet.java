package com.sogou.upd.ufo.lion.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import com.sogou.upd.ufo.lion.Application;
import com.sogou.upd.ufo.lion.Config;
import com.sogou.upd.ufo.lion.template.Template;
import com.sogou.upd.ufo.lion.utils.*;

/**
 * Handle *.ut
 * 
 * @author yinyong
 * 
 */
public final class EntryServlet extends HttpServlet {

	private Template template;

	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		super.init();
		template = Application.getInstance().getTemplate();
	}

	/**
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void doUt(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/html;charset="
				+ (String) Config.getInstance().get(Config.KEY_CHARSET));
		PrintWriter out = resp.getWriter();
		String url = req.getRequestURI();
		String token = url.replaceFirst("\\.ut$", "");
		try {
			Gson gson = new Gson();
			Map<String, Object> data = gson.fromJson(
					Utils.getFileContent(
							Application.WD_DATA_DIR + token + ".json",
							(String) Config.getInstance().get(
									Config.KEY_CHARSET)),
					new TypeToken<Map<String, Object>>() {
					}.getType());
			out.print(template.render(token + Application.TPL_EXT, data));
		} catch (Exception e) {
			resp.sendError(500, e.getMessage());
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doUt(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doUt(req, resp);
	}

}
