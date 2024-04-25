package Seminars.sem3.hw;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class HWControl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите данные через пробел: (ФИО, дата рождения, номер телефона, пол (F/M))");
        String input = sc.nextLine();
        String[] data = input.split(" ");

        if(data.length != 6){
            throw new RuntimeException("Введены неполные данные, попробуйте ещё раз.");
        }

        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];
        String bornDate = data[3];
        long phoneNumber;
        String gender = data[5];

        try {
            String[] bd = bornDate.split("\\.");
            if (Integer.parseInt(bd[0]) < 0 || Integer.parseInt(bd[0]) > 31
                    || Integer.parseInt(bd[1]) < 0 || Integer.parseInt(bd[1]) > 12 || Integer.parseInt(bd[2]) < 1920
                    || Integer.parseInt(bd[2]) > 2024) {

                throw new ArrayIndexOutOfBoundsException("Неверная дата");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Некорректный формат ввода, повторите в формате: dd.mm.yyyy.");
        }
        try {
            phoneNumber = Long.parseLong(data[4]);
            if (phoneNumber <= 0) {
                throw new InvalidDataFormatException("Некорректно введен номер");
            }
        } catch (NumberFormatException e) {
            throw new InvalidDataFormatException("Некорректно введен номер");
        }
        
        if(gender.equals("m") && !gender.equals ("f")){
            throw new RuntimeException("Введите пол из данных значений: f/m");
        }

        Person p = new Person(lastName, firstName, middleName, bornDate, phoneNumber, gender);
        System.out.println(p.toString());

        String fn = data[0] + ".txt";
        try (FileWriter fw = new FileWriter(fn, true)) {
            fw.write(p.toString() + "\n");
            fw.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}