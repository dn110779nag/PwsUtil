import spock.lang.*
import com.mycompany.pwsutil.Example

@Unroll
class DataDrivenSpec extends Specification {
    def "say hello"() {
        expect:
        new Example().sayHello(a) == b;

        where:
        a << ["test", "Java", "Friday"]
        b << ["Hello, test", "Hello, Java", "Hello, Friday"]
    }
    
    def "sum"(){
        expect:
        new Example().sum(a,b) == c;
        where:
        a|b|c
        1|2|3
        4|5|9
    }
}
