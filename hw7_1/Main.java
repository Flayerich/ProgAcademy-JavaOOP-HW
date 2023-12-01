package hw7_1;

public class Main {
    public static void main(String[] args) {

        int totalShips = 3;
        Port port = new Port(2, totalShips); // two docks
        Ship[] ships = {new Ship(10, 1),
                        new Ship(10, 2),
                        new Ship(10, 3)}; // three ships with 10 boxes each and unique IDs

        port.unloadShips(ships);
    }
}


