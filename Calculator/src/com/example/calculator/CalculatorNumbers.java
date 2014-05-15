package com.example.calculator;

public class CalculatorNumbers{

	public static double areaCircle(double radius){
		return radius*radius*3.142;
	}
	
	public static double areaRectangle(double width,double base){
		return width*base;
	}
	
	public static int add(int num1,int num2){
		return num1+num2;
	}  
	
	public static double add(double num1,double num2){
		return num1+num2;
	}
	
	public static double sub(double num1,double num2){
		return num1-num2;
	}
	
	public static double div(double num1,double num2){
		if(num2==0)
			return -1;
		else
			return num1/num2;
	}
	
	public static double mul(double num1,double num2){
		return num1*num2;
	}
	
	public static int add3Numbers(int num1,int num2,int num3){
		return num1+num2+num3;
	}
	
	public static int addBetween(int from,int to){
		int sum=0;
		for(int i=from;i<=to;i++){
			sum+=i;
		}
		return sum;
	}
	
	public static double fahrenheitToCelsius(double fahrenheit){
		return ((5.0/9)*(fahrenheit-32));
	}
	
	public static double celsiusToFahrenheit(double celsius){
		return ((9/5.0)*(celsius))+32;
	}
	
	public static void even(int num){
		if(num%2==0)
			System.out.println(num+" is even\n");
		else
			System.out.println(num+" is odd\n");
	}
	
	public static void evenNumbers(int from,int to){
		for(int i=from;i<to;i++)
		{
			if(i%2==0)
				System.out.println(i);
		}
		System.out.println();
	}
	
	public static boolean isLeap(int year){
		boolean leap=((year%4==0 && year%100!=0) || (year%400==0));
		return leap;
	}
	
	public static void palindrome(int num1){
		int rem=0,rev=0,n=num1;
		while(n!=0){ 
			rem=n%10;
			rev=rev*10+rem;
			n/=10;	
		}
		 if(rev==num1)
			System.out.println(num1+" is a Palindrome\n");
		else
			System.out.println(num1+" is not a palindrome\n");
	}
	
	public static void isPrime(int num){
		boolean flag=true;
		for(int i=2;i<num/2;i++)
		{
			if(num%i==0)
			{
				flag=false;
				break;
			}
			flag=true;
		}
		if(flag)
			System.out.println(num+" is a prime number\n");
		else
			System.out.println(num+" is not a prime number\n");
	}
	
	public static void primeSeries(int from,int to){	
		boolean flag=true;
		int count=0;
		for(int i=from;i<to;i++)
		{
			for(int j=2;j<i;j++)
			{
				if(i%j==0)
				{
					flag=false;
					break;
				}
				flag=true;	
			}
			if(flag && (i!=0 && i!=1))
			{
				System.out.println(i);
				count++;
			}
		}
		System.out.println("Prime numbers from "+from+" to "+to+" ,we have "+count+" numbers\n");
	}
	
	public static int fibonacci(int num){
		int fib1=0;
		int fib2=1;
		int fib3,j=0;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   
		for(int i=2;i<num;i++)
		{
			fib3=fib1+fib2;
			fib1=fib2;
			fib2=fib3;
			if(fib3==num)
				j=1;
		}
		return j;
	}
	
	public static void fibonacciSeries(int maxLength,int min){
		int fib1=0;
		int fib2=1;
		int fib3;
		System.out.println("The fibonacci series");
		System.out.println(fib1);
		System.out.println(fib2);
		for(int i=2;i<maxLength;i++)
		{
			fib3=fib1+fib2;
			if(fib3<min)
			{
				System.out.println(fib3);
			}
			fib1=fib2;
			fib2=fib3;
				
		}
	}
}