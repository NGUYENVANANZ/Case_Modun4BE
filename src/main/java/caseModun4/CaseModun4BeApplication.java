package caseModun4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringVersion;

@SpringBootApplication
public class CaseModun4BeApplication {

    public static void main(String[] args) {
        SpringApplication springApplication=new SpringApplication(CaseModun4BeApplication.class);
        System.out.println("Spring Core Version:- " + SpringVersion.getVersion());
        springApplication.run(args);
    }

}
