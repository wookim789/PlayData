package svc;

import vo.MemberBean;
import static db.JdbcUtil.*;
import java.sql.Connection;
import dao.MemberDAO;

public class MemberViewService {

	public MemberBean getMember(String viewId) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		MemberBean member = memberDAO.selectMember(viewId);
		close(con);
		return member;
	}

}
