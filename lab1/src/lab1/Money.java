package lab1;

public class Money {
	
	private int value;
	private int number;
	
	public Money(){
		
	}
	
	public Money(int value, int number){
		this.value = value;
		this.number = number;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public int getNumber(){
		return this.number;
	}
}
