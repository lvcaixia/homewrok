/*��½�����ʵ��*/
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
		l1=new Label("��¼��");
		l2=new Label("���� ");
		t1=new TextField(20);
		t2=new TextField(20); 
		b1=new Button("��½");
		b2=new Button("ע��");
		b3=new Button("����Ա��½");
		b1.addActionListener(this);        //��Ӱ�ť������
		b2.addActionListener(this);
		b3.addActionListener(this);
		setLayout(null);                   //��Ĭ�ϵĲ��ֹ���������Ϊ�գ��Զ��岼��
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
		// TODO �Զ����ɵķ������
		if(e1.getSource()==b3)
		{try
		{
			Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver");//�����Ž����ӷ���
			String source = "jdbc:odbc:testDB";
			Connection con = DriverManager.getConnection(source);//�������Ӷ���
			Statement  stmt = con.createStatement() ;//����ָ��
			String sql = "SELECT ID,pass FROM ADMIN";
			ResultSet rs = stmt.executeQuery(sql);//���������
			while(rs.next()){
				String id=rs.getString(1);//�õ����ݿ��е�ID����ֵ���ַ���id
				String pass=rs.getString(2);//�õ����ݿ��е�pass����ֵ���ַ���pass
				String user,password;
				user=t1.getText();//�õ��û�������û���
				password=t2.getText();//�õ��û����������
				if(user.equals(id)&&password.equals(pass)){//�����ƥ��
					adminmanage AAA=new adminmanage();
					AAA.setTitle("��Ҫ����ϰ");//���ô��������
					AAA.setVisible(true);//������ʾ�ɼ�
					AAA.setSize(500,500);//���ô����С
					AAA.addWindowListener(new WindowAdapter() {//��Ӵ���Ĵ��ڵļ�����������������
				public void windowClosing(WindowEvent windowevent) {
					System.exit(0);
					}
					});
					this.setVisible(false);
		}
			}
		}
		catch(Exception e)//�쳣����
		{e.printStackTrace();}
		}
		
		if(e1.getSource()==b1)
		{
			try
			{
				Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver");//�����Ž����ӷ���
				String source = "jdbc:odbc:testDB";
				Connection con = DriverManager.getConnection(source);//�������Ӷ���
				Statement  stmt = con.createStatement() ;//����ָ��
				String sql = "SELECT ID,pass FROM Name";
				ResultSet rs = stmt.executeQuery(sql);//���������
				while(rs.next()){
					String id=rs.getString(1);//�õ����ݿ��е�ID����ֵ���ַ���id
					String pass=rs.getString(2);//�õ����ݿ��е�pass����ֵ���ַ���pass
					String user,password;
					user=t1.getText();//�õ��û�������û���
					password=t2.getText();//�õ��û����������
					if(user.equals(id)&&password.equals(pass)){//�����ƥ��
						Study AAA=new Study();
						AAA.setTitle("��Ҫ����ϰ");//���ô��������
						AAA.setVisible(true);//������ʾ�ɼ�
						AAA.setSize(500,500);//���ô����С
						AAA.addWindowListener(new WindowAdapter() {//��Ӵ���Ĵ��ڵļ�����������������
					public void windowClosing(WindowEvent windowevent) {
						System.exit(0);
						}
						});
						this.setVisible(false);
				}
			}
			}
			catch(Exception e)//�쳣����
			{e.printStackTrace();}
			}
		if(e1.getSource()==b2)
		{
			Register RRR=new Register();
			RRR.setTitle("ע��");
			RRR.setVisible(true);
			RRR.setSize(500, 500);
			RRR.addWindowListener(new WindowAdapter() {//��Ӵ���Ĵ��ڵļ�����������������
				public void windowClosing(WindowEvent windowevent) {
					System.exit(0);
					}
					});
			this.setVisible(false);
		}
		
	}
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		loading TEST=new loading();
		TEST.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowevent) {
			System.exit(0);
			}
			});
		TEST.setTitle("��½");
		TEST.setSize(500,500);
		TEST.setVisible(true);
	}
}