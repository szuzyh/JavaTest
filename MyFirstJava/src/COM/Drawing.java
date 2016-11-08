package COM;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class Drawing {

	 JFrame jframe = new JFrame();
	 public static JPanel GImage = null;
	 public Drawing() {
	  initFrame();
	 }
	 // ��ʼ������
	 public void initFrame() {
	  // ����JPanel��ӱ���ͼƬ
	  GImage = new JPanel() {
	   protected void paintComponent(Graphics g) {
	    ImageIcon icon = new ImageIcon("src\\Img\\head.bmp");
	    Image img = icon.getImage();
	    g.drawImage(img, 0, 0, icon.getIconWidth(),
	      icon.getIconHeight(), icon.getImageObserver());
	    jframe.setSize(450, 300);
	   }
	  };
	  jframe.setTitle("���Ա���ͼƬ");
	  GroupLayout groupLayout = new GroupLayout(jframe.getContentPane());
	  groupLayout.setHorizontalGroup(
	  	groupLayout.createParallelGroup(Alignment.LEADING)
	  		.addGroup(groupLayout.createSequentialGroup()
	  			.addGap(136)
	  			.addComponent(GImage, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
	  			.addContainerGap(147, Short.MAX_VALUE))
	  );
	  groupLayout.setVerticalGroup(
	  	groupLayout.createParallelGroup(Alignment.LEADING)
	  		.addGroup(groupLayout.createSequentialGroup()
	  			.addGap(63)
	  			.addComponent(GImage, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
	  			.addContainerGap(83, Short.MAX_VALUE))
	  );
	  jframe.getContentPane().setLayout(groupLayout);
	  jframe.pack();
	  jframe.setVisible(true);
	  jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }
	 public static void main(String[] args) {
			ActiveXComponent com = new ActiveXComponent("CLSID:0F55CC69-97EF-42A9-B63D-D1831CB2B3B9");
			Dispatch disp = (Dispatch)com.getObject();
			int ret = Dispatch.call(disp, "getCardInfo", new Variant("src\\Img\\head.bmp")).getInt();
			System.out.println("��������ͼƬ");
			
			ret = Dispatch.call(disp, "SaveCardData2Bmp", new Variant(1), new Variant("src\\Img\\front.bmp")).getInt();
			if(ret != 0)
			{
				System.out.println("failed");
			}
			else 
			{
				System.out.println("success");
			}
			
			System.out.println("���淴��ͼƬ");
			
			ret = Dispatch.call(disp, "SaveCardData2Bmp", new Variant(2), new Variant("src\\Img\\back.bmp")).getInt();
			if(ret != 0)
			{
				System.out.println("failed");
			}
			else 
			{
				System.out.println("success");
			}
			
			System.out.println("����������");
			
			ret = Dispatch.call(disp, "SaveCardData2Bmp", new Variant(3), new Variant("src\\Img\\full.bmp")).getInt();
			if(ret != 0)
			{
				System.out.println("failed");
			}
			else 
			{
				System.out.println("success");
			}
	 
	  
	 }
	}