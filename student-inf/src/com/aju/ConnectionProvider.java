package com.aju;
import java.sql.*;
import static com.aju.Provider.*;

public class ConnectionProvider {
	

	private static Connection con=null;
	static {
		try {
			Class.forName(DRIVER);
			con=(Connection)DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);
			
		}catch(Exception e) {}
	}
	public static Connection getCon() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER );
        con = (Connection) DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
		return con;
	}

}
