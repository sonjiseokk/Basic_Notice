# 기본적인 게시판

# 기본적인 게시판(회원, 게시물 기능)
> **스프링 프레임워크 학습 후** <br/> **개발기간: 2023.07.25 ~ 2023.07.28**

## 프로젝트 소개

기본적인 게시판에 대한 기능을 직접 구현하면서, 스프링 프레임워크와 웹 뷰와의 동작 과정에 대해 이해하는 작은 프로젝트

## 시작 가이드
### Requirements
For building and running the application you need:

- [Spring-boot 2.7.14](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot/2.7.14)
- [Spring-core 5.3.29](https://mvnrepository.com/artifact/org.springframework/spring-core/5.3.29)


---

## Stacks 🐈

### Environment
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Git](https://img.shields.io/badge/Git-F05032?style=for-the-badge&logo=Git&logoColor=white)
![Github](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white)

### Config
<!-- ![npm](https://img.shields.io/badge/npm-CB3837?style=for-the-badge&logo=npm&logoColor=white)         -->

### Development
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005C0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white)
<!-- ![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=Javascript&logoColor=white)
![React](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)
![Strapi](https://img.shields.io/badge/Strapi-2F2E8B?style=for-the-badge&logo=Strapi&logoColor=white)
![Next.js](https://img.shields.io/badge/Next.js-000000?style=for-the-badge&logo=Next.js&logoColor=white) -->
![Bootstrap](https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=Bootstrap&logoColor=white)

<!-- ![Material UI](https://img.shields.io/badge/Material%20UI-007FFF?style=for-the-badge&logo=MUI&logoColor=white) -->

### Communication
<!-- ![Slack](https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=Slack&logoColor=white)
![Notion](https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=Notion&logoColor=white)
![GoogleMeet](https://img.shields.io/badge/GoogleMeet-00897B?style=for-the-badge&logo=Google%20Meet&logoColor=white) -->

---
## 화면 구성 📺
|                                                                      메인 페이지                                                                       |                                                                         작성 페이지                                                                          |
|:-------------------------------------------------------------------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------------------------------------------------------------------:|
|  <img width="329" height="250" src="https://raw.githubusercontent.com/sonjiseokk/Basic_Notice/main/src/main/resources/static/github/main.png"/>   | <img width="329" height="250" src="https://raw.githubusercontent.com/sonjiseokk/Basic_Notice/main/src/main/resources/static/github/content_write.png"/> |  
|                                                                      게시물 페이지                                                                      |                                                                         로그인 페이지                                                                         |  
| <img width="329" height="250" src="https://raw.githubusercontent.com/sonjiseokk/Basic_Notice/main/src/main/resources/static/github/content.png"/> |     <img width="329" height="250" src="https://raw.githubusercontent.com/sonjiseokk/Basic_Notice/main/src/main/resources/static/github/login.png"/>     |

---
## 주요 기능 📦

### ⭐️ 게시물 작성 기능
- 사진과 함께 게시물을 업로드하는 기능
- 추후 더 많은 사진과 여러 편의 기능들을 제공할 예정

### ⭐️ 회원 기능
- 이메일, 이름, 비밀번호로 회원가입이 가능
- 추후 이메일 인증을 통한 가입 방식을 도입할 예정

---
## 아키텍쳐

### 디렉토리 구조
📦src
```bash
┣ 📂main
┃ ┣ 📂generated
┃ ┣ 📂java
┃ ┃ ┗ 📂toy
┃ ┃ ┃ ┗ 📂notice
┃ ┃ ┃ ┃ ┣ 📂domain
┃ ┃ ┃ ┃ ┃ ┣ 📂member
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Member.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MemberDto.java
┃ ┃ ┃ ┃ ┃ ┣ 📂post
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Post.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostWriteForm.java
┃ ┃ ┃ ┃ ┃ ┗ 📂service
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberService.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberServiceV1.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜NoticeService.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜NoticeServiceImpl.java
┃ ┃ ┃ ┃ ┣ 📂web
┃ ┃ ┃ ┃ ┃ ┣ 📂controller
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜HomeController.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberController.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜NoticeController.java
┃ ┃ ┃ ┃ ┃ ┣ 📂mybatis
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberMapper.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostMapper.java
┃ ┃ ┃ ┃ ┃ ┗ 📂repository
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂memory
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemoryMemberRepository.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostRepositoryImpl.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂mybatis
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MybatisMemberRepository.java
┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜MyBatisPostRepository.java
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberRepository.java
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostRepository.java
┃ ┃ ┃ ┃ ┗ 📜NoticeApplication.java
┃ ┗ 📂resources
┃ ┃ ┣ 📂static
┃ ┃ ┃ ┣ 📂github
┃ ┃ ┃ ┃ ┣ 📜content.png
┃ ┃ ┃ ┃ ┣ 📜content_write.png
┃ ┃ ┃ ┃ ┣ 📜login.png
┃ ┃ ┃ ┃ ┗ 📜main.png
┃ ┃ ┃ ┗ 📂images
┃ ┃ ┃ ┃ ┣ 📜fzjwfjuagaerd05.jpg
┃ ┃ ┃ ┃ ┣ 📜images.jpg
┃ ┃ ┃ ┃ ┣ 📜img.jpg
┃ ┃ ┃ ┃ ┣ 📜KakaoTalk_20230810_200056178.jpg
┃ ┃ ┃ ┃ ┗ 📜test.jpg
┃ ┃ ┣ 📂templates
┃ ┃ ┃ ┣ 📜detail.html
┃ ┃ ┃ ┣ 📜index.html
┃ ┃ ┃ ┣ 📜login.html
┃ ┃ ┃ ┣ 📜loginHome.html
┃ ┃ ┃ ┣ 📜mypage.html
┃ ┃ ┃ ┣ 📜register.html
┃ ┃ ┃ ┗ 📜write.html
┃ ┃ ┣ 📂toy
┃ ┃ ┃ ┗ 📂notice
┃ ┃ ┃ ┃ ┗ 📂web
┃ ┃ ┃ ┃ ┃ ┗ 📂mybatis
┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MemberMapper.xml
┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostMapper.xml
┃ ┃ ┣ 📜application.properties
┃ ┃ ┗ 📜errors.properties
┗ 📂test
┃ ┣ 📂generated_tests
┃ ┣ 📂java
┃ ┃ ┗ 📂toy
┃ ┃ ┃ ┗ 📂notice
┃ ┃ ┃ ┃ ┣ 📂service
┃ ┃ ┃ ┃ ┃ ┣ 📜MemberServiceTest.java
┃ ┃ ┃ ┃ ┃ ┗ 📜NoticeServiceTest.java
┃ ┃ ┃ ┃ ┗ 📜NoticeApplicationTests.java
┃ ┗ 📂resources
┃ ┃ ┗ 📜application.properties
```bash
<!-- ```bash
├── README.md
├── gradle/wrapper
├── build.gradle
├── gradlew
├── gradlew.bat
├── settings.gradle
├── src
│   ├── main
│   │   ├── java/toy/notice
│   │   └── resources
│   │       └── resources
│   ├── config : 서버, 데이터베이스 관련 정보 폴더
│   │   ├── database.js
│   │   ├── env : 배포 환경(NODE_ENV = production) 일 때 설정 정보 폴더
│   │   ├── functions : 프로젝트에서 실행되는 함수 관련 정보 폴더
│   │   └── server.js
│   ├── extensions
│   │   └── users-permissions : 권한 정보
│   ├── favicon.ico
│   ├── package-lock.json
│   ├── package.json
│   └── public
│       ├── robots.txt
│       └── uploads : 강의 별 사진
└── voluntain-app : 프론트엔드
    ├── README.md
    ├── components
    │   ├── CourseCard.js
    │   ├── Footer.js
    │   ├── LectureCards.js
    │   ├── MainBanner.js : 메인 페이지에 있는 남색 배너 컴포넌트, 커뮤니티 이름과 슬로건을 포함.
    │   ├── MainCard.js
    │   ├── MainCookieCard.js
    │   ├── NavigationBar.js : 네비게이션 바 컴포넌트, _app.js에서 공통으로 전체 페이지에 포함됨.
    │   ├── RecentLecture.js
    │   └── useWindowSize.js
    ├── config
    │   └── next.config.js
    ├── lib
    │   ├── context.js
    │   └── ga
    ├── next.config.js
    ├── package-lock.json
    ├── package.json
    ├── pages
    │   ├── _app.js
    │   ├── _document.js
    │   ├── about.js
    │   ├── course
    │   ├── index.js
    │   ├── lecture
    │   ├── newcourse
    │   ├── question.js
    │   └── setting.js
    ├── public
    │   ├── favicon.ico
    │   └── logo_about.png
    └── styles
        └── Home.module.css

``` -->

<!--
```bash
├── README.md : 리드미 파일
│
├── strapi-backend/ : 백엔드
│   ├── api/ : db model, api 관련 정보 폴더
│   │   └── [table 이름] : database table 별로 분리되는 api 폴더 (table 구조, 해당 table 관련 api 정보 저장)
│   │       ├── Config/routes.json : api 설정 파일 (api request에 따른 handler 지정)
│   │       ├── Controllers/ [table 이름].js : api controller 커스텀 파일
│   │       ├── Models : db model 관련 정보 폴더
│   │       │   ├── [table 이름].js : (사용 X) api 커스텀 파일
│   │       │   └── [table 이름].settings.json : model 정보 파일 (field 정보)
│   │       └─── Services/ course.js : (사용 X) api 커스텀 파일
│   │ 
│   ├── config/ : 서버, 데이터베이스 관련 정보 폴더
│   │   ├── Env/production : 배포 환경(NODE_ENV = production) 일 때 설정 정보 폴더
│   │   │   └── database.js : production 환경에서 database 설정 파일
│   │   ├── Functions : 프로젝트에서 실행되는 함수 관련 정보 폴더
│   │   │   │   ├── responses : (사용 X) 커스텀한 응답 저장 폴더
│   │   │   │   ├── bootstrap.js : 어플리케이션 시작 시 실행되는 코드 파일
│   │   │   │   └── cron.js : (사용 X) cron task 관련 파일
│   │   ├── database.js : 기본 개발 환경(NODE_ENV = development)에서 database 설정 파일
│   │   └── server.js : 서버 설정 정보 파일
│   │  
│   ├── extensions/
│   │   └── users-permissions/config/ : 권한 정보
│   │ 
│   └── public/
│       └── uploads/ : 강의 별 사진
│
└── voluntain-app/ : 프론트엔드
    ├── components/
    │   ├── NavigationBar.js : 네비게이션 바 컴포넌트, _app.js에서 공통으로 전체 페이지에 포함됨.
    │   ├── MainBanner.js : 메인 페이지에 있는 남색 배너 컴포넌트, 커뮤니티 이름과 슬로건을 포함.
    │   ├── RecentLecture.js : 사용자가 시청 정보(쿠키)에 따라, 현재/다음 강의를 나타내는 컴포넌트 [호출: MainCookieCard]
    │   ├── MainCookieCard.js : 상위 RecentLecture 컴포넌트에서 전달받은 props를 나타내는 레이아웃 컴포넌트.
    │   ├── MainCard.js : 현재 등록된 course 정보를 백엔드에서 받아서 카드로 나타내는 컴포넌트 [호출: CourseCard]
    │   └── CourseCard.js : 상위 MainCard 컴포넌트에서 전달받은 props를 나타내는 레이아웃 컴포넌트
    │
    ├── config/
    │   └── next.config.js
    │
    ├── lib/
    │   └── ga/
    │   │   └── index.js
    │   └── context.js
    │
    ├── pages/
    │   ├── courses/
    │   │   └── [id].js : 강의 페이지
    │   ├── _app.js : Next.js에서 전체 컴포넌트 구조를 결정, 공통 컴포넌트(navbar, footer)가 선언되도록 customizing 됨.
    │   ├── _document.js : Next.js에서 전체 html 문서의 구조를 결정, lang 속성과 meta tag가 customizing 됨.
    │   ├── about.js : 단체 소개 페이지
    │   ├── index.js : 메인 페이지
    │   ├── question.js : Q&A 페이지
    │   └── setting.js : 쿠키, 구글 애널리틱스 정보 수집 정책 페이지
    │
    ├── public/
    │   ├── favicon.ico : 네비게이션바 이미지
    │   └── logo_about.png : about 페이지 로고 이미지
    │
    └── styles/
        └── Home.module.css

```
-->