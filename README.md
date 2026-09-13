# MealMates

# Dues

정기 모임의 회원과 월별 회비 납부 상태를 관리하는 토이 프로젝트입니다.

## 목적

Java / Spring / JPA / DB 학습 내용을 실제 프로젝트에 적용하는 것을 목표로 합니다.

추후 아래 내용을 단계적으로 적용할 예정입니다.

- JPA 연관관계 설계
- JPQL / QueryDSL
- 테스트 코드
- Docker
- Spring Security / JWT
- CI/CD
- 배포

## MVP

- 회원 등록 / 조회
- 모임 등록 / 조회
- 모임 회원 추가
- 월별 회비 생성
- 회비 납부 처리
- 미납자 조회

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Gradle

## Architecture

단일 모듈 기반의 간단한 Hexagonal Architecture를 사용합니다.

Controller
→ Inbound Port
→ Application Service
→ Outbound Port
→ Persistence Adapter
→ Spring Data JPA