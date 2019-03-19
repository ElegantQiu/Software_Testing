package lab1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Problem {
	
	//给定的数字
	public static int givenNumber;
	
	//初始化所有货币
	private static Money money0 = new Money(0,0);
	private static Money money1 = new Money(50,1);
	private static Money money2 = new Money(20,2);
	private static Money money3 = new Money(5,3);
	private static Money money4 = new Money(5,4);
	private static Money money5 = new Money(1,5);
	private static Money money6 = new Money(1,6);
	private static Money money7 = new Money(1,7);
	
	private static Money[] arrayMoney = {money1,money2,money3,money4,money5,
			                      money6,money7};
	private static Money[] initArray = arrayMoney;
	
	public static void init(){
		arrayMoney = initArray;
	}
	
	public static Money[] exchange(int i,Money[] array){
		Money[] tempArray = new Money[array.length];
		for(int j = 0; j < i; j++){
			tempArray[j] = array[j];
		}
		for(int k = i; k < array.length-1; k++){
			tempArray[k] = array[k+1];
		}
		tempArray[array.length-1] = money0;
		array = tempArray;
		return array;
	}
	
	public static Money findLess(int number){
		Money result = new Money();
		for(int i=0; i <arrayMoney.length; i++){
			if(number >= arrayMoney[i].getValue()){
				result = arrayMoney[i];
				arrayMoney = exchange(i,arrayMoney);
				break;
			}
		}
		return result;
	}
	
	public static String solution(){
		String result = null;
		Stack<Money> stack = new Stack<Money>();
		int sum = 0;
		int temp = givenNumber;
		while(sum != givenNumber){
			Money money = findLess(temp);
			if(money.getNumber() != 0){
				temp = temp - money.getValue();
				sum = sum + money.getValue();
				stack.push(money);
				if(sum == givenNumber){
					Stack tempStack = (Stack)stack.clone();
					String str = new String();
					for(int i=0; i<tempStack.size(); i++){
						str = str + stack.pop().getValue() + "yuan ";
					}
					result = str;
					break;
				}
			}else{
				result = "无解";
				break;
			}
		}
		return result;
	}
	
	public static void main(String [] args){
		while(true){
			init();
			Scanner sc = new Scanner(System.in);
			System.out.print("请输入给定的数字:");
			givenNumber = sc.nextInt();
			String result = solution();
			System.out.println(result);
		}
	}
	
}
