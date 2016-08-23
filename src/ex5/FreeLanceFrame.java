package ex5;

import javax.swing.JFrame;

public class FreeLanceFrame extends JFrame{
	
	FreeLanceFrame(){
		this.setTitle("Freelance Quote");
		this.setSize(600,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		FreeLancePanel flp = new FreeLancePanel();
		flp.addMouseListener(flp);
		this.add(flp);
	}
}
