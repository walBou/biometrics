package com.mnice;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.ResultSetMetaData;

import org.apache.derby.drda.NetworkServerControl;

public class Db {
	static Connection conn;
	private String framework = "embedded";
	private String protocol = "jdbc:derby:";
	String dbName = "JavaDB";
    PreparedStatement psInsert;
    PreparedStatement psUpdate;
    Statement s;
    ResultSet rs = null;
    Connection cn2 = connect("mysql");
    static Db db = new Db();
	static Connection cn = db.cn();
   

	public static void main(String[] args) {
		///db.populate("STAFF");

	}
	
	public void test2() {
		///db.create("STAFF");
		//db.addStaff(db.staff());
		///db.populate("STAFF");
		/**
		try {
			ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM ADMIN.STAFF"); //rs.next();
			while(rs.next()) {
				System.out.println(rs.getInt(1));
			}
		} catch (Exception e) { System.out.println(e); }
		*/
		//
		//
		
		///
		
		///
		

		
		//
		/**
		Object oo[][] = db.getData("STAFF");
		//System.out.println(oo.length);
		for(int i=0;i<5;i++) {
			///try { System.out.println(oo[i][4].toString()); } catch(Exception e) {}
			
		}
		for(Object[] st : oo) {
			//System.out.println(oo[1][1]);
		}
		
		//System.out.println(oo[0][1]);
		
		*/
		//System.out.println(db.records("STAFF"));
	}
	
	public Staff staff() {
		String fullname = "Test Two";
		String companyno = "123456";
		String designation = "Programmer";
		String mobileno = "6010202020";
		String gender = "Male";
		String dob = "1980-07-06";
		String email = "auwal@gmail.com";
		String address = "Bukit Jalil";
		String datereg = "2014-09-14";
		
		Staff staff = new Staff();
		staff.setFullname(fullname);
		staff.setCompanyno(companyno);
		staff.setDesignation(designation);
		staff.setMobileno(mobileno);
		staff.setGender(gender);
		staff.setDob(dob);
		staff.setEmail(email);
		staff.setAddress(address);
		staff.setDatereg(datereg);
		return staff;
	}
	public void populate(String table) {
		db.drop("STAFF");
		db.create("STAFF");
		String[] names = {"Auwal One","Sani Two","Salisu There","Rabiu Four","Khamisu Five"};
		for(String name: names) {
			String username = "auwal";
			String password = "awual";
			String fullname = name;
			String companyno = "123456";
			String designation = "Programmer";
			String mobileno = "6010202020";
			String gender = "Male";
			String dob = "1980-07-06";
			String email = "auwal@gmail.com";
			String address = "Bukit Jalil";
			String datereg = "2014-09-14";
			
			Staff staff = new Staff();
			staff.setUsername(username);
			staff.setPassword(password);
			staff.setFullname(fullname);
			staff.setCompanyno(companyno);
			staff.setDesignation(designation);
			staff.setMobileno(mobileno);
			staff.setGender(gender);
			staff.setDob(dob);
			staff.setEmail(email);
			staff.setAddress(address);
			staff.setDatereg(datereg);
			db.addStaff(staff);
		}
		//db.drop("STAFF");
	}
	
	public void test1() {
		Db db = new Db();
		Connection cn = db.connect("javadb" ,"localhost","staffdb", "admin", "admin");
		
		///db.create("STAFF");
				String fullname = "Test Two";
				String companyno = "123456";
				String designation = "Programmer";
				String mobileno = "6010202020";
				String gender = "Male";
				String dob = "1980-07-06";
				String email = "auwal@gmail.com";
				String address = "Bukit Jalil";
				String datereg = "2014-09-14";
				
				Staff staff = new Staff();
				staff.setFullname(fullname);
				staff.setCompanyno(companyno);
				staff.setDesignation(designation);
				staff.setMobileno(mobileno);
				staff.setGender(gender);
				staff.setDob(dob);
				staff.setEmail(email);
				staff.setAddress(address);
				staff.setDatereg(datereg);
				
				
				///db.addStaff(staff);
				///db.truncate("STAFF");
				
				Staff staff2 = db.getStaff(1);
				System.out.println(staff2.getFullname());
				//Staff staff = st.load(1);
				//System.out.println(staff.getName());
				//Staff st = staff.load(1);
						
				//db.insert(staff);
				
				System.out.println(db.records("STAFF"));
	}
	
	private Staff getStaff(int id) {
		Staff staff = new Staff();
		try {
			ResultSet rs = cn().createStatement().executeQuery("SELECT * FROM ADMIN.STAFF WHERE ID="+id); rs.next();
			String fullname = rs.getString("fullname");
			String companyno = rs.getString("companyno");
			String designation = rs.getString("designation");
			String mobileno = rs.getString("mobileno");
			String gender = rs.getString("gender");
			String dob = rs.getString("dob");
			String email = rs.getString("email");
			String address = rs.getString("address");
			String datereg = rs.getString("datereg");
			
			staff.setFullname(fullname);
			staff.setCompanyno(companyno);
			staff.setDesignation(designation);
			staff.setMobileno(mobileno);
			staff.setGender(gender);
			staff.setDob(dob);
			staff.setEmail(email);
			staff.setAddress(address);
			staff.setDatereg(datereg);
		} catch(Exception e) { System.out.println(e); }
		return staff;
	}

	public Db() {
		/**
		try {
			NetworkServerControl server = new NetworkServerControl(InetAddress.getByName("localhost"), 1527);
			server.start(null);
			System.out.println("Derby Server Started!");
		} catch (Exception e) { e.printStackTrace(); }
		*/
	}
	
	public Connection connect(String dbtype, String dbhost, String dbname, String dbuser, String dbpass) {
		Connection con = null;
		try { conn = DriverManager.getConnection(protocol + dbName + ";create=true", "admin","admin");
			System.out.println("Connected!");
		} catch (SQLException e) { System.out.println(e); }
		
		return con;
	}
	
	
	public void create(String table) {
		try { s.execute("drop table "+table); } catch(Exception e1) { }
		try { s = cn.createStatement();
		
		String sql = "CREATE TABLE ADMIN."+table+"\r\n" + 
				"(ID INT NOT NULL GENERATED ALWAYS AS IDENTITY,\r\n" + 
				"USERNAME VARCHAR(20),\r\n" + 
				"PASSWORD VARCHAR(20),\r\n" + 
				"MOBILENO VARCHAR(20),\r\n" + 
				"EMAIL VARCHAR(50),\r\n" + 
				"FULLNAME VARCHAR(50),\r\n" + 
				"DESIGNATION VARCHAR(50),\r\n" + 
				"GENDER VARCHAR(10),\r\n" + 
				"DOB DATE,\r\n" + 
				"ADDRESS VARCHAR(50),\r\n" + 
				"COMPANYNO VARCHAR(20),\r\n" + 
				"DATEREG DATE,\r\n" + 
				"PRIMARY KEY (ID))";
		
			s.execute(sql);
			System.out.println("Table  Created");
		} catch (SQLException e) {System.out.println(e); }
	}

	public void addStaff(Staff staff) {
		try {
		PreparedStatement ps = cn().prepareStatement("INSERT INTO ADMIN.STAFF(username, password, fullname, companyno, designation, mobileno, gender, dob, email, address, datereg) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, staff.getUsername());
			ps.setString(2, staff.getPassword());
	      	ps.setString(3, staff.getFullname());
	      	ps.setString(4, staff.getCompanyno());
	      	ps.setString(5, staff.getDesignation());
	      	ps.setString(6, staff.getMobileno());
	      	ps.setString(7, staff.getGender());
	      	ps.setString(8, staff.getDob());
	      	ps.setString(9, staff.getEmail());
	      	ps.setString(10, staff.getAddress());
	      	ps.setString(11, staff.getDatereg());
	        ps.executeUpdate();
	        System.out.println("Staff Records Saved!");
	        ps.close();
	        cn().close();
		} catch(Exception e) { System.out.println(e); }
		
	}

	private Connection cn() {
		Connection con = null;
		try {
		con = DriverManager.getConnection(this.protocol + this.dbName + ";create=true", "admin","admin");
		} catch(Exception e) { System.out.println(e); }
		return con;
	}
	
	private Connection cn2() {
		Connection con = null;
		try {
		con = DriverManager.getConnection(this.protocol + this.dbName + ";create=true", "admin","admin");
		} catch(Exception e) { System.out.println(e); }
		return con;
	}


	/*public ArrayList<String> getStaff() {
		ArrayList<String> list = new ArrayList<String>();
		try { ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM STAFF WHERE ID=?");
		while(rs.next()) {
			System.out.println(rs.getString("STAFF"));
			list.add(rs.getString("STAFF")); }
		} catch(Exception e) { System.out.println(e); }
		return list;
		
	}*/
	

	public void truncate(String table) {
		try { cn().createStatement().execute("TRUNCATE TABLE "+table);
		System.out.println("Table truncated!");
		} catch(Exception e) {System.out.println(e);}
	}
	
	public int records(String table) {
		int total = 0;
		try { ResultSet rs = cn().createStatement().executeQuery("SELECT COUNT(*) AS total FROM ADMIN.STAFF"); rs.next();
		total = Integer.parseInt(rs.getString("total"));
		} catch(Exception e) {System.out.println(e);}
		
		return total;
	}
	
	public Staff loadStaff() {
		String fullname = "Test Two";
		String companyno = "123456";
		String designation = "Programmer";
		String mobileno = "6010202020";
		String gender = "Male";
		String dob = "1980-07-06";
		String email = "auwal@gmail.com";
		String address = "Bukit Jalil";
		String datereg = "2014-09-14";
		
		Staff staff = new Staff();
		staff.setFullname(fullname);
		staff.setCompanyno(companyno);
		staff.setDesignation(designation);
		staff.setMobileno(mobileno);
		staff.setGender(gender);
		staff.setDob(dob);
		staff.setEmail(email);
		staff.setAddress(address);
		staff.setDatereg(datereg);
		
		return staff;
	}

	public Connection connect(String dbtype) {
		Connection con = null;
		try {
		con = DriverManager.getConnection(this.protocol + this.dbName + ";create=true", "admin","admin");
		} catch(Exception e) { System.out.println(e); }
		return con;
	}
	
	public Object[][] getData(String tb) {
		Object[][] oo = null;
	
		try {
		Statement st2 = cn2.createStatement();
		ResultSet r3 = st2.executeQuery("SELECT id, companyno, fullname, gender, mobileno, designation, address FROM "+tb);
		ResultSetMetaData metaData = r3.getMetaData();
		int colCount = metaData.getColumnCount();
		ArrayList rows = new ArrayList();
		Object[] row = null;
		while (r3.next()) {
			row = new Object[colCount];
			for (int a = 0; a < colCount; a++) {
				row[a] = r3.getObject(a + 1);
			}
		rows.add(row);
		}
		oo = (Object[][])rows.toArray(new Object[0][0]);
		} catch(Exception e3) { System.out.println("getObjects()"+e3);
		
		}
		return oo;
	}
	
	public void drop(String table) {
		try { cn2.createStatement().executeUpdate("DROP TABLE "+table);} catch (SQLException e) {}
	}

}
