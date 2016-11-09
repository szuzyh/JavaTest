package COM;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;

import java.awt.Color;

import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.AttributedCharacterIterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.IconUIResource;

import org.omg.CORBA.portable.InputStream;

public class TestWindow {

	private JFrame frame;
	private static TestWindow window;
	private static String nullString="";
	//字符框  首字母大写 不加后缀
	private JTextPane Name;      //名字
	private JTextPane Sex;       //性别
	private JTextPane Nation;    //民族
	private JTextPane Birthday;     //出生日期
	private JTextPane Address;      //住址
	private JTextPane IDNum;     //身份证号
	private JTextPane Department;     //签发机关
	private JTextPane StartDate;          //发证日期
	private JTextPane EndDate;       //有效期
	
//得到信息  首字母大写后缀加Text
	private JTextArea NameText;         //名字
	private JTextArea SexText;          //性别
	private JTextArea NationText;       //民族
	private JTextArea BirthdayText;        //出生日期
	private JTextArea IDNumText;        //身份证号
	private JTextArea DepartmentText;   //签发机关
	private JTextArea StartDateText;        //发证日期
	private JTextArea EndDateText;     //有效期
	
    //按钮
	private JButton checkBtn;
	private JButton clearBtn;
	//卡
	private static ActiveXComponent com;
	private static Dispatch disp;
	//读取所得信息 首字母小写  不加后缀
	private static String name;
	private static String sex;
	private static String nation;
	private static String address;
	private static String birthday;
	private static String ID;
	private static String department;
	private static String startDate;
	private static String endDate;
	private JTextArea AddressText;
	
	private static Icon icon;
	private JLabel lblNewLabel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		com = new ActiveXComponent("CLSID:0F55CC69-97EF-42A9-B63D-D1831CB2B3B9");
		disp = (Dispatch)com.getObject();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new TestWindow();
					window.frame.setVisible(true);
					window.checkBtn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							int ret = Dispatch.call(disp, "getCardInfo", new Variant("E:\\Img\\head.jpg")).getInt();
							if(ret==0){
								name=Dispatch.call(disp, "Name").getString();
								sex=Dispatch.call(disp, "Sex").getString();
								nation=Dispatch.call(disp, "Nation").getString();
								birthday=Dispatch.call(disp, "Birthday").getString();
								address=Dispatch.call(disp, "Address").getString();
								ID=Dispatch.call(disp, "ID").getString();
								department=Dispatch.call(disp, "Department").getString();
								startDate=Dispatch.call(disp, "StartDate").getString();
								endDate=Dispatch.call(disp, "EndDate").getString();
								
								window.NameText.setText(name);
								window.SexText.setText(sex);
								window.NationText.setText(nation);
								window.BirthdayText.setText(birthday);
								window.AddressText.setText(address);
								window.IDNumText.setText(ID);
								window.DepartmentText.setText(department);
								window.StartDateText.setText(startDate);
								window.EndDateText.setText(endDate);
							
								addPhoto();
							}else{
								System.out.println("打开设备失败");
								return;
							}
						}

						private void addPhoto() {
							// TODO Auto-generated method stub
							ImageIcon imageIcon=new ImageIcon("E:\\Img\\head.jpg");
							window.lblNewLabel=new JLabel(imageIcon);
						}
					});
					window.clearBtn.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							window.NameText.setText(nullString);
							window.SexText.setText(nullString);
							window.NationText.setText(nullString);
							window.BirthdayText.setText(nullString);
							window.AddressText.setText(nullString);
							window.IDNumText.setText(nullString);
							window.DepartmentText.setText(nullString);
							window.StartDateText.setText(nullString);
							window.EndDateText.setText(nullString);
						}
					});
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
	}

	/**
	 * Create the application.
	 */
	public TestWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.menu);
		frame.setBounds(100, 100, 500, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Name = new JTextPane();
		Name.setEnabled(false);
		Name.setEditable(false);
		Name.setBackground(SystemColor.inactiveCaptionBorder);
		Name.setText("\u59D3\u540D\uFF1A");
		
		Sex = new JTextPane();
		Sex.setText("\u6027\u522B\uFF1A");
		Sex.setEnabled(false);
		Sex.setEditable(false);
		Sex.setBackground(SystemColor.inactiveCaptionBorder);
		
		Nation = new JTextPane();
		Nation.setText("\u6C11\u65CF\uFF1A");
		Nation.setEnabled(false);
		Nation.setEditable(false);
		Nation.setBackground(SystemColor.inactiveCaptionBorder);
		
		NameText = new JTextArea();
		NameText.setEnabled(false);
		NameText.setEditable(false);
		NameText.setBackground(Color.WHITE);
		
		SexText = new JTextArea();
		SexText.setEnabled(false);
		SexText.setEditable(false);
		SexText.setBackground(Color.WHITE);
		
		NationText = new JTextArea();
		NationText.setEnabled(false);
		NationText.setEditable(false);
		NationText.setBackground(Color.WHITE);
		
		Birthday = new JTextPane();
		Birthday.setText("\u51FA\u751F\u65E5\u671F\uFF1A");
		Birthday.setEnabled(false);
		Birthday.setEditable(false);
		Birthday.setBackground(SystemColor.inactiveCaptionBorder);
		
		BirthdayText = new JTextArea();
		BirthdayText.setEnabled(false);
		BirthdayText.setEditable(false);
		BirthdayText.setBackground(Color.WHITE);
		
		Address = new JTextPane();
		Address.setText("\u4F4F\u5740\uFF1A");
		Address.setEnabled(false);
		Address.setEditable(false);
		Address.setBackground(SystemColor.inactiveCaptionBorder);
		
		IDNumText = new JTextArea();
		IDNumText.setEnabled(false);
		IDNumText.setEditable(false);
		IDNumText.setBackground(Color.WHITE);
		
		IDNum = new JTextPane();
		IDNum.setText("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		IDNum.setEnabled(false);
		IDNum.setEditable(false);
		IDNum.setBackground(SystemColor.inactiveCaptionBorder);
		
		Department = new JTextPane();
		Department.setText("\u7B7E\u53D1\u673A\u5173\uFF1A");
		Department.setEnabled(false);
		Department.setEditable(false);
		Department.setBackground(SystemColor.inactiveCaptionBorder);
		
		DepartmentText = new JTextArea();
		DepartmentText.setEnabled(false);
		DepartmentText.setEditable(false);
		DepartmentText.setBackground(Color.WHITE);
		
		StartDateText = new JTextArea();
		StartDateText.setEnabled(false);
		StartDateText.setEditable(false);
		StartDateText.setBackground(Color.WHITE);
		
		StartDate = new JTextPane();
		StartDate.setText("\u53D1\u8BC1\u65E5\u671F\uFF1A");
		StartDate.setEnabled(false);
		StartDate.setEditable(false);
		StartDate.setBackground(SystemColor.inactiveCaptionBorder);
		
		EndDate = new JTextPane();
		EndDate.setText("  \u6709\u6548\u671F\uFF1A");
		EndDate.setEnabled(false);
		EndDate.setEditable(false);
		EndDate.setBackground(SystemColor.inactiveCaptionBorder);
		
		EndDateText = new JTextArea();
		EndDateText.setEnabled(false);
		EndDateText.setEditable(false);
		EndDateText.setBackground(Color.WHITE);
		
		checkBtn = new JButton("\u67E5\u8BE2");
		checkBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		AddressText = new JTextArea();
		AddressText.setEnabled(false);
		AddressText.setEditable(false);
		AddressText.setLineWrap(true);     //JTextArea默认不换行，这里激活自动换行功能
		AddressText.setWrapStyleWord(true);   //激活换行不断字功能
		AddressText.setBackground(Color.WHITE);
		
		clearBtn= new JButton("\u6E05\u9664");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		lblNewLabel = new JLabel();
		
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(Address, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(Birthday, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(Sex, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addComponent(Nation, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addComponent(IDNum, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addComponent(Department, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addComponent(StartDate, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addComponent(EndDate, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(IDNumText, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(NameText, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addComponent(SexText, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addComponent(NationText, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addComponent(BirthdayText, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
								.addComponent(DepartmentText, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
								.addComponent(EndDateText, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
								.addComponent(AddressText, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
								.addComponent(StartDateText, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(clearBtn)
								.addComponent(checkBtn)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(Name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(NameText, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(Sex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(SexText, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(NationText, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(Nation, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(Birthday, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(BirthdayText, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(Address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(AddressText, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(IDNumText, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(IDNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(16)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(DepartmentText, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(Department, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(StartDate, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(StartDateText, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
							.addGap(6)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(EndDate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(EndDateText, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(checkBtn)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(clearBtn)))
					.addGap(42))
		);
		
		frame.getContentPane().setLayout(groupLayout);
	}
}
