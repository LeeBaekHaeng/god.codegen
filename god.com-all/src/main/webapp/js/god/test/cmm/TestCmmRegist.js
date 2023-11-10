function fn_listTestCmmRegist(_this) {
    location.href = _this.href;
    return false;
}

function fn_saveTestCmmRegist() {
    if (!searchKeyword.value) {
        alert('검색어은(는) 필수 입력값입니다.');
        return false;
    }
    return true;
}
