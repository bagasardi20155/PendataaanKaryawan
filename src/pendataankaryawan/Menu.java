/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendataankaryawan;

/**
 *
 * @author Predator
 */
public abstract class Menu implements MenuChoice {
    
    //method
    public int getChoice() { return choice; }
    public void menuUtama(){
        
        System.out.println("1.	Tambah Data");
        System.out.println("2.	Hapus Data");
        System.out.println("3.	Cari Data");
        System.out.println("4.	Lihat Data");
        System.out.println("5.	Exit");
    }
    
    abstract void subMenu();
    
}
