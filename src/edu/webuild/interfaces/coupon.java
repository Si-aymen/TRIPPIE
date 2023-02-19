/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.webuild.interfaces;

import java.util.List;

/**
 *
 * @author HP
 */
public interface coupon {
     public void ajoutercoupon();
      public void ajouterpersonne2(coupon c);
     public List<coupon> afficher();
         public  int Supprimer(int id );
           public void modifier(coupon c );
           
    
    public List<coupon> rech(int id );
    
    public List<coupon> sortCoupons(String column, String order);
    
    public boolean validateCoupon(coupon coupon);
     public List<coupon> Filter_Coupon(String S, String SS);
}
