package course.study.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private Connection conn;
	private String url = "jdbc:mysql://localhost:3306/selective-courses-system";
	private String user = "root";
	private String password = "keda123";
	public DatabaseConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库驱动加载失败");
		}
		try {
			this.conn = DriverManager.getConnection(url,user,password);
			System.out.println("访问数据库成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("数据库连接失败");
		}
	}
	
	public Connection getConnection(){
		return this.conn;
	}
	
	public void close(){
		if(this.conn != null){
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
