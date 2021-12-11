<h3 align="center"><b>📰 항해99 6주차 12팀 미니프로젝트 📰</b></h3>
	
<h4 align="center">📆 2021.12.06 ~ 2021.12.11</h4>
<br>

---

<h3><b>🎫 프로젝트 소개 🎫</b></h3>
개발자 정보 공유 커뮤니티! 개발자들의 살롱을 꿈꿉니다..⭐
<br>Front-End Git Repository : https://github.com/mtae616/sout-FrontEnd

<br><br>

<h3><b>🎞 프로젝트 시연영상 🎞</b></h3>
https://www.youtube.com/watch?v=Ltmke9IyPXo
<br>

---

<br>
<h3 align="center"><b>🛠 Tech Stack 🛠</b></h3>
<p align="center">
<img src="https://img.shields.io/badge/github-181717?style=flat&logo=github&logoColor=white"></a>&nbsp;&nbsp;&nbsp;
<img src="https://img.shields.io/badge/MySQL-005C84?style=flat&logo=mysql&logoColor=white"></a>&nbsp;&nbsp;&nbsp; 
<img src="https://img.shields.io/badge/Springboot-47?style=flat&logo=Springboot&logoColor=white"/></a>&nbsp;&nbsp;&nbsp; 
<img src="https://img.shields.io/badge/Java-ED8B00?style=flat&logo=java&logoColor=white"/></a>&nbsp;&nbsp;&nbsp;
<img src="https://img.shields.io/badge/JWT-000000?style=flat&logo=JSON%20web%20tokens&logoColor=white"></a>&nbsp;&nbsp;&nbsp;
<img src="https://img.shields.io/badge/Swagger-85EA2D?style=flat&logo=Swagger&logoColor=white"></a>&nbsp;&nbsp;&nbsp;
<img src="https://img.shields.io/badge/gradle-02303A?style=flat&logo=gradle&logoColor=white"></a>&nbsp;&nbsp;&nbsp;
<img src="https://img.shields.io/badge/Amazon_AWS-FF9900?style=flat&logo=amazonaws&logoColor=white"></a>&nbsp;&nbsp;&nbsp;
<img src="https://img.shields.io/badge/Notion-000000?style=flat&logo=notion&logoColor=white"></a>&nbsp;&nbsp;&nbsp;

<br><br>
<h3 align="center"><b>📂 Project Directory Structure 📁</b></h3>
<pre>
<code>
/com.seongend.sout
  └──/config
     └── /SwaggerConfig.java
  └──/controller
     ├── /CommentController.java
     ├── /HomeController.java
     ├── /KakaoUserController.java
     ├── /PostController.java
     └── /UserController.java
  └──/dto
     ├── /CommentRequestDto.java
     ├── /CommentResponseDto.java
     ├── /KakaoUserInfoDto.java
     ├── /PostRequestDto.java
     ├── /PostResponseDto.java
     ├── /SignupRequestDto.java
     └── /UserInfoDto.java
  └──/entity
     ├── /Comment.java
     ├── /Post.java
     ├── /Timestamped.java
     └── /User.java
  └──/repository
     ├── /CommentRepository.java
     ├── /PostRepository.java
     └── /UserRepository.java
  └──/security
     └── /filter
         ├── /FormLoginFilter.java
         └── /JwtAuthFilter.java
     └── /jwt
         ├── /HeaderTokenExtractor.java
         ├── /JwtDecoder.java
         ├── /JwtPreProcessingToken.java
         └── /JwtTokenUtils.java
     └── /provider
         ├── /FormLoginAuthProvider.java
         └── /JWTAuthProvider.java
     ├── /FilterSkipMatcher.java
     ├── /FormLoginSuccessHandler.java
     ├── /UserDetailsImpl.java
     ├── /UserDetailsServiceImpl.java
     └── /WebSecurityConfig.java
  └──/service
     ├── /CommentService.java
     ├── /HomeService.java
     ├── /KakaoUserService.java
     ├── /PostService.java
     └── /UserService.java
  └──/timeconversion
     └── /TimeConversion.java
  └──/validator
     └── /UserInfoValidator.java
  └──/SoutApplication.java
</code>
</pre>
<br>

---

<h3 align="center"><b>📢 Entity Relationship Diagram 📢</b></h3>
<p align="center"><img src="https://user-images.githubusercontent.com/57797592/145665724-4b516321-0d66-47e4-834b-e8aee8221664.png" /></p>

<br>
<h3 align="center"><b>🏷 API Table 🏷</b></h3>

### **User**

| **URI** | **RequestBody** | **ResponseBody** |
| --- | --- | --- |
| POST /user/login | {username : " ", password : " " } | {token : " "} |
| POST /user/signup | {email : " ", nickname : " ", interest : " ", password : " "} |   |
| POST /userinfo | ?token="token" | {email : " ", nickname : " ", interest : " ", password : " "} |

### **Posts**

| **URI** | **RequestBody** | **ResponseBody** |
| --- | --- | --- |
| GET / | ?page="pagenum"&size="size" | \[{email : " ", nickname : " ", interest : " ", content: " ", postId : "", modifiedAt : "", url : "", commentList: \[{nickname : " ", content : " ", modifiedAt : ""}\]}\] |
| GET /search | search?keyword\="keyword"&page="pagenum"&size="size" | \[{ email : " ", nickname : " ", interest : " ", content: " ", postId : "", modifiedAt : "", url : "" commentList: \[{ nickname : " ", content : " ", modifiedAt : "" }\] |
| POST /newpost | { content: " ", url : " "} , ?token\="token" | {email : " ", nickname : " ", interest : " ", content: " ", postId : "", modifiedAt : "", url : "", commentList: [{nickname : " ", content : " ", modifiedAt : ""}]} |
| PUT /newpost/{postId} | { content: " ", url : " "} , ?token\="token" |   |
| DELETE /api/{postId} | ?token\="token" |   |

### **Comment**

| **URI** | **RequestBody** | **ResponseBody** |
| --- | --- | --- |
| POST /api/{postId}/comment | {content : " "}, ?value="token" | {nickname : " ", content : " ", modifiedAt : "", email : "", commentId : ""} |
| DELETE /api/{postId}/{commentId} | ?value="token" |   |

### **Profile**

| **URI** | **RequestBody** | **ResponseBody** |
| --- | --- | --- |
| PUT /setting/profile | {email : " ", nickname : " ", interest : " ", password : " "} , ?value="token" |   |
| GET /user/kakao/callback | ?code="code" | {token : " "} |

---

<h3 align="center"><b>👨🏻‍🤝‍👨🏻 Members 👨🏻‍🤝‍👨🏻</b></h3>
<br>
<table align="center">
    <tr>
        <td align="center">
        <a href="https://diddl.tistory.com/"><img src="https://img.shields.io/badge/양성은-000AFF?style=뱃지모양&logo=로고&logoColor=white"/></a>
        </td>
        <td align="center">
        <a href="https://velog.io/@davidko"><img src="https://img.shields.io/badge/고성범-2DDC88?style=뱃지모양&logo=로고&logoColor=black"/></a>
        </td>
        <td align="center">
        <a href="https://www.notion.so/99-6-12-a6a6f7372d9d4d5a93af8803be40330e"><img src="https://img.shields.io/badge/성해인-D77EE9?style=뱃지모양&logo=로고&logoColor=white"/></a>
        </td>
    </tr>
    <tr>
        <th width="25%" align="center">:spider_web: BACK-END
        </th>
        <th width="25%" align="center">:spider_web: BACK-END
        </th>
        <th width="25%" align="center">:spider_web: BACK-END 
        </th>
    </tr>
</table>
<br>

---

<h3 align="center"><b>✏ Trouble Shooting ✏</b></h3>
<br>
<details>
    <summary>
       <b>댓글이 달려있는 포스트는 삭제가 되지 않는 문제 발생</b>
    </summary>
    <br><b>해결: 댓글 선 삭제 후 포스트 삭제</b>
    <br>방식 1: Entity 설계 시 JPA 양방향 관계로 설계 시, casecade.all 설정을 통해 해결 가능
    <br>방식 2: Entity 설계 시 JPA 단방향 관계로 설계 시, 댓글을 먼저 삭제한 후, 포스트 삭제
    <br>현재 프로젝트의 경우 처음 Entity 설계 시, 단방향으로 설계하여 방식 2번을 통해 문제를 해결하였다. 이렇듯 중간에 설계적 오류로 인해 발생하는 문제를 겪어보았는데 이러한 문제를 겪으며 처음 Entity 설계의 중요성을 알았고, 다음부터 테이블 간의 관계를 잘 생각해서 설계해야겠다는 것을 느꼈다..

```java
    @Transactional
    public Long deletePosts(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("게시물이 없습니다."));
        commentRepository.deleteAllByPost(post);
        postRepository.deleteById(postId);
        return postId;
    }

```

</details>
	
<details>
    <summary>
        <b>deleteAllByIdxIn 호출 시 entitymanager가 없는 문제 발생</b>
    </summary>

```java
javax.persistence.TransactionRequiredException: No EntityManager with actual transaction available for current thread - cannot reliably process 'remove' call

```

<br><b>해결 : @Transactional</b>
<br> 문제 발생 원인: deleteAllById함수 호출 시, EntityManager가 호출이 되는데 JPA Repository에 있는 기본적 함수들은 모두 @Transactional 어노테이션이 붙어있는 것과는 다르게
@Transactional이 붙어있는 deleteAllById라는 함수는 찾을 수가 없었다. -> 그렇다면 우리가 deleteAllById라는 함수를 호출 시 @Transactional 어노테이션을 반드시 붙여줘야만 EntityManager가 호출이 된다.


```java    
    @Transactional //이 어노테이션을 반드시 붙일 것
    public Long deletePosts(Long postId) {
    ...
        commentRepository.deleteAllByPost(post); //deleteAllByPost함수 호출
    ...
    }

```

</details>
	
<details>
    <summary>
        <b>localhost:8080/swagger-ui.html 405 Error 그런데 localhost:8080/swagger-resources는 문제가 없이 돌아감</b>
    </summary>
<br>문제 발생 원인 : URI 설정 시 root URI 다음에 바로 Path Variable로 받으면 swagger-ui의 GET POST 요청을 Block한다. -> swagger 자체의 버그? 문제로 예상됨
<br><b>해결 : /{postId} -> /api/{postId} 이런식으로 모두 수정</b>

```java
    @DeleteMapping("/api/{postId}")
    @PostMapping("/api/{postId}/comment")
    @DeleteMapping("/api/{postId}/{commentId}")
    // 총 3군데의 URI 수정 ps. 이 문제 진짜 아무리 쳐도 안나와요.. 해결하는데 10시간 걸렸어요.. 같은 문제로 해결하셨다면 STAR 기대합니다..☆
```

</details>

<details>
    <summary>
        <b>CORS문제 : front에서 HttpResponse 200으로 동작은 정상 작동하나, 서버에서 내려준 token값이 헤더에서 보이지 않는 문제 발생</b>
    </summary>
    <br>해결 : CORS 설정에서 addExposedHeader로 Authorization 값을 보이도록 설정해줌.
    
```java
public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        ... 생략
        configuration.addExposedHeader("Authorization");
        ... 생략
        return source;
    }

```

</details>
