package Farmer;

import Farm.Farm;// importing farm
import Foods.Food;// importing food
import Foods.Fruit;//importing fruit
import Foods.Vegetable;// importing vegetable
/**
 * Farmers have a name and can own a farm.
 * Farmer objects can be initialized regardless of whether farmer owns
 * a farm or not. Farmer objects are always initialized with energy to 100
 * @author Mansi
 */
public class Farmer {
    private String name;//name of farmer
    private int energy;//energy of farmer
    private Farm farm;// farm he owns
    /**
     * Farmer constructor which makes a farmer
     * who will not own a farm.
     * @param name of Farmer
     */
    public Farmer(String name) {
        this.name = name;
        energy = 100;// energy initialized to 100
    }
    /**
     * Farmer constructor which makes a farmer who
     * will own a farm.
     * @param name of Farmer
     * @param farm of the farmer
     */
    public Farmer(String name, Farm farm) {
        this.name = name;
        this.farm = farm;
        energy = 100;// energy initialized to 100
    }
    /**
     * gets food from the farm at particular index
     * @param index of the food we want
     * @return Food got from the farm
     */
    public Food getFoodFromFarm(int index) {
        return farm.getFood(index);
    }
    /**
     * gets the name of the farmer
     * @return String name
     */
    public String getName() {
        return name;
    }
    /**
     * get energy of the farmer
     * @return int energy
     */
    public int getEnergy() {
        return energy;
    }
    /**
     * this method increases the energy of farmer by
     * 35 when he sleeps and energy cannot be more
     * than 100. It also calls grow overnight method
     */
    public void sleep() {
        if(energy<100){
            energy+=35;
            if(energy>100){
                energy = 100;
            }
        }
        farm.overnightGrow();
    }
    /**
     * if farmer has a farm it returns false
     * if he doesn't have a farm it buys a farm
     * and return true
     * @param farm to buy
     * @return boolean
     */
    public boolean buyFarm(Farm farm) {
        if (this.farm == null) {
            this.farm = farm;
            return true;
        }
        return false;
    }
    /**
     * if farmer owns a farm and has enough energy(30) to
     * grow vegetable and has space then it grows that
     * it reduces the energy by 30 and grow vegetable.
     * if it has enough energy(50) to grow fruit and has
     * space. It grows fruit and reduce energy by 50.
     * @param food to seed
     * @return boolean true if seeded and false it not
     */
    public boolean seedFood(Food food) {
        if(this.farm != null){//check for space and farm
            if(food instanceof Fruit && energy>=50){// check for food type and energy
                farm.seedFood(food);//seed the food
                energy = energy - 50;
                return true;
            }
            else if (food instanceof Vegetable && energy>=30){
                farm.seedFood(food);
                energy = energy - 30;
                return true;
            }
        }
        return false;
    }
    @Override
    /**
     * this method gives farmer name and energy if he owns no farm
     * but if he owns a farm it returns String which also has all the
     * details of farm toString method
     * @return String
     */
    public String toString(){
        if(this.farm == null){
            return String.format("Farmer: %s\nEnergy left: %d/100\n%s owns no farm",name,energy,name);
        }
        return "Farmer: "+name+"\n"+"Energy left: "+energy+"/100\n"+"Farm info:\n"+farm.toString();
    }
}


