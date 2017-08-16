package dao;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;



import bean.UserBean;
//import config.MyConnection;

public class UserDao {
	private DataSource dataSource;
	
	public UserDao(DataSource theDataSource){
		dataSource = theDataSource;
	}
	
	public int createUser(UserBean ub){
		int i = 0;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement("insert into usersprac values(?,?,?,?)");
			Blob bl = con.createBlob();
			bl.setBytes(1, ub.getLang().getBytes());
			ps.setString(1, ub.getUname());
			ps.setString(2, ub.getPass());
			ps.setString(3, ub.getQuali());
			ps.setBlob(4, bl);
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return i;
	}
	
	public List<UserBean> getUsers() throws Exception {
		
		List<UserBean> users = new ArrayList<>();
		
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "SELECT * FROM usersprac order by name";
			
			con = dataSource.getConnection();
			stat = con.createStatement();
			rs = stat.executeQuery(sql);
			
			while(rs.next()){
				String name = rs.getString("name");
				String pass = rs.getString("password");
				String quali = rs.getString("qualification");
				String lang = rs.getString("language");
				
				UserBean tempBean = new UserBean();
				tempBean.setUname(name);
				tempBean.setPass(pass);
				tempBean.setQuali(quali);
				tempBean.setLang(lang);
				
				users.add(tempBean);
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		} finally {
			try {
				con.close();
				stat.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return users;
	}
	
	public void deleteUser(String name){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "delete from usersprac where name=?";
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return;
	}
	
	public void updateUser(UserBean ub, String upName){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "update usersprac set name=?, password=?,qualification=?,language=? where name=?";
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			Blob bl = con.createBlob();
			bl.setBytes(1, ub.getLang().getBytes());
			ps.setString(1, ub.getUname());
			ps.setString(2, ub.getPass());
			ps.setString(3, ub.getQuali());
			ps.setBlob(4, bl);
			ps.setString(5, upName);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return;
	}
	
	public boolean validateUser(String uname, String pass) {
		boolean val = false;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from usersprac where name=? and password=?";
		try {

			String name ="";
			String password="";
			
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			
			if(rs.next())
				return true;
			else
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally{
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public boolean updatePass(UserBean ub, String oldPass){
		boolean val = false;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "update usersprac set password=? where name=? and password=?";
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setString(1, ub.getPass());
			ps.setString(2, ub.getUname());
			ps.setString(3, oldPass);
			
			int i = ps.executeUpdate();
			
			if(i>0){
				val = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return val;
	}
}
