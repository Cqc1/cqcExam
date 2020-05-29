package com.exam;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;

@SpringBootTest
class ExamApplicationTests {

   /* @Test*/
    /*void contextLoads() {*/
        @Test
        public void TestspringVersionAndspringBootVersion (){
            String springVersion = SpringVersion.getVersion();
            String springBootVersion = SpringBootVersion.getVersion();
            System.out.println(springVersion+"============"+springBootVersion);
        }



   /* }*/

}
