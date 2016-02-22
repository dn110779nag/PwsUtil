import spock.lang.*
import com.mycompany.pwsutil.*

@Unroll
class ConvertToJsonSpec extends Specification {
    def "convert"(){
        setup:
        ConvertToJson converter = new ConvertToJson()
        java.util.Properties p = ["v1.v2":"value", "v2":"xxx"]
        when:
        def ret = converter.convert(p)
        println "ret=$ret"
        then:
        ret.v1.v2 == "value"
        ret.v2 == "xxx";
    }
}