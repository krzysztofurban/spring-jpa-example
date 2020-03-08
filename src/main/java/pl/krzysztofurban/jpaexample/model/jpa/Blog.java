package pl.krzysztofurban.jpaexample.model.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"posts"})
@EqualsAndHashCode(exclude = {"posts"})
@Entity
public class Blog {
  //guid is useful to hide incremental 'id' from all external - security reasons
  //'id' would be faster to index and query while doing pagination filtering etc
  @Type(type = "pg-uuid")
  UUID guid;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String about;
  private LocalDateTime publishedAt;

  @JsonIgnore
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "blog")
  private Set<Post> posts;
}

//In order to use UUID in postgres, we need to enable it
// schema.sql - CREATE EXTENSION IF NOT EXISTS uuid-ossp
