package ex4;

import javax.swing.JFrame;

public class ColorFrame extends JFrame{
	
	ColorFrame(){
		this.setTitle("Paint");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(450,700);
		
		ColorPanel c = new ColorPanel();
		c.addMouseListener(c);
		c.addMouseMotionListener(c);
		this.add(c);
	}
}
