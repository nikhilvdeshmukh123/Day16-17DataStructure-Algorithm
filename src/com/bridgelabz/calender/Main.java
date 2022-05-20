package com.bridgelabz.calender;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.of(2020, 12, 22);
        java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println("Day of week in number:"+dayOfWeek.getValue());
        System.out.println("Day of week in text:"+dayOfWeek.toString());
	}

}
