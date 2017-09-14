package br.estacio.progII.ex02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import br.estacio.progII.ex01.Ex01Class;

public class Ex02Frame extends JFrame {

	  private JPanel pnlTopo;
	  private JPanel pnlEsquerda;
	  private JPanel pnlCentro;
	  private JLabel lbformato;
	  private JLabel lbSalarioB;
	  private JLabel lbBaseINSS;
	  private JLabel lbBaseIRPF;
	  private JLabel lbDescontoINSS;
	  private JLabel lbDescontoIRPF;
	  private JLabel lbSalarioL;
	  private JTextField txtSalarioB;
	  private JTextField txtBaseINSS;
	  private JTextField txtBaseIRPF;
	  private JTextField txtDescontoINSS;
	  private JTextField txtDescontoIRPF;
	  private JTextField txtSalarioL;
	  private JCheckBox  chformato;
	  private JButton btCalcular; 
	  
	  public void Janela()
	  {
		    configurarFrame();
		    InstanciarElementos();
		    definirEventos();
		    MontarFrame();
		  
	  }
	  
	  private void definirEventos()
	  {
		  chformato.addActionListener(new ActionListener() {
			  @Override
			  public void actionPerformed(ActionEvent e) {
			    try {
			    	if(chformato.isSelected())
			    	{
				 double BaseINSS = Double.parseDouble(txtBaseINSS.getText());
				 double DescontoINSS = Double.parseDouble(txtDescontoINSS.getText());
				 double BaseIRPF = Double.parseDouble(txtBaseIRPF.getText());
				 double DescontoIRPF = Double.parseDouble(txtDescontoIRPF.getText());
				 double SalarioL = Double.parseDouble(txtSalarioL.getText());
				 pnlCentro.removeAll();
				 txtBaseINSS.setText(NumberFormat.getCurrencyInstance().format(BaseINSS));
				 txtDescontoINSS.setText(NumberFormat.getCurrencyInstance().format(DescontoINSS));
				 txtBaseIRPF.setText(NumberFormat.getCurrencyInstance().format(BaseIRPF));
				 txtDescontoIRPF.setText(NumberFormat.getCurrencyInstance().format(DescontoIRPF));
				 txtSalarioL.setText(NumberFormat.getCurrencyInstance().format(SalarioL));
		         pnlCentro.add(lbBaseINSS);
                 pnlCentro.add(txtBaseINSS);
                 pnlCentro.add(lbDescontoINSS);
                 pnlCentro.add(txtDescontoINSS);
                 pnlCentro.add(lbBaseIRPF);
                 pnlCentro.add(txtBaseIRPF);
                 pnlCentro.add(lbDescontoIRPF);
                 pnlCentro.add(txtDescontoIRPF);
                 pnlCentro.add(lbSalarioL);
                 pnlCentro.add(txtSalarioL);
			    	}
			    	
			    }
			    finally
			    {
			    	pnlCentro.revalidate();
			    }
				  
			  }
		  });
		  
        btCalcular.addActionListener(new ActionListener() {
		      
		      @Override
		      public void actionPerformed(ActionEvent e) {        
		        double salario = Double.parseDouble(txtSalarioB.getText());
		        
		        
		        Ex02Class classe = new Ex02Class();
		        classe.SetSalario(salario);
		        
		        try {     

		          pnlCentro.removeAll();
		          List<String> calculoINSS = classe.CalcularINSS();
                  txtBaseINSS.setText(calculoINSS.get(1));
                  txtDescontoINSS.setText(calculoINSS.get(0));
                  List<String> calculoIRPF = classe.CalcularIRPF();
                  txtBaseIRPF.setText(calculoIRPF.get(1));
                  txtDescontoIRPF.setText(calculoIRPF.get(0));
                  txtSalarioL.setText(calculoIRPF.get(1));
                  pnlCentro.add(lbBaseINSS);
                  pnlCentro.add(txtBaseINSS);
                  pnlCentro.add(lbDescontoINSS);
                  pnlCentro.add(txtDescontoINSS);
                  pnlCentro.add(lbBaseIRPF);
                  pnlCentro.add(txtBaseIRPF);
                  pnlCentro.add(lbDescontoIRPF);
                  pnlCentro.add(txtDescontoIRPF);
                  pnlCentro.add(lbSalarioL);
                  pnlCentro.add(txtSalarioL);
                  
		                 
		        }
		        finally {
		          
		          pnlCentro.revalidate();
		        }        
		      }
		    });
	  }
	  public void MontarFrame()
	  {
	
		  pnlTopo.add(lbSalarioB);
		  pnlTopo.add(txtSalarioB);
		  pnlTopo.add(btCalcular);
		  pnlTopo.add(chformato);
		  pnlTopo.add(lbformato);
		  pnlCentro.add(lbBaseINSS);
		  pnlCentro.add(txtBaseINSS);
		  pnlCentro.add(lbDescontoINSS);
		  pnlCentro.add(txtDescontoINSS);
		  pnlCentro.add(lbBaseIRPF);
		  pnlCentro.add(txtBaseIRPF);
		  pnlCentro.add(lbDescontoIRPF);
		  pnlCentro.add(txtDescontoIRPF);
		  pnlCentro.add(lbSalarioL);
		  pnlCentro.add(txtSalarioL);
		  
		    this.add(pnlTopo, BorderLayout.PAGE_START);
		    this.add(pnlCentro, BorderLayout.CENTER);
	  }
	
	public void InstanciarElementos()
	  {
		  pnlTopo = new JPanel(new FlowLayout());
		  pnlTopo.setBackground(Color.GRAY);
		  
		  pnlCentro = new JPanel(new FlowLayout());
		  pnlCentro.setBackground(Color.GRAY);
		  
		  lbSalarioB = new JLabel("Salário Bruto: ");
		  lbSalarioB.setFont(new Font("Consolas", Font.BOLD, 14));
		  
		  lbBaseINSS = new JLabel("Base INSS: ");
		  lbBaseINSS.setFont(new Font("Consolas", Font.BOLD, 14));
		  
		  lbformato = new JLabel("Formatar ");
		  lbformato.setFont(new Font("Consolas", Font.BOLD, 14));
		  
		  lbDescontoINSS = new JLabel("Desconto INSS: ");
		  lbDescontoINSS.setFont(new Font("Consolas", Font.BOLD, 14));
		  
		  lbBaseIRPF = new JLabel("Base IRPF: ");
		  lbBaseIRPF.setFont(new Font("Consolas", Font.BOLD, 14));
		  
		  lbDescontoIRPF = new JLabel("Desconto IRPF: ");
		  lbDescontoIRPF.setFont(new Font("Consolas", Font.BOLD, 14));
		  
		  lbSalarioL = new JLabel("Salário Líquido: ");
		  lbSalarioL.setFont(new Font("Consolas", Font.BOLD, 14));
		  
		  txtSalarioB = new JTextField("0000.00", 20);
		  txtBaseINSS = new JTextField("0000.00", 45);
		  txtBaseIRPF = new JTextField("0000.00", 45);
		  txtDescontoINSS = new JTextField("0000.00", 45);
		  txtDescontoIRPF = new JTextField("0000.00", 45);
		  txtSalarioL = new JTextField("0000.00", 20);
		  chformato = new JCheckBox();
		  btCalcular = new JButton("Calcular");
	  }
	  private void configurarFrame() {
		    
		    this.setLayout(new BorderLayout(5, 5));
		    this.setSize(640, 200);
		    this.setLocationRelativeTo(null);
		    this.setResizable(false);    
		    this.setTitle("Contra Cheque EX02");
		    
		  }
	
}
