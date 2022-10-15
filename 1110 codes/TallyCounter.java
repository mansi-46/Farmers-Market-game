package week04;
/**
 * This /class represents a Tally Counter, a device used to count stuff(?)
 *
 * @author Juliano Franz
 */
public class TallyCounter {
    private int counter;


    /**
     * Creates a new tally counter given intiial counte value
     * @param counter the start value
     */
    public TallyCounter(int counter){
        if(counter <0){
            counter =0;
        }
        this.counter = counter;
    }


    /**
     * Creates new tally counter initialized to zero
     */
    public TallyCounter(){

        //this(0);
        counter = 0;
    }

    /**
     * Gets the current count value in the tally counter
     * @return the current count
     */
    public int getCounter(){
        return counter;
    }

    /**
     * Increases the value in the tally counter by 1
     */
    public void countUp(){
        counter++;//count = count + 1;
    }

    /**
     * Decreases the value in the tally counter by 1
     *
     * If counter is 0 it remains 0
     */
    public void countDown(){
        if(counter >0) {
            counter--;
        }
    }

    /**
     * Resets the tally counter to 0
     */
    public void reset(){
        counter = 0;
    }

}
