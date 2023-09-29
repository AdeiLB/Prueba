
public class EjemploLamda {
	public static void main(String[] args) {
		int a = 3;
		
		
		//IncrementarUnidad incrementar = new IncrementarUnidad();
		Operacion incrementar = x-> x+1;
		
		int b = incrementar.incrementar(a);
		System.out.println(b);
	}

	
}
