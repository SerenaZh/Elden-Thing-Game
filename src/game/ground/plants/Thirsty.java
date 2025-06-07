package game.ground.plants;

/**
 * Interface that represents plants that are thirsty
 * and that needs to be watered every few turns
 *
 * @author Serena Zhou
 */
public interface Thirsty {
    /**
     * Method to water the thirsty plant
     */
    public void water();

    /**
     * Method that decreases the counter for the death
     * of the plant if the counter reaches 0
     */
    public void decreaseCounter();
}
