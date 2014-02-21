package com.sogou.upd.ufo.lion;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Handle *.ut
 * 
 * @author yinyong
 * 
 */
public final class EntryServlet extends HttpServlet {

	private Template template;

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param filename
	 * @return
	 */
	private static String getFileContent(String filename) {
		StringBuffer content = new StringBuffer();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				content.append(line);
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			return "";
		} catch (IOException e) {
			return "";
		} finally {
			try {
				br.close();
				fr.close();
			} catch (Exception ex) {
			}
		}

		return content.toString();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		template = new FreemarkerTemplate();
		try {
			template.init(Config.WD_TPL_DIR);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void doUt(HttpServletRequest req, HttpServletResponse resp) throws IOException{
  		resp.setContentType("text/html;charset=utf-8");
  		PrintWriter out = resp.getWriter();
  		String url=req.getRequestURI();
  		String token=url.replaceFirst("\\.ut$", "");
  		try{
  			Gson gson=new Gson();
  			Map<String,Object> data=gson.fromJson(getFileContent(Config.WD_DATA_DIR+token+".json"),new TypeToken<Map<String,Object>>() {}.getType());
  			out.print(template.render(token+".ftl", data));
  		}catch(Exception e){
  			resp.sendError(500, e.getMessage());
  			e.printStackTrace();
  		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doUt(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doUt(req,resp);
	}

}
