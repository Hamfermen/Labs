public class Main{
	public static void main(String[] args){
		// Инициализация массива размера 6 и заполнение его четными числами от 6 до 16 включительно
		int[] c = new int[6];
		int k = 0;
		for (int i = 6; i <= 16; i+=2){
			c[k] = i;
			k++;
		}
		// Инициализация массива размера 10 и заполнение его рандомными числами от -8.0 до 13.0
		float[] x = new float[10];
		for (int i = 0; i < 10; i++){
			// Получение рандомного числа от 0 до 1.0 через класс java.lang.Math и преобразование промежутка [0, 1.0] до [-8.0, 13.0]
			x[i] = (float) Math.random() * 21 - 8;
		}
		
		// Инициализация двумерного массива для задания 3
		
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
		// Форматированный вывод в экспоненциальной записи
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
		// Форматированный вывод в обычной записи
		System.out.println("\n------------------Форматированный вывод в обычной записи------------------\n");
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 10; j++) {
				System.out.printf(" %.3f ", arr[i][j]);
			}
			System.out.println();
		}
	}
}