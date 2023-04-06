# 에이원퍼포먼스팩토리 기술과제 - 김유정

## 기술 스택
Java 17, Spring Boot 3.0.5, Thymeleaf

## 실행 방법
Java 17 버전이 설치되어 있어야합니다.
<details>
  <summary>Java 버전 확인 및 변경</summary>

  ### Java 버전 확인
  ```
  java -version
  ```
  ### 설치된 JDK 리스트 확인
  ```
  /usr/libexec/java_home -V
  ```
  ### Java 버전 변경
  ```
  export JAVA_HOME=$(/usr/libexec/java_home -v 11)
  ```
</details>

### 1. 프로젝트 복제
복제를 원하는 위치에서 다음 명령어를 실행
```
git clone https://github.com/yujung7768903/board.git
```
프로젝트로 이동
```
cd board
```
### 2. 빌드 및 실행
```
./gradlew build && java -jar ./build/libs/*-SNAPSHOT.jar
```
이제 실행환경 세팅이 완료되었습니다 🙌

## 기능 소개
### 글 쓰기
* URI: http://localhost:8080/post/new
* 중요 게시물 체크 가능
* 닉네임은 가장 최근에 사용한 닉네임으로 자동 입력
<img width="1440" alt="Screen Shot 2023-04-06 at 10 18 39 PM" src="https://user-images.githubusercontent.com/68562176/230390382-e36f5b6b-91fc-4bd7-9cc5-8f3841258563.png">

### 글 리스트
* URI: http://localhost:8080
* 제목과 닉네임을 선택하여 검색 가능
<img width="1440" alt="Screen Shot 2023-04-06 at 10 24 59 PM" src="https://user-images.githubusercontent.com/68562176/230391881-d420c7dc-3dab-4402-ba59-5f50d56208bb.png">

### 글 읽기
* URI: http://localhost:8080/post/{postId}
* 삭제 가능
<img width="1440" alt="Screen Shot 2023-04-06 at 10 29 27 PM" src="https://user-images.githubusercontent.com/68562176/230392953-e4b6820c-54ae-447f-bbab-bcb7d01e34bb.png">

