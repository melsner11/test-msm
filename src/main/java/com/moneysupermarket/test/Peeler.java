package com.moneysupermarket.test;

public class Peeler implements PeelerInterface {

    public Peeler() {
    }

    /**
     * 
     * @param color
     * @return
     */
    public boolean canPeel(Color skinColor){
        boolean canPeel=false;
        if (skinColor.equals(Color.RED)||skinColor.equals(Color.GREEN)){
            canPeel=true;
        }
        return canPeel;
    }
}
