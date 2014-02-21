package com.sogou.upd.ufo.lion;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sogou.upd.ufo.lion.utils.FileWalker;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

/**
 * 
 * @author yinyong
 * 
 */
public final class Manager {

	private FreemarkerTemplate template;
	/**
	 * 
	 * @throws Exception
	 */
	public Manager() throws Exception {
		template = new FreemarkerTemplate();
		template.init(Config.MG_TPL_DIR);
	}

	/**
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void serveIndex(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		PrintWriter out = resp.getWriter();
		Map<String, Object> data = new HashMap<String, Object>();
		FileWalker fw = new FileWalker(Config.WD_TPL_DIR,".ftl");
		String[] empty = {};//TODO
		data.put("tpls", fw.getRelFilesWithoutExt());
		data.put("module_tpls", empty);
		data.put("common_tpls", empty);
		try {
			out.print(template.render("index.ftl", data));
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500, e.getMessage());
		}
	}

	/**
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void serveStatic(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		PrintWriter out = resp.getWriter();
		out.print(req.getRequestURI());
	}

	/**
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void serveHelp(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		PrintWriter out = resp.getWriter();
		out.print(req.getRequestURI());
	}
}
