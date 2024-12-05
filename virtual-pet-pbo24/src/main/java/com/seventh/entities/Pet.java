package com.seventh.entities;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public abstract class Pet {

    private final String name;
    private final LocalDate birthDate;
    private String age;
    
    protected final double MAX_HEALTH;
    private final static double  DOG_MAX_HEALTH = 100;
    private final static double  CAT_MAX_HEALTH = 70;
    private final static double  HAMSTER_MAX_HEALTH = 50;
    private final static double  PARROT_MAX_HEALT = 70;
    private final static double  TURTLE_MAX_HEALT = 70;
    private final static double  RABBIT_MAX_HEALT = 70;
    
    private final double MAX_STATS = 100;
    protected double health, energy, hunger, thirst, happiness, cleanness;
    protected boolean isDead, isSick, isTired, isHungry, isThristy, isSad, isDirty;
    
    public Pet(String name, double upperBound){
        this.name = name;
        this.birthDate = LocalDate.now();
        
        // status upper bounds
        this.MAX_HEALTH = upperBound;
        
        //status set status level
        health = MAX_HEALTH;
        energy = 100;
        hunger = thirst = happiness = cleanness = 80;
        
        // negative effects
        this.isTired = this.isHungry = this.isThristy = 
        this.isSad = this.isDirty = false;
    }
    
    // updateAge
    public void updateAge() {
        LocalDate currentDate = LocalDate.now();
        double calAgeInDays = ChronoUnit.DAYS.between(birthDate, currentDate) / 7.0;
        double ageInYears = calAgeInDays / 365.25;
        double ageInWeeks = calAgeInDays / 7.0;
        
        if (ageInWeeks > 52) {
            age = String.format("%.0f Weeks", ageInWeeks);
        } else {
            age = String.format("%.2f Years", ageInYears);
        }
    }
    
    // Setter for status
    public void setHealth(double amount){
        health =  Math.min(health + amount, MAX_HEALTH);
    }
    public void setEnergy(double amount){
        energy = Math.min(energy + amount, MAX_STATS);
    }
    public void setHunger(double amount){
        hunger = Math.min(hunger + amount, MAX_STATS);
    }
    public void setThirst(double amount){
        thirst = Math.min(thirst + amount, MAX_STATS);
    }
    public void setHappiness(double amount){
        happiness = Math.min(happiness + amount, MAX_STATS);
    }
    public void setCleanness(double amount){
        cleanness = Math.min(cleanness + amount, MAX_STATS);
    }
    
    // Setter for negative effects
    public void setDead(){
        isDead = (health == 0);
    }
    public void setSick(double lowerBounds){
        isSick = (health < lowerBounds);
    }
    public void setTired(double lowerBounds){
        isTired = (energy < lowerBounds);
    }
    public void setHungry(double lowerBounds){
        isHungry = (hunger < lowerBounds);
    }
    public void setThrirsty(double lowerBounds){
        isThristy = (thirst < lowerBounds);
    }
    public void setSad(double lowerBounds){
        isSad = (happiness < lowerBounds);
    }
    public void setDirty(double lowerBounds){
        isDirty = (cleanness < lowerBounds);
    }
    
    // Getter pet info
    public String getName(){return name;}
    public String getAge(){return age;}
    public LocalDate getBirthDate(){return birthDate;}
    
    // Getter health for each pet type
    public static double DOG_MAX_HEALTH() {return DOG_MAX_HEALTH;}
    public static double CAT_MAX_HEALTH() {return CAT_MAX_HEALTH;}
    public static double HAMSTER_MAX_HEALTH() {return HAMSTER_MAX_HEALTH;}
    public static double PARROT_MAX_HEALT() {return PARROT_MAX_HEALT;}
    public static double TURTLE_MAX_HEALT() {return TURTLE_MAX_HEALT;}
    public static double RABBIT_MAX_HEALT() {return RABBIT_MAX_HEALT;}
    
    // Getter status level
    public double getHealth(){return health;}
    public double getEnergy(){return energy;}
    public double getHunger(){return hunger;}
    public double getThirst(){return thirst;}
    public double getHappiness(){return happiness;}
    public double getCleanness(){return cleanness;}
    
    // Getter negative effects
    public boolean getDead(){return isDead;}
    public boolean getSick(){return isSick;}
    public boolean getTired(){return isTired;}
    public boolean getHungry(){return isHungry;}
    public boolean getThrirsty(){return isThristy;}
    public boolean getSad(){return isSad;}
    public boolean getDirty(){return isDirty;}
}
