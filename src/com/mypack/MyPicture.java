package com.mypack;

import org.eclipse.swt.widgets.Button;

import org.eclipse.swt.widgets.Display;


import org.eclipse.swt.widgets.Shell;

import com.mypack.Board;

import java.lang.reflect.Constructor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

public class MyPicture {
	private static GC gcMain = null;
	protected static Shell shell;
	private static Board board = null;
	private static int startX;
	private static int startY;
	private static boolean leftButtonDown = false;
	private static Display display  = null; 
	private static int lastWidth ;
	private static  int lastHeight ;
	private static String shapeType = "Rect";
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {		
		try {
			
			MyPicture window = new MyPicture();
			window.open();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent arg0) {
				board = new Board();
				gcMain = new GC(shell);
				board.refreshShape();
				shell.layout();
			}
		});

		
		shell.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent arg0) {
				if(leftButtonDown) {
					/*Rect
					gcMain.setLineStyle(SWT.LINE_DOT);
					gcMain.setForeground(shell.getBackground());
					gcMain.drawRectangle(startX, startY,lastWidth, lastHeight);
					gcMain.setForeground(display.getSystemColor(SWT.COLOR_BLUE));
					gcMain.drawRectangle(startX, startY,arg0.x - startX, arg0.y - startY);
					lastHeight = arg0.y-startY;
					lastWidth = arg0.x - startX;
					gcMain.setLineStyle(SWT.BORDER_SOLID);
					*/
					gcMain.setLineStyle(SWT.LINE_DOT);
					gcMain.setForeground(shell.getBackground());
					gcMain.drawRectangle(startX, startY,lastWidth, lastHeight);
					gcMain.setLineStyle(SWT.BORDER_SOLID);
					gcMain.setForeground(display.getSystemColor(SWT.COLOR_BLACK));
					
				}
			}
		});
		shell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				if(e.button ==1 ) {
					shell.setCursor(new Cursor(null,SWT.CURSOR_ARROW));
					lastHeight = 0;
					lastWidth = 0;
					leftButtonDown = false;
					int   width= e.x-startX;
					int height = e.y - startY;
					gcMain = new GC(shell);
//					Rect rect = new Rect(startX,startY,height,width,gcMain);
//					rect.draw();
//					board.insertShape(rect);
//					Circle circle = new Circle(startX,startY,width,height,gcMain);
//					circle.draw();
//					board.insertShape(circle);
//					shell.layout();
					Shape shape1 = null;
					board = new Board();
					
					try {
						Class shapeclass = Class.forName("com.mypack."+shapeType);
						shape1 = (Shape)shapeclass.newInstance();
						shape1.setTop(startX);
						shape1.setLeft(startY);
						shape1.setHeight(e.y-startY);
						shape1.setWidth(e.x - startY);
						shape1.setGcmain(gcMain);
						
						
					//	Object oShape= shapeclass.newInstance();
					

						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(shape1 !=null) {
						board.insertShape(shape1);
						board.refreshShape();
					}
					
//					Shape shape1;
//					board = new Board();
//					switch (shapeType) {
//					case "Rect":
//						shape1 = new Rect(startX,startY,width,height,gcMain);
//						
//						break;
//					case "Circle":
//						shape1 = new Circle(startX,startY,width,height,gcMain);
//	
//						break ; 
//					default:
//						shape1 = new Rect(startX,startY,width,height,gcMain);
//				
//						break;
//					}
//					board.insertShape(shape1);
//					board.refreshShape();
				}
			}
			@Override
			public void mouseDown(MouseEvent e) {
				shell.setCursor(new Cursor(null, SWT.CURSOR_CROSS));
				leftButtonDown = true;
				startX = e.x;
				startY = e.y;
			}
		});
		
	    display = Display.getDefault();
	    
		shell.setLayout(new RowLayout());
		shell.setTouchEnabled(true);
		gcMain = new GC(shell);
		//shell.setLayout(new RowLayout(SWT.HORIZONTAL));
		Button btnRect = new Button(shell,SWT. NONE);
		btnRect.setSelection(true);
		btnRect.setTouchEnabled(true);
		btnRect.setVisible(true);
		btnRect.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					Class  shapeclass =  Class.forName("com.mypack.Rect");
					Object oShape = shapeclass.newInstance();
					Rect shape = (Rect) oShape;
					shape.setTop(100);
					shape.setLeft(200);
					shape.setWidth(300);
					shape.setHeight(200);
					
					System.out.println(shape.getWidth());
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				shapeType = "Rect";
			}
		});
		btnRect.setText("Rect");
		
		Button btnCircle = new Button(shell, SWT.None);
		btnCircle.setTouchEnabled(true);
		btnCircle.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shapeType = "Circle";
			}
		});
		btnCircle.setText("Circle");
//		
//		Button btnRoundrect = new Button(shell, SWT.NONE);
//		btnRoundrect.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				
//			}
//		});
//		btnRoundrect.setText("RoundRect");
		
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		


	}
}
