function fn_searchTestCmmList() {
    if (!searchKeyword.value) {
        alert('검색어은(는) 필수 입력값입니다.');
        return false;
    }
    searchUseYn.value = 'Y';
    return true;
}

function fn_listTestCmmList(_this) {
    location.href = _this.href + '?searchUseYn=N';
    return false;
}

function fn_detailTestCmmList(_this) {
    location.href = _this.href + '?searchKeyword=' + searchKeyword.value;
    return false;
}
