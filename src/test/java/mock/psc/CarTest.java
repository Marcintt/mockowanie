package mock.psc;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CarTest {

    private static final Logger LOGGER = Logger.getLogger(CarTest.class);


    private Car car;
    @Mock
    private Engine engine;

    @InjectMocks
    private Car carWithInjectMocks;

    @Before
    public void SetUp() {
        car = new Car(engine, "HKS566");
    }

    @Test
    public void shouldStartEngineWhenStartingCar() {
        LOGGER.info("BEGIN - shouldStartEngineWhenStartingCar");
        LOGGER.error("ERROR - shouldStartEngineWhenStartingCar");
        car.start();
        Mockito.verify(engine).start();

    }

    @Test(expected = UnsupportedOperationException.class)
    public void shouldThrowExceptionWhenWeTryToStartRunningCar() {
        car.start();
        Mockito.doThrow(UnsupportedOperationException.class).when(engine).start();
        car.start();
    }

    @Test
    public void shouldDriveWhenUsingDummyEngine() {
        car.drive("LEFT");
    }

    @Test
    public void shouldStartEngineBeforeStopping() {
        Mockito.doReturn(false).when(engine).isRunning();
        car.stop();
        InOrder inOrder = Mockito.inOrder(engine);
        inOrder.verify(engine).start();
        inOrder.verify(engine).stop();
    }

    @Test
    public void shouleCallDriveWithParameterLeftWhenTurningLeft() {
        car = Mockito.spy(new Car(engine, "ffgd3232"));
        car.turnLeft();
        Mockito.verify(car).turnLeft();
        Mockito.verify(car).drive("LEFT");
    }

    @Test
    public void shouldStartEngineBeforeDoSomething() {
        carWithInjectMocks.doSomethingWithAdditionaEngine();
        Mockito.verify(carWithInjectMocks.getAdditionalEngine()).start();
    }
}
