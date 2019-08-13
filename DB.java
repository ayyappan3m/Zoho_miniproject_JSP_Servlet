package student;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DB {
	private Statement stmt;
	public DB()
	{
		try 
		{
		
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/STUDENT","root","");    
			stmt=con.createStatement();  
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	public boolean insert(String name,String dept)
	{
		
		try 
		{
			String sql = "INSERT INTO student_details(name,dept) VALUES('"+name+"','"+dept+"')";
			stmt.executeUpdate(sql);
			return true;
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return false;
	}
	// display and reset is same
	public List<Student> display()
	{
		List<Student> list = new ArrayList<Student>();
		try
		{
			String sql = "SELECT * FROM student_details";
			ResultSet rs = stmt.executeQuery(sql); 
			while(rs.next())
			{
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setDept(rs.getString(3));
				list.add(s);				
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return list;
	}
	/*
	0 --- no
	1 --- asc
	2 --- desc
	*/
	public List<Student> sort(int id,int name,int dept)
	{
		List<Student> list = new ArrayList<Student>();
		String sql = "SELECT * FROM student_details";
		try
		{
			if(id != 0)
			{
				if(id == 1)
				{
					sql = "SELECT * FROM student_details ORDER BY id ASC";
				}
				else
				{
					sql = "SELECT * FROM student_details ORDER BY id DESC";
				}
			}
			else if(name != 0)
			{
				if(name == 1)
				{
					sql = "SELECT * FROM student_details ORDER BY name ASC";
				}
				else
				{
					sql = "SELECT * FROM student_details ORDER BY name DESC";
				}
			}
			else if(dept != 0)
			{
				if(dept == 1)
				{
					sql = "SELECT * FROM student_details ORDER BY dept ASC";
				}
				else
				{
					sql = "SELECT * FROM student_details ORDER BY dept DESC";
				}
			}
			
			ResultSet rs = stmt.executeQuery(sql); 
			while(rs.next())
			{
				Student s = new Student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setDept(rs.getString(3));
				list.add(s);				
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return list;
	}
	public boolean update(int id,String name,String dept)
	{
		
		try 
		{
			String sql = "UPDATE student_details SET name = '"+name+"',dept = '"+dept+"' where id = "+id;
			stmt.executeUpdate(sql);
			return true;
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return false;
	}
	public boolean delete(int id)
	{
		
		try 
		{
			String sql = "DELETE FROM student_details WHERE id = "+id;
			stmt.executeUpdate(sql);
			return true;
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return false;
	}
}
