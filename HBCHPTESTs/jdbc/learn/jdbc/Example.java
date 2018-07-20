/**
 * 
 */
package learn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author ysharma
 *
 */
public class Example {
	private	static	String	DBURL	=	"jdbc:postgres://localhost:<PORT>/<dbName>";
	private	static	String	USER	=	"UN";
	private	static	String	Pass	=	"PASS";
	
	public static void main(String[] args) {
		try {
			Class.forName("com.postgres.jdbc.Driver");
			
			Connection	conn	=	DriverManager.getConnection(DBURL, USER, Pass);
			String	sql	=	"";
			PreparedStatement	prepSt	=	conn.prepareStatement(sql);
			
			ResultSet	res	=	prepSt.executeQuery();
			while(res.next()) {
				//String	values	=-	
			}
			
		} catch (Exception e) {

		}
	}
}
