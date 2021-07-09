import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
        "src/test/resources/Email_and_password_cannot_be_left_blank.feature",
},
        plugin = {"pretty", "html:target/Raport.html"},
        monochrome = true)
public class TestRunner {
}
