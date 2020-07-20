package payroll.persistance;

import payroll.domain.Employee;
import payroll.domain.Role;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public
class LoadDatabase {

    public final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", Role.burglar)));
            log.info("Preloading " + repository.save(new Employee("Frodo Baggins", Role.boss)));
            log.info("Preloading " + repository.save(new Employee("Edo Baggins", Role.thief)));
        };
    }
}