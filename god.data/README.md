# 공공데이터포털

## [개발가이드] 공유서비스 개발 가이드라인

공유서비스 개발 가이드라인을 게시하오니, 참고하시기 바랍니다. (공유서비스 인터페이스 표준, 서비스 인터페이스 명세 표준, 서비스 검색 표준, 서비스 관리 및 품질 표준)

공유서비스_개발가이드라인.hwp

https://www.data.go.kr/bbs/rcr/selectRecsroom.do?pageIndex=1&originId=PDS_0000000000000124&atchFileId=FILE_000000002244460&searchCondition3=&searchCondition2=2&cndCtgryLaword=Y&cndCtgryEdc=Y&cndCtgryBigdata=Y&cndCtgryStd=Y&cndCtgryNews=Y&cndCtgryContest=&cndCtgryEtc=Y&cndCtgryCardNews=&bindCndCtgry=PDTY01%2CPDTY02%2CPDTY03%2CPDTY04%2CPDTY05%2CPDTY06&sort-post=2&searchKeyword1=%EA%B0%9C%EB%B0%9C%EA%B0%80%EC%9D%B4%EB%93%9C&Laword=PDTY01&Edc=PDTY02&Bigdata=PDTY03&Std=PDTY04&News=PDTY05&Etc=PDTY06

## 로컬 테스트

http://localhost:8080/data/api/v1/data/aaa/COM001/REGC01

http://localhost:8080/data/api/v1/data/aaa/COM001/REGC01?comMsgHeader.serviceKey=serviceKeytest이백행

http://localhost:8080/data/api/v1/data/aaa/COM001/REGC01?msgHeader.header=headertest이백행

http://localhost:8080/data/api/v1/data/aaa/COM001/REGC01?msgBody.codeId=COM001&msgBody.code=REGC01

http://localhost:8080/data/api/v1/data/aaa/COM001/REGC01?comMsgHeader.serviceKey=serviceKeytest이백행&msgHeader.header=headertest이백행&msgBody.codeId=COM001&msgBody.code=REGC01

http://localhost:8080/data/api/v1/data/baa/COM001/REGC01?comMsgHeader.serviceKey=serviceKeytest이백행&msgHeader.header=headertest이백행&msgBody.codeId=COM001&msgBody.code=REGC01
