package dev.findfirst.users.model.user;


import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import dev.findfirst.security.userAuth.models.payload.request.SignupRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

  public User(String username, String email, String encodedPasswd, boolean enabled) {
    this.username = username;
    this.email = email;
    this.password = encodedPasswd;
    this.enabled = enabled;
  }

  public User(SignupRequest signup, String encodedPasswd) {
    this(signup.username(), signup.email(), encodedPasswd, false);
  }

  @Id
  private Integer userId;

  private boolean enabled;

  private String username;

  private String email;

  private String password;

  @Column("role_role_id")
  private AggregateReference<Role, Integer> role;

}
