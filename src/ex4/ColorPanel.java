package ex4;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

public class ColorPanel extends JPanel implements MouseListener , MouseMotionListener{
	
	private ArrayList<FreeLineList> f = new ArrayList<FreeLineList>();
	private ImageIcon image = new ImageIcon("christmas.jpg");
	private Color color;
	private int count=0;
	
	ColorPanel(){
		color = Color.GREEN;
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(image.getImage(), 0, 0,this.getWidth(),this.getHeight(), null);
		Graphics2D g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(8));
		
		for(int i = 0 ; i < f.size() ; i ++){
			for(int k = 1 ; k < f.get(i).getSize() ; k++){
				g.setColor(f.get(i).getColor());
				g.drawLine((int)f.get(i).getLine().get(k-1).getX(), (int)f.get(i).getLine().get(k-1).getY(), 
						(int)f.get(i).getLine().get(k).getX(), (int)f.get(i).getLine().get(k).getY());
			}
		}
		repaint();
	}	
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {	
		if(e.getButton() == MouseEvent.BUTTON3){
			color = JColorChooser.showDialog(null ,"Choose Color !!", Color.BLACK);
		}
	}
	@Override
	public void mouseDragged(MouseEvent d) {
		f.get(count-1).add(new Point(d.getX(),d.getY()));
	}
	@Override
	public void mousePressed(MouseEvent e) {
		f.add(new FreeLineList(color));
		count++;
	}
	
	
	
	
	
	
	
	@Override
	public void mouseReleased(MouseEvent e) {	
	}	
	@Override
	public void mouseMoved(MouseEvent m) {
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
	}
	@Override
	public void mouseExited(MouseEvent arg0) {	
	}	
}
