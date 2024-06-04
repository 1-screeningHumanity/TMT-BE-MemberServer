package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.entity;


import com.example.TMTBEMemberServer.global.common.enumclass.PaymentMethod;
import com.example.TMTBEMemberServer.global.common.enumclass.PaymentType;
import com.example.TMTBEMemberServer.global.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "paymentLog")
public class PaymentLogEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentLogId; //결제로그ID

    private Long paymentRealcash; //결제금액

    private PaymentType payName; //원 OR 캐시

    private PaymentMethod payMethod;//결제수단

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private MemberEntity memberId;//회원ID






}
