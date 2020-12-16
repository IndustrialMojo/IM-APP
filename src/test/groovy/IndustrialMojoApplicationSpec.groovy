import com.industrialmojo.IndustrialMojoApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import spock.lang.Specification

@SpringBootTest(classes = IndustrialMojoApplication)
class IndustrialMojoApplicationSpec extends Specification {

    @Autowired
    private ApplicationContext context

    def "test context is loaded and all expected beans are created"() {
        expect: "the HelloController is created"
//        context
    }
}