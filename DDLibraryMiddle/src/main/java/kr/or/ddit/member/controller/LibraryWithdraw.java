package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;


@WebServlet("/member/LibraryWithdraw.do")
public class LibraryWithdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LibraryWithdraw() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		
		String userid = request.getParameter("userName");
		String pass = request.getParameter("userPassword");
		
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(userid);
		memVo.setMem_pw(pass);
		
		
		IMemberService service = MemberServiceImpl.getInstance();
		int deleteMemVo = service.deleteMember(memVo);
		
		HttpSession session = request.getSession();
		request.setAttribute("deleteMemVo", deleteMemVo);
		request.getRequestDispatcher("/member/delete_ok.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
