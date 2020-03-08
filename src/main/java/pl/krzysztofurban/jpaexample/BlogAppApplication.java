package pl.krzysztofurban.jpaexample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.krzysztofurban.jpaexample.repository.base.BaseRepositoryImpl;

@SpringBootApplication
@Slf4j
@EnableJpaRepositories(repositoryBaseClass = BaseRepositoryImpl.class)
public class BlogAppApplication {

  public static void main(String[] args) {
    SpringApplication.run(BlogAppApplication.class, args);
  }
}
