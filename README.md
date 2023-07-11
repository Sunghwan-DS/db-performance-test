# DB 성능테스트
## 0. Oracle DB 연결
1. $ docker pull jaspeen/oracle-xe-11g
2. $ docker run --name springboot-oracle -d -p 9000:8080 -p 1521:1521 jaspeen/oracle-xe-11g
3. $ docker exec -it springboot-oracle bash
4. sqlplus / as sysdba (초기 계정 정보: user-name / oracle)
5. SQL> create user root identified by pass;
6. SQL> grant connect,resource,dba to root