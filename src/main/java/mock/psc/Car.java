package mock.psc;

public class Car {

    private Engine engine;
    private String serialNumber;

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


