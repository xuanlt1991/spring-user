package com.spring.springuser.entity;

import com.spring.springcommon.entity.SoftDeleteEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "USER")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends SoftDeleteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID", nullable = false)
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "status_code")
    private String statusCode;
}
