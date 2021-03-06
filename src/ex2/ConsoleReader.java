package ex2;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class ConsoleReader {
	private FreeLineList fl;
	private Scanner scan;

	ConsoleReader() {
		scan = new Scanner(System.in);
		fl = new FreeLineList(Color.BLACK);
	}

	public Color selectColor() {
		Color color = JColorChooser.showDialog(null, "Color", Color.BLACK);
		if(color == null){
			color = Color.BLACK;
		}
		fl.setColor(color);
		return color;
	}

	public Point readPoint() {
		return fl.getLine().get(0).getLocation();
	}

	public void enterLine() {
		System.out.println("Select your color:");
		selectColor();
		System.out.println("You picked color - " + fl.getColor().toString());
		while (true) {
			System.out.print("Enter x1: ");
			int x1 = scan.nextInt();
			System.out.print("Enter y1: ");
			int y1 = scan.nextInt();
			fl.add(new Point(x1, y1));
			System.out.print("Do you want to add more point? (y/n) ");
			String choice = scan.next();
			if (choice.equalsIgnoreCase("n")) {
				break;
			}
		}
		System.out.println("--------------------");
		System.out.println("List of your points: ");
		for(int i = 0 ; i < fl.getSize() ; i++){
			System.out.print("(" + (int)fl.getLine().get(i).getX() + ", " + (int)fl.getLine().get(i).getY()+")");
		}

	}

	public void drawLine() {
		System.out.println();
		System.out.println("Your border points (x1,y1), (x2,y2): " 
				+ " ("+fl.getMinX()+", "+fl.getMinY() + "), ("+fl.getMaxX()
				+", "+fl.getMaxY()+")");
		if(fl.getSize()==1&&fl!=null){
			System.out.println("Not enough point to draw a line!");
		}
		else{
			JFrame frame = new JFrame();
			frame.setSize(600, 600); 
			frame.setTitle("DrawLine Frame");
			frame.add(new DrawLinePanel(fl));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
	}
}
