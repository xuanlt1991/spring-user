package com.spring.springuser.request;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long userId;
    private String name;
    private String email;
}
