package ex3;

import java.awt.Dimension;

import javax.swing.JFrame;

public class DrawFrame extends JFrame{
	
	DrawFrame(){
		this.setTitle("Star Drawing");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(new Dimension(600, 600));
		
		DrawStarPanel p = new DrawStarPanel();		
		this.add(p);
			
	}
}
