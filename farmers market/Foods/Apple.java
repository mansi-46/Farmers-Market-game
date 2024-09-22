package Foods;

import Farm.*;
/**
 *This class gives the food object Apple and
 * initialize selling price, days of Mature, and requiredArea
 * in the constructor and preferred soil is set to Loam
 * @author Mansi
 */
public class Apple extends Fruit{
    public Apple() {
        super("Apple", 1250.00, 15, 275);
        preferredSoil = Soil.Loam;
    }
}
