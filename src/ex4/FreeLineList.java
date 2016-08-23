package ex4;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

public class FreeLineList {
	private ArrayList<Point> line;
	private Color color;
	
	FreeLineList(Color color){
		line = new ArrayList<Point>();
		this.color = color;
	}
	public void add(Point p){
		line.add(p);
	}
	public ArrayList<Point> getLine(){
		return line;
	}
	public Color getColor(){
		return color;
	}
	public void setColor(Color color){
		this.color = color;
	}
	public int getSize(){
		return line.size();
	}
	public int getMaxX(){
		double max = line.get(0).getX();
		for(int i = 0 ; i < line.size() ; i ++){
			if(line.get(i).getX()>max){
				max = line.get(i).getX();
			}
		}
		return (int)max;
	}
	public int getMaxY(){
		double max = line.get(0).getY();
		for(int i = 0 ; i < line.size() ; i ++){
			if(line.get(i).getY()>max){
				max = line.get(i).getY();
			}
		}
		return (int)max;
	}
	public int getMinX(){
		double min = line.get(0).getX();
		for(int i = 0 ; i < line.size() ; i ++){
			if(line.get(i).getX()<min){
				min = line.get(i).getX();
			}
		}
		return (int)min;
	}
	public int getMinY(){
		double min = line.get(0).getY();
		for(int i = 0 ; i < line.size() ; i ++){
			if(line.get(i).getY()<min){
				min = line.get(i).getY();
			}
		}
		return (int)min;
	}
}
