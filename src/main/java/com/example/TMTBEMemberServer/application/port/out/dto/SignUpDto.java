package com.example.TMTBEMemberServer.application.port.out.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class SignUpDto {

    @Column(nullable = false)
    private Long userId;
    private String name;
    @NotEmpty(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{8,20}$", message = "비밀번호는 영어+숫자 8~20자리로 입력해주세요.")
    private String password;
    private String phoneNumber;
    @NotEmpty(message = "닉네임을 입력해주세요.")
    @Pattern(regexp = "^[가-힣a-zA-Z0-9]{1,10}$", message = "닉네임은 한글, 영어, 숫자로 구성되며 1자에서 10자리로 입력해주세요.")
    private String nickname;

    @Builder
    public SignUpDto(Long userId, String name, String password, String phoneNumber,
            String nickname) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.nickname = nickname;
    }
}
