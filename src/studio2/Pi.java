package studio2;

public class Pi {

	public static void main(String[] args) {
		int inside = 0;
		double pi;
		for (int i=0; i<100000; i++) {
			double x = Math.random();
			double y = Math.random();
			double distance = Math.pow(x, 2) + Math.pow(y,2);
			if (distance <= 1) {
				inside ++;
			}
		}
		pi = (double) inside / 100000.0 * 4.0;
		System.out.println(pi);

	}

}
