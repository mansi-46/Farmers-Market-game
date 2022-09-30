package Foods;

import Farm.Soil;//import Soil from Farm
/**
 * this class is a child of food. It has Vegetable as food
 * type and provide implementation of abstract methods
 * of food class
 * @author Mansi Patel
 */
public class Vegetable extends Food{
    private int countDays;//count days since vegetable potted
    public Vegetable(String name, double sellPrice,int daysToMature, int requiredArea){
        super(name, sellPrice, daysToMature, requiredArea);
        preferredSoil = Soil.Loam;
    }
    @Override
    /**
     * this method will check the preferred soil and then increase
     * call the grow method if soil is preferred else it will
     * check that it skips one  day of the growth cycle;
     * @param soil gets which soil is preferred
     * @return double by calling grow method and returning percent
     */
    public double grow(Soil soil) {
        if(soil == preferredSoil || (countDays % 2 != 0)){
            countDays++;
            return grow();
        }
        else{
            countDays++;
        }
        return (double)getDaysSincePotted()/(double) getDaysToMature();
    }
}
