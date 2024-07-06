# Member Server

## 📖 Description
- 스프링 시큐리티를 이용해 보안을 제공합니다.
- JWT 기반, AccessToken, RefreshToken 을 가공해 토큰방식의 로그인 기능을 제공합니다.
- RefreshToken을 통해 AccessToken 재발급 기능을 제공합니다.
- coolsms의 문자인증을 통해 회원 정보 변경시 본인인증 서비스를 제공합니다.

## ⚙ Function
1. 사용자의 이름, 전화번호, 비밀번호를 받아 회원으로 등록합니다.
2. 안전한 로그인 기능을 제공하기위해 비밀번호를 해시알고리즘을 이용해 암호화 시킵니다.
3. 유효성 검증을 통해 회원가입시 중복된 닉네임을 사용하지 못하게합니다.
4. 회원 개인정보 변경시 본인인증 절차를 추가해 보안을 강화했습니다.
   
## 🔧 Stack
 - **Language** : Java 17
 - **Library & Framework** : Spring Boot 3.3.0
 - **Database** : MYSQL, Redis
 - **ORM** : ""
 - **Deploy** : AWS EC2 / Jenkins
 - **Dependencies** : Spring Security, JWT, Redis, Validation, Lombok, Model Mapper, Swagger, Eureka, Kakfa, FeignClient

## 🔧 Architecture
- **Design Patter** : Hexagonal Architecture
- **Micro Service Architecture** : Spring Cloud
- **Event-Driven Architecture** : Kafka

## 👨‍👩‍👧‍👦 Developer
*  **강성욱** ([KangBaekGwa](https://github.com/KangBaekGwa))
*  **김도형** ([ddohyeong](https://github.com/ddohyeong))
*  **박태훈** ([hoontaepark](https://github.com/hoontaepark))
