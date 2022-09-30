package Foods;

import Farm.Soil;
/**
 * This class gives the food object Cabbage and
 * initialize selling price, days of Mature, and requiredArea
 * in the constructor and preferred soil is set to Clay
 * @author Mansi
 */
public class Cabbage extends Vegetable{
    public Cabbage(){
        super("Cabbage",239.75,10,50);
        preferredSoil = Soil.Clay;
    }
}

