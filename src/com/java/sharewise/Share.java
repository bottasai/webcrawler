package com.java.sharewise;

public class Share {
	String symbol;
	float pe;
	float d2e;
	float div;
	float pbv;
	float roce;
	public void setSymbol(String symbol)
	{
		this.symbol=symbol;
	}
	public String getSymbol()
	{
		return this.symbol;
	}
	public float getPe() {
		return pe;
	}
	public void setPe(float pe) {
		this.pe = pe;
	}
	public float getD2e() {
		return d2e;
	}
	public void setD2e(float d2e) {
		this.d2e = d2e;
	}
	public float getDiv() {
		return div;
	}
	public void setDiv(float div) {
		this.div = div;
	}
	public float getPbv() {
		return pbv;
	}
	public void setPbv(float pbv) {
		this.pbv = pbv;
	}
	public float getRoce() {
		return roce;
	}
	public void setRoce(float roce) {
		this.roce = roce;
	}
	public String toString()
	{
		return "symbol:"+symbol+",pe:"+pe+",pbv:"+pbv+",div:"+div+",d2e:"+d2e+",roce:"+roce;
	}
	public String printHeader()
	{
		return "symbol,pe,pbv,div,d2e,roce";
	}
	public String toCSV()
	{
		return symbol+","+pe+","+pbv+","+div+","+d2e+","+roce;
	}
}
