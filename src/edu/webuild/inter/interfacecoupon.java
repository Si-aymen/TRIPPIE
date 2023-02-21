/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.inter;
import java.util.List;

/**
 *
 * @author HP
 */
public interface interfacecoupon {
    public void ajoutercoupon();
    public void ajouterpersonne2(interfacecoupon c);
     public List<interfacecoupon> displayCoupon(); 
     public  int Supprimer(int id );
      public void modifier(interfacecoupon c );
      
    
    public List<interfacecoupon> rech(int id );
    
    public List<interfacecoupon> sortCoupons(String column, String order);
    
    public List<interfacecoupon> Filter_Coupon(String S, String SS);
     
    
}
