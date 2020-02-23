package atenaExcercises.ex3;

import java.util.LinkedList;

public class Solution {
    public int solution(int[] A, int X, int Y, int Z) {
        Dispenser dispenserX = new Dispenser(X);
        Dispenser dispenserY = new Dispenser(Y);
        Dispenser dispenserZ = new Dispenser(Z);
        LinkedList<Integer> carsQueue = new LinkedList<>();
        carsQueue = getLinkedList(carsQueue, A);
        int timeCounter = -1;
        do {
            dispenserX.isDisposing();
            dispenserY.isDisposing();
            dispenserZ.isDisposing();
            timeCounter++;

            if (!carsQueue.isEmpty()) {
                if (dispenserX.isAvailable && dispenserX.hasEnoughFuel(carsQueue.peek())) {
                    dispenserX.setFuelToDispose(carsQueue.pop());
                    dispenserX.setUnavailable();
                }
                if (dispenserY.isAvailable && dispenserY.hasEnoughFuel(carsQueue.peek())) {
                    dispenserY.setFuelToDispose(carsQueue.pop());
                    dispenserY.setUnavailable();
                }
                if (dispenserZ.isAvailable && dispenserZ.hasEnoughFuel(carsQueue.peek())) {
                    dispenserZ.setFuelToDispose(carsQueue.pop());
                    dispenserZ.setUnavailable();
                }
            }
        } while (dispenserX.fuelToDispose > 0
                || dispenserY.fuelToDispose > 0
                || dispenserZ.fuelToDispose > 0);
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
