package com.moneysupermarket.test;

public class Apple {
    private int weight;
    private int taste;
    private boolean hasWorm= true;
    private Color color;
    private FruitState state;

    public Apple() {
    }

    /**
     * @return the taste
     */
     public int getTaste() {
          return taste;
     }

     /**
      * @param taste the taste to set - has to be >=1 and <=4
      */
     public void setTaste(int taste) {
         if (taste >= 1 && taste <= 4){
               this.taste = taste;
         }else{
               throw new IllegalArgumentException("Taste is out of range. (1 - 4)");
         }
     }

     public int getWeight(){
         return this.weight;
     }

     /**
      * 
      * @param weight - has to be >=10 and <=100
      */
     public void setWeight(int weight){
         if (weight >= 10 && weight <= 100){
             this.weight= weight;
         } else{
             throw new IllegalArgumentException("Weight is out of range. (10 - 100)");
         }
      }

    public Color getColor() {
        return color;
    }

    /**
     * 
     * @param color - either RED,GREEN,BLUE
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * @return the state
     */
    public FruitState getState() {
        return state;
    }

    /**
     * @param state the state to set EATEN or PEELED
     */
    public void setState(FruitState state) {
        this.state = state;
    }

    /**
     * @return the hasWorm
     */
    public boolean hasWorm() {
        return hasWorm;
    }

    /**
     * @param hasWorm the hasWorm to set
     */
    public void setHasWorm(boolean hasWorm) {
        this.hasWorm = hasWorm;
    }

    public void eat(){
        if (state != null){
            if (state.equals(FruitState.PEELED)){
                state =FruitState.EATEN;
            }
        }
    }

    /**
     * peel the apple only if its not peeled already and not eaten and has no worm and the taste is > 3
     */
    public void peel(Peeler peeler){
        if (state == null){
            if ((peeler != null) && !hasWorm() && getTaste()>3 ){
                if (peeler.canPeel(color)){
                    state = FruitState.PEELED;    
                }
            }
        }
    }
}