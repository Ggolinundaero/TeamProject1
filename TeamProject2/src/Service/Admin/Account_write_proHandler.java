package Service.Admin;

import java.io.PrintStream;

import org.omg.CORBA.ORB;

import com.sun.corba.se.impl.activation.CommandHandler;

import model.board.BoardDAO;
import model.board.BoardVO;

public class Account_write_proHandler implements CommandHandler {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void printCommandHelp(PrintStream out, boolean helpType) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean processCommand(String[] cmd, ORB orb, PrintStream out) {
		// TODO Auto-generated method stub
		return false;
	}

	
	request.setCharacterEncoding("utf-8");
	BoardVO vo = new BoardVO();
	vo.setName(request.getParameter("name"));
	vo.setEmail(request.getParameter("email"));
	vo.setSubject(request.getParameter("subject"));
	vo.setContents(request.getParameter("contents"));
	vo.setPass(request.getParameter("pass"));
int page = Integer.parseInt(request.getParameter("page"));
	BoardDAO dao = BoardDAO.getInstance();
	int row = dao.boardInsert(vo);
	request.setAttribute("row", row);
	request.setAttribute("page", page);
	
	return "/Board/board_write_pro2.jsp";
}
