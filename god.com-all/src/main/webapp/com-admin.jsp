<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공통컴포넌트 관리자</title>
</head>
<body>

    <ul>

        <li>포털(예제) 메인화면</li>
        <li>
            <ul>
                <li><a href="<c:url value="/sym/mnu/mpm/EgovMainMenuHome.do" />" target="_blank" style="text-decoration: line-through;">1. 포털(예제) 메인화면</a></li>
            </ul>
        </li>

        <li>사용자디렉토리/통합인증</li>
        <li>
            <ul>
                <li><a href="<c:url value="/uat/uia/egovLoginUsr.do" />" target="_blank">10. 로그인</a></li>
                <li><a href="<c:url value="/uat/uap/selectLoginPolicyList.do" />" target="_blank" style="text-decoration: line-through;">30. 로그인정책관리</a></li>
            </ul>
        </li>

        <li>보안</li>
        <li>
            <ul>
                <li><a href="<c:url value="/sec/ram/EgovAuthorList.do" />" target="_blank">60. 권한관리</a></li>
                <li><a href="<c:url value="/sec/rgm/EgovAuthorGroupList.do" />" target="_blank">70. 권한그룹관리</a></li>
                <li><a href="<c:url value="/sec/gmt/EgovGroupList.do" />" target="_blank">80. 그룹관리</a></li>
                <li><a href="<c:url value="/sec/rmt/EgovRoleList.do" />" target="_blank">90. 롤관리</a></li>
                <li><a href="<c:url value="/sec/drm/EgovDeptAuthorList.do" />" target="_blank">100. 부서권한관리</a></li>
                <li><a href="<c:url value="/qrmpm/qrmpmView.do" />" target="_blank">110. 모바일운전면허증</a></li>
            </ul>
        </li>

        <li>통계/리포팅</li>
        <li>
            <ul>
                <li><a href="<c:url value="/qrmpm/qrmpmView.do" />" target="_blank">120. 게시물통계</a></li>
                <li><a href="<c:url value="/sts/ust/selectUserStats.do" />" target="_blank">130. 사용자통계</a></li>
                <li><a href="<c:url value="/sts/cst/selectConectStats.do" />" target="_blank">140. 접속통계</a></li>
                <li><a href="<c:url value="/sts/sst/selectScrinStats.do" />" target="_blank">150. 화면통계</a></li>
                <li><a href="<c:url value="/sts/rst/selectReprtStatsListView.do" />" target="_blank">160. 보고서통계</a></li>
                <li><a href="<c:url value="/sts/dst/selectDtaUseStatsListView.do" />" target="_blank">161. 자료이용현황통계</a></li>
            </ul>
        </li>

        <li>협업</li>
        <li>
            <ul>
                <li><a href="<c:url value="/cop/bbs/selectBlogList.do" />" target="_blank" style="text-decoration: line-through;">170. 블로그관리</a></li>
                <li><a href="<c:url value="/cop/bbs/selectBBSMasterInfs.do" />" target="_blank">180. 게시판관리</a></li>
                <li><a href="<c:url value="/cop/tpl/selectTemplateInfs.do" />" target="_blank">200. 템플릿관리</a></li>
                <li><a href="<c:url value="/cop/scp/selectArticleScrapList.do" />" target="_blank" style="text-decoration: line-through;">250. 스크랩 목록</a></li>
                <li><a href="<c:url value="/cop/cmy/selectCommuMasterList.do" />" target="_blank" style="text-decoration: line-through;">270. 커뮤니티관리</a></li>
                <li><a href="<c:url value="/cop/sms/selectSmsList.do" />" target="_blank">310. 문자메시지</a></li>
                <li><a href="<c:url value="/cop/smt/sdm/EgovDeptSchdulManageList.do" />" target="_blank" style="text-decoration: line-through;">320. 부서일정관리</a></li>
                <li><a href="<c:url value="/cop/smt/sim/EgovIndvdlSchdulManageList.do" />" target="_blank" style="text-decoration: line-through;">330. 일정관리</a></li>
                <li><a href="<c:url value="/cop/smt/dsm/EgovDiaryManageList.do" />" target="_blank" style="text-decoration: line-through;">340. 일지관리</a></li>
                <li><a href="<c:url value="/cop/smt/sam/EgovAllSchdulManageList.do" />" target="_blank" style="text-decoration: line-through;">350. 전체일정관리</a></li>
                <li><a href="<c:url value="/cop/ems/insertSndngMailView.do" />" target="_blank">360. 메일발송</a></li>
                <li><a href="<c:url value="/cop/ems/selectSndngMailList.do" />" target="_blank">361. 발송메일내역</a></li>
                <li><a href="<c:url value="/cop/ncm/selectNcrdInfs.do" />" target="_blank" style="text-decoration: line-through;">370. 명함관리</a></li>
                <li><a href="<c:url value="/cop/ncm/selectMyNcrdUseInf.do" />" target="_blank" style="text-decoration: line-through;">371. 내명함목록</a></li>
                <li><a href="<c:url value="/cop/adb/selectAdbkList.do" />" target="_blank" style="text-decoration: line-through;">380. 주소록관리</a></li>
                <li><a href="<c:url value="/cop/smt/lsm/usr/selectLeaderSchdulList.do" />" target="_blank" style="text-decoration: line-through;">390. 간부일정관리</a></li>
                <li><a href="<c:url value="/cop/smt/djm/selectDeptJobBxList.do" />" target="_blank" style="text-decoration: line-through;">400. 부서업무함관리</a></li>
                <li><a href="<c:url value="/cop/smt/djm/selectDeptJobList.do" />" target="_blank" style="text-decoration: line-through;">401. 부서업무정보</a></li>
                <li><a href="<c:url value="/cop/smt/wmr/selectWikMnthngReprtList.do" />" target="_blank style="text-decoration:line-through;"">410. 주간/월간보고관리</a></li>
                <li><a href="<c:url value="/cop/smt/mtm/selectMemoTodoList.do" />" target="_blank" style="text-decoration: line-through;">420. 메모할일관리</a></li>
                <li><a href="<c:url value="/cop/smt/mrm/selectMemoReprtList.do" />" target="_blank" style="text-decoration: line-through;">430. 메모보고</a></li>
            </ul>
        </li>

        <li>사용자지원</li>
        <li>
            <ul>
                <li><a href="<c:url value="/uss/umt/EgovEntrprsMberManage.do" />" target="_blank">450. 기업회원관리</a></li>
                <li><a href="<c:url value="/uss/umt/EgovUserManage.do" />" target="_blank">460. 업무사용자관리</a></li>
                <li><a href="<c:url value="/uss/umt/dpt/selectDeptManageListView.do" />" target="_blank" style="text-decoration: line-through;">461. 부서관리</a></li>
                <li><a href="<c:url value="/uss/umt/EgovMberManage.do" />" target="_blank">470. 일반회원관리</a></li>
                <li><a href="<c:url value="/uss/mpe/selectIndvdlPgeList.do" />" target="_blank" style="text-decoration: line-through;">480. 마이페이지관리</a></li>
                <li><a href="<c:url value="/uss/sam/stp/StplatListInqire.do" />" target="_blank" style="text-decoration: line-through;">490. 약관관리</a></li>
                <li><a href="<c:url value="/uss/sam/cpy/CpyrhtPrtcPolicyListInqire.do" />" target="_blank" style="text-decoration: line-through;">500. 저작권보호정책</a></li>
                <li><a href="<c:url value="/uss/sam/ipm/listIndvdlInfoPolicy.do" />" target="_blank" style="text-decoration: line-through;">510. 개인정보보호정책확인</a></li>
                <li><a href="<c:url value="/uss/olh/hpc/selectHpcmList.do" />" target="_blank" style="text-decoration: line-through;">520. 도움말</a></li>
                <li><a href="<c:url value="/uss/olh/wor/selectWordDicaryList.do" />" target="_blank" style="text-decoration: line-through;">530. 용어사전</a></li>
                <li><a href="<c:url value="/uss/olh/faq/selectFaqList.do" />" target="_blank">540. FAQ관리</a></li>
                <li><a href="<c:url value="/uss/olh/qna/selectQnaList.do" />" target="_blank">550. Q&A관리</a></li>
                <li><a href="<c:url value="/uss/olh/qna/selectQnaAnswerList.do" />" target="_blank">551. Q&A답변관리</a></li>
                <li><a href="<c:url value="/uss/olh/awm/selectAdministrationWordList.do" />" target="_blank" style="text-decoration: line-through;">560. 행정전문용어사전</a></li>
                <li><a href="<c:url value="/uss/olh/awm/selectAdministrationWordManageList.do" />" target="_blank" style="text-decoration: line-through;">561. 행정전문용어사전관리</a></li>
                <li><a href="<c:url value="/uss/olh/omm/selectOnlineManualList.do" />" target="_blank">570. 온라인매뉴얼</a></li>
                <li><a href="<c:url value="/uss/olh/omn/selectOnlineManualList.do" />" target="_blank">571. 사용자온라인매뉴얼</a></li>
                <li><a href="<c:url value="/uss/olp/cns/CnsltListInqire.do" />" target="_blank">580. 상담관리</a></li>
                <li><a href="<c:url value="/uss/olp/cnm/CnsltAnswerListInqire.do" />" target="_blank">581. 상담답변관리</a></li>
                <li><a href="<c:url value="/uss/olp/qmc/EgovQustnrManageList.do" />" target="_blank" style="text-decoration: line-through;">590. 설문관리</a></li>
                <li><a href="<c:url value="/uss/olp/qnn/EgovQustnrRespondInfoManageList.do" />" target="_blank" style="text-decoration: line-through;">600. 설문조사</a></li>
                <li><a href="<c:url value="/uss/olp/qtm/EgovQustnrTmplatManageList.do" />" target="_blank" style="text-decoration: line-through;">610. 설문템플릿관리</a></li>
                <li><a href="<c:url value="/uss/olp/qrm/EgovQustnrRespondManageList.do" />" target="_blank" style="text-decoration: line-through;">620. 응답자관리</a></li>
                <li><a href="<c:url value="/uss/olp/qqm/EgovQustnrQestnManageList.do" />" target="_blank" style="text-decoration: line-through;">630. 질문관리</a></li>
                <li><a href="<c:url value="/uss/olp/qim/EgovQustnrItemManageList.do" />" target="_blank" style="text-decoration: line-through;">640. 항목관리</a></li>
                <li><a href="<c:url value="/uss/olp/mgt/EgovMeetingManageList.do" />" target="_blank" style="text-decoration: line-through;">650. 회의관리</a></li>
                <li><a href="<c:url value="/uss/olp/opm/listOnlinePollManage.do" />" target="_blank" style="text-decoration: line-through;">660. 온라인poll관리</a></li>
                <li><a href="<c:url value="/uss/olp/opp/listOnlinePollPartcptn.do" />" target="_blank" style="text-decoration: line-through;">661. 온라인poll참여</a></li>
                <li><a href="<c:url value="/uss/ion/nws/selectNewsList.do" />" target="_blank" style="text-decoration: line-through;">670. 뉴스관리</a></li>
                <li><a href="<c:url value="/uss/ion/sit/selectSiteList.do" />" target="_blank" style="text-decoration: line-through;">680. 사이트관리</a></li>
                <li><a href="<c:url value="/uss/ion/rec/selectRecomendSiteList.do" />" target="_blank" style="text-decoration: line-through;">700. 추천사이트관리</a></li>
                <li><a href="<c:url value="/uss/ion/ecc/selectEventCmpgnList.do" />" target="_blank" style="text-decoration: line-through;">710. 행사/이벤트/캠페인</a></li>
                <li><a href="<c:url value="/uss/ion/ecc/selectTnextrlHrList.do" />" target="_blank" style="text-decoration: line-through;">711. 외부인사정보</a></li>
                <li><a href="<c:url value="/uss/ion/pwm/listPopup.do" />" target="_blank">720. 팝업창관리</a></li>
                <li><a href="<c:url value="/uss/ion/noi/selectNotificationList.do" />" target="_blank">730. 정보알림이</a></li>
                <li><a href="<c:url value="/uss/ion/bnr/selectBannerList.do" />" target="_blank">740. 배너관리</a></li>
                <li><a href="<c:url value="/uss/ion/bnr/selectBannerMainList.do" />" target="_blank" style="text-decoration: line-through;">741. MYPAGE배너관리</a></li>
                <li><a href="<c:url value="/uss/ion/lsi/selectLoginScrinImageList.do" />" target="_blank" style="text-decoration: line-through;">750. 로그인화면이미지관리</a></li>
                <li><a href="<c:url value="/uss/ion/rsm/listRecentSrchwrd.do" />" target="_blank" style="text-decoration: line-through;">760. 최근검색어 조회</a></li>
                <li><a href="<c:url value="/uss/ion/msi/selectMainImageList.do" />" target="_blank" style="text-decoration: line-through;">770. 메인이미지관리</a></li>
                <li><a href="<c:url value="/uss/ion/msi/getMainImageResult.do" />" target="_blank" style="text-decoration: line-through;">771. 메인이미지 반영결과보기</a></li>
                <li><a href="<c:url value="/uss/ion/ulm/listUnityLink.do" />" target="_blank" style="text-decoration: line-through;">780. 통합링크관리</a></li>
                <li><a href="<c:url value="/uss/ion/uas/selectUserAbsnceListView.do" />" target="_blank" style="text-decoration: line-through;">790. 사용자부재관리</a></li>
                <li><a href="<c:url value="/uss/ion/isg/selectIntnetSvcGuidanceList.do" />" target="_blank" style="text-decoration: line-through;">800. 인터넷서비스안내및관리</a></li>
                <li><a href="<c:url value="/uss/ion/wik/bmk/listWikiBookmark.do" />" target="_blank" style="text-decoration: line-through;">810. Wiki기능</a></li>
                <li><a href="<c:url value="/uss/ion/rss/listRssTagManage.do" />" target="_blank" style="text-decoration: line-through;">820. RSS태그관리</a></li>
                <li><a href="<c:url value="/uss/ion/rsn/listRssTagService.do" />" target="_blank" style="text-decoration: line-through;">822. RSS태그서비스</a></li>
                <li><a href="<c:url value="/uss/ion/tir/selectTwitterMain.do" />" target="_blank" style="text-decoration: line-through;">830. Twitter연동</a></li>
                <li><a href="<c:url value="/uss/ion/fbk/facebook.do" />" target="_blank" style="text-decoration: line-through;">831. Facebook 연동</a></li>
                <li><a href="<c:url value="/uss/ion/ntm/registEgovNoteManage.do" />" target="_blank" style="text-decoration: line-through;">840. 쪽지관리</a></li>
                <li><a href="<c:url value="/uss/ion/ntr/listNoteRecptn.do" />" target="_blank" style="text-decoration: line-through;">850. 받은쪽지함관리</a></li>
                <li><a href="<c:url value="/uss/ion/nts/listNoteTrnsmit.do" />" target="_blank" style="text-decoration: line-through;">860. 보낸쪽지함관리</a></li>
                <li><a href="<c:url value="/uss/ion/mtg/selectMtgPlaceManageList.do" />" target="_blank" style="text-decoration: line-through;">870. 회의실관리</a></li>
                <li><a href="<c:url value="/uss/ion/mtg/selectMtgPlaceResveManageList.do" />" target="_blank" style="text-decoration: line-through;">871. 회의실예약관리</a></li>
                <li><a href="<c:url value="/uss/ion/ctn/selectCtsnnManageList.do" />" target="_blank" style="text-decoration: line-through;">890. 직원경조사관리</a></li>
                <li><a href="<c:url value="/uss/ion/ctn/EgovCtsnnConfmList.do" />" target="_blank" style="text-decoration: line-through;">891. 직원경조사승인관리</a></li>
                <li><a href="<c:url value="/uss/ion/vct/EgovVcatnManageList.do" />" target="_blank" style="text-decoration: line-through;">900. 휴가관리</a></li>
                <li><a href="<c:url value="/uss/ion/vct/EgovVcatnConfmList.do" />" target="_blank" style="text-decoration: line-through;">901. 휴가승인관리</a></li>
                <li><a href="<c:url value="/uss/ion/yrc/EgovIndvdlYrycManageList.do" />" target="_blank" style="text-decoration: line-through;">902. 개인연차관리</a></li>
                <li><a href="<c:url value="/uss/ion/bnt/EgovBndtManageList.do" />" target="_blank" style="text-decoration: line-through;">910. 당직관리</a></li>
                <li><a href="<c:url value="/uss/ion/bnt/EgovBndtCeckManageList.do" />" target="_blank" style="text-decoration: line-through;">911. 당직체크관리</a></li>
                <li><a href="<c:url value="/uss/ion/rwd/selectRwardManageList.do" />" target="_blank" style="text-decoration: line-through;">920. 포상관리</a></li>
                <li><a href="<c:url value="/uss/ion/rwd/EgovRwardConfmList.do" />" target="_blank" style="text-decoration: line-through;">921. 포상승인관리</a></li>
                <li><a href="<c:url value="/uss/ion/ans/selectAnnvrsryManageList.do" />" target="_blank" style="text-decoration: line-through;">930. 기념일관리</a></li>
                <li><a href="<c:url value="/uss/ion/ans/selectAnnvrsryMainList.do" />" target="_blank" style="text-decoration: line-through;">931. 기념일목록(확인용)</a></li>
                <li><a href="<c:url value="/uss/ion/evt/EgovEventReqstManageList.do" />" target="_blank" style="text-decoration: line-through;">940. 행사신청관리</a></li>
                <li><a href="<c:url value="/uss/ion/evt/EgovEventRcrptManageList.do" />" target="_blank" style="text-decoration: line-through;">941. 행사접수관리</a></li>
                <li><a href="<c:url value="/uss/ion/evt/selectEventRceptConfmList.do" />" target="_blank" style="text-decoration: line-through;">942. 행사접수승인관리</a></li>
                <li><a href="<c:url value="/com/uss/ion/rmm/selectRoughMapList.do" />" target="_blank" style="text-decoration: line-through;">943. 약도 관리</a></li>
                <li><a href="<c:url value="/uss/cmt/EgovCmtManageList.do" />" target="_blank" style="text-decoration: line-through;">950. 출퇴근관리</a></li>
            </ul>
        </li>

        <li>시스템관리</li>
        <li>
            <ul>
                <li><a href="<c:url value="/sym/ccm/ccc/SelectCcmCmmnClCodeList.do" />" target="_blank">960. 공통분류코드</a></li>
                <li><a href="<c:url value="/sym/ccm/cde/SelectCcmCmmnDetailCodeList.do" />" target="_blank">970. 공통상세코드</a></li>
                <li><a href="<c:url value="/sym/ccm/cca/SelectCcmCmmnCodeList.do" />" target="_blank">980. 공통코드</a></li>
                <li><a href="<c:url value="/sym/ccm/zip/EgovCcmZipList.do" />" target="_blank" style="text-decoration: line-through;">1000. 우편번호관리</a></li>
                <li><a href="<c:url value="/sym/ccm/adc/EgovCcmAdministCodeList.do" />" target="_blank" style="text-decoration: line-through;">1010. 행정코드관리</a></li>
                <li><a href="<c:url value="/sym/ccm/icr/getInsttCodeRecptnList.do" />" target="_blank" style="text-decoration: line-through;">1020. 기관코드수신</a></li>
                <li><a href="<c:url value="/sym/log/lgm/SelectSysLogList.do" />" target="_blank">1030. 로그관리</a></li>
                <li><a href="<c:url value="/sym/log/ulg/SelectUserLogList.do" />" target="_blank">1040. 사용로그관리</a></li>
                <li><a href="<c:url value="/sym/log/tlg/SelectTrsmrcvLogList.do" />" target="_blank">1050. 송/수신로그관리</a></li>
                <li><a href="<c:url value="/sym/log/slg/SelectSysHistoryList.do" />" target="_blank">1060. 시스템이력관리</a></li>
                <li><a href="<c:url value="/sym/log/wlg/SelectWebLogList.do" />" target="_blank">1070. 웹로그관리</a></li>
                <li><a href="<c:url value="/sym/log/clg/SelectLoginLogList.do" />" target="_blank">1080. 접속로그관리</a></li>
                <li><a href="<c:url value="/sym/log/plg/SelectPrivacyLogList.do" />" target="_blank">1085. 개인정보조회로그관리</a></li>
                <li><a href="<c:url value="/sym/mnu/mpm/EgovMenuListSelect.do" />" target="_blank">1090. 메뉴리스트관리</a></li>
                <li><a href="<c:url value="/sym/mnu/mpm/EgovMenuManageSelect.do" />" target="_blank">1091. 메뉴관리리스트</a></li>
                <li><a href="<c:url value="/sym/mnu/mcm/EgovMenuCreatManageSelect.do" />" target="_blank">1100. 메뉴생성관리</a></li>
                <li><a href="<c:url value="/sym/mnu/stm/EgovSiteMapng.do" />" target="_blank">1101. 사이트맵</a></li>
                <li><a href="<c:url value="/sym/mnu/bmm/selectBkmkMenuManageList.do" />" target="_blank">1110. 바로가기메뉴관리</a></li>
                <li><a href="<c:url value="/sym/prm/EgovProgramListManageSelect.do" />" target="_blank">1111. 프로그램관리</a></li>
                <li><a href="<c:url value="/sym/prm/EgovProgramChangeRequstSelect.do" />" target="_blank">1112. 프로그램변경요청관리</a></li>
                <li><a href="<c:url value="/sym/prm/EgovProgramChangeRequstProcessListSelect.do" />" target="_blank">1113. 프로그램변경요청처리</a></li>
                <li><a href="<c:url value="/sym/prm/EgovProgramChgHstListSelect.do" />" target="_blank">1114. 프로그램변경이력</a></li>
                <li><a href="<c:url value="/sym/bat/getBatchOpertList.do" />" target="_blank" style="text-decoration: line-through;">1120. 배치작업관리</a></li>
                <li><a href="<c:url value="/sym/bat/getBatchResultList.do" />" target="_blank" style="text-decoration: line-through;">1130. 배치결과관리</a></li>
                <li><a href="<c:url value="/sym/bat/getBatchSchdulList.do" />" target="_blank" style="text-decoration: line-through;">1140. 스케줄처리</a></li>
                <li><a href="<c:url value="/sym/sym/bak/getBackupOpertList.do" />" target="_blank" style="text-decoration: line-through;">1150. 백업관리</a></li>
                <li><a href="<c:url value="/sym/sym/bak/getBackupResultList.do" />" target="_blank" style="text-decoration: line-through;">1151. 백업결과관리</a></li>
                <li><a href="<c:url value="/sym/sym/nwk/selectNtwrkList.do" />" target="_blank" style="text-decoration: line-through;">1160. 네트워크관리</a></li>
                <li><a href="<c:url value="/sym/sym/srv/selectServerEqpmnList.do" />" target="_blank" style="text-decoration: line-through;">1170. 서버정보관리</a></li>
                <li><a href="<c:url value="/sym/sym/srv/selectServerList.do" />" target="_blank" style="text-decoration: line-through;">1171. 서버(S/W)목록</a></li>
                <li><a href="<c:url value="/sym/tbm/tbr/selectTroblReqstList.do" />" target="_blank">1180. 장애신청관리</a></li>
                <li><a href="<c:url value="/sym/tbm/tbp/selectTroblProcessList.do" />" target="_blank">1190. 장애처리결과관리</a></li>
            </ul>
        </li>

        <li>시스템/서비스연계</li>
        <li>
            <ul>
                <li><a href="<c:url value="/ssi/syi/sim/getSystemCntcList.do" />" target="_blank">1210. 시스템연계관리</a></li>
                <li><a href="<c:url value="/ssi/syi/ist/getCntcSttusList.do" />" target="_blank">1220. 연계현황관리</a></li>
                <li><a href="<c:url value="/ssi/syi/ims/getCntcMessageList.do" />" target="_blank">1230. 연계메시지관리</a></li>
                <li><a href="<c:url value="/ssi/syi/iis/getCntcInsttList.do" />" target="_blank">1240. 연계기관관리</a></li>
            </ul>
        </li>

        <li>디지털 자산 관리</li>
        <li>
            <ul>
                <li><a href="<c:url value="/dam/per/EgovComDamPersonalList.do" />" target="_blank" style="text-decoration: line-through;">1250. 개인지식관리</a></li>
                <li><a href="<c:url value="/dam/map/mat/EgovComDamMapMaterialList.do" />" target="_blank" style="text-decoration: line-through;">1260. 지식맵관리(유형)</a></li>
                <li><a href="<c:url value="/dam/map/tea/EgovComDamMapTeamList.do" />" target="_blank" style="text-decoration: line-through;">1261. 지식맵관리(조직)</a></li>
                <li><a href="<c:url value="/dam/spe/spe/EgovComDamSpecialistList.do" />" target="_blank" style="text-decoration: line-through;">1270. 지식전문가관리</a></li>
                <li><a href="<c:url value="/dam/mgm/EgovComDamManagementList.do" />" target="_blank" style="text-decoration: line-through;">1280. 지식정보관리</a></li>
                <li><a href="<c:url value="/dam/app/EgovComDamAppraisalList.do" />" target="_blank" style="text-decoration: line-through;">1290. 지식평가관리</a></li>
                <li><a href="<c:url value="/dam/spe/req/listRequestOffer.do" />" target="_blank" style="text-decoration: line-through;">1291. 지식정보제공</a></li>
            </ul>
        </li>

        <li>요소기술</li>
        <li>
            <ul>
                <li><a href="<c:url value="/sym/cal/EgovRestdeList.do" />" target="_blank">1300. 공휴일관리(달력)</a></li>
                <li><a href="<c:url value="/utl/sys/trm/getTrsmrcvMntrngList.do" />" target="_blank">2080. 송수신모니터링</a></li>
                <li><a href="<c:url value="/utl/sys/dbm/getDbMntrngList.do" />" target="_blank" style="text-decoration: line-through;">2090. DB서비스모니터링</a></li>
                <li><a href="<c:url value="/utl/sys/htm/EgovComUtlHttpMonList.do" />" target="_blank" style="text-decoration: line-through;">2100. HTTP서비스모니터링</a></li>
                <li><a href="<c:url value="/utl/sys/prm/EgovComUtlProcessMonList.do" />" target="_blank" style="text-decoration: line-through;">2110. 프로세스모니터링</a></li>
                <li><a href="<c:url value="/utl/sys/nsm/selectNtwrkSvcMntrngList.do" />" target="_blank" style="text-decoration: line-through;">2120. 네트워크서비스모니터링</a></li>
                <li><a href="<c:url value="/utl/sys/fsm/selectFileSysMntrngList.do" />" target="_blank" style="text-decoration: line-through;">2130. 파일시스템모니터링</a></li>
                <li><a href="<c:url value="/utl/sys/pxy/selectProxySvcList.do" />" target="_blank" style="text-decoration: line-through;">2140. 프록시서비스</a></li>
                <li><a href="<c:url value="/utl/sys/ssy/selectSynchrnServerList.do" />" target="_blank" style="text-decoration: line-through;">2150. 파일동기화(대상서버)</a></li>
                <li><a href="<c:url value="/utl/sys/rsc/loginSessionView.do" />" target="_blank" style="text-decoration: line-through;">2160. 로그인세션정보체크</a></li>
                <li><a href="<c:url value="/utl/sys/srm/selectMntrngServerList.do" />" target="_blank" style="text-decoration: line-through;">2170. 서버자원모니터링-대상목록</a></li>
                <li><a href="<c:url value="/sym/adr/getAdressCntcInitPage.do" />" target="_blank" style="text-decoration: line-through;">2180. 주소정보연계</a></li>
                <li><a href="<c:url value="/sec/pki/EgovCryptoInfo.do" />" target="_blank" style="text-decoration: line-through;">2200. 암호화/복호화</a></li>
            </ul>
        </li>

        <li>외부 추가 컴포넌트</li>
        <li>
            <ul>
                <li><a href="<c:url value="/ext/ldapumt/dpt/selectDeptManageTreeView.do" />" target="_blank" style="text-decoration: line-through;">3100. LDAP 조직도 트리</a></li>
                <li><a href="<c:url value="/ext/ldapumt/dpt/selectDeptManageOrgChartView.do" />" target="_blank" style="text-decoration: line-through;">3110. LDAP 조직도 그래프</a></li>
                <li><a href="<c:url value="/cop/msg/websocketMessengerView.do" />" target="_blank" style="text-decoration: line-through;">3200. 웹소켓 메신저</a></li>
            </ul>
        </li>

    </ul>

</body>
</html>