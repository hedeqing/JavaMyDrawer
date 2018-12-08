package com.mypack;

import org.eclipse.swt.graphics.GC;

public class Rect implements Shape {

	private int top;
	private int left;
	private int width;
	private int height;
	private GC gcmain;
	
	
	public Rect() {
		super();
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		gcmain.drawRectangle(top, left, width, height);
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public GC getGcmain() {
		return gcmain;
	}
	public void setGcmain(GC gcmain) {
		this.gcmain = gcmain;
	}
	/**
	 *   alt+shift+s
	 * @param top
	 * @param left
	 * @param width
	 * @param height
	 * @param gcmain
	 */
	public Rect(int top, int left, int width, int height, GC gcmain) {
		super();
		this.top = top;
		this.left = left;
		this.width = width;
		this.height = height;
		this.gcmain = gcmain;
	}
	


}
