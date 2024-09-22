package Farm;

import Foods.Food;// importing Food from foods package
/** Apple farm is a child of farm class. It has
 * specific area and preferred soil and ensures
 * that only apple grows on the farm
 * @author Mansi Patel
 */
public class AppleFarm extends Farm {
    public AppleFarm(int area){
        super(area,Soil.Loam);
    }
/**
 * overloaded method from farm which ensures
 * that only apple is seeded in this farm
 * @param food food object to check type of food
 * @return boolean true if Apple is seeded otherwise false
 */
    public boolean seedFood(Food food){
        String name = food.getName();//stores name of food
        if(name.equals("Apple")){
            return true;
        }
        return false;
    }
}