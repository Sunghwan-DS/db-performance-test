# DB 성능테스트
## 0. Oracle DB 연결
1. $ docker pull jaspeen/oracle-xe-11g
2. $ docker run --name springboot-oracle -d -p 9000:8080 -p 1521:1521 jaspeen/oracle-xe-11g
3. $ docker exec -it springboot-oracle bash
4. sqlplus / as sysdba (초기 계정 정보: user-name / oracle)
5. SQL> create user root identified by pass;
6. SQL> grant connect,resource,dba to root

## [1. Oracle DB 복합키 조회 성능테스트](https://github.com/Sunghwan-DS/db-performance-test/commit/f9dc0c3c59f32ac950668e78cca1cbca83226d68)
> 테스트 조건: 100만 개의 데이터 중 중간 위치의 1만 개 데이터 조회

#### 결과
1. 3개의 parameter로 pk를 만들어 조회하는 경우 15884 ms
2. 3개의 parameter를 WHERE 절로 조회하는 경우 317651 ms
3. 3개의 parameter를 복합키로 저장한 테이블에서 WHERE 절로 조회하는 경우 16334 ms

1번 케이스와 3번 케이스의 경우 테스트 시도마다 대소 관계가 뒤바뀐다.
##### 결과적으로 번거롭게 parameter를 커스텀하여 pk를 만들 필요 없이 복합키로 데이터를 저장하여도 데이터를 조회하는 데에 성능 이슈를 발생시키지 않는다.