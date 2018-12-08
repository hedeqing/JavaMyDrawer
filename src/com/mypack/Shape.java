package com.mypack;

import org.eclipse.swt.graphics.GC;

public interface Shape {
    int top =0;
	int left = 0;
	int width =0;
	int height = 0;
	GC gcmain =null ;
  void draw();
  void setTop(int i);
  void setLeft(int i);
  void setHeight(int i);
  void setWidth(int i);
  void setGcmain(GC gcmain);
}
