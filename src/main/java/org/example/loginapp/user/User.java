package org.example.loginapp.user;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "user_tb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String username;
    private String password;
    private String email;

    // 여기 값이 들어왔다? 그럼 오어스를 사용한것
    private String provider; // facebook, kakao, apple, naver

    @Builder
    public User(Integer id, String username, String password, String email, String provider) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.provider = provider;
    }
}
