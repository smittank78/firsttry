

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet  
{
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			String email = request.getParameter("email");
			String pass = request.getParameter("password");
			
	   
			System.out.println(email  + " ::     ::   " + pass + "          " );
			loginBean bean = new loginBean();
			bean.setEmail(email);
			bean.setPass(pass);
			HttpSession session = request.getSession();
			session.setAttribute("Email", email);
			session.setAttribute("Pass", pass);
			System.out.println("login --> " +"session id : " + request.getRequestedSessionId());
			PrintWriter ot = response.getWriter();
		
		
				if(new loginDao().login(bean))
				{
					System.out.println("data inserted");
					request.getRequestDispatcher("sucess.jsp").forward(request, response);
				}
				else
				{
					ot.println("data not inserted");
					response.sendRedirect("logn.jsp");
				}
		
		}
	}