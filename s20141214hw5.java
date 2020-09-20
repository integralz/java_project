package hw5;

import java.awt.*;
import java.awt.event.*;

class WindowDestroyer extends WindowAdapter
{
    public void windowClosing(WindowEvent e) 
    {
        System.exit(0);
    }
}

class BounceThread extends Frame implements ActionListener
{  	 private Canvas canvas; 
	public BounceThread()
   	{  	canvas = new Canvas();
      	add("Center", canvas);
      	Panel p = new Panel();
		Button s = new Button("Start");
		Button c = new Button("Close");
		p.add(s);	p.add(c);
      	s.addActionListener(this);
		c.addActionListener(this);
      	add("South", p);
   	}
	public void actionPerformed(ActionEvent evt)
   	{  	if (evt.getActionCommand() == "Start")
      	{  	Ball b = new Ball(canvas);
         		b.start();
      	}
      	else if (evt.getActionCommand() == "Close")
         	System.exit(0);
   	}
	private Canvas box;
	private int maxnum = 0;
	private int[] start = {16, 16, 16, 16, 16};{
	for(int i = 0; i < 5; i++) {
		maxnum += start[i];
	}}
   	private double[] XSIZE = new double[maxnum];
   	private double[] YSIZE = new double[maxnum];
   	private double []x = new double[maxnum];
   	private double []y = new double[maxnum];
   	private double []dx = new double[maxnum];
   	private double []dy = new double[maxnum];  
   	private double change;{
   	for(int i = 0; i < 5; i++) {
   		XSIZE[i] = 16;
   		YSIZE[i] = 16;
   		x[i] = 190;
   		y[i] = 120;
   	}
   	dx[0] = 2; dx[1] = -2; dx[2] = 2; dx[3] = -2; dx[4] = 1;
   	dy[0] = 2; dy[1] = 2; dy[2] = -2; dy[3] = -2; dy[4] = 3;{
   		for(int i = 5; i < maxnum; i++) {
   			XSIZE[i] = 0;
   			YSIZE[i] = 0;
   			x[i] = 0;
   			y[i] = 0;
   			dx[i] = 0;
   			dy[i] = 0;
   		}
   	}
   	}
   	private int ballnum = 5;
   	private int plusball = 0;
   	
	class Ball extends Thread
	{  	public Ball(Canvas c) 	{ box = c; }
		public void draw()
   		{  	Graphics g = box.getGraphics();
   		for(int i = 0; i < ballnum; i++)
      		g.fillOval((int)x[i], (int)y[i], (int)XSIZE[i], (int)YSIZE[i]);
      		g.dispose();	}
   		public void move(int time){
   			plusball = 0;
   			Graphics g = box.getGraphics();
      		g.setXORMode(box.getBackground());
      		for(int i = 0; i < ballnum; i++) {
      			g.fillOval((int)x[i], (int)y[i], (int)XSIZE[i], (int)YSIZE[i]);
      		}
      		for(int i = 0; i < ballnum; i++) {
      		x[i] += dx[i];	y[i] += dy[i];
      		Dimension d = box.getSize();
      		if (x[i] < 0) { x[i] = 0; dx[i] = -dx[i]; }
      		if (x[i] + XSIZE[i] >= d.width) { x[i] = d.width - XSIZE[i]; dx[i] = -dx[i]; }
      		if (y[i] < 0) { y[i] = 0; dy[i] = -dy[i]; }
      		if (y[i] + YSIZE[i] >= d.height) { y[i] = d.height - YSIZE[i]; dy[i] = -dy[i]; }
      		}
      		for(int i = 0; i < ballnum; i++) {
      		if(time > 20)
          		for(int j = i + 1; j < ballnum; j++) {
          			if(((x[i] + XSIZE[i] / 2) - (x[j] + XSIZE[j] / 2))*((x[i] + XSIZE[i]/ 2) - (x[j] + XSIZE[j] / 2)) + 
          					((y[i] + YSIZE[i] / 2) - (y[j] + YSIZE[j] / 2))*((y[i] + YSIZE[i] / 2) - (y[j] + YSIZE[j] / 2)) <= (XSIZE[i]/2 + XSIZE[j]/2)*(XSIZE[i]/2 + XSIZE[j]/2) +
          					(YSIZE[i]/2 + YSIZE[j]/2)*(YSIZE[i]/2 + YSIZE[j]/2) + 2*Math.sqrt((XSIZE[i]/2 + XSIZE[j]/2)*(YSIZE[i]/2 + YSIZE[j]/2))) {
           				change = dx[i];
          				dx[i] = dx[j];
          				dx[j] = change;
          				change = dy[i];
          				dy[i] = dy[j];
          				dy[j] = change;
          				if(XSIZE[i] != 1 && YSIZE[i] != 1) {
          					plusball++;
          					dx[ballnum + plusball - 1] = -dx[i];
          					dy[ballnum + plusball - 1] = dy[i];
          					x[ballnum + plusball - 1] = x[i] - 2 * dx[i];
          					y[ballnum + plusball - 1] = y[i];
          					x[i] += 3 * dx[i];
          					XSIZE[ballnum + plusball - 1] = XSIZE[i] /2;
          					YSIZE[ballnum + plusball - 1] = YSIZE[i] /2;
          					XSIZE[i] /= 2;
          					YSIZE[i] /= 2;
          				}
          				if(XSIZE[j] != 1 && YSIZE[j] != 1) {
          					plusball++;
          					dx[ballnum + plusball - 1] = -dx[j];
          					dy[ballnum + plusball - 1] = dy[j];
          					x[ballnum + plusball - 1] = x[j] - 2 * dx[j] ;
          					y[ballnum + plusball - 1] = y[j];
          					x[j] +=3 * dx[j];
          					XSIZE[ballnum + plusball - 1] = XSIZE[j] / 2;
          					YSIZE[ballnum + plusball - 1] = YSIZE[j] / 2;
          					XSIZE[j] /= 2;
          					YSIZE[j] /= 2;
          				}
          			}
          		}
       		}
      		
      		ballnum += plusball;
      		for(int i = 0; i < ballnum; i++)
      			g.fillOval((int)x[i], (int)y[i], (int)XSIZE[i], (int)YSIZE[i]);
      		g.dispose();	}
		public void run()
   		{  	int i = 1;
   			int count = 0;
			draw();
      		for(int a = 0; a >= 0; a++){
      			for(int b = 0; b < ballnum; b++) {
      				if(XSIZE[b] == 1)
      					count++;
      			}
      			if(count == ballnum) break;
      			move(i);
      			i++;
      			count = 0;
         			try { Thread.sleep(50); } catch(InterruptedException e) {}} 
   		}
	}
}

public class s20141214hw5 {

	public static void main(String[] args) {
		Frame f = new BounceThread();
      	f.setSize(400, 300);
      	WindowDestroyer listener = new WindowDestroyer();  
      		f.addWindowListener(listener);
      	f.setVisible(true);  
 	}
}