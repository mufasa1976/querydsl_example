package io.github.mufasa1976.example.querydsl;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.NONE;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "some_tables")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
@Builder
public class SomeTable {

  @Id
  @Setter(NONE)
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @NotNull
  @Size(min = 1, max = 1000)
  private String someText;
}
