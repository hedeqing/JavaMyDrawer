package com.mypack;

import java.util.ArrayList;
import java.util.List;

import com.mypack.Shape;

public class Board {
	private static List<Shape> shapes;

	public Board() {
		shapes = new ArrayList<Shape>();
	}
	public void insertShape(Shape shape) {
		shapes.add(shape);
	}
	public void refreshShape() {
		for(Shape shape:shapes) {
			shape.draw();
		}
	}
	
}
