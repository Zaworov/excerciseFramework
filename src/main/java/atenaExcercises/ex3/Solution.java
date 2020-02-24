package atenaExcercises.ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int solution(int[] A, int X, int Y, int Z) {
        int entryNumberOfCars = A.length;
        ArrayList<Dispenser> dispensers = new ArrayList<>(Arrays.asList(new Dispenser(X), new Dispenser(Y), new Dispenser(Z)));
        LinkedList<Integer> carsQueue = new LinkedList<>();
        carsQueue = getLinkedList(carsQueue, A);
        int timeCounter = -1;
        do {
            for (Dispenser dispenser : dispensers) {
                dispenser.isDisposing();

                if (!carsQueue.isEmpty()) {
                    if (dispenser.isAvailable && dispenser.hasEnoughFuel(carsQueue.peek())) {
                        dispenser.setFuelToDispose(carsQueue.pop());
                        dispenser.setUnavailable();
                    }
                }
                timeCounter++;
                if (carsQueue.size() == entryNumberOfCars) return -1;
            }
        } while (dispensers.get(0).fuelToDispose > 0
                || dispensers.get(1).fuelToDispose > 0
                || dispensers.get(2).fuelToDispose > 0);
        return timeCounter;
    }

    private LinkedList<Integer> getLinkedList(LinkedList carsQueue, int[] a) {
        for (int neededFuelForCar : a) {
            carsQueue.addLast(neededFuelForCar);
        }
        return carsQueue;
    }

    class Dispenser {
        private int amountOfFuel;
        private int fuelToDispose = 0;
        private boolean isAvailable = true;

        Dispenser(int amountOfFuel) {
            this.amountOfFuel = amountOfFuel;
        }

        void isDisposing() {
            if (fuelToDispose > 0) {
                fuelToDispose = fuelToDispose - 1;
            }
            if (fuelToDispose == 0) {
                this.setAvailable();
            }
        }

        void setFuelToDispose(Integer neededFuelForACar) {
            this.fuelToDispose = neededFuelForACar;
        }

        boolean hasEnoughFuel(Integer neededFuelForACar) {
            return (amountOfFuel >= neededFuelForACar);
        }

        void setUnavailable() {
            isAvailable = false;
        }

        void setAvailable() {
            isAvailable = true;
        }
    }
}
