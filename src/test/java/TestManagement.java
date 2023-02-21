import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestManagement {
    private Application application;

    @BeforeEach
    public void setup() {
        application = new Application();
        application.init();
    }
}
