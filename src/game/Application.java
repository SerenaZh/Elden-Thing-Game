package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actor.npc.OmenSheep;
import game.actor.Player;
import game.ground.*;
import game.items.Seed;
import game.items.Talisman;

/**
 * <h1>Application</h1>
 * The main class to set up and run the game.
 * <p>
 *    Where the main application is initalised to run
 * </p>
 * @author Adrian Kristanto
 * @version 1.0
 * @since 07/04/2025
 * Modified by Serena Zhou
 */
public class Application {
    /**
     * Main method that can run the program
     * @param args
     */
    public static void main(String[] args) {

        World world = new World(new Display());

        FancyGroundFactory groundFactory = new FancyGroundFactory(new Blight(),
                new Wall(), new Floor(), new Soil());

        List<String> map = Arrays.asList(
                "xxxx...xxxxxxxxxxxxxxxxxxxxxxx........xx",
                "xxx.....xxxxxxx..xxxxxxxxxxxxx.........x",
                "..........xxxx....xxxxxxxxxxxxxx.......x",
                "....xxx...........xxxxxxxxxxxxxxx.....xx",
                "...xxxxx...........xxxxxxxxxxxxxx.....xx",
                "...xxxxxxxxxx.......xxxxxxxx...xx......x",
                "....xxxxxxxxxx........xxxxxx...xxx......",
                "....xxxxxxxxxxx.........xxx....xxxx.....",
                "....xxxxxxxxxxx................xxxx.....",
                "...xxxx...xxxxxx.....#####.....xxx......",
                "...xxx....xxxxxxx....#___#.....xx.......",
                "..xxxx...xxxxxxxxx...#___#....xx........",
                "xxxxx...xxxxxxxxxx...##_##...xxx.......x",
                "xxxxx..xxxxxxxxxxx.........xxxxx......xx",
                "xxxxx..xxxxxxxxxxxx.......xxxxxx......xx");

        GameMap gameMap = new GameMap("Valley of the Inheritree", groundFactory, map);
        world.addGameMap(gameMap);

        // BEHOLD, ELDEN THING!
        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        Player player = new Player("Farmer", '@', 100, 200);
        player.addItemToInventory(new Seed(new Inheritree()));
        player.addItemToInventory(new Seed(new Bloodrose()));
        world.addPlayer(player, gameMap.at(23, 10));

        // game setup
        gameMap.at(24, 11).addItem(new Talisman());

        OmenSheep sheep = new OmenSheep();
        gameMap.at(16,6).addActor(sheep);

//        SpiritGoat goat2 = new SpiritGoat();
//        gameMap.at(22,13).addActor(goat2);
//        SpiritGoat goat3 =  new SpiritGoat();
//        gameMap.at(24,13).addActor(goat3);

        OmenSheep sheep2 = new OmenSheep();
        gameMap.at(22,13).addActor(sheep2);
        OmenSheep sheep3 =  new OmenSheep();
        gameMap.at(24,13).addActor(sheep3);

        OmenSheep sheep4 = new OmenSheep();
        gameMap.at(21,8).addActor(sheep4);

        world.run();
    }
}
