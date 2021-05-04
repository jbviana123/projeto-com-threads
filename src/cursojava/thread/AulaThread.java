package cursojava.thread;

import javax.swing.JOptionPane;

public class AulaThread {
    
	public static void main(String[] args) throws InterruptedException {
		/*envio de nota fiscal*/
		
		Thread threademail = new Thread(thread1);
		threademail.start();
				
		/*=============Divisao das threads==========================*/
		
		/*thread processamento paralelo do envio de email*/
		
		Thread threadNota = new Thread(thread2);
		threadNota.start();
	
		System.out.println("Chegou ao fim do codigo de teste da thread");
		JOptionPane.showMessageDialog(null, "Sistema continua executando para Usuario");
	}
	
	private static Runnable thread2 = new Runnable() {
		
		@Override
		public void run() {
			 for(int pos=0 ; pos<10 ; pos++) {
					System.out.println("executando alguma rotina:enviando email");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}	
			
		}
	};
	private static Runnable thread1 = new Runnable() {
		
		@Override
		public void run() {
			for(int pos=0 ; pos<10 ; pos++) {
				System.out.println("executando alguma rotina:enviando Nota Fiscal");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
			
		}
	};
}
