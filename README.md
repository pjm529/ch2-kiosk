# 스파르타 내임배움캠프 키오스크 프로젝트

---

## 차례

[과제 내용](#과제-내용)

[주요 기능](#주요-기능)

[디렉토리 구조](#디렉토리-구조)

---

## 사용언어
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

## 개발환경
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
![Badge](http://img.shields.io/badge/-Github-%23181717?style=for-the-badge&logo=GitHub&logoColor=white)

---

## 📋과제 내용
### 필수 Lv1.
- **햄버거 메뉴 출력 및 선택**
    - 실행시 햄버거 메뉴가 표시되고, 이후 Scanner로 숫자를 입력받아서 메뉴를 선택 가능
    - 제시된 메뉴 중 입력받은 숫자에 따라 다른 로직을 실행하는 코드를 작성
    - 반복문을 이용해서 특정 번호가 입력되면 프로그램을 종료


### 필수 Lv2.
- **`MenuItem` 클래스 생성**
    - 설명 : 개별 음식 항목을 관리하는 클래스. 현재는 햄버거만 관리
    - 클래스는 `이름`, `가격`, `설명` 필드로 구성


- **`main` 함수에서 `MenuItem` 클래스를 활용하여 햄버거 메뉴를 출력**
    - `MenuItem` 객체 생성을 통해 `이름`, `가격`, `설명을` 세팅
        - 키워드: `new`
    - `List`를 선언하여 여러 `MenuItem`을 추가
        - `List<MenuItem> menuItems = new ArrayList<>();`
    - 반복문을 활용해 `menuItems`를 탐색하면서 하나씩 접근


### 필수 Lv3.
- **`Kiosk` 클래스 생성**
    - **설명**: 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스
    - `MenuItem`을 관리하는 리스트가 필드로 존재
    - `main` 함수에서 관리하던 입력과 반복문 로직은 이제 `start` 함수를 만들어 관리
    - `List<MenuItem> menuItems` 는 `Kiosk` 클래스 생성자를 통해 값을 할당
        - `Kiosk` 객체를 생성하고 사용하는 `main` 함수에서 객체를 생성할 때 값을 넘겨줌


- **요구사항에 부합하는지 검토**
    - 키오스크 프로그램을 시작하는 메서드가 구현
        - 콘솔에 햄버거 메뉴를 출력
        - 사용자의 입력을 받아 메뉴를 선택하거나 프로그램을 종료
        - 유효하지 않은 입력에 대해 오류 메시지를 출력
        - `0`을 입력하면 프로그램이 ‘뒤로가기’되거나 ‘종료’


### 필수 Lv4.
- **`Menu` 클래스 생성**
    - 설명 : MenuItem 클래스를 관리하는 클래스
    - 예를 들어, 버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 `MenuItem`을 포함
    - `List<MenuItem>` 은 `Kiosk` 클래스가 관리하기에 적절하지 않으므로 Menu 클래스가 관리하도록 변경
    - 여러 버거들을 포함하는 상위 개념 ‘버거’ 같은 `카테고리 이름` 필드 구성
    - 메뉴 카테고리 이름을 반환하는 메서드가 구현


### 필수 Lv5.
- **`MenuItem`, `Menu` 그리고 `Kiosk` 클래스의 필드에 직접 접근하지 못하도록 설정**
- **Getter와 Setter 메서드를 사용해 데이터를 관리**


### 도전 Lv1.
- **장바구니 생성 및 관리 기능**
    - 사용자가 선택한 메뉴를 장바구니에 추가할 수 있는 기능을 제공
    - 장바구니는 메뉴명, 수량, 가격 정보를 저장하며, 항목을 동적으로 추가 및 조회
    - 사용자가 잘못된 선택을 했을 경우 예외를 처리(예: 유효하지 않은 메뉴 번호 입력)


- **장바구니 출력 및 금액 계산**
    - 사용자가 결제를 시도하기 전에, 장바구니에 담긴 모든 메뉴와 총 금액을 출력
    - 출력 예시
        - 각 메뉴의 이름, 가격, 수량
        - 총 금액 합계


- **장바구니 담기 기능**
    - 메뉴를 클릭하면 장바구니에 추가할 지 물어보고, 입력값에 따라 “추가”, “취소” 처리
        - 메뉴는 한 번에 1개만 담을 수 있음
    - 장바구니에 담은 목록을 출력


- **주문 기능**
    - 장바구니에 담긴 모든 항목을 출력
    - 합산하여 총 금액을 계산하고, “주문하기”를 누르면 장바구니를 초기화


### 도전 Lv2.
- **Enum을 활용한 사용자 유형별 할인율 관리**
    - 사용자 유형의 Enum 정의 및 각 사용자 유형에 따른 할인율 적용
        - 예시 : 군인, 학생, 일반인
    - 주문 시, 사용자 유형에 맞는 할인율 적용해 총 금액 계산


- **람다 & 스트림을 활용한 장바구니 조회 기능**
    - 기존에 생성한 Menu의 MenuItem을 조회 할 때 스트림을 사용하여 출력하도록 수정
    - 기존 장바구니에서 특정 메뉴 빼기 기능을 통한 스트림 활용
        - 예시 : 장바구니에 SmokeShack 가 들어 있다면, stream.filter를 활용하여 특정 메뉴 이름을 가진 메뉴 장바구니에서 제거


---

## 📌주요 기능

1️⃣ **햄버거 키오스크 메뉴 출력 및 선택**
- 콘솔에 햄버거 메뉴 리스트를 출력
- `Scanner`를 사용하여 사용자 입력을 받아 메뉴 선택
- 특정 번호(`0`) 입력 시 프로그램 종료

2️⃣ **객체 지향 설계를 활용한 메뉴 관리**
- `MenuItem` 클래스를 활용하여 메뉴 데이터를 구조적으로 관리
- `List<MenuItem>`을 사용하여 여러 개의 메뉴 항목 저장 및 출력

3️⃣ **키오스크 프로그램의 흐름 관리**
- `Kiosk` 클래스를 도입하여 전체 프로그램 흐름 관리
- `start()` 메서드로 메뉴 출력, 사용자 입력 처리, 종료 기능 구현

4️⃣ **카테고리별 메뉴 분류 및 출력**
- `Menu` 클래스를 활용하여 `Burgers`, `Drinks`, `Desserts` 등 메뉴 카테고리 관리
- 사용자가 메인 메뉴에서 카테고리 선택 후 세부 메뉴 출력

5️⃣ **캡슐화 적용**
- `MenuItem`, `Menu`, `Kiosk` 클래스의 필드에 직접 접근하지 못하도록 `private` 설정
- `getter` 및 `setter` 메서드를 활용하여 데이터 관리

6️⃣ **장바구니 및 구매하기 기능**
- 사용자가 선택한 메뉴를 장바구니에 추가할 수 있음
- 장바구니는 메뉴명, 수량, 가격 정보를 저장하며, 항목을 동적으로 추가 및 조회 가능
- 사용자가 결제를 시도하기 전에, 장바구니에 담긴 모든 메뉴와 총 금액을 출력
- 주문 시 장바구니 초기화

7️⃣ **Enum, 람다 & 스트림을 활용한 주문 및 장바구니 관리**
- 사용자 유형별 할인율을 적용하는 Enum 도입
- `stream.filter`를 활용하여 장바구니에서 특정 메뉴 제거 가능
- 스트림을 사용하여 메뉴 조회 및 출력 기능 최적화


---

## 📂디렉토리 구조
``` plaintext
src/com/exmaple/kiosk/
├── challenge/
│   ├── lv1/
│   │   ├── InputHandler.java
│   │   ├── Kiosk.java
│   │   ├── Main.java
│   │   ├── Menu.java
│   │   ├── MenuItem.java
│   │   └── Order.java
│   └── lv2/
│       ├── DiscountType.java
│       ├── InputHandler.java
│       ├── Kiosk.java
│       ├── Main.java
│       ├── Menu.java
│       ├── MenuItem.java
│       └── Order.java
└── required
    ├── lv1
    │   └── Main.java
    ├── lv2
    │   ├── Main.java
    │   └── MenuItem.java
    ├── lv3
    │   ├── Kiosk.java
    │   ├── Main.java
    │   └── MenuItem.java
    ├── lv4
    │   ├── Kiosk.java
    │   ├── Main.java
    │   ├── Menu.java
    │   └── MenuItem.java
    └── lv5/
        ├── InputHandler.java
        ├── Kiosk.java
        ├── Main.java
        ├── Menu.java
        └── MenuItem.java
```

### 블로그 : [https://pjm529.tistory.com/](https://pjm529.tistory.com/)