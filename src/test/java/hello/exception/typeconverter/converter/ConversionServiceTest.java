package hello.exception.typeconverter.converter;

import hello.exception.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

public class ConversionServiceTest {

    @Test
    void conversionService() {
        // 등록
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());

        // 사용
        Integer result1 = conversionService.convert("10", Integer.class);
        Assertions.assertThat(result1).isEqualTo(10);

        IpPort result2 = conversionService.convert("127.0.0.1:8080", IpPort.class);
        Assertions.assertThat(result2).isEqualTo(new IpPort("127.0.0.1", 8080));



    }
}
