package COM;

import javax.swing.JTextArea;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class test {
	public static void main(String[] args) {
		Window mWindow=new Window();
		mWindow.main(args);
		JTextArea a=mWindow.textArea;
		String s="1222222";
		a.setText(s);
	}		
}

