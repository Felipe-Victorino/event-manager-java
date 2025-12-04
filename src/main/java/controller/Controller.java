package controller;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public abstract class Controller<T, E> implements ControllerInterface<E>{

	protected T service;
	protected Scanner sc = new Scanner(System.in);

	public Controller(T service) {
		this.service = service;
	}

	public abstract void create();
	public abstract void readAll();
	public abstract void update();
	public abstract void delete();
	public abstract E searchById();

	private int getMonth(int month){
		switch(month){
			case 1:
				return Calendar.JANUARY;
			case 2:
				return Calendar.FEBRUARY;
			case 3:
				return Calendar.MARCH;
			case 4:
				return Calendar.APRIL;
			case 5:
				return Calendar.MAY;
			case 6:
				return Calendar.JUNE;
			case 7:
				return Calendar.JULY;
			case 8:
				return Calendar.AUGUST;
			case 9:
				return Calendar.SEPTEMBER;
			case 10:
				return Calendar.OCTOBER;
			case 11:
				return Calendar.NOVEMBER;
			case 12:
				return Calendar.DECEMBER;
			default:
				System.err.println("Valor de mês inválido");
		}
		return 0;
	}

	protected Date parseDate(){
		System.out.print("Year: ");
		int year = sc.nextInt();
		System.out.print("Month: ");
		int month = sc.nextInt();
		System.out.print("Day: ");
		int day = sc.nextInt();
		Calendar calendar = Calendar.getInstance();
		calendar.set(year -1900, getMonth(month), day);
		return calendar.getTime();
	}

	@SuppressWarnings("deprecation")
	protected Date parseTime(Date date){
		System.out.print("Hours: ");
		int hour = sc.nextInt();
		System.out.print("Minutes: ");
		int minute = sc.nextInt();

		date.setHours(hour);
		date.setMinutes(minute);
		return date;
	}

}