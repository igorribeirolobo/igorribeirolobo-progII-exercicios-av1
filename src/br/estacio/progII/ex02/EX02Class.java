package br.estacio.progII.ex02;

public class EX02Class {

	public double INNS(double salario)
	{
		double calc = 0;
		if(salario <= 1659.38)
		{
			calc = (salario * 8)/100;
		}
		else if(salario >= 1659.39 && salario <= 2765.66)
		{
			calc = (salario * 9)/100;
		}
		else if(salario >= 2765.67 && salario <= 5531.31)
		{
			calc = (salario * 11)/100;
		}
		
		return calc;
	}
	public double IRPF(double salario)
	{
		double calc = 0;
		if(salario >= 1903.99 && salario <= 2826.65)
		{
			calc = (salario * 7.5)/100 - 142.8;
		}
		else if(salario >= 2826.66 && salario <= 3751.05)
		{
			calc = (salario * 15)/100 - 354.8;
		}
		else if(salario >= 3751.06 && salario <= 4664.68)
		{
			calc = (salario * 22.5)/100 - 636.13;
		}
		else if(salario > 4664.68)
		{
			calc = (salario * 27.5)/100 - 869.36;
		}
		
		return calc;
	}
}
