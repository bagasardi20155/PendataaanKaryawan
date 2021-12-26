/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendataankaryawan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Predator
 */
public class LihatData extends Menu {

    int menuChoice = choice;
    int usia;
    Scanner input = new Scanner(System.in);
    
    @Override
    void subMenu() {
        System.out.println("\n1. Kembali ke Menu Utama");
    }

    @Override
    public void chooseSubMenu() {
        System.out.print("Menu Pilihan : ");
        menuChoice = Integer.parseInt(input.nextLine());
    }
    
    
    public void lihatData(ArrayList<ArrayList<String>> dataKaryawan) throws ParseException {
        int i = 0;
        String leftAlignFormat = "| %-10s | %-30s | %-5s | %-5s | %-15s | %-11s |%n";
        
        System.out.println("\n================================================================================================");
        System.out.println("                                   DATA KARYAWAN");
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.printf(leftAlignFormat, "KODE KARY", "NAMA KARY", "GOL", "USIA", "STATUS NIKAH", "JUMLAH ANAK");
        
        while(i < dataKaryawan.size()) {
            
            // mencari usia
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = formatter.parse(dataKaryawan.get(i).get(3));
            LocalDate birthDay = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            Period period = Period.between(birthDay, LocalDate.now());
            usia = period.getYears();
            
            if(dataKaryawan.get(i).size() == 7) {
                System.out.format(leftAlignFormat,
                        dataKaryawan.get(i).get(0),
                        dataKaryawan.get(i).get(1),
                        dataKaryawan.get(i).get(4),
                        usia,
                        dataKaryawan.get(i).get(5),
                        dataKaryawan.get(i).get(6));
                i++;
                
            } else if (dataKaryawan.get(i).size() == 6) {
                System.out.format(leftAlignFormat,
                            dataKaryawan.get(i).get(0),
                            dataKaryawan.get(i).get(1),
                            dataKaryawan.get(i).get(4),
                            usia,
                            dataKaryawan.get(i).get(5),
                            0);
                i++;
            }
            
        }
    }
    
}
