package Api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // <-- Esta anotación le da superpoderes web a tu clase
public class Main {

    public static void main(String[] args) {
        // Esta línea apaga la consola tradicional y enciende el servidor Tomcat interno
        SpringApplication.run(Main.class, args);
    }
}