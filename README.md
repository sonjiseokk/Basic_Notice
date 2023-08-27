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
```bash
📦src
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
