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
		btn=new Button(String.valueOf("inquire"));//����ť��������
		btn.addActionListener(this);
		l0=new Label("��ϰ�Ҳ�ѯ");
		l0.setBackground(Color.orange);//����label l0�ı���ɫΪ�ٻ�ɫ
		l0.setFont(new Font("serif",Font.PLAIN,20));//����l0������Ϊ���壬�ֺŴ�СΪ20
		l1= new Label("��ѡ�������Ϊ");
		l1.setBackground(Color.orange);
		l2=new Label("��ѡ���ʱ����");
		l2.setBackground(Color.orange);
		setLayout(null);//��Ĭ�ϵĲ��ֹ���������Ϊ�գ������û��Զ��巽ʽ����
		add(l0);
		l0.setBounds(240, 50, 110, 40);//����awt������ڴ����е�λ�ú�����Ĵ�С
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
		studypanel.setLayout(new GridLayout(1,1));//�������Ĳ���Ϊ����״����
		studypanel.add(btn);
		l3=new Label("���еĽ����У�");
		l3.setBackground(Color.lightGray);
		l3.setFont(new Font("serif",Font.PLAIN,20));
		add(l3);
		l3.setBounds(70,250, 150, 30);
		showresult=new TextArea();
		add(showresult);
		showresult.setBounds(70, 300, 350, 200);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if(e.getSource()==btn)
		{	
			try
			{
				Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver");//�����Žӷ�ʽ��ACCESS�Žӷ�ʽ
				String source = "jdbc:odbc:testDDBB";
				Connection con = DriverManager.getConnection(source);//�������Ӷ���
				Statement  stmt = con.createStatement() ;//����ָ��
				String sql = "SELECT name,container,time,date FROM people";
				ResultSet rs = stmt.executeQuery(sql);//���������
				while(rs.next())
				{
					String name1=rs.getString(1);//�õ����ݿ���name
					String container=rs.getString(2);//�õ���������
					String time1=rs.getString(3);//�õ����ҵ�ʱ��
					String date1=rs.getString(4);//�õ����ҵ�����
					if(choose.choose1.equals(date1)&&choose.choose2.equals(time1))//�û�ѡ������ں�ʱ�������ݿ��е����ݾ��бȽ�
					showresult.append(name1+"        "+"���ҵ�����Ϊ"+container+"\r\n");//���ı�������������еĽ��ҵ����ֺͽ��ҵ�������Ȼ����
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
		// TODO �Զ����ɵķ������
		Study inquireroom = new Study();
		inquireroom.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowevent) {
			System.exit(0);
			}
			});
		inquireroom.setTitle("��Ҫ����ϰ");
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
