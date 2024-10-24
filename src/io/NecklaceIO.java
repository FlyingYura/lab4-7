package io;

import necklace.Necklace;
import stones.Stone;

import java.io.*;

public class NecklaceIO {
    public static void saveToFile(Necklace necklace, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (Stone stone : necklace.getStones()) {
                oos.writeObject(stone);
                System.out.println("Збережено камінь: " + stone.getName() +
                        ", Вага: " + stone.getWeight() +
                        ", Вартість: " + stone.getCost() +
                        ", Прозорість: " + stone.getTransparency());
            }
        }
    }

    public static void loadFromFile(Necklace necklace, String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                try {
                    Stone stone = (Stone) ois.readObject();
                    necklace.addStone(stone);
                    System.out.println("Завантажено камінь: " + stone.getName() +
                            ", Вага: " + stone.getWeight() +
                            ", Вартість: " + stone.getCost() +
                            ", Прозорість: " + stone.getTransparency());
                } catch (EOFException e) {
                    break;
                }
            }
        }
    }
}
