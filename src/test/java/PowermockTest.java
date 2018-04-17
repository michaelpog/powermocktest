import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest(SomeClass.class)
public class PowermockTest {

    @Test
    public void test() {
        PowerMockito.mockStatic(SomeClass.class);
        Mockito.when(SomeClass.printSomething()).thenReturn(6);
        int x = SomeClass.printSomething();
        Assert.assertEquals(6, x);
    }
}
