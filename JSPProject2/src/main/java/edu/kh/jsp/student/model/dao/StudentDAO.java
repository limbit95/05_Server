package edu.kh.jsp.student.model.dao;

import static edu.kh.jsp.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jsp.common.JDBCTemplate;
import edu.kh.jsp.student.model.dto.Student;

public class StudentDAO {

	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public StudentDAO(){
		try {
			prop = new Properties();
			String filePath = StudentDAO.class.getResource("/edu/kh/jsp/sql/student-sql.xml").getPath();
			prop.loadFromXML( new FileInputStream(filePath));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	/** 전체 학생 조회 SQL 수행 DAO
	 * @return
	 */
	public List<Student> selectAll(Connection conn) throws Exception{
		List<Student> stdList = new ArrayList<Student>();
		
		try {
			String sql = prop.getProperty("selectAll");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Student std = new Student();
				
				std.setStudentNo(rs.getString("STUDENT_NO"));
				std.setStudentName(rs.getString("STUDENT_NAME"));
				std.setStudentAddress(rs.getString("STUDENT_ADDRESS"));
				std.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
				
				stdList.add(std);
			}
		}finally {
			close(rs);
			close(stmt);
		}
		
		return stdList;
	}

	/** 건축공학과 학생만 조회
	 * @param conn
	 * @return
	 */
	public List<Student> selectArch(Connection conn) throws Exception{
		List<Student> archList = new ArrayList<Student>();
		
		try {
			String sql = prop.getProperty("selectArch");
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Student std = new Student();
				
				std.setStudentNo(rs.getString("STUDENT_NO"));
				std.setStudentName(rs.getString("STUDENT_NAME"));
				std.setStudentAddress(rs.getString("STUDENT_ADDRESS"));
				std.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
				
				archList.add(std);
			}
		}finally {
			close(rs);
			close(stmt);
		}
		
		return archList;
	}

	/**입력받은 학과의 학생만 조회
	 * @param conn
	 * @param select
	 * @return
	 */
	public List<Student> selectOne(Connection conn, String deptName) throws Exception{
		List<Student> selectOneList = new ArrayList<Student>();
		
		try {
			String sql = prop.getProperty("selectOne");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, deptName);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Student std = new Student();
				
				std.setStudentNo(rs.getString("STUDENT_NO"));
				std.setStudentName(rs.getString("STUDENT_NAME"));
				std.setStudentAddress(rs.getString("STUDENT_ADDRESS"));
				std.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
				
				selectOneList.add(std);
			}
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return selectOneList;
	}
	
	
	
}