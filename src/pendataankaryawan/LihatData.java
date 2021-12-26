/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendataankaryawan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Predator
 */
public class LihatData extends Menu {

    int menuChoice = 1;
    Scanner input = new Scanner(System.in);
    
    @Override
    void subMenu() {
        System.out.println("1. Kembali ke Menu Utama");
    }

    @Override
    public void chooseSubMenu() {
        System.out.print("Menu Pilihan : ");
        menuChoice = Integer.parseInt(input.nextLine());
    }
    
    public void lihatData(ArrayList<ArrayList<String>> dataKaryawan) {
        int i = 0;
        
        while(i < dataKaryawan.size()) {
            if(dataKaryawan.get(i).size() == 7) {
                for(int j = 0; j < 7; j++) {
                    System.out.print(dataKaryawan.get(i).get(j) + "     ");
                }
                System.out.println("");
                i++;
            } else if (dataKaryawan.get(i).size() == 6) {
                for(int j = 0; j < 6; j++) {
                    System.out.print(dataKaryawan.get(i).get(j) + "     ");
                }
                System.out.println("");
                i++;
            }
            
        }
    }
    
}
