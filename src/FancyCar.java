import Program4.Util4;

import java.io.PrintWriter;
import java.util.Scanner;

/*
Program 1 Fancy Car
Creates a car that accurately works.
CS160-03
2/4/2026
@author Asher Plotsky
*/public class FancyCar {
    private int odometer;
    private double gas;
    private double mpg;
    private double capacity = 14.0;
    private String model;
    private boolean engine;

    public FancyCar() {
        odometer = 5;
        gas = capacity;
        mpg = 24.0;
        model = "Old Clunker";
    }
    public FancyCar(String model, double mpg) {
        odometer = 5;
        gas = capacity;
        this.mpg = mpg;
        this.model = model;
    }
    public int checkOdometer() {
        return odometer;
    }
    public double checkGasGauge() {
        return gas;
    }
    public double getMPG() {
        return mpg;
    }
    public double checkCapacity() {
        return capacity;
    }
    public String getModel() {
        return model;
    }
    public void honkHorn(){
        System.out.println("The " + model + " says beep beep!");
    }
    public void drive(double distance) {
        if (distance > gas * mpg){
            distance = gas * mpg;
        }
        if (engine == true) {
            if (distance > 0) {
                gas -= distance / mpg;
                odometer += distance;
            }
            if (gas == 0) {
                engine = false;
            }
        }
    }
    public void addGas(double gas) {
        if (engine == false) {
            if (gas > 0) {
                this.gas += gas;
                if (this.gas > capacity) {
                    this.gas = capacity;
                }
            }
        }
    }
    public void startEngine(){
        engine = true;
    }
    public void stopEngine(){
        engine = false;
    }

}
