package mock.psc;

public class Car {

    private Engine engine;
    private String serialNumber;
    private Engine additionalEngine;

    public Engine getAdditionalEngine() {
        return additionalEngine;
    }

    public Car(Engine engine, String serialNumber, Engine additionalEngine) {
        this.engine = engine;
        this.serialNumber = serialNumber;
        this.additionalEngine = additionalEngine;
    }

    public void setAdditionalEngine(Engine additionalEngine) {
        this.additionalEngine = additionalEngine;
    }

    public Car(Engine engine, String serialNumber) {
        this.engine = engine;
        this.serialNumber = serialNumber;
    }

    public void start() {
        engine.start();
    }

    public void stop() {
        if (!engine.isRunning())
            start();

        engine.stop();
    }
    public  void  doSomethingWithAdditionaEngine(){
        additionalEngine.start();
        System.out.println("Do something");
    }

    public void turnLeft() {
        drive("LEFT");
    }


    public void drive(String direction) {
        switch (direction) {
            case "LEFT":
                break;

            case "RIGHT":
                break;

            case "FORWARD":
                break;

            case "BACK":
                break;
        }
    }
}


