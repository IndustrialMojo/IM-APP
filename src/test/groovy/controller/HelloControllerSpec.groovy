import com.industrialmojo.controller.HelloController
import spock.lang.Specification

class HelloControllerSpec extends Specification {

    private HelloController controller

    def setup() {
        controller = new HelloController()
    }

    def 'test hello'() {
        given:

        when:
        String actual = controller.hello()

        then:
        assert actual
    }
}