public class Main{
	public static void main(String[] args){
		int[] c = new int[6];
		int k = 0;
		for (int i = 6; i <= 16; i+=2){
			c[k] = i;
			k++;
		}
		float[] x = new float[10];
		for (int i = 0; i < 10; i++){

			x[i] = (float) Math.random() * 21 - 8;
		}
		double[][] arr = new double[6][10];
		for (int i = 0; i < 6; i++){
			for (int j = 0; j < 10; j++){
				if (c[i] == 8){
					arr[i][j] = Math.pow(2 * Math.pow((Math.log(Math.abs(x[j])) + 1 / 3.0d) / Math.tan(x[j]), 2), Math.atan((1 / Math.pow(Math.E, Math.abs(x[j])))));
				}else if (c[i] == 6 || c[i] == 10 || c[i] == 14) {
					arr[i][j] = Math.pow((Math.asin(Math.cos(x[j])) - 1) / 4.0d, 2);
				}else {
					arr[i][j] = Math.pow(Math.E, Math.pow(Math.tan(Math.cos(x[j])), 2 * Math.sin(Math.tan(x[j]))));
				}
			}
		}
		System.out.println("\n------------------Форматированный вывод в экспоненциальной записи------------------\n");
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 10; j++) {
				if (Double.isNaN(arr[i][j])) {
					System.out.format(" %f ", arr[i][j]);
				}else {
					System.out.format("% .3e ", arr[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println("\n------------------Форматированный вывод в обычной записи------------------\n");
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.printf(" %.3f ", arr[i][j]);
			}
			System.out.println();
			
		}
	}
}