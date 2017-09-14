package br.estacio.progII.ex01;

import java.util.List;
import java.util.ArrayList;

public class Ex01Class {

	public List Calcular(int tab,int de,int ate)
	{  double calc = 0;
		List<String> retorno = new ArrayList<String>();
	    while(de <= ate)
		{
			calc = tab * de;
			retorno.add(String.valueOf(tab)+" * "+String.valueOf(de)+" = "+String.valueOf(calc));
			de++;
			
		}
	    
	    return retorno;
		
	}
	
}
