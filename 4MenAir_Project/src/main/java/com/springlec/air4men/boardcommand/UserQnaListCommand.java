package com.springlec.air4men.boardcommand;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.springlec.air4men.command.BCommand;
import com.springlec.air4men.dao.BoardDao;
import com.springlec.air4men.dto.BoardDto;

public class UserQnaListCommand implements BCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String userId=request.getParameter("userId");
		
		
		BoardDao dao=sqlSession.getMapper(BoardDao.class);
		ArrayList<BoardDto> dtos=dao.list(userId);
		model.addAttribute("list", dtos);

	}

}
