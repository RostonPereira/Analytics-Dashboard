package rnm;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

public class All extends JFrame {
	
	JSplitPane p;
	JScrollPane sp;
	JTabbedPane tp;
	
	public All() {
		
		PropertyChangeListener resizeHandler = new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				
			}

		};
		
		Header header = new Header(new ImageIcon("Icon/RnmSignature.jpg").getImage());
		Overall overall = new Overall();
		Web web = new Web();
		Android android = new Android();
		Ios ios = new Ios();
		
		ImageIcon overallIcon = new ImageIcon("overall.jpg");
		ImageIcon webIcon = new ImageIcon("web.jpg");
		ImageIcon androidIcon = new ImageIcon("android.jpg");
		ImageIcon iosIcon = new ImageIcon("ios.jpg");
		
		tp = new JTabbedPane(JTabbedPane.LEFT);
		
		tp.addTab("Overall", overallIcon, overall);
		tp.addTab("Web", webIcon, web);
		tp.addTab("Android", androidIcon, android);
		tp.addTab("IOS", iosIcon, ios);
		
		sp = new JScrollPane(tp);
		
		p = new JSplitPane(JSplitPane.VERTICAL_SPLIT, header, sp);
		p.addPropertyChangeListener(JSplitPane.DIVIDER_LOCATION_PROPERTY, resizeHandler);

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());

		cp.add(p);
		
	}
	
	public static void main(String[] args) {

		All all = new All();
		all.setTitle("RNM Moving Pictures");
		all.setSize(1200, 800);
		all.setVisible(true);
		all.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
//=================================================================== End of JFrame =============================================================





class Header extends JPanel {

	private Image img;
	
	public Header(String img) {
	
		this(new ImageIcon(img).getImage());
	}
	
	public Header(Image img) {
		
		this.img=img;
		Dimension size = new Dimension (img.getWidth(null),img.getHeight(null));
		setPreferredSize(size);
		setMinimumSize(size);
		setSize(size);
		setLayout(null);
	}
	
	public void paintComponent(Graphics g) {
		
		g.drawImage(img, 20, 0, null);
	}

}

// =================================================================== End of JPanel Header =============================================================







class Overall extends JPanel {
	
	JScrollPane sp;
	JTable table;
	
	public Overall() {
		
		table = new JTable(10,16);
		table.setPreferredScrollableViewportSize(new Dimension(1000,600));
		sp = new JScrollPane(table);
		
		add(sp);
	}
}
//=================================================================== End of JPanel Overall =============================================================






class Web extends JPanel {
	
	JScrollPane sp;
	JTable table;
	
	public Web() {
		
		table = new JTable(3,8);
		table.setPreferredScrollableViewportSize(new Dimension(1000,600));
		sp = new JScrollPane(table);
		
		add(sp);
	}
}
//=================================================================== End of JPanel Overall =============================================================





class Android extends JPanel {
	
	JScrollPane sp;
	JTable table;
	
	public Android() {
		
		table = new JTable(3,8);
		table.setPreferredScrollableViewportSize(new Dimension(1000,600));
		sp = new JScrollPane(table);
		
		add(sp);
	}
}
//=================================================================== End of JPanel Overall =============================================================




class Ios extends JPanel {
	
	JScrollPane sp;
	JTable table;
	
	public Ios() {
		
		table = new JTable(3,8);
		table.setPreferredScrollableViewportSize(new Dimension(1000,600));
		sp = new JScrollPane(table);
		
		add(sp);
	}
}
//=================================================================== End of JPanel Overall =============================================================