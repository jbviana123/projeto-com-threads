package cursojava.thread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTimeThread extends JDialog {
	    private JPanel jPanel = new JPanel (new GridBagLayout());
	    private JLabel descricaoHora = new JLabel("nome");
	    private JTextField mostrarTempo = new JTextField();
	    
	    private JLabel descricaoHora2 = new JLabel("E-Mail");
	    private JTextField mostrarTempo2 = new JTextField();
	    
	    private JButton jButton = new JButton("Gerar...");
	    private JButton jButton2 = new JButton("Stop");
	    
	    private ImplementacaoFilaThread fila =  new ImplementacaoFilaThread(); 
	    
//	    private Runnable thread1 =  new Runnable() {
//			public void run() {
//				while(true) {/*fica sempre rodando*/
//					mostrarTempo.setText(new SimpleDateFormat("dd/MM/YYYY hh:mm.ss").
//							format(Calendar.getInstance().getTime()));
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					
//				}
//			}
//	    };
//	    
//	    private Runnable thread2 =  new Runnable() {
//			public void run() {
//				while(true) {/*fica sempre rodando*/
//					mostrarTempo2.setText(new SimpleDateFormat("dd-MM-YYYY hh:mm:ss").
//							format(Calendar.getInstance().getTime()));
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					
//				}
//			}
//	    };
//	    
//	    private Thread thread1time;
//	    private Thread thread2time;
	    
	    
	    
    
	public TelaTimeThread() {/*Executa o que tiver dentro no momento da abertura ou execuçao*/
		                                  /*dizer que queremos fazer o controle*/
		
		setTitle("Minha tela de time com thread");
		setSize(new Dimension(500,240));
		setLocationRelativeTo(null);
		//setResizable(false);
		
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth=2;
		gridBagConstraints.insets=new Insets(5,10, 5,5);
		gridBagConstraints.anchor=gridBagConstraints.WEST;
		
		descricaoHora.setPreferredSize(new Dimension(200,25));
		jPanel.add(descricaoHora,gridBagConstraints);
		
		mostrarTempo.setPreferredSize(new Dimension(200,25));
		mostrarTempo.setEditable(true);
		gridBagConstraints.gridy ++;
		jPanel.add(mostrarTempo,gridBagConstraints);
		
		descricaoHora2.setPreferredSize(new Dimension(200, 25));
		//mostrarTempo2.setEditable(true);
		gridBagConstraints.gridy ++;
		jPanel.add(descricaoHora2,gridBagConstraints); 
		
		mostrarTempo2.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy ++;
		jPanel.add(mostrarTempo2, gridBagConstraints);
		
		gridBagConstraints.gridwidth=1;
		
		jButton.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy ++;
		jPanel.add(jButton,gridBagConstraints);
		
		jButton2.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx ++;
		jPanel.add(jButton2,gridBagConstraints);
		
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(fila == null) {
					fila = new ImplementacaoFilaThread();
					fila.start();
				}
				for(int qtd=0 ; qtd<10; qtd++) {
				ObjetoFilaThread filaThread = new ObjetoFilaThread();
				filaThread.setNome(mostrarTempo2.getText());
				filaThread.setEmail(mostrarTempo.getText()+ "-" +qtd);
				
				fila.add(filaThread);
				}
//				thread1time = new Thread(thread1);
//				thread1time.start();
//				thread2time = new Thread(thread2);
//				thread2time.start();
				
//				jButton2.setEnabled(true);
			}
		});
		
		jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			     fila.stop();
			     fila = null;
//				thread2time.stop();
				
//				jButton.setEnabled(true);
//				jButton2.setEnabled(false);
				
			}
		});
		
//		jButton2.setEnabled(false);
		
		
		fila.start();
		add(jPanel,BorderLayout.WEST);
		/*sempre sera o ultimo comando*/
		setVisible(true);/*TORNA A TELA VISIVEL PARA O USUARIO*/
	}
}
