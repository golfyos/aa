package ex5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FreeLancePanel extends JPanel implements MouseListener{
	
	private String title,text1,text2,text3;
	private String ham = " ห้าม";
	
	FreeLancePanel(){
		title = "ฟรีแลนซ์";
		text1 = ham+"ป่วย..  ";
		text2 = ham+"พัก..  ";
		text3 = ham+"รักหมอ ";
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		Font font = new Font ("Tahoma", Font.BOLD , 60);
		Font font2 = new Font("Tahoma", Font.LAYOUT_RIGHT_TO_LEFT , 20);
		FontMetrics titleMetrics = g2.getFontMetrics(font);
		int titleHeight = titleMetrics.getHeight();
		int titleWidth = titleMetrics.stringWidth(title);
		
		FontMetrics msgMetrics = g2.getFontMetrics(font2);
		int msgHeight = msgMetrics.getHeight();
		int msg1Width = msgMetrics.stringWidth(text1);
		int msg2Width = msgMetrics.stringWidth(text2);
		int msg3Width = msgMetrics.stringWidth(text3);
		
		g2.setFont(font);
		g2.drawString(title, (this.getWidth() - titleWidth )/2,  ((this.getHeight() + titleMetrics.getDescent() )/2)-titleMetrics.getDescent());
		
		g2.setColor(new Color(0,35,189));
		g2.fillRect((this.getWidth()- (msg1Width + msg2Width +msg3Width) )/2  , (this.getHeight()/2) +titleMetrics.getDescent(), (msg1Width + msg2Width +msg3Width) , msgHeight+msgMetrics.getDescent());
		
		g2.setFont(font2);
		g2.setColor(Color.white);
		g2.drawString(text1 + text2 + text3,(this.getWidth()  - (msg1Width + msg2Width +msg3Width) )/2  , ((this.getHeight() + titleMetrics.getDescent() )/2) +titleMetrics.getDescent() + msgMetrics.getAscent());
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		String getTT,getT1,getT2,getT3;
		getTT = JOptionPane.showInputDialog("Title");
		if(getTT!=null){
			title = getTT;
		}
		getT1 = JOptionPane.showInputDialog("message 1");
		if(getT1 != null){
			text1 = ham + getT1 + "..  ";
		}
		getT2 = JOptionPane.showInputDialog("message 2");
		if(getT2 != null){
			text2 = ham + getT2 + "..  ";
		}
		getT3 = JOptionPane.showInputDialog("message 3");
		if(getT3 != null){
			text3 = ham + getT3 + " ";
		}		
		repaint();
		
	}

	
	
	
	
	@Override
	public void mousePressed(MouseEvent e) {	
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
}
