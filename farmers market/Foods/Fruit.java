package Foods;

import Farm.Soil;// import soil from farm package
/**
 * this class is a child of food. It has fruits as food
 * type and provide implementation of abstract methods
 * of food class
 * @author Mansi Patel
 */
public class Fruit extends Food{
    private int countDays = 1;// count days since fruit was potted
    /**
     * creates the object Fruit and sets soil type to Silt.
     */
    public Fruit(String name, double sellPrice, int daysToMature, int requiredArea) {
        super(name, sellPrice, daysToMature, requiredArea);
        preferredSoil = Soil.Silt;
    }
    @Override
    /**
     * this grow method checks if soil is preferred one
     * and call grow method. If it's not preferred soil
     * it skips 2 days.
     * @return double percentage of growth
     * */
    public double grow(Soil soil) {
        double percent = 0;//percent returned by grow() of food class
        if(soil == preferredSoil || (countDays % 3 == 0)){
            countDays++;
            return grow();
        }
        else{
            countDays++;
        }
        return (double)getDaysSincePotted()/(double)getDaysToMature();
    }
}