/*_______________________________________________________________________________






*/
package selfstudy;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Register extends Frame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Label l0,l1,l2;
	private TextField t1,t2;
	private Button b1,b2;
	private	String registername,registerpass;
	public Register(){
		l0=new Label("用户注册");
		l1=new Label("请输入您要注册的用户名");
		l2=new Label("请输入您的密码");
		t1=new TextField(20);
		t2=new TextField(20);
		b1=new Button("注册");
		b2=new Button("返回登陆");
		registername=new String();
		registerpass=new String();
		setLayout(null);
		add(l0);
		l0.setBounds(200, 20, 50, 50);
		add(l1);
		l1.setBounds(70,100,150,30);
		add(t1);
		t1.setBounds(220, 100, 100, 30);
		add(l2);
		l2.setBounds(70, 150, 100, 30);
		add(t2);
		t2.setBounds(220, 150, 100, 30);
		add(b1);
		b1.setBounds(180, 200, 40, 40);
		b1.addActionListener(this);
		add(b2);
		b2.setBounds(300, 200, 60, 40);
		b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==b1)
		{				
			String strUpdate="INSERT INTO Name(ID,pass)VALUES(?,?)";
			registername=t1.getText();
			registerpass=t2.getText();
			System.out.println(registername);
			System.out.println(registerpass);
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				String source = "jdbc:odbc:testDB";
				Connection con=DriverManager.getConnection(source);
				PreparedStatement stmt=con.prepareStatement(strUpdate);
				String strID=registername;
				String strpass=registerpass;
				stmt.setString(1, strID);
				stmt.setString(2, strpass);
				stmt.executeUpdate();
			}
			catch(Exception e1)
			{e1.printStackTrace();}
		}
		if(e.getSource()==b2)
		{
			loading LLL=new loading();
			LLL.setTitle("注册");
			LLL.setVisible(true);
			LLL.setSize(500, 500);
			LLL.addWindowListener(new WindowAdapter() {//添加窗体的窗口的监听器，采用适配器
				public void windowClosing(WindowEvent windowevent) {
					System.exit(0);
					}
					});
			this.setVisible(false);}

		}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Register AAA=new Register();
		AAA.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowevent) {
			System.exit(0);
			}
			});
		AAA.setTitle("注册");
		AAA.setVisible(true);
		AAA.setSize(500, 500);
	}

}

