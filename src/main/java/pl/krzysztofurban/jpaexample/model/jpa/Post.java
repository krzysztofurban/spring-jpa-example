package pl.krzysztofurban.jpaexample.model.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"blog", "user"})
@EqualsAndHashCode(exclude = {"blog", "user"})
@Entity
public class Post {
  @Column(name = "post_status")
  @Type(type = "pl.krzysztofurban.jpaexample.constants.PgEnumType",
      parameters = {@org.hibernate.annotations.Parameter(name = "enumClassName",
          value = "pl.krzysztofurban.jpaexample.model.jpa.PostStatus")})
  PostStatus postStatus;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String title;
  private String content;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
  @JoinColumn(name = "blog_id")
  private Blog blog;

  @JsonIgnore
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
  @JoinColumn(name = "author_id")
  private User user;
}
