package cn.itcast.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SysInitServlet
 */
public class SysInitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override
    public void init() throws ServletException {
    	Map<String,Object> sysParam = new HashMap<String,Object>();

        Map<String,String> supType = new HashMap<String,String>();
        //��������ЩӦ�ô����ݿ����������servletӦ�øĳ�action
        supType.put("3", "������Ӧ��");
        supType.put("2", "һ����Ӧ��");
        supType.put("1", "��ͨ��Ӧ��");
        
        
        
        Map<String,String> goodsColor = new HashMap<String,String>();
        goodsColor.put("red", "��ɫ");
        goodsColor.put("green", "��ɫ");
        goodsColor.put("blue", "��ɫ");   
        
        sysParam.put("goodsColor", goodsColor);
        sysParam.put("supType", supType);
        ServletContext application =this.getServletContext();
        application.setAttribute("sysParam",sysParam);
    }   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SysInitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
