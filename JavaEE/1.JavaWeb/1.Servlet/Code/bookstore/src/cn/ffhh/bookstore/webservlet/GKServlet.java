package cn.ffhh.bookstore.webservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GKServlet
 */
@WebServlet("/GKServlet")
public class GKServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Integer[] score2018 =  new Integer[] {403,365,334,200};
	private final Integer[] score2017 =  new Integer[] {391,356,328,200};
	private final Integer[] score2016 =  new Integer[] {416,380,353,200};
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GKServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/jsps/gk/gk.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String year = request.getParameter("year");
		String pici = request.getParameter("pici");
		String highI = request.getParameter("high");
		String lowI = request.getParameter("low");
		String avgI = request.getParameter("avg");
		if(year.equals("2018")) {
			Integer high = Integer.valueOf(highI)-this.score2018[Integer.valueOf(pici)];
			System.out.println(high);
			Integer low = Integer.valueOf(lowI)-this.score2018[Integer.valueOf(pici)];
			Integer avg = Integer.valueOf(avgI)-this.score2018[Integer.valueOf(pici)];
			Score score =new Score(high,low,avg);
			request.setAttribute("score", score);
		}
		if(year.equals("2017")) {
			Integer high = Integer.valueOf(highI)-this.score2017[Integer.valueOf(pici)];
			System.out.println(high);
			Integer low = Integer.valueOf(lowI)-this.score2017[Integer.valueOf(pici)];
			Integer avg = Integer.valueOf(avgI)-this.score2017[Integer.valueOf(pici)];
			Score score =new Score(high,low,avg);
			request.setAttribute("score", score);
		}
		if(year.equals("2016")) {
			Integer high = Integer.valueOf(highI)-this.score2016[Integer.valueOf(pici)];
			System.out.println(high);
			Integer low = Integer.valueOf(lowI)-this.score2016[Integer.valueOf(pici)];
			Integer avg = Integer.valueOf(avgI)-this.score2016[Integer.valueOf(pici)];
			Score score =new Score(high,low,avg);
			request.setAttribute("score", score);
		}
		request.getRequestDispatcher("/WEB-INF/jsps/gk/gk.jsp").forward(request, response);
	}


}
