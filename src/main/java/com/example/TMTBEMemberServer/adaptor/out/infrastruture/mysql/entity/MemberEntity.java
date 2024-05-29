package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.entity;

import com.example.TMTBEMemberServer.domain.SignUp;
import com.example.TMTBEMemberServer.global.common.enumclass.State;
import com.example.TMTBEMemberServer.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "member")
public class MemberEntity extends BaseEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId; //PK

    private String name; //이름

    private String password; //비밀번호

    private String nickname; //닉네임

    private String payingPassword; //결제 PW

    private String uuid; //uuid

    @Enumerated(EnumType.STRING)
    private State status; //회원상태

    private int grade; //회원등급

    private String phoneNumber; //전화번호

    public static MemberEntity toEntity(SignUp signUp) {

        return MemberEntity.builder()
                .name(signUp.getName())
                .password(signUp.getPassword())
                .phoneNumber(signUp.getPhoneNumber())
                .nickname(signUp.getNickName())
                .build();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return uuid;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
