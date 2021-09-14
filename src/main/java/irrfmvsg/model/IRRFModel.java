package irrfmvsg.model;

import java.text.DecimalFormat;

public class IRRFModel {
	
	
	private double irrf, inss, salario_bruto;
	private int num_dependentes;

	public IRRFModel() {
	
	}
	 public Double getSalario_bruto() {
		 return salario_bruto;
	 }
	 public Integer getNum_dependentes() {
		 return num_dependentes;
	 }
	 
	 public void setSalario_bruto(double salario_bruto) {
		 this.salario_bruto=salario_bruto;
	 }
	 public void setNum_dependentes(int num_dependentes) {
		 this.num_dependentes=num_dependentes;
	 }
	 public String retornaIRRF(){
		 double part_um=0, salario_base=1100.00;
		 
		 if(salario_bruto<=salario_base) {
			irrf=0;
		 }
		 if((salario_bruto>salario_base)&&(salario_bruto<=2203.48)) {
				inss=(((salario_bruto-salario_base)*0.09))+(salario_base*0.075);
			
		 } if((salario_bruto>2203.48)&&(salario_bruto<=30305.22)) {
			   double x=salario_base*0.075;
			   double y=(2203.48-salario_base)*0.09;
			   double z=(salario_bruto-2203.48)*0.12;
			   inss=x+y+z;
		 }
		 if((salario_bruto>2203.48)&&(salario_bruto<=3305.22)) {
			   double x=salario_base*0.075;
			   double y=(2203.48-salario_base)*0.09;
			   double z=(salario_bruto-2203.48)*0.12;
			   inss=x+y+z;
		 }
		 if((salario_bruto>3305.22)&&(salario_bruto<=6433.57)) {
			   double x=salario_base*0.075;
			   double y=(2203.48-salario_base)*0.09;
			   double z=(3305.22-2203.48)*0.12;
			   double w=(salario_bruto-3305.22)*0.14;
			   inss=x+y+z+w;
		 }
		 if(salario_bruto>6433.57) {
			 inss=751.97;
		 }
		 
		 part_um=((salario_bruto-inss)-(num_dependentes*189.59));
		 
		 if((part_um>1903.99)&&(part_um<=2826.65)){
			 irrf=((part_um*0.075)-142.80);
		 }
		 if((part_um>2826.65)&&(part_um<=3751.05)){
			 irrf=((part_um*0.15)-354.80);
		 }
		 if((part_um>3751.05)&&(part_um<=4664.68)){
			 irrf=((part_um*0.225)-636.13);
		 }
		 if(part_um>4664.68){
			 irrf=((part_um*0.275)-869.36);
		 }
		 
		 return new DecimalFormat("#,##0.00").format(irrf);
	 }
}