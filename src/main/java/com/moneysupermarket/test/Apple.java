package com.moneysupermarket.test;

public class Apple {
    private int weight;
    private int taste;
    private boolean hasWorm= true;
    private int color;

    public Apple() {
    }

    /**
     * @return the taste
     */
     public int getTaste() {
          return taste;
     }

     /**
      * @param taste the taste to set
      */
     public void setTaste(int taste) {
         if (taste >= 1 && taste <= 4){
               this.taste = taste;
         }else{
               throw new IllegalArgumentException("Taste is out of range. (1 - 4)");
         }
     }
}