package org.example;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Иван", Gender.MALE),
                new Employee("Мария", Gender.FEMALE),
                new Employee("Сергей", Gender.MALE),
                new Employee("Анна", Gender.FEMALE),
        };

        congratulateEmployees(employees);
    }

    public static void congratulateEmployees(Employee[] employees) {
        LocalDate currentDate = LocalDate.now();
        Holiday currentHoliday = getCurrentHoliday(currentDate);

        switch (currentHoliday) {
            case NEW_YEAR:
                for (Employee employee : employees) {
                    System.out.println("С Новым Годом, " + employee.getName() + "!");
                }
                break;

            case MARCH_8:
                for (Employee employee : employees) {
                    if (employee.getGender() == Gender.FEMALE) {
                        System.out.println("С 8 марта, " + employee.getName() + "!");
                    }
                }
                break;

            case FEBRUARY_23:
                for (Employee employee : employees) {
                    if (employee.getGender() == Gender.MALE) {
                        System.out.println("С 23 февраля, " + employee.getName() + "!");
                    }
                }
                break;

            default:
                System.out.println("Сегодня не праздник.");
                break;
        }
    }

    private static Holiday getCurrentHoliday(LocalDate date) {
        int month = date.getMonthValue();
        int dayOfMonth = date.getDayOfMonth();

        if (month == 1 && dayOfMonth == 1) {
            return Holiday.NEW_YEAR; // Новогодний праздник
        } else if (month == 3 && dayOfMonth == 8) {
            return Holiday.MARCH_8; // 8 марта
        } else if (month == 2 && dayOfMonth == 23) {
            return Holiday.FEBRUARY_23; // 23 февраля
        }

        return Holiday.NONE; // Нет праздника
    }
}