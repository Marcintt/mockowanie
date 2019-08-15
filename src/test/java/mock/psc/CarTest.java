package mock.psc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CarTest {


    private Car car;
    @Spy
    private Engine engine;

    @Before
    public void SetUp() {
        car = new Car(engine, "HKS566");
    }

    @Test
    public void shouldStartEngineWhenStartingCar() {
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
}
