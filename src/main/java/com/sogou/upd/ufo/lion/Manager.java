package com.sogou.upd.ufo.lion;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sogou.upd.ufo.lion.template.FreemarkerTemplate;
import com.sogou.upd.ufo.lion.utils.FileWalker;

/**
 * System management
 * 
 * @author yinyong
 * @since 1.0.0
 * @version 1.0.0
 */
public final class Manager {

	private FreemarkerTemplate template;

	/**
	 * 
	 * @throws Exception
	 */
	public Manager() throws Exception {
		template = new FreemarkerTemplate();
		template.init(Application.MG_TPL_DIR);
	}

	/**
	 * Show templates list.
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void serveIndex(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		PrintWriter out = resp.getWriter();
		Map<String, Object> data = new HashMap<String, Object>();
		FileWalker fw = new FileWalker(Application.WD_TPL_DIR,
				Application.TPL_EXT);
		data.put("tpls", fw.getRelFilesWithoutExt());
		try {
			out.print(template.render("index.ftl", data));
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500, e.getMessage());
		}
	}

	/**
	 * Show static resources(images,javascript,css).
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void serveStatic(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		PrintWriter out = resp.getWriter();
		Map<String, Object> data = new HashMap<String, Object>();
		FileWalker fw = new FileWalker(Application.WD_CSS_DIR, ".css");
		data.put("css", fw.getRelFiles());
		fw = new FileWalker(Application.WD_IMG_DIR, ".png,.gif,.bmp,.jpg");
		data.put("img", fw.getRelFiles());
		fw = new FileWalker(Application.WD_JS_DIR, ".js");
		data.put("js", fw.getRelFiles());
		try {
			out.print(template.render("static.ftl", data));
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500, e.getMessage());
		}
	}

	/**
	 * Show help.
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	public void serveHelp(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.sendRedirect("/");
	}
}
