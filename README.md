### 성명

박신형

### 애플리케이션의 실행 방법 (엔드포인트 호출 방법 포함)

- 회원가입
  `
  :POST localhost:8080/auth/signup
  `
- 로그인
`
:POST localhost:8080/auth/signin
`

### 데이터베이스 테이블 구조
| Name     | Type | Description | Nullable | Note |
|----------| --- |-----------|----------| --- |
| id       | string | ID        | N        |  |
| email    | string | 계정 이메일    | N        |  |
| password | string | 계정 비밀번호   | N        |  |

## API 명세
### 회원가입
#### - Request Parameters
| Name     | Type | Description | Nullable | Note |
|----------| --- |-----------|----------| --- |
| email    | string | 계정 이메일    | N        |  |
| password | string | 계정 비밀번호   | N        |  |

#### - Response Parameters

- **200 OK**

| Name | Type | Description |
| --- | --- |-------------|
| id | string | id          |
| email | string | 계정 이메일      |

```json
{
  "token": null,
  "id": "40285be889feb4360189feb789270000",
  "email": "hello7@world.com",
  "password": null
}
```

- **400 Bad Request**

| Name | Type | Description |
| --- | --- | --- |
| error | string | 에러 메세지
- “Invalid argument” //이메일을 입력하지 않은 경우
- “The User already exists” //이미 DB에 있는 이메일을 입력했을 경우
- “Invalid Password Value.” //비밀번호를 입력하지 않은 경우
```json
{
    "error": "Invalid argument",
    "data": null
}
```

```json
{
    "error": "The User already exists",
    "data": null
}
```

```json
{
    "error": "Invalid Password value.",
    "data": null
}
```
### 로그인
#### - Request Parameters

| Name     | Type | Description | Mandatory | Note |
|----------| ---- | --- | --- | --- |
| email    | string | 계정 이메일 | Y |  |
| password | string | 계정 비밀번호 | Y | |

####- Response Parameters

- **200 OK**

| Name | Type | Description   |
| ---- | --- |---------------|
| token | string | access token  |
| id | string | id            |
| email | string | 계정 이메일        |

```json
{
  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI0MDI4NWJlODg5ZmViNDM2MDE4OWZlYjc4OTI3MDAwMCIsImlzcyI6ImJvYXJkIGFwcCIsImlhdCI6MTY5MjE5NTczOSwiZXhwIjoxNjkyMjM4OTM5fQ.rkzaos_HPID1pO00lG4G4s24-n4fWH2eOEEMm8MVMMsLVr44Emo7Va_A55oMkd0DMNwuV41EjydKhcoWFuoRIw",
  "id": "40285be889feb4360189feb789270000",
  "email": "hello7@world.com",
  "password": null
}
```

- **400 Bad Request**

| Name | Type | Description                          |
| --- | --- |--------------------------------------|
| error | string | “Login failed” //비밀번호 또는 이메일이 틀렸을 경우 |

```json
{
    "error": "Login failed.",
    "data": null
}
```
