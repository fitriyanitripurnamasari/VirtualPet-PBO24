package com.seventh.entities;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.seventh.domain.Action;

public class Dog extends Pet implements Action {

    public Dog(String name) {
        super(name, DOG_MAX_HEALTH());
    }

    // Easily bored or sad at < 70 happiness (blm)
   // @Override
   // public void setSad(double lowerBound) {
   //     isSad = getHappiness() < lowerBound;
    //}

    @Override
    public void updateStatus() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable updateStatus = () -> {
            // Update age
            updateAge();

            // Update stats
            setHunger(-0.2); // -1 hunger every 5 minutes
            setThirst(-0.5); // -1 thirst every 2 minutes
            setHappiness(-0.25); // -1 happiness every 4 minutes
            setCleanness(-0.1); // -1 cleanness every 10 minutes

            // Check negative effects
            setDead();
            setSick(50);
            setTired(60);
            setHungry(70);
            setThrirsty(70);
            setSad(70);
            setDirty(70);
        };

        // Run each minute
        scheduler.scheduleAtFixedRate(updateStatus, 0, 1, TimeUnit.MINUTES);
    }

    // Action implementations
    @Override
    public void giveFood() {
        setHunger(10);
        setEnergy(-5);
    }

    @Override
    public void giveDrink() {
        setThirst(10);
        setEnergy(-3);
    }

    @Override
    public void playWith() {
        setHappiness(20);
        setEnergy(-20);
    }

    @Override
    public void takeNap() {
        setEnergy(30);
    }

    @Override
    public void clean() {
        setCleanness(20);
    }

    @Override
    public void goToVet() {
        setHealth(40);
    }
}
