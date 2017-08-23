package br.estacio.progII.ex03;

import java.util.ArrayList;
import java.util.List;

public class Ex03Class {
  
  /*
   * Números a serem trabalhados
   * (de x até y)
   */
  private int de;
  private int ate;
  
  /*
   * Construtor que recebe os números
   * como parâmetros
   */
  public Ex03Class(int _de, int _ate) {
    
    this.de = _de;
    this.ate = _ate;
  }
  
  /*
   * 1a funcionalidade da classe:
   * 
   * Listar os números divisíveis por 7
   */
  public List<String> divisiveisPor7() {
    
    /*
     * Instanciando o ArrayList
     */
    List<String> lista = new ArrayList<String>();
    
    /*
     * Para cada número: se o mesmo for divisível por 7,
     * adicionamos este número à lista
     */
    for(int i = this.de; i <= this.ate; i++) {
      
      if (i % 7 == 0) {
       
        /*
         * Como a lista é de Strings, precisamos
         * converter o inteiro para String. Podemos
         * usar String.valueOf
         */
        lista.add(String.valueOf(i));
      }
    }
    
    /*
     * Retornando lista preenchida
     */
    return lista;    
  }
  
  /*
   * 2a funcionalidade da classe:
   * 
   * Listar os números primos
   */
  public List<String> primos() {
    
    /*
     * Instanciando o ArrayList
     */
    List<String> lista = new ArrayList<String>();
    
    /*
     * Para cada número: se o mesmo for primo,
     * adicionamos este número à lista
     */
    for(int i = this.de; i <= this.ate; i++) {
      
      /*
       * Como o algoritmo para verificar se um número
       * é primo é mais complexo, criei um método
       * para tal. Percebam que ele é estático, pois
       * foi invocado pela classe
       */
      if (Ex03Class.isPrimo(i)) {
       
        /*
         * Como a lista é de Strings, precisamos
         * converter o inteiro para String. Podemos
         * usar String.valueOf
         */
        lista.add(String.valueOf(i));
      }
    }
    
    /*
     * Retornando lista preenchida
     */
    return lista;    
  }

  /*
   * Método que verifica se determinado número
   * é primo ou não.
   * 
   * Um número primo é aquele que só é divisível
   * por 1 e ele próprio
   * 
   * Criei o método como estático, pois ele não
   * utiliza os atributos da classe.
   */
  private static boolean isPrimo(int numero) {
    
    /*
     * Minha ideia é a seguinte: começo com 2
     * e vou até o (número - 1), contando de
     * 1 em 1. Se em algum momento houver 
     * divisão inteira, o número não é primo.
     * 
     * Se ao final não houve nenhuma divisão
     * inteira, o número é primo
     * 
     */
    for (int i = 2; i < numero; i++) {
      
      /*
       * Teste principal
       */
      if (numero % i == 0)
        return false; //Não é primo
    }
    
    //Se "superou" o for, é primo
    return true;
  }
}
