package hw7_1;

public class Ship {
    private int cargoBoxes;
    private int shipId;

    public Ship(int cargoBoxes, int shipId) {
        this.cargoBoxes = cargoBoxes;
        this.shipId = shipId;
    }

    public synchronized boolean isEmpty() {
        return cargoBoxes == 0;
    }

    public synchronized void unloadBox() {
        if (cargoBoxes > 0) {
            cargoBoxes--;
        }
    }

    public int getBoxesRemaining() {
        return cargoBoxes;
    }

    public int getShipId() {
        return shipId;
    }
}
