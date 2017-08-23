package br.estacio.progII.ex01;
import javax.swing.*;

import br.estacio.progII.ex03.Ex03Class;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class EX01Frame extends JFrame {


	  private JPanel pnlTopo;
	  private JPanel pnlEsquerda;
	  private JPanel pnlCentro;

	  private JLabel lbDe;
	  private JLabel lbAte;
	  private JLabel lbTab;
	  private JTextField txtTab;
	  private JTextField txtDe;
	  private JTextField txtAte;
	  private JButton btCalcular; 
	  
	  public void Janela() {
		     
		    configurarFrame();
		    instanciarComponentes();
		    definirEventos();
		    montarFrame();
		  }
	  private void definirEventos() {

		    btCalcular.addActionListener(new ActionListener() {
		      
		      @Override
		      public void actionPerformed(ActionEvent e) {        
		        int tab = Integer.parseInt(txtTab.getText());
		        int de = Integer.parseInt(txtDe.getText());
		        int ate = Integer.parseInt(txtAte.getText());
		        
		        
		        EX01Class classe = new EX01Class();
		        
		        try {     

		          pnlCentro.removeAll();
		          adicionarTitulo("Tabuada Dinamica", pnlCentro);

		          List<String> calculo = classe.Calcular(tab, de, ate);
   
		          for(String valor : calculo) {
		            
		            JLabel label = new JLabel(valor);
		            label.setHorizontalAlignment(JLabel.CENTER);
		            pnlCentro.add(label);
		          }         
		        }
		        finally {
		          
		          pnlCentro.revalidate();
		        }        
		      }
		    });
		  }

	 private void montarFrame()
	 {
		    pnlTopo.add(lbTab);
		    pnlTopo.add(txtTab);
		    pnlTopo.add(lbDe);
		    pnlTopo.add(txtDe);    
		    pnlTopo.add(lbAte);
		    pnlTopo.add(txtAte);
		    pnlTopo.add(btCalcular);
		    
		    this.add(pnlTopo, BorderLayout.PAGE_START);
		    this.add(pnlCentro, BorderLayout.CENTER);
	 }
	 private void instanciarComponentes() {
		    
		    pnlTopo  = new JPanel(new FlowLayout());
		    pnlTopo.setBackground(Color.BLACK);

		    pnlCentro = new JPanel(new GridLayout(20, 1));
		    pnlCentro.setBackground(Color.LIGHT_GRAY);
		    adicionarTitulo("Tabuada Dinamica", pnlCentro);
		    
		    lbDe = new JLabel("De: ");
		    lbDe.setFont(new Font("Consolas", Font.BOLD, 14));
		    lbDe.setForeground(Color.WHITE);
		    
		    lbTab = new JLabel("Tabuada: ");
		    lbTab.setFont(new Font("Consolas", Font.BOLD, 14));
		    lbTab.setForeground(Color.WHITE);
		    
		    lbAte = new JLabel("Ate: ");
		    lbAte.setFont(new Font("Consolas", Font.BOLD, 14));
		    lbAte.setForeground(Color.WHITE); 
		    
		    
            txtTab = new JTextField("9", 10);
		    txtAte = new JTextField("9", 10); 
		    txtDe = new JTextField("1", 10);
		    
		    btCalcular = new JButton("Calcular");    
		  }
	  private void configurarFrame() {
		    
		    this.setLayout(new BorderLayout(5, 5));
		    this.setSize(640, 480);
		    this.setLocationRelativeTo(null);
		    this.setResizable(false);    
		    this.setTitle("Tabuada Automatica EX01");
		    
		  }
	 private static void adicionarTitulo(String titulo, JPanel painel) {
		    
		    JLabel lbTitulo = new JLabel("  " + titulo + "  ");
		    lbTitulo.setFont(new Font("Calibri", Font.BOLD, 20));
		    lbTitulo.setHorizontalAlignment(JLabel.CENTER);
		    painel.add(lbTitulo);
		  }
       
}
