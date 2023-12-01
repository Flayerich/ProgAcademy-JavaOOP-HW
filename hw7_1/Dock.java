package hw7_1;

import java.util.LinkedList;
import java.util.Queue;

public class Dock implements Runnable {
    private Ship currentShip;
    private Port port;
    public final Queue<Ship> shipQueue = new LinkedList<>();

    public Dock(Port port) {
        this.port = port;
    }

    public synchronized void assignShip(Ship ship) {
        shipQueue.offer(ship);
        notifyAll();
    }

    public synchronized void run() {
        while (true) {
            while (currentShip == null || currentShip.isEmpty()) {
                currentShip = shipQueue.poll();
                if (currentShip == null) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                } else {
                    System.out.println("Ship " + currentShip.getShipId() + " is now unloading.");
                }
            }

            if (currentShip != null && !currentShip.isEmpty()) {
                currentShip.unloadBox();
                System.out.println("Unloading a box from ship " + currentShip.getShipId() + ". Boxes left: " + currentShip.getBoxesRemaining());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            if (currentShip != null && currentShip.isEmpty()) {
                System.out.println("Ship " + currentShip.getShipId() + " has been completely unloaded.");
                port.notifyShipUnloaded(); // Повідомлення Port про розвантаження корабля
                currentShip = null;
            }
        }
    }
}
