package com.mypack;



import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class Main {
    public static void main(String[] args) {
	Display display = Display.getDefault();
	Shell shell = new Shell();
	shell.setSize(450 ,300 );
	shell.setText("hello World");
	shell.setLayout(new FillLayout());
	Label  label = new Label(shell,SWT.CENTER);
	label.setText("ÄãºÃÂð");
	Color red =new Color(display,255,0,0);
	label.setForeground(red);
	shell.open();
	shell.layout();
	while(!shell.isDisposed()) {
		if(!display.readAndDispatch()) {
			display.sleep();
			}
		}
	
	}
}
