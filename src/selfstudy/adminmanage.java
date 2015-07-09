

package selfstudy;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
public class adminmanage extends Frame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Label l0,l1,l2,l3,l4;
	private TextField t1,t2,t3,t4;
	private Button b1,b2;
	private	String freshname,freshtime,freshdate,freshcontainer;
	public adminmanage(){
		l0=new Label("教室管理");
		l1=new Label("新增空间闲教室名称");
		l2=new Label("教室空闲时间");
		l3=new Label("教室空闲日期");
		l4=new Label("教室的容量");
		t1=new TextField(20);
		t2=new TextField(20);
		t3=new TextField(20);
		t4=new TextField(20);
		b1=new Button("确认添加");
		b2=new Button("返回登陆");
		freshname=new String();
		freshtime=new String();
		freshdate=new String();
		freshcontainer=new String();
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
		add(l3);
		l3.setBounds(70, 200, 100, 30);
		add(t3);
		t3.setBounds(220, 200, 100, 30);
		add(l4);
		l4.setBounds(70, 250, 100, 30);
		add(t4);
		t4.setBounds(220, 250, 100, 30);
		add(b1);
		b1.setBounds(180, 300, 60, 40);
		b1.addActionListener(this);
		add(b2);
		b2.setBounds(300, 300, 60, 40);
		b2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==b1)
		{				
			String strUpdate="INSERT INTO people(name,time,date,container) VALUES (?,?,?,?)";
			freshname=t1.getText();
			freshtime=t2.getText();
			freshdate=t3.getText();
			freshcontainer=t4.getText();
			System.out.println(freshname);
			System.out.println(freshtime);
			try
			{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				String source = "jdbc:odbc:testDDBB";
				Connection con=DriverManager.getConnection(source);
				PreparedStatement stmt=con.prepareStatement(strUpdate);
				String strname=freshname;
				String strtime=freshtime;
				String strdate=freshdate;
				String strcontainer=freshcontainer;
				stmt.setString(1, strname);
				stmt.setString(2, strtime);
				stmt.setString(3, strdate);
				stmt.setString(4, strcontainer);
				stmt.executeUpdate();
			}
			catch(Exception e1)
			{e1.printStackTrace();}
		}
		if(e.getSource()==b2)
		{
			loading LLL=new loading();
			LLL.setTitle("登陆");
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
		adminmanage AAA=new adminmanage();
		AAA.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowevent) {
			System.exit(0);
			}
			});
		AAA.setTitle("教室管理");
		AAA.setVisible(true);
		AAA.setSize(500, 500);
	}

}


