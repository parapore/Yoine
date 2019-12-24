package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Yoine;
import model.YoineLogic;

/**
 * Servlet implementation class YoineServlet
 */
@WebServlet("/YoineServlet")
public class YoineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public YoineServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 初回起動かどうかを判定するための処理
		// アプリケーションスコープから値を取得
		ServletContext sc = this.getServletContext();
		Yoine y = (Yoine) sc.getAttribute("yoine");

		// 初回起動判定の続き
		// アプリケーションスコープに値がなければnewする
		if(y == null) {
			y = new Yoine();
			sc.setAttribute("yoine", y);
		}

		// リクエストパラメーターの取得
			request.setCharacterEncoding("UTF-8");
			String yoine = request.getParameter("action");


		// いいねボタン押されたら
		if (yoine != null) {

			// YoineLogicでいいねを加算
			YoineLogic yl = new YoineLogic();
			yl.yoinePlus(y);

			// いいねの数をアプリケーションスコープに保存
			sc.setAttribute("yoine", y);
		}

		// フォワード
		RequestDispatcher rd = request.getRequestDispatcher("/yoineView.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
