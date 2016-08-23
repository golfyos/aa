package ex3;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawStarPanel extends JPanel implements ActionListener {

	private ImageIcon image = new ImageIcon("star.png");
	private ArrayList<Point> ap;
	private Random r;
	private int countAmountStar = 0;
	private int countFlash = 1;
	private int countFlashRound = 0;
	private Timer t;

	public DrawStarPanel() {
		r = new Random();
		ap = new ArrayList<Point>();
		t = new Timer(1000, this);
		t.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (countFlash != 0) {
			for (int i = 0; i < ap.size(); i++) {
				g.drawImage(image.getImage(), (int) ap.get(i).getX(), (int) ap.get(i).getY(), 100, 100, null);
			}
		}
		repaint();
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (countAmountStar < 10) {
			ap.add(new Point(ranX(), ranY()));
			countAmountStar++;
		} 
		else if(countAmountStar==10){
			countAmountStar = 20;
			countFlash = 0;
			countFlashRound++;
		}
		else if(countFlash==0){
			countAmountStar = 10;
			countFlash = 1;
		}
		if(countFlashRound==4){
			countAmountStar = 0;
			countFlash = 1;
			for(int k = ap.size()-1 ; k >= 0 ; k--){
				ap.remove(k);
			}
			countFlashRound = 0;
		}
	}
	
	public int ranX() {
		int ran = r.nextInt(this.getWidth()-100);
		return ran;
	}

	public int ranY() {
		int ran = r.nextInt(this.getHeight()-100);
		return ran;
	}

}
