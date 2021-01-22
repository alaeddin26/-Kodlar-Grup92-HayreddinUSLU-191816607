/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stok_takip_programi;

/**
 *
 * @author MFK
 */
public class Ayakkabi implements urun{
  public int numara;
  public String renk="Siyah";
  public String getRenk(){
    return renk;
  }
  public int usNumaradonustur(){
    return (numara-10);
  }  
  public int geteunumara(){
      return numara;
  }    
}