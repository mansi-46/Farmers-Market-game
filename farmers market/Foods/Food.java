package Foods;

import Farm.*;// importing farm package
/**
 * this class has food objects and implements a
 * comparable interface. It gets food name, price
 * required area to grow, days to mature and keeps
 * the track of food's age and growth.
 * @author Mansi Patel
 * Student ID B00871094
 * CSCI 1110
 */
public abstract class Food implements Comparable<Food>{
    private String name;// stores name of food
    private double sellPrice;//stores selling price
    private int daysToMature;//stores days required to mature
    private int daysSincePotted;// stores days since potted
    private int requiredArea;// stores area required by the food to grow
    protected Soil preferredSoil;// preferred soil of the food
    /**
     * create food object
     * @param name name of food
     * @param sellPrice price of food
     * @param daysToMature days required to mature
     * @param requiredArea area required by food to grow
     */
    public Food(String name,double sellPrice,int daysToMature,int requiredArea){
        this.name = name;
        this.sellPrice = sellPrice;
        this.daysToMature = daysToMature;
        this.requiredArea = requiredArea;
        daysSincePotted = 0;// 0 when object is made.
    }
    /**
     * this method gets name of the food
     * @return name of food
     */
    public String getName(){
        return name;
    }
    /**
     * this method gets sell price of the food
     * @return sellPrice of the food
     */
    public double getSellPrice(){
        return sellPrice;
    }
    /**
     * this method gets preferred soil of food
     * @return preferred soil of food
     */
    public Soil getPreferredSoil(){
        return preferredSoil;
    }
    /**
     * this method gets days to mature
     * @return days required to mature
     */
    public int getDaysToMature(){
        return daysToMature;
    }
    /**
     * this method gets days since potted
     * @return days passed since food was potted
     */
    public int getDaysSincePotted(){
        return daysSincePotted;
    }
    /**
     * this method gets required area
     * @return area required by food to grow
     */
    public int getRequiredArea(){
        return requiredArea;
    }
    /**
     * it is an abstract method whose implementation
     * is in Fruit and Vegetable child class of Food
     * @param soil gets the preferred soil
     * */
    public abstract double grow(Soil soil);
    /**
     * this method will grow the food if days to mature is
     * lesser than days passed since potted. It will
     * return the growth percentage between 0 - 1.
     * @return double percentage
     * */
    protected double grow(){
        double percentage = 0;
        if(daysSincePotted>=daysToMature){
            daysSincePotted++;
            return 1.00;
        }
        daysSincePotted++;
        percentage = (double)(daysSincePotted)/(double) daysToMature;// casting to double
        return percentage ;
    }

    @Override
    /**
     * this method arrange food from the highest sale price to lowest
     * @return int difference of sale price
     */
    public int compareTo(Food o) {
        return (int)(o.sellPrice-sellPrice);//order from the highest sale price to lowest
    }
    @Override
    /**
     * display name, preferred soil, days since potted and days to mature of food
     * @return String
     */
    public String toString(){
        return String.format("%s (%s) - %d/%d days",name, preferredSoil, daysSincePotted,daysToMature);
    }
}