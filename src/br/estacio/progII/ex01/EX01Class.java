package br.estacio.progII.ex01;

public class EX01Class {

	public String Calcular(int tab,int de,int ate)
	{  double calc = 0;
		String retorno = "";
	    while(de <= ate)
		{
			calc = tab * de;
			retorno += tab + " * "+ de +" = "+ calc+ " | ";
			de++;
			
		}
	    
	    return retorno;
		
	}
	
}
