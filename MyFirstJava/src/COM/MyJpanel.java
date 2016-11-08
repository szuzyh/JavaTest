package COM;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyJpanel extends JPanel{
	
	Image img;
	public MyJpanel() {

	setOpaque(false);//ÉèÖÃÍ¸Ã÷É«
	img=new ImageIcon("src\\Img\\head.bmp").getImage();
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img,0,40,img.getWidth(null)+300,img.getHeight(null)-30,null);
		super.paint(g);
	}
}
