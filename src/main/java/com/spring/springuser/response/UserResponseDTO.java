package com.spring.springuser.response;

import com.spring.springcommon.response.PostResponseDTO;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long userId;
    private String name;
    private String email;
    private String statusCode;
    private List<PostResponseDTO> postResponseDTOList;
}
