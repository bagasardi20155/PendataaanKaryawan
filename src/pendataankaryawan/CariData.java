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
public class CariData extends Menu {

    int menuChoice = choice;
    Scanner input = new Scanner(System.in);
    
    boolean found = false;
    int index = 0;
    
    int usia, jmlAnak, gajiPokok, tunjanganMenikah, tunjanganPegawai, tunjanganAnak, gajiKotor;
    double potongan, gajiBersih;
    String golongan, statusMenikah;
    
    @Override
    void subMenu() {
        System.out.println("\n1. Kembali ke Menu Utama");
    }

    @Override
    public void chooseSubMenu() {
        System.out.print("Menu Pilihan : ");
        menuChoice = Integer.parseInt(input.nextLine());
    }
    
    public boolean cariData(ArrayList<ArrayList<String>> dataKaryawan) throws ParseException {
        System.out.print("Masukkan kode karyawan : ");
        String kodeKaryawan = input.nextLine();
        
        for(int i = 0; i < dataKaryawan.size(); i++) {
            String dataKodeKaryawan = dataKaryawan.get(i).get(0);
            
            if(dataKodeKaryawan.equals(kodeKaryawan)){
                found = true;
                index = i;
            } else {
                found = false;
            }
        }
        return found;
    }
    
    public void gaji() {
        
        //gaji pokok
        switch(golongan) {
            case "A" :
                gajiPokok = 5000000;
                break;
                
            case "B" :
                gajiPokok = 6000000;
                break;
            
            case "C" :
                gajiPokok = 7000000;
                break;
        }
        
        //tunjangan menikah
        if(statusMenikah == "Sudah Menikah") {
            tunjanganMenikah = (gajiPokok * 10) / 100;
        } else {
            tunjanganMenikah = 0;
        }
        
        //tunjangan pegawai
        if(usia > 30) {
            tunjanganPegawai = (gajiPokok * 15) / 100;
        } else {
            tunjanganPegawai = 0;
        }
        
        //tunjangan anak
        if(jmlAnak > 0) {
            tunjanganAnak = (gajiPokok * 5 / 100) * jmlAnak;
        } else {
            tunjanganAnak = 0;
        }
        
        //gaji kotor
        gajiKotor = gajiPokok + tunjanganMenikah + tunjanganPegawai + tunjanganAnak;
        
        //potongan
        potongan = (gajiKotor * 2.5) / 100;
        
        //gaji bersih
        gajiBersih = gajiKotor - potongan;
    }
    
    public void showData(ArrayList<ArrayList<String>> dataKaryawan, int index) throws ParseException {
        
        String kodeKaryawan = dataKaryawan.get(index).get(0);
        String namaKaryawan = dataKaryawan.get(index).get(1);
        golongan = dataKaryawan.get(index).get(4);
        
        // mencari usia
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(dataKaryawan.get(index).get(3));
        LocalDate birthDay = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        
        Period period = Period.between(birthDay, LocalDate.now());
        usia = period.getYears();
        
        statusMenikah = dataKaryawan.get(index).get(5);
        
        if(statusMenikah == "Sudah Menikah") {
            jmlAnak = Integer.parseInt(dataKaryawan.get(index).get(6));
        } else {
            jmlAnak = 0;
        }
        
        //hitung gaji
        gaji();
        
        //tampilkan semua
        System.out.println("\n================================");
        System.out.println("    DATA PROFILE KARYAWAN");
        System.out.println("--------------------------------");
        System.out.println("Kode Karyawan : " + kodeKaryawan);
        System.out.println("Nama Karyawan : " + namaKaryawan);
        System.out.println("Golongan : " + golongan);
        System.out.println("Usia : " + usia);
        System.out.println("Status Menikah : " + statusMenikah);
        System.out.println("Jumlah Anak : " + jmlAnak);
        
        System.out.println("-------------------------------");
        
        System.out.println("Gaji Pokok : Rp. " + gajiPokok);
        System.out.println("Tunjangan Istri/Suami : Rp. " + tunjanganMenikah);
        System.out.println("Tunjangan Pegawai : Rp. " + tunjanganPegawai);
        System.out.println("Tunjangan Anak : Rp. " + tunjanganAnak);
        
        System.out.println("-------------------------------");
        
        System.out.println("Gaji Kotor : Rp. " + gajiKotor);
        System.out.println("Potongan : Rp. " + potongan);
        
        System.out.println("-------------------------------");
        
        System.out.println("Gaji Bersih : Rp. " + gajiBersih);
    }
}
