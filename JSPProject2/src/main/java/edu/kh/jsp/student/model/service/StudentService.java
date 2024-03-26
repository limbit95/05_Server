package edu.kh.jsp.student.model.service;

import static edu.kh.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp.student.model.dao.StudentDAO;
import edu.kh.jsp.student.model.dto.Student;

public class StudentService {

	private StudentDAO dao = new StudentDAO();
	
	/** 전체 학생 조회 service
	 * @return
	 */
	public List<Student> selectAll() throws Exception{
		Connection conn = getConnection();
		
		List<Student> stdList = dao.selectAll(conn);
		
		close(conn);
		
		return stdList;
	}
 
	/** 건축공학과 학생만 조회
	 * @param select 
	 * @return
	 */
	public List<Student> selectArch() throws Exception{
		Connection conn = getConnection();
		
		List<Student> archList = dao.selectArch(conn);
		
		close(conn);
		
		return archList;
	}

	/** 입력받은 학과의 학생만 조회
	 * @param select
	 * @return
	 */
	public List<Student> selectOne(String deptName) throws Exception{
		Connection conn = getConnection();
		
		List<Student> selectOneList = dao.selectOne(conn, deptName);
		
		close(conn);
		
		return selectOneList;
	}
	
	
	
}