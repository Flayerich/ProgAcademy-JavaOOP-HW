package hw7_1;

public class Port {
    private final Dock[] docks;
    private final int totalShips;
    private int unloadedShips = 0;
    private boolean isUnloadingFinished = false;

    public Port(int dockCount, int totalShips) {
        this.totalShips = totalShips;
        docks = new Dock[dockCount];
        for (int i = 0; i < dockCount; i++) {
            docks[i] = new Dock(this);
            new Thread(docks[i]).start();
        }
    }

    public synchronized void notifyShipUnloaded() {
        ++unloadedShips;
        if (unloadedShips == totalShips) {
            isUnloadingFinished = true;
            System.out.println("All ships have been unloaded. Ending program.");
            notifyAll(); // Повідомляє всі чекаючі потоки про завершення розвантаження
            System.exit(0); // Завершує програму
        }
    }

    public synchronized boolean isUnloadingFinished() {
        return isUnloadingFinished;
    }

    public void unloadShips(Ship[] ships) {
        for (Ship ship : ships) {
            getAvailableDock().assignShip(ship);
        }
    }

    private Dock getAvailableDock() {
        Dock minQueueDock = docks[0];
        for (Dock dock : docks) {
            if (dock.shipQueue.size() < minQueueDock.shipQueue.size()) {
                minQueueDock = dock;
            }
        }
        return minQueueDock;
    }
}
