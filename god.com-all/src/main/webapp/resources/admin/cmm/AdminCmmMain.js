$(function() {

    fn_adminCmm_getCode();
    fn_adminCmm_getCode2();

});

/**
 * jquery 코드 가져오기
 */
function fn_adminCmm_getCode() {
    var settings = {};
    settings.url = '/rest/com/cmm/v1/cmmcodedetail';

    settings.method = 'GET';

    settings.data = {};
    settings.data.codeId = 'COM001';

    fn_comCmm_ajax(settings)
        .done(function(data, textStatus, jqXHR) {
            console.log('data', data);
            console.log('textStatus', textStatus);
            console.log('jqXHR', jqXHR);

            $('#test').html(JSON.stringify(data));
        }).fail(function(jqXHR, textStatus, errorThrown) {
            console.log('jqXHR', jqXHR);
            console.log('textStatus', textStatus);
            console.log('errorThrown', errorThrown);

            $('#test').html(textStatus);
        }).always(function(data, textStatus, jqXHR) {
            console.log('always complete');
            console.log('data', data);
            console.log('textStatus', textStatus);
            console.log('jqXHR', jqXHR);
        });;

}

/**
 * axios 코드 가져오기
 */
function fn_adminCmm_getCode2() {
    var config = {};
    config.url = '/rest/com/cmm/v1/cmmcodedetail';

    config.method = 'get';

    config.params = {};
    config.params.codeId = 'COM001';

    fn_comCmm_axios(config)
        .then(function(response) {
            // 성공 핸들링
            console.log(response);
            $('#test2').html(JSON.stringify(response.data));
        })
        .catch(function(error) {
            // 에러 핸들링
            console.log(error);
            $('#test2').html(error.toJSON());
        })
        .finally(function() {
            // 항상 실행되는 영역
            console.log('항상 실행되는 영역');
        });
}
