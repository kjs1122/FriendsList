package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.FriendsVO;

import util.DBManager;

public class FriendsDAO {

	private FriendsDAO() {
		
	}
	
	private static FriendsDAO instance = new FriendsDAO();
	
	public static FriendsDAO getInstance() {
		return instance;
	}
	
	public int getListCount() {
		String sql = "select count(*) from friends";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int listCount = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return listCount;
	}
	
	public List<FriendsVO> selectFriendsPage(int page, int limit){
		String sql =" select * from(select rownum as rnum,a.* from (select * from friends order by birth asc) a) where rnum between ? and ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FriendsVO> list = new ArrayList<FriendsVO>();
		
		int startRow = (page - 1) * 10 + 1;
		int endRow = startRow + limit - 1;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FriendsVO fVo = new FriendsVO();
				fVo.setName(rs.getString("name"));
				fVo.setAge(rs.getInt("age"));
				fVo.setGender(rs.getString("gender"));
				fVo.setJob(rs.getString("job"));
				fVo.setRelation(rs.getString("relation"));
				fVo.setBirth(rs.getString("birth"));
				fVo.setPhone(rs.getString("phone"));
				fVo.setPicture(rs.getString("picture"));
				fVo.setGirlfriend(rs.getString("girlfriend"));
				list.add(fVo);		
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
		
	}
	
	public List<FriendsVO> selectFreinds() {
		List<FriendsVO> list = new ArrayList<FriendsVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from friends";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				FriendsVO fVo = new FriendsVO();
				fVo.setName(rs.getString("name"));
				fVo.setAge(rs.getInt("age"));
				fVo.setGender(rs.getString("gender"));
				fVo.setJob(rs.getString("job"));
				fVo.setRelation(rs.getString("relation"));
				fVo.setBirth(rs.getString("birth"));
				fVo.setPhone(rs.getString("phone"));
				fVo.setPicture(rs.getString("picture"));
				fVo.setGirlfriend(rs.getString("girlfriend"));
				list.add(fVo);		
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
	public FriendsVO selectFriendsByName(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from friends where name = ?";
		FriendsVO fVo = new FriendsVO();
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				fVo.setName(rs.getString("name"));
				fVo.setAge(rs.getInt("age"));
				fVo.setGender(rs.getString("gender"));
				fVo.setJob(rs.getString("job"));
				fVo.setRelation(rs.getString("relation"));
				fVo.setBirth(rs.getString("birth"));
				fVo.setPhone(rs.getString("phone"));
				fVo.setPicture(rs.getString("picture"));
				fVo.setGirlfriend(rs.getString("girlfriend"));		
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return fVo;
	}
	
	public void insertFriends(FriendsVO fVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into friends values(?,?,?,?,?,?,?,?,?)";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fVo.getName());
			pstmt.setInt(2, fVo.getAge());
			pstmt.setString(3, fVo.getGender());
			pstmt.setString(4, fVo.getRelation());
			pstmt.setString(5, fVo.getJob());
			pstmt.setString(6, fVo.getBirth());
			pstmt.setString(7, fVo.getPhone());
			pstmt.setString(8, fVo.getPicture());
			pstmt.setString(9, fVo.getGirlfriend());
			pstmt.executeUpdate();
			
			System.out.println(fVo.getBirth());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	public void updateFriends(FriendsVO fVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update friends set "
					+ "name=?,age=?,gender=?,relation=?,job=?,birth=?,phone=?,picture=?,girlfriend=? where name=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fVo.getName());
			pstmt.setInt(2, fVo.getAge());
			pstmt.setString(3, fVo.getGender());
			pstmt.setString(4, fVo.getRelation());
			pstmt.setString(5, fVo.getJob());
			pstmt.setString(6, fVo.getBirth());
			pstmt.setString(7, fVo.getPhone());
			pstmt.setString(8, fVo.getPicture());
			pstmt.setString(9, fVo.getGirlfriend());
			pstmt.setString(10, fVo.getName());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	public void deleteFriends(String name) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete friends where name=?";
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	
	

}
