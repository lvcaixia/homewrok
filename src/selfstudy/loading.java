/*登陆界面的实现*/
package selfstudy;
import selfstudy.Study;
import java.awt.Button;//import java.awt.*;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class loading extends Frame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Label l1,l2;
	private TextField t1,t2;
	private	Button b1,b2,b3;
	public loading(){
		l1=new Label("登录名");
		l2=new Label("密码 ");
		t1=new TextField(20);
		t2=new TextField(20); 
		b1=new Button("登陆");
		b2=new Button("注册");
		b3=new Button("管理员登陆");
		b1.addActionListener(this);        //添加按钮监听器
		b2.addActionListener(this);
		b3.addActionListener(this);
		setLayout(null);                   //将默认的布局管理器设置为空，自定义布局
		add(l1);
		l1.setBounds(150, 120, 40,20);
		add(t1);
		t1.setBounds(200, 120, 150, 20);
		add(l2);
		l2.setBounds(150, 160, 40, 20);
		add(t2);
		t2.setBounds(200, 160, 150, 20);
		add(b1);
		b1.setBounds(150,200,50,50);
		add(b2);
		b2.setBounds(220, 200, 50,50);
		add(b3);
		b3.setBounds(300, 200, 80, 50);
	}
	public void actionPerformed(ActionEvent e1) {
		// TODO 自动生成的方法存根
		if(e1.getSource()==b3)
		{try
		{
			Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver");//引入桥接连接方法
			String source = "jdbc:odbc:testDB";
			Connection con = DriverManager.getConnection(source);//创建连接对象
			Statement  stmt = con.createStatement() ;//创建指令
			String sql = "SELECT ID,pass FROM ADMIN";
			ResultSet rs = stmt.executeQuery(sql);//创建结果集
			while(rs.next()){
				String id=rs.getString(1);//得到数据库中的ID，赋值给字符串id
				String pass=rs.getString(2);//得到数据库中的pass，赋值给字符串pass
				String user,password;
				user=t1.getText();//得到用户输入的用户名
				password=t2.getText();//得到用户输入的密码
				if(user.equals(id)&&password.equals(pass)){//密码的匹配
					adminmanage AAA=new adminmanage();
					AAA.setTitle("我要上自习");//设置窗体的名称
					AAA.setVisible(true);//窗体显示可见
					AAA.setSize(500,500);//设置窗体大小
					AAA.addWindowListener(new WindowAdapter() {//添加窗体的窗口的监听器，采用适配器
				public void windowClosing(WindowEvent windowevent) {
					System.exit(0);
					}
					});
					this.setVisible(false);
		}
			}
		}
		catch(Exception e)//异常处理
		{e.printStackTrace();}
		}
		
		if(e1.getSource()==b1)
		{
			try
			{
				Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver");//引入桥接连接方法
				String source = "jdbc:odbc:testDB";
				Connection con = DriverManager.getConnection(source);//创建连接对象
				Statement  stmt = con.createStatement() ;//创建指令
				String sql = "SELECT ID,pass FROM Name";
				ResultSet rs = stmt.executeQuery(sql);//创建结果集
				while(rs.next()){
					String id=rs.getString(1);//得到数据库中的ID，赋值给字符串id
					String pass=rs.getString(2);//得到数据库中的pass，赋值给字符串pass
					String user,password;
					user=t1.getText();//得到用户输入的用户名
					password=t2.getText();//得到用户输入的密码
					if(user.equals(id)&&password.equals(pass)){//密码的匹配
						Study AAA=new Study();
						AAA.setTitle("我要上自习");//设置窗体的名称
						AAA.setVisible(true);//窗体显示可见
						AAA.setSize(500,500);//设置窗体大小
						AAA.addWindowListener(new WindowAdapter() {//添加窗体的窗口的监听器，采用适配器
					public void windowClosing(WindowEvent windowevent) {
						System.exit(0);
						}
						});
						this.setVisible(false);
				}
			}
			}
			catch(Exception e)//异常处理
			{e.printStackTrace();}
			}
		if(e1.getSource()==b2)
		{
			Register RRR=new Register();
			RRR.setTitle("注册");
			RRR.setVisible(true);
			RRR.setSize(500, 500);
			RRR.addWindowListener(new WindowAdapter() {//添加窗体的窗口的监听器，采用适配器
				public void windowClosing(WindowEvent windowevent) {
					System.exit(0);
					}
					});
			this.setVisible(false);
		}
		
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		loading TEST=new loading();
		TEST.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowevent) {
			System.exit(0);
			}
			});
		TEST.setTitle("登陆");
		TEST.setSize(500,500);
		TEST.setVisible(true);
	}
}