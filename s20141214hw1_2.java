package hw1;

public class s20141214hw1_2 {

	public static void main(String[] args) {
	
		int lotto[] = {7, 18, 32, 37, 44};
		int pick[] = new int[50];
		int count = 0, iter = 0;
		
		for(int i = 0; i < 50; i++) {
			pick[i] = i;
		}
		
		while(count < 3) {
			
			iter++;
			count  = 0;
	
			for(int i = 0; i < 5; i++) {
				int a;
				int pick1 = (int)((50-i)*Math.random());
			
				a = pick[pick1];
				pick[pick1] = pick[49 - i];
				pick[49 - i] = a;
			}
		
			for(int i = 0; i < 5; i++) {
				for(int u = 0; u < 5; u++) {
					if(pick[49 - i] ==  lotto[u]) {
						count ++;
						break;
					}
				}
		}
		}
		System.out.println("number of iteration : " + iter);
		System.out.print("final random number : ");
		for(int i = 0; i < 5; i++)
		System.out.print(pick[49 - i] + " ");
		System.out.println();
	}

}
