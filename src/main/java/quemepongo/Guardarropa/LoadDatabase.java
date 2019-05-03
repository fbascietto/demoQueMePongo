/*package quemepongo.Guardarropa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(GuardarropaRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Guardarropa("Ropa de casa", "Bilbo Baggins")));
            log.info("Preloading " + repository.save(new Guardarropa("Ropa de Aventura", "Frodo Baggins")));
        };
    }
}
*/