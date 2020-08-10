package com.aju;
import java.sql.*;
import com.aju.mailer;

public class registerstudent {
public int register(student s) {
	mailer ml=new mailer();
	String email,name;
	MailService objmail = new MailService();
	
	int status=0;;
	try {
		Connection con=ConnectionProvider.getCon();
		PreparedStatement ps=con.prepareStatement("insert into jspfiles.student(firstname,secondname,email,phone,address,password) values(?,?,?,?,?,?)");
//		for(int i=0;i<8;i++) {
			ps.setString(1,s.getFname());
			ps.setString(2,s.getLname());
			ps.setString(3,s.getEmai_l());
			ps.setString(4,s.getPhon_e());
			ps.setString(5,s.getAddres_s());
			ps.setString(6,s.getPassword());
			objmail.send("renjithravikkm1@gmail.com", "Sample mail test", "This is a test mail");
//		}
			if(ps.execute()) {
				email=s.getEmai_l();
				name=s.getFname()+s.getLname();
				System.out.println(name);
				objmail.send(email, "Sample mail test", "This is a test mail");
			//ml.mail(email,name);
				}
	}catch(Exception e) 
	{
		System.out.println("Error form here"+e);
	}
	return status;
}
}
 