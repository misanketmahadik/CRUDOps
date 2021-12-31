package servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FormDao;
import model.FormBean;

@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("In Get Update Servelt");

		int id = Integer.parseInt(request.getParameter("id"));
		FormDao d=new FormDao();
		FormBean b=d.getUserbyID(id);
		if(b!=null)
		{
			request.setAttribute("data", b);
			RequestDispatcher rd=request.getRequestDispatcher("Update.jsp");
			rd.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("In Post Update Servelt");
		FormBean b=new FormBean();
		b.setId(request.getParameter("id"));
		b.setEmail(request.getParameter("email"));
		b.setUname(request.getParameter("uname"));
		b.setMsg(request.getParameter("msg"));
		FormDao d=new FormDao();
		int status=d.updateUser(b);
		if(status!=0)
		{
			request.setAttribute("success", "Updated SuccessFully...");
			RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
			rd.include(request, response);
		}
		else
		{
			request.setAttribute("failed", "Updation Failed...");
			RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
			rd.include(request, response);
		}




	}

}
