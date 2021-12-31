package dao;

import java.sql.*;
import java.util.*;

import model.FormBean;
import utility.DBConnection;

public class FormDao 
{
	public void addUser(FormBean user)
	{
		Connection con=DBConnection.getConnection();
		try
		{
			String query="INSERT INTO contactsimple(username, email, msg) VALUES (?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, user.getUname());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getMsg());
			pstmt.executeUpdate();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	public List getUser()
	{
		List ls=new ArrayList();
		Connection con=DBConnection.getConnection();
		try
		{
			String query="SELECT id, username, email, msg FROM contactsimple";
			PreparedStatement pstmt=con.prepareStatement(query);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				FormBean b=new FormBean();
				b.setId(rs.getString("id"));
				b.setUname(rs.getString("username"));
				b.setEmail(rs.getString("email"));
				b.setMsg(rs.getString("msg"));
				ls.add(b);
			}
		}
		catch (Exception e) 
		{
			
		}
		return ls;
	}
	public int deleteUser(int id)
	{
		
		Connection con=DBConnection.getConnection();
		String query="DELETE FROM contactsimple WHERE id=?";
		int status=0;
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, id);
			status=pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return status;
	}
	public FormBean getUserbyID(int id)
	{
		FormBean b=new FormBean();
		Connection con=DBConnection.getConnection();
		String query="SELECT * FROM contactsimple WHERE id=?";
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				b.setId(rs.getString("id"));
				b.setUname(rs.getString("username"));
				b.setEmail(rs.getString("email"));
				b.setMsg(rs.getString("msg"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return b;
	}
	public int updateUser(FormBean s)
	{
		int status=0;
		Connection con=DBConnection.getConnection();
		String query="UPDATE contactsimple SET username=?,email=?,msg=? WHERE id=?";
		try {
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, s.getUname());
			pstmt.setString(2, s.getEmail());
			pstmt.setString(3, s.getMsg());
			pstmt.setInt(4, Integer.parseInt(s.getId()));
			status= pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		
		return status;
	}
}
