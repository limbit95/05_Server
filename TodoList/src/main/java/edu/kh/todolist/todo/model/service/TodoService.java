package edu.kh.todolist.todo.model.service;

import edu.kh.todolist.todo.model.dao.TodoDAO;
import edu.kh.todolist.todo.model.dto.Todo;

import static edu.kh.todolist.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

public class TodoService {

	private TodoDAO dao = new TodoDAO();

	/** 로그인한 회원이 등록한 todoList 전체 조회 서비스
	 * @param memberNo
	 * @return
	 */
	public List<Todo> selectAll(int memberNo) throws Exception{
		Connection conn = getConnection();
		
		List<Todo> todoList = dao.selectAll(conn, memberNo);
		
		close(conn);
		
		return todoList;
	}
	
	
	
}