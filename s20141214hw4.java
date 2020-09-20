package hw4;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

 


class WindowDestroyer extends WindowAdapter
{
    public void windowClosing(WindowEvent e) 
    {
        System.exit(0);
    }
}
class calculate{
	public static double method(int start, int end, String[] input) {
		int operation = 0, unit = 0;
		double []number;
		String []index1;
		double partans=1, transnum = 0;
		for(int i = start; i<= end; i++) {
			if(input[i] == "/" || input[i] == "*" || input[i] == "-"|| input[i] == "+")
				operation++;
			else unit++;
		}
		index1 = new String[operation];
		number = new double[unit];
		
		operation =0; unit = 0;
		for(int i = start; i <= end; i++) {
			if(input[i] == "/" || input[i] == "*" || input[i] == "-"|| input[i] == "+") {
				index1[operation] = input[i];
				operation++;
				number[unit] = transnum;
				transnum = 0;
				unit++;
			}
			else {
				if(transnum == 0)
					transnum =Integer.parseInt(input[i]);
				else {
					transnum *= 10;
					transnum += Integer.parseInt(input[i]);
				}
			}
			  number[unit] = transnum;
			
		}
	
		
		for(int i = 0; i < operation; i++) {
			if(index1[i] == "*") {
				partans = number[i]*number[i+1];
				number[i] = partans;
				for(int j = i + 2; j < operation + 1; j++) {
					number[j-1] = number[j];
					index1[j-2] = index1[j-1];
				}
				i--;
				operation--;
			}
			else if(index1[i] == "/") {
				partans = number[i]/number[i+1];
				number[i] = partans;
				for(int j = i + 2; j < operation + 1; j++) {
					number[j-1] = number[j];
					index1[j-2] = index1[j-1];
				}
				i--;
				operation--;
			}
		}
		partans = number[0];
		for(int i = 0; i < operation; i++) {
			switch(index1[i]) {
			case "+" : partans += number[i+1];
			break;
			case "-" : partans -= number[i+1];
			break;
			}
		}
		
		return partans;
	}
}
class ButtonDemo implements ActionListener {
	private Frame f;
	private String []input = new String[200];
	private int node = 0;
	private double ans;
	private TextField text = new TextField();
	private String strans;
	private Panel p = new Panel();
	private String write="";
	
	public ButtonDemo () {
		Button []index = new Button[20];
		String []index1 = {"7", "8", "9", "/", "c", "4", "5",
				"6", "*", "<-", "1", "2", "3", "-", "(", "0", ".",
				"=", "+", ")"};
    	
		f = new Frame("Calculator");
		
		for(int i = 0; i < 20; i++) {
			index[i] = new Button(index1[i]);
		}
		
		f.add("North", text);
		f.add("Center", p);
   		p.setLayout(new GridLayout(4,5));
   		for(int i = 0; i < 20; i++) {
   			index[i].addActionListener(this);
   			p.add(index[i]);
   		}
   		
   		f.pack();
   		WindowDestroyer listener = new WindowDestroyer();
   		f.addWindowListener(listener);
		f.setVisible(true);
  	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() != "<-" && e.getActionCommand() != "c") {
			System.out.print(e.getActionCommand());
		}
		if(e.getActionCommand() != "<-" && e.getActionCommand() != "c" && e.getActionCommand() != "=") {
			input[node] = e.getActionCommand();
			node++;
			write="";
			for(int i = 0; i < node; i++)
				write += input[i];
			text.setText(write);
			}
		else if(e.getActionCommand() == "<-")
			if(node == 0);
			else {
				write="";
				node--;
				for(int i = 0; i < node; i++)
					write += input[i];
				text.setText(write);
			}
		else if(e.getActionCommand() == "c") {
			node = 0;
			write="";
			text.setText(write);
		}
		else {
			write= "";
			input[node] = e.getActionCommand();
			ans = calculate.method(0, node-1, input);
			System.out.println(ans);
			strans = Double.toString(ans);
			for(int i = 0; i <= node; i++)
				write += input[i];
			text.setText(write + strans);
			for(int a = 0; a <= node; a++)
			System.out.println(input[a]);
			node = 0;
		}
	}
  	}

public class s20141214hw4 {

	public static void main(String[] args) {
		ButtonDemo bd = new ButtonDemo();

	}

}
