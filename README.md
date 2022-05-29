# 프로젝트명
### Search your House
# 프로젝트의 실행 환경
### - Window 10
### - Java 1.8 
### - MySQL 8.0.21

# 이 프로젝트를 local 에서 어떻게 돌릴 수 있는지 소개

Eclipse, IntelliJ와 같은 Java+Spring 코드를 실행시킬 수 있는 IDE와 Visual Studio Code와 같이 Vue를 실행시킬 수 있는 IDE가 필요합니다.

MySQL을 열고 db.sql을 실행시켜 데이터베이스 환경을 구축합니다.

FrontEnd :  https://github.com/Korea-APT-Trading/FrontEnd

FrontEnd의 파일을 다운받고 npm install , npm run serve 명령어를 통해 FrontEnd 실행시킬 수 있습니다.

이때 본인의 .evn.local 파일에 다음과 같은 구문이 작성되어야 합니다.
```
VUE_APP_APT_DEAL_API_KEY=your_app_key
VUE_APP_KAKAOMAP_KEY=your_app_key
```

이후에는 BackEnd 파일을 다운받고 Eclipse, IntelliJ에서 Spring Boot를 실행시키면 API Server가 돌아가게 됩니다.

localhost:8080에서 FrontEnd의 API 요청이 들어오면 Spring Boot가 이를 처리하여 반환합니다.

# 프로젝트의 주요 Dependencies를 나열
mybatis 사용

mySQL 사용

swagger 사용

JWT를 위한 jjwt사용

암호화를 위한 jbcrypt 사용

유효성 검증을 위한 spring-boot-starter-validation 사용

Json 형태의 String을 객체로 변환하기 위해 gson 사용

# 기타 프로젝트 실행 혹은 이해에 필요한 글을 적어주세요.
최종 프로젝트.ppt 를 참고해주시면 좋을 것 같습니다.

# 실제 프로젝트를 서비스하고 있는 링크
실제 서비스하고 있지는 않습니다
