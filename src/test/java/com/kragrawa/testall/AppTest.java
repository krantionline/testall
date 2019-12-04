package com.kragrawa.testall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.testng.annotations.Test;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    @Test
    public void testjdbc() {
    	Connection con = null;

		//adcs60-scan1.us.oracle.com:1521/pdfdprd.us.oracle.com  smpperf/smpperf123
		
		String DBURL = "jdbc:oracle:thin:@slc15azo.us.oracle.com:1521/orclpdb1";
		String USER = "testdb_user";
		String PWD = "testdb";
		System.out.println("Trying to connect to DB with : DB_URL=" + DBURL + ",DB_USER=" + USER + ",DB_PWD=" + PWD);

		try {

			

			Class.forName("oracle.jdbc.OracleDriver");

			con = DriverManager.getConnection(DBURL, USER, PWD);
			System.out.println("Connection successful");

			PreparedStatement s1 = con
					.prepareStatement("select sysdate from dual");
			ResultSet rs = s1.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}

			con.close();
			
		} catch (Exception e) {
			System.out.println(
					"Unable to create a conenction to " + DBURL + " with " + USER + " and " + PWD + " credentials");
			e.printStackTrace();
		}
		
		System.out.println("Execution complete");
    }
}
