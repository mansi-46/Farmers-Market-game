package Farm;

import Foods.Food;// import food from Food class
import java.util.ArrayList;
/**
 * this class is a farm which contains all the foods
 * type of soil, area, and price of food in the farm
 * @author Mansi Patel
 */
public class Farm {
    private final int totalArea;// total area of farm
    private ArrayList<Food> foods;// arrayList of foods on farm
    private final Soil farmSoil;// Soil type of farm
    private double totalHarvestValue = 0;// total Harvest Value of food
    private  double totalValue=0;// total price
    /**
     * constructor of Farm class which table input
     * of total area and type of soil and initialize
     * the variables.
     * @param totalArea area of farm
     * @param farmSoil soil type of farm
     */
    public Farm(int totalArea, Soil farmSoil){
        this.totalArea = totalArea;
        this.farmSoil = farmSoil;
        foods = new ArrayList<Food>();//initialize array
    }
    /**
     * gets the totalArea of farm
     * @return int area
     */
    public int getTotalArea(){ return totalArea; }
    /**
     * gets Soil of the farm
     * @return Soil farmSoil
     */
    public Soil getFarmSoil() { return farmSoil; }
    /**
     * gets quantity of food on the farm which is
     * size of the array.
     * @return int size of array
     */
    public int getFoodQuantity(){ return foods.size(); }
    /**
     * this method gets food at Index
     * @return Food food at that index
     */
    public Food getFood(int foodIndex){
        if(foodIndex<0||foodIndex>foods.size()){
            return null;
        }
        return foods.get(foodIndex);
    }
    /**
     * calculate the total value of farm by adding
     * selling price of each food in array
     * @return double totalValue.
     */
    public double getTotalFarmValue(){
        for(int i = 0; i < foods.size(); i++){
            totalValue += foods.get(i).getSellPrice();
        }
        return totalValue;
    }
    /**
     * calculate the total harvest value of farm by adding
     * selling price of each food that is harvested in array
     * @return double totalHarvestValue.
     */
    public double getReadyToHarvestValue(){
        for(int i = 0; i<foods.size() ;i++){
            Food food = foods.get(i);// calls harvestFood
            if(food.getDaysSincePotted()>=food.getDaysToMature()){//check if food is harvestable or not
                totalHarvestValue += food.getSellPrice();
            }
        }
        return totalHarvestValue;
    }
    /**
     * this method checks if there is enough space left
     * to seedFood on the farm if yes return true other-
     * wise false
     * @param foodArea gets areaRequired by food of farm
     * @return boolean
     */
    public boolean seedFood(Food foodArea){
        int areaLeft = totalArea;//areaLeft after food is seeded
        for (int i = 0; i < foods.size(); i++) {
            areaLeft -= foods.get(i).getRequiredArea();
        }
        int requiredArea = foodArea.getRequiredArea();//area required by food to be seeded
        if(requiredArea > areaLeft){
            return false;
        }
        else{
            foods.add(foodArea);
            return true;
        }
    }
    /**
     * harvests the food if days since potted is greater than
     * days since matured and removes that food object from
     * arrayList
     * @param index gets food to be harvested
     * @return Food that was harvested
     */
    public Food harvestFood(int index){
        Food food = foods.get(index);
        if(food.getDaysSincePotted() >=
                food.getDaysToMature()){
            foods.remove(index);
            return food;
        }
        return null;
    }
    /**
     * grows the food overnight by 1 cycle
     */
    public void overnightGrow(){
        for (int i = 0; i<foods.size();i++) {
            foods.get(i).grow(farmSoil);
        }
    }
    @Override
    /**
     * method displays all the information about the farm
     * @return String containing detail of farm
     */
    public String toString(){
        String foodAvailable = "";// gets food string from food class
        String finalString = "Total farm value: " + String.format("%.2f",getTotalFarmValue())+"\n" +
                "Ready to harvest value: "+String.format("%.2f",totalHarvestValue) + "\n";
        for (int i = 0; i < foods.size(); i++) {
            foodAvailable += i+" - " +foods.get(i).toString()+"\n";
        }
        //checks if there is any food element in food list
        if(foods.size()>0) {
            finalString += "Food available:\n";
            return finalString + foodAvailable;
        }
        else{
            return  finalString + "No food available";
        }
    }
}
