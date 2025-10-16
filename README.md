# java-calculator-precourse

---
mvc 패턴을 이용한 문자열 덧셈 계산기 만들기

> 사용자로부터 문자열을 입력받아 숫자를 추출하여 더하는 계산기

## 구현 기능 목록

---

### Main

- Application
    - [ ] calculatorController를 통해 계산기를 실행한다.

### Model

- NumberExtractor
  > 숫자 추출기 모델. 문자열로 부터 숫자를 추출한다.
    - [ ] 입력 값이 존재하는지 확인한다.
    - [ ] 커스텀 구분자를 확인한다.
        - [ ] `//`와 `\n`사이에 위치하는 문자를 커스텀 구분자로 확인한다.
    - [ ] 쉼표(,), 콜론(:), 커스텀 구분자를 기준으로 문자열을 분리한다.
    - [ ] 분리된 문자열이 양수인지 확인한다.
    - [ ] 잘못된 값이 있는 경우 `IllegalArgumentException`을 발생시킨 후 어플리케이션을 종료한다.
    - [ ] 최종 분리된 문자열을 반환한다.


- Calculator
  > 계산기 모델. 추출한 숫자들을 더한다.
    - [ ] 추출한 숫자를 배열로 받아 덧셈을 한다.

### View

- InputView
  > 사용자의 문자열을 입력하는 UI 역할을 담당한다.
    - [ ] StringInputView
        - [ ] `덧셈할 문자열을 입력해 주세요.` 문자열 출력한다.
        - [ ] 사용자로부터 문자열을 입력 받는다


- OutputView
  > 덧셈 계산기에서 계산 결과를 출력하는 UI 역할을 담당한다.
    - [ ] `결과 : ${결과 값}` 형식의 문자열 출력한다.

### Controller

- calculatorController
  > 덧셈 계산기의 전체적인 흐름을 제어한다.
    - [ ] `InputView`로 사용자의 입력을 받는다.
    - [ ] 계산기의 핵심 로직들을 모델을 통해 수행한다.
    - [ ] `OutputView`를 통해 계산 결과값을 출력한다.

---

## 커밋 컨벤션

커밋 단위는 위에서 정리한 구현할 기능 목록 단위로 진행된다.
[AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋 메시지를
작성한다.

```text
<type>(<scope>): <subject>
<BLANK LINE>
<body>
```

## <type> 유형 : 필수 사항

커밋의 유형 표시

- feat (feature) : 새로운 기능 추가
- fix (bug fix) : 버그 수정
- docs (documentation) : 문서 수정 (README 등)
- refactor : 코드 리팩토링 (기능 변화 없음)
- test (when adding missing tests) : 테스트 코드 추가/수정
- chore (maintain) : 빌드, 설정, 의존성, 배포 관련 등 유지보수 작업

## <scope> 범위 : 선택 사항

변경이 발생한 기능 또는 모듈의 범위를 표시

## <subject> 제목 : 필수 사항

한 줄로 간결하게 변경 요약을 작성

- 명령문 형태로 작성
- 끝에 마침표(.) 금지

## <body> 본문 : 선택 사항

변경의 이유, 배경, 추가 설명을 작성

- “무엇을, 왜” 했는지 자세히 설명
- 현재 시제로 작성
- 이전 동작과의 차이점 작성

## 커밋 예시

```text
docs(readme): 구현할 기능 목록 작성
```

```text
feat(model): Calculator 모델 기능 추가

계산기 모델 기능 추가:
- 추출한 문자를 배열로 받아 더하는 기능 추가
```
