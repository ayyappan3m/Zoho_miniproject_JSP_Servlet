package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.DB;
import database.Student;
/**
 * Servlet implementation class ViewHandler
 */
@WebServlet("/ViewHandler")
public class ViewHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public  void  init()  throws  ServletException{
        
	}

	public ViewHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<h1>doGet-viewHandler.java</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("doPost-viewHandler.java");
		List<Student> list;
		DB db = new DB();
		list = db.display();
		StringBuilder sb = new StringBuilder();
		for(Student st : list)
		{
			sb.append("<tr>")
			.append("<td>").append(st.getId()).append("</td>")
			.append("<td>").append(st.getName()).append("</td>")
			.append("<td>").append(st.getDept()).append("</td>")			
			.append("</tr>");
		}
		request.setAttribute("table", sb.toString());
        getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
	}

}
