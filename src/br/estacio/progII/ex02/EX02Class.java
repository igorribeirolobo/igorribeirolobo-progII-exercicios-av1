package br.estacio.progII.ex02;

import java.util.ArrayList;
import java.util.List;

public class EX02Class {
    protected double salario = 0;
	public double SetSalario(double salario)
	{
		return this.salario = salario;
	}
	public double INSS()
	{
		double calc = 0;
		if(this.salario <= 1659.38)
		{
			calc = (this.salario * 8)/100;
		}
		else if(this.salario >= 1659.39 && this.salario <= 2765.66)
		{
			calc = (this.salario * 9)/100;
		}
		else if(this.salario >= 2765.67 && this.salario <= 5531.31)
		{
			calc = (this.salario * 11)/100;
		}
		
		return calc;
	}
	public double IRPF()
	{
		double calc = 0;
		if(this.salario >= 1903.99 && this.salario <= 2826.65)
		{
			calc = (this.salario * 7.5)/100 - 142.8;
		}
		else if(this.salario >= 2826.66 && this.salario <= 3751.05)
		{
			calc = (this.salario * 15)/100 - 354.8;
		}
		else if(this.salario >= 3751.06 && this.salario <= 4664.68)
		{
			calc = (this.salario * 22.5)/100 - 636.13;
		}
		else if(this.salario > 4664.68)
		{
			calc = (this.salario * 27.5)/100 - 869.36;
		}
		
		return calc;
	}
	
	public List CalcularINSS()
	{
	    double calc = 0;
	    double desconto = 0;
		List<String> descontoINSS = new ArrayList<String>();
		desconto = INSS();
	    descontoINSS.add(String.valueOf(desconto));
	    descontoINSS.add(String.valueOf(this.salario));
	    this.salario -= desconto;
	    return descontoINSS;
	   
	}
	public List CalcularIRPF()
	{
		double calc = 0;
		double desconto = 0;
		List<String> descontoIRPF = new ArrayList<String>();
		desconto = IRPF();
		descontoIRPF.add(String.valueOf(desconto));
		descontoIRPF.add(String.valueOf(this.salario));
		this.salario -= desconto;
		return descontoIRPF;
		
	}
}
