package cursojava.thread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;


public class ImplementacaoFilaThread extends Thread{
	
	private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_filha = new 
			ConcurrentLinkedQueue<ObjetoFilaThread>();
	
	public static void add(ObjetoFilaThread objetoFilaThread) {
		pilha_filha.add(objetoFilaThread);
	}
	
	@Override
	public void run() {
		
		System.out.println("fila Rodando");
		
		while(true) {
			
		Iterator iteracao = pilha_filha.iterator();
		synchronized (pilha_filha) {/*Bloque o acesso desta lista por outros processos*/
		
			while(iteracao.hasNext()) {/*enquanto tiver dados na lista ira processar*/
			
			ObjetoFilaThread processar = (ObjetoFilaThread) iteracao.next();/*pega o objeto atual*/
			/*processar 10 mil nota fiscal*/
			/*gerar uma lista enorme de PDF*/
			/*Gerar um envio em massa de email*/
			System.out.println("-----------------------------------------------");
			System.out.println(processar.getEmail());
			System.out.println(processar.getNome());
		    iteracao.remove();
		    try {
				Thread.sleep(1000);/*dar um tempo de descarga da memoria*/
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
			try {
				Thread.sleep(1000);/*Processou toda lista da um tempo descarga  de memoria*/
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	 }
		
	}
		
}	  
    
 
	

