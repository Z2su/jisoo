package com.spring.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.spring.dto.NoticeAttachVO;

public class NoticeAttachDAOImpl implements NoticeAttachDAO{	
	
	private SqlSession session;
	public void setSession(SqlSession session) {
		this.session=session;
	}
	
	@Override
	public void insertAttach(NoticeAttachVO attach) throws SQLException {
		session.update("Attach-Mapper.insertAttach",attach);
	}

	@Override
	public void deleteAttach(int nano) throws SQLException {
		session.update("Attach-Mapper.deleteAttach",nano);		
		
	}

	@Override
	public List<NoticeAttachVO> selectAttachesByNno(int nno) throws SQLException {
		List<NoticeAttachVO> attachList=
				session.selectList("Attach-Mapper.selectAttachByNano",nno);
		return attachList;
	}

	@Override
	public void deleteAllAttach(int nno) throws SQLException {
		session.update("Attach-Mapper.deleteAllAttach",nno);		
	}
	@Override
	public NoticeAttachVO selectAttachByNano(int nano) throws SQLException {
		NoticeAttachVO attach=
			session.selectOne("Attach-Mapper.selectAttachByAno",nano);
		
		return attach;
	}

}
