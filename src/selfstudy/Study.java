package selfstudy;
import selfstudy.choose;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Study extends Frame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Button btn;
	private TextArea showresult;
	private Panel studypanel; 
	private Label l0,l1,l2,l3;
	private choose ch;
	public Study()
	{
		setCh(new choose());
		studypanel =new Panel();
		btn =new Button();
		btn=new Button(String.valueOf("inquire"));//给按钮加上名称
		btn.addActionListener(this);
		l0=new Label("自习室查询");
		l0.setBackground(Color.orange);//设置label l0的背景色为橘黄色
		l0.setFont(new Font("serif",Font.PLAIN,20));//设置l0的字体为宋体，字号大小为20
		l1= new Label("您选择的星期为");
		l1.setBackground(Color.orange);
		l2=new Label("您选择的时间是");
		l2.setBackground(Color.orange);
		setLayout(null);//将默认的布局管理器设置为空，采用用户自定义方式布局
		add(l0);
		l0.setBounds(240, 50, 110, 40);//设置awt组件的在窗体中的位置和自身的大小
		add(l1);
		l1.setBounds(70, 120, 90,20);
		add(choose.choosedate);
		choose.choosedate.setBounds(230, 120, 130, 130);
		add(l2);
		l2.setBounds(70, 160, 90, 20);
		add(choose.choosetime);
		choose.choosetime.setBounds(230, 160, 130, 130);
		add(studypanel);
		studypanel.setBounds(230, 200, 120, 40);
		studypanel.setLayout(new GridLayout(1,1));//设置面板的布局为网格状布局
		studypanel.add(btn);
		l3=new Label("空闲的教室有：");
		l3.setBackground(Color.lightGray);
		l3.setFont(new Font("serif",Font.PLAIN,20));
		add(l3);
		l3.setBounds(70,250, 150, 30);
		showresult=new TextArea();
		add(showresult);
		showresult.setBounds(70, 300, 350, 200);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==btn)
		{	
			try
			{
				Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver");//创建桥接方式，ACCESS桥接方式
				String source = "jdbc:odbc:testDDBB";
				Connection con = DriverManager.getConnection(source);//创建连接对象
				Statement  stmt = con.createStatement() ;//创建指令
				String sql = "SELECT name,container,time,date FROM people";
				ResultSet rs = stmt.executeQuery(sql);//创建结果集
				while(rs.next())
				{
					String name1=rs.getString(1);//得到数据库中name
					String container=rs.getString(2);//得到教室容量
					String time1=rs.getString(3);//得到教室的时间
					String date1=rs.getString(4);//得到教室的日期
					if(choose.choose1.equals(date1)&&choose.choose2.equals(time1))//用户选择的日期和时间与数据库中的数据就行比较
					showresult.append(name1+"        "+"教室的容量为"+container+"\r\n");//在文本区域中输入空闲的教室的名字和教室的容量，然后换行
					showresult.setFont(new Font("serif",Font.PLAIN,20));
					System.out.println(name1);
					System.out.println(container);
				}
			}
			catch(Exception e2)
			{e2.printStackTrace();}
			}
		}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Study inquireroom = new Study();
		inquireroom.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowevent) {
			System.exit(0);
			}
			});
		inquireroom.setTitle("我要上自习");
		inquireroom.setSize(500,550);	
		inquireroom.setVisible(true);
	}
	public choose getCh() {
		return ch;
	}
	public void setCh(choose ch) {
		this.ch = ch;
	}
}
