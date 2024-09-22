package Foods;

import Farm.Soil;
/**
 * This class gives the food object Carrot and
 * initialize selling price, days of Mature, and requiredArea
 * in the constructor and preferred soil is set to Soil
 * @author Mansi
 */
public class Carrot extends Vegetable{
    public Carrot(){
        super("Carrot",750.32,15,100);
        preferredSoil = Soil.Sand;
    }
}