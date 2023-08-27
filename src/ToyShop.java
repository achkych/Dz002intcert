import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyShop {
    private List<Toy> toys;
    private List<Toy> prizeToys;

    public ToyShop() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
    }

    public void addToy(int id, String name, int quantity, int weight) {
        Toy toy = new Toy(id, name, quantity, weight);
        toys.add(toy);
    }

    public void updateToyWeight(int id, int newWeight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(newWeight);
                return;
            }
        }
        System.out.println("Toy not found!");
    }

    public void conductPrizeDraw() {
        int totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        Random random = new Random();
        int randomNumber = random.nextInt(totalWeight) + 1;

        int currentWeight = 0;
        for (Toy toy : toys) {
            currentWeight += toy.getWeight();
            if (randomNumber <= currentWeight) {
                if (toy.getQuantity() > 0) {
                    toy.setQuantity(toy.getQuantity() - 1);
                    prizeToys.add(toy);
                    System.out.println("Prize Toy: " + toy.getName());
                    return;
                } else {
                    System.out.println("No more quantity for this toy!");
                    return;
                }
            }
        }

        System.out.println("No toys available!");
    }

    public void savePrizeToysToFile(String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (Toy prizeToy : prizeToys) {
                writer.write(prizeToy.getName() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}