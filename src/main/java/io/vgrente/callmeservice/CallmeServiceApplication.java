package io.vgrente.callmeservice;

import org.hibernate.dialect.H2Dialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.nativex.hint.NativeHint;
import org.springframework.nativex.hint.TypeHint;

@SpringBootApplication
public class CallmeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CallmeServiceApplication.class, args);
    }

}
