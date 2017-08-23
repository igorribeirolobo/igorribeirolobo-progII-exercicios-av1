package br.estacio.progII.ex03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * Classe que monta a tela com Swing, 
 * através de um frame
 */
public class Ex03Frame extends JFrame {

  /*
   * Paineis
   */
  private JPanel pnlTopo;
  private JPanel pnlEsquerda;
  private JPanel pnlCentro;
  
  /*
   * Elementos de pnlTopo.
   * 
   * Os elementos dos paineis da esquerda
   * e centro serão criados dinamicamente
   */
  private JLabel lbDe;
  private JLabel lbAte;
  private JTextField txtDe;
  private JTextField txtAte;
  private JButton btCalcular; 
  
  /*
   * Construtor
   */
  public Ex03Frame() {
    
    /*
     * Separando a lógica
     * em métodos
     */
    configurarFrame();
    instanciarComponentes();
    definirEventos();
    montarFrame();
  }

  /*
   * Aqui, programei os eventos desta
   * aplicação
   */
  private void definirEventos() {
        
    /*
     * Evento no botão "Calcular"
     */
    btCalcular.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {        
        
        int de = Integer.parseInt(txtDe.getText());
        int ate = Integer.parseInt(txtAte.getText());
        
        //Instanciando a classe de negócio
        Ex03Class classe = new Ex03Class(de, ate);
        
        /*
         * Utilizei o try para garantir (com finally, no final)
         * que a tela sempre será repintada, mesmo que ocorra
         * algum erro no processo. Essa é uma boa prática.
         */
        try {     
          
          /*
           * Limpando os respectivos paineis 
           * e readicionando cada título
           */
          pnlEsquerda.removeAll();
          pnlCentro.removeAll();
          adicionarTitulo("Divisíveis por 7", pnlEsquerda);
          adicionarTitulo("Primos", pnlCentro);
          
          //Obtendo os números divisíveis por 7
          List<String> divisiveisPor7 = classe.divisiveisPor7();
          
          //Obtendo os números primos
          List<String> primos = classe.primos();
          
          /*
           * Para cada elemento da lista, criamos um
           * label e o adicionamos ao respectivo painel
           */
          for(String valor : divisiveisPor7) {
            
            JLabel label = new JLabel(valor);
            label.setHorizontalAlignment(JLabel.CENTER);
            pnlEsquerda.add(label);
          }
          
          for(String valor : primos) {
            
            JLabel label = new JLabel(valor);
            label.setHorizontalAlignment(JLabel.CENTER);
            pnlCentro.add(label);
          }         
        }
        finally {
          
          /*
           * Repintamos a tela, pois houve exclusão
           * e reinserção de labels
           */
          pnlEsquerda.revalidate();
          pnlCentro.revalidate();
        }        
      }
    });
  }

  /*
   * Montando o frame, adicionando os elementos
   * aos paineis
   */
  private void montarFrame() {
    
    pnlTopo.add(lbDe);
    pnlTopo.add(txtDe);    
    pnlTopo.add(lbAte);
    pnlTopo.add(txtAte);
    pnlTopo.add(btCalcular);
    
    this.add(pnlTopo, BorderLayout.PAGE_START);
    this.add(pnlEsquerda, BorderLayout.LINE_START);
    this.add(pnlCentro, BorderLayout.CENTER);
  }

  /*
   * Instanciando os componentes
   */
  private void instanciarComponentes() {
    
    pnlTopo  = new JPanel(new FlowLayout());
    pnlTopo.setBackground(Color.BLACK);
    
    //Perceba o grid layout. Defini para mostrar
    //20 linhas e 1 coluna
    pnlEsquerda = new JPanel(new GridLayout(20, 1));
    pnlEsquerda.setBackground(Color.LIGHT_GRAY);    
    adicionarTitulo("Divisíveis por 7", pnlEsquerda);
    
    //Perceba o grid layout. Defini para mostrar
    //20 linhas e 1 coluna
    pnlCentro = new JPanel(new GridLayout(20, 1));
    pnlCentro.setBackground(Color.LIGHT_GRAY);
    adicionarTitulo("Primos", pnlCentro);
    
    lbDe = new JLabel("De: ");
    lbDe.setFont(new Font("Consolas", Font.BOLD, 14));
    lbDe.setForeground(Color.WHITE);
    
    lbAte = new JLabel("Até: ");
    lbAte.setFont(new Font("Consolas", Font.BOLD, 14));
    lbAte.setForeground(Color.WHITE);   

    txtAte = new JTextField("50", 10); 
    txtDe = new JTextField("1", 10);
    
    btCalcular = new JButton("Calcular");    
  }

  /*
   * Configurações iniciais do frame
   */
  private void configurarFrame() {
    
    this.setLayout(new BorderLayout(5, 5));
    this.setSize(640, 480);
    this.setLocationRelativeTo(null);
    this.setResizable(false);    
    this.setTitle("Trabalhando com números");
  }
  
  /*
   * Criei um método estático para auxiliar a inclusão dos
   * títulos dos paineis, pois envolve troca de fontes
   * e estilos
   */
  private static void adicionarTitulo(String titulo, JPanel painel) {
    
    JLabel lbTitulo = new JLabel("  " + titulo + "  ");
    lbTitulo.setFont(new Font("Calibri", Font.BOLD, 20));
    lbTitulo.setHorizontalAlignment(JLabel.CENTER);
    painel.add(lbTitulo);
  }
}
