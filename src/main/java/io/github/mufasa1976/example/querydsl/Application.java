package io.github.mufasa1976.example.querydsl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@RequiredArgsConstructor
@EnableJpaRepositories
@EnableTransactionManagement
@Slf4j
public class Application implements ApplicationRunner {
  private final SomeTableRepository someTableRepository;

  public static void main(String... args) {
    new SpringApplicationBuilder(Application.class)
        .run(args);
  }

  @Override
  @Transactional
  public void run(ApplicationArguments args) throws Exception {
    List<SomeTable> someTables = Stream.of(
        SomeTable.builder()
                 .someText("some Test")
                 .build(),
        SomeTable.builder()
                 .someText("some other Text")
                 .build()
    ).collect(Collectors.toList());
    someTableRepository.save(someTables);
  }
}
