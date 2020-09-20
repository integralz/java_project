package hw2;

public class s20141214hw2_1 {

	public static void main(String[] args) {
		double x0,x1;
		int iteration = 1;
		
		x0 = 2;
		x1 = 3;
		
		System.out.println("f'(x) = 2x, x1 = " + (x0 - (x0*x0 - 5) / (2*x0)));
		
		while(x1 != x0) {
			x1 = x0;
			x0 = x0 - (x0*x0 - 5) / (2*x0);
			System.out.println("Iteration " +  iteration + " :" + String.format("%.5f", x0));
			iteration++;
		}
	}

}
