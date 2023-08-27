import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();

        toyShop.addToy(1, "Car", 10, 20);
        toyShop.addToy(2, "Doll", 5, 30);
        toyShop.addToy(3, "Ball", 15, 50);

        toyShop.updateToyWeight(1, 10);

        toyShop.conductPrizeDraw();
        toyShop.conductPrizeDraw();
        toyShop.conductPrizeDraw();

        toyShop.savePrizeToysToFile("prize_toys.txt");
    }
}

