/*____________________________________________________________________________________


*/

package selfstudy;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class choose extends Frame implements ItemListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  static Choice choosedate;
	public static Choice choosetime;
	public static String choose1;//��choose���û�ѡ�������ݴ���ھ�̬����choose��
	public static String choose2;//ͬ��
	private static choose ch1;
	public choose()
	{
	choosedate =new Choice();
	add(choosedate);
	choosedate.setBackground(Color.lightGray);
	choosedate.addItem("  ");
	choosedate.addItem("��һ");//���choice������
	choosedate.addItem("�ܶ�");
	choosedate.addItem("����");
	choosedate.addItem("����");
	choosedate.addItem("����");
	choosedate.addItem("����");
	choosedate.addItem("����");
	choosedate.addItemListener(this);
	choosetime =new Choice();
	add(choosetime);
	choosetime.setBackground(Color.lightGray);
	choosetime.addItem("          ");
	choosetime.addItem("7:50~9:25");
	choosetime.addItem("9:25~11:15");
	choosetime.addItem("11:15~12:00");
	choosetime.addItem("12:00~13:30");
	choosetime.addItem("13:30~15:05");
	choosetime.addItem("15:05~15:55");
	choosetime.addItem("15:55~17:40");
	choosetime.addItem("17:40~19:00");
	choosetime.addItem("19:00~21:25");
	choosetime.addItem("21:30~22:30");
	choosetime.addItemListener(this);
	}
	public void itemStateChanged(ItemEvent e1) {
		// TODO �Զ����ɵķ������
		if(e1.getSource()==choosedate)
		{
			Choice temp1=(Choice)e1.getSource();
			choose1 = temp1.getSelectedItem();//���û�ѡ������ڸ�ֵ��choose1��
		}
		if(e1.getSource()==choosetime)
		{//String choose2=choosetime.getSelectedItem();
			Choice temp2=(Choice)e1.getSource();
			choose2=temp2.getSelectedItem();//���û�ѡ����ʱ��θ�ֵ��choose2
		}
	}


	public static void main(String[] args) {
		setCh1(new choose());
	}
	public static choose getCh1() {
		return ch1;
	}
	public static void setCh1(choose ch1) {
		choose.ch1 = ch1;
	}
}


