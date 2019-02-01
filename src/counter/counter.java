package counter;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class counter extends JFrame {
	private JLabel l1;
	private JTextField f;
	MyThread t;
	int x;
	public counter() {
		x=0;
		l1=new JLabel("  x="+x);
		add(l1);
		f=new JTextField();
		add(f,BorderLayout.NORTH);
		t=new MyThread("thread test");
		t.start();
		setSize(200,200);
		setVisible(true);
		String s=JOptionPane.showInputDialog(null,"thread test");
		f.setText(s);
	}
	class MyThread extends Thread{
		public MyThread(String sn) {
			super(sn);
		}
		@Override
		public void run() {
			while(true) {
				try{
					Thread.sleep(1000);
					x++;
					x=x%100;
					l1.setText("x="+x);
				}
				catch(InterruptedException in) {
					System.out.println(in.toString());
				}
			}
			
		}
	}
	public static void main(String arg[] ) {
		counter app=new counter();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
