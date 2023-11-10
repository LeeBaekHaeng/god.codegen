function fn_listTestCmmDetail(_this) {
    location.href = _this.href;
    return false;
}

function fn_createTestCmmDetail(_this) {
    location.href = _this.href + '?searchKeyword=' + searchKeyword;
    return false;
}
