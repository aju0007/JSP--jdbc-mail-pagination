package com.aju;
import java.sql.*;
import java.util.*;

public class retriver {
	public static List<retriverSet> getRecords(int start, int total){
		List<retriverSet> list=new ArrayList<retriverSet>();
	try {
	Connection con=ConnectionProvider.getCon();
	PreparedStatement ps=con.prepareStatement("select * from student limit "+(start-1)+","+total);
	ResultSet rs=ps.executeQuery();
	while(rs.next()) {
		retriverSet rst=new retriverSet();
		rst.setStudent_id(rs.getInt(1));
		rst.setFirstname(rs.getString(2));
		rst.setSecondname(rs.getString(3));
		rst.setEmail(rs.getString(4));
		rst.setPhone(rs.getString(5));
		rst.setAddress(rs.getString(6));
		
		list.add(rst);
		
	}
	con.close();
	}catch(Exception e) {
		System.out.println(e);
	}
	System.out.println(list);
	return list;
	
}
}

