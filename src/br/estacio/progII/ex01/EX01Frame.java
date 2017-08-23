package br.estacio.progII.ex01;
import javax.swing.*; 
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
public class EX01Frame extends JFrame {
 
	public JButton calc = new JButton("Calcular");
	public JTextField tab = new JTextField();
    public JTextField de = new JTextField();
    public JTextField ate = new JTextField();
    public JFrame principal = new JFrame();
	
    public void Janela()
	{
		
		principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    principal.setTitle("Exercício 01");
	    principal.setSize(400,250);
	    principal.setVisible(true);	
	    JLabel lbltab = new JLabel("Tabuada de: ");
	    JLabel lblde = new JLabel(" Começo: ");
	    JLabel lblate = new JLabel(" Final: ");
	    Box Horizontal = Box.createHorizontalBox();
	    Horizontal.add(lbltab);
	    Horizontal.add(tab);
	    Horizontal.add(lblde);
	    Horizontal.add(de);
	    Horizontal.add(lblate);
	    Horizontal.add(ate);
	    Horizontal.add(calc);
	    principal.add(Horizontal,BorderLayout.PAGE_START);
	    principal.setVisible(true);
	}
	
   
       
}
