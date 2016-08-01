package com.moneysupermarket.test;

public class ValyrianSteelPeeler extends Peeler implements PeelerInterface{

    public ValyrianSteelPeeler() {
        super();
    }

    /**
     * 
     * @param skinColor
     * @return
     */
    @Override
    public boolean canPeel(Color skinColor){
        boolean canPeel=false;
        if (skinColor.equals(Color.BLUE)||skinColor.equals(Color.RED)||skinColor.equals(Color.GREEN)){
                canPeel = true;
        }
        return canPeel;
    }
}
