/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendataankaryawan;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Predator
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        
        // atribut
        ArrayList<ArrayList<String> > dataKaryawan = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        
        // object
        TambahData td = new TambahData();
        LihatData ld = new LihatData();
        HapusData hd = new HapusData();
        CariData cd = new CariData();
        
        while(true) {
            System.out.println("Menu Data ArrayList");
            td.menuUtama();
            
            System.out.print("\nMenu pilihan : ");
            int menuChoosen = Integer.parseInt(input.next());

            switch(menuChoosen) {
                
                case 1:
                OUTER:
                while (true) {
                    td.tambahData(dataKaryawan);
                    td.subMenu();

                    td.chooseSubMenu();
                    switch (td.menuChoice) {
                        case 1:
                            break OUTER;
                        case 2:
                            continue;
                        default:
                            System.out.println("Pilihan Invalid, Menuju Ke Menu Utama");
                            break OUTER;
                    }
                }
                   break;
               
                case 2:
                OUTER:
                while (true) {
                    hd.hapusData(dataKaryawan);
                    hd.subMenu();

                    hd.chooseSubMenu();
                    switch (hd.menuChoice) {
                        case 1:
                            break OUTER;
                        case 2:
                            continue;
                        default:
                            System.out.println("Pilihan Invalid, Menuju Ke Menu Utama");
                            break OUTER;
                    }
                }
                    break;
                    
                case 3:
                OUTER:
                while (true) {
                    cd.cariData(dataKaryawan);
                    cd.showData(dataKaryawan);
                    
                    cd.subMenu();
                    cd.chooseSubMenu();
                    switch (cd.menuChoice) {
                        case 1:
                            break OUTER;
                        default:
                            System.out.println("Pilihan Invalid, Menuju Ke Menu Utama");
                            break OUTER;
                    }
                }
                    break;

                case 4:
                OUTER:
                while (true) {
                    ld.lihatData(dataKaryawan);
                    ld.subMenu();
                    ld.chooseSubMenu();
                    switch (ld.menuChoice) {
                        case 1:
                            break OUTER;
                        default:
                            System.out.println("Pilihan Invalid, Menuju Ke Menu Utama");
                            break OUTER;
                    }
                }
                    break;

                case 5:
                    System.out.println("Program telah berhenti");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilih menu yang tersedia :");
                    break;
            }
        }
    }
}
