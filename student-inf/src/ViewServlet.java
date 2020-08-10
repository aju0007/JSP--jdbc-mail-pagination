

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aju.retriver;
import com.aju.retriverSet;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String spageid=request.getParameter("page"); 
		int pageid=Integer.parseInt(spageid);
		int total=5;
		if(pageid==1) {}else {
			pageid=pageid-1;
			pageid=pageid*total+1;
		}
		List<retriverSet> list= retriver.getRecords(pageid, total);
		out.print("<h1> Page No:"+spageid+"</h1>");
		out.print("<table border='1' cellpadding='4' width='60%'>");
		out.print("<tr><th>Id</th><th>First Name</th><th>Last Name</th><th>email</th><th>phone</th><th>Address</th></tr>");
	/*	for(int i=0;i<list.size();i++) {*/
		for(retriverSet e:list) {
			out.print("<tr><td>"+e.getStudent_id()+"</td><td>"+e.getFirstname()+"</td><td>"+e.getSecondname()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPhone()+"</td><td>"+e.getAddress()+"</td></tr>");
		}out.print("</table>");
			out.print("<a href='ViewServlet?page=1'>1</a>");
			out.print("<a href='ViewServlet?page=2'>2</a>");
			out.print("<a href='ViewServlet?page=3'>3</a>");
			out.print("<a href='ViewServlet?page=3'>4</a>");
			
			out.close(); 
			
		}
		/*out.close();*/
	//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
