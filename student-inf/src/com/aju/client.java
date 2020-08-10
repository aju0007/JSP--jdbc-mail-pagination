package com.aju;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class client
 */
@WebServlet("/client")
public class client extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public client() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		student obj=new student();
		String fname=request.getParameter("firstname");
		String lname=request.getParameter("lastname");
		String emai_l=request.getParameter("email");
		String phon_e=request.getParameter("phone");
		String password=request.getParameter("pass");
		String repassword=request.getParameter("repass");
		String addres_s=request.getParameter("address");
			obj.setFname(fname);
			obj.setLname(lname);
			obj.setAddres_s(addres_s);
			obj.setEmai_l(emai_l);
			obj.setPassword(repassword);
			obj.setPhon_e(phon_e);
	
		
		
		registerstudent registerstudentobj = new registerstudent();
		registerstudentobj.register(obj);
		retriver retriverObj=new retriver();
		//retriverObj.retrive();
		doGet(request, response);
	}

}
