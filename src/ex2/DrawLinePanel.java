package ex2;

import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawLinePanel extends JPanel{
	
	public FreeLineList flist;
	DrawLinePanel(FreeLineList list){
		flist = list;
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setColor(flist.getColor());
		for(int i = 0 ; i < flist.getSize() ; i++){
			g.drawLine(((int)flist.getLine().get(i).getX()), ((int)flist.getLine().get(i).getY())
					, ((int)flist.getLine().get(i+1).getX()), ((int)flist.getLine().get(i+1).getY()));
			if(i==flist.getSize()-2){
				break;
			}
		}
		g.drawRect(flist.getMinX(), flist.getMinY(), (flist.getMaxX()-flist.getMinX()), (flist.getMaxY()-flist.getMinY()));
		repaint();
	}
}
