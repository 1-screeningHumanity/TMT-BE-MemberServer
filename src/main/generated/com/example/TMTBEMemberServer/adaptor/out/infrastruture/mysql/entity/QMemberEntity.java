package com.example.TMTBEMemberServer.adaptor.out.infrastruture.mysql.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberEntity is a Querydsl query type for MemberEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberEntity extends EntityPathBase<MemberEntity> {

    private static final long serialVersionUID = -775736759L;

    public static final QMemberEntity memberEntity = new QMemberEntity("memberEntity");

    public final com.example.TMTBEMemberServer.global.entity.QBaseEntity _super = new com.example.TMTBEMemberServer.global.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Integer> grade = createNumber("grade", Integer.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modifiedAt = _super.modifiedAt;

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final StringPath payingPassword = createString("payingPassword");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final EnumPath<com.example.TMTBEMemberServer.global.common.response.State> status = createEnum("status", com.example.TMTBEMemberServer.global.common.response.State.class);

    public final StringPath uuid = createString("uuid");

    public QMemberEntity(String variable) {
        super(MemberEntity.class, forVariable(variable));
    }

    public QMemberEntity(Path<? extends MemberEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberEntity(PathMetadata metadata) {
        super(MemberEntity.class, metadata);
    }

}

