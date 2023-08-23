function fn_comCmm_ajax(settings) {
    $.blockUI();

    settings.async = false;

    settings.url = vr_comCmm_contextPath + settings.url;

    return $.ajax(settings)
        .done(function(data, textStatus, jqXHR) {
            console.log('done success');
            console.log('data', data);
            console.log('textStatus', textStatus);
            console.log('jqXHR', jqXHR);
        }).fail(function(jqXHR, textStatus, errorThrown) {
            console.log('fail error');
            console.log('jqXHR', jqXHR);
            console.log('textStatus', textStatus);
            console.log('errorThrown', errorThrown);
            alert('에러가 발생했습니다!');
            //alert('요청처리를 실패하였습니다.');
        }).always(function(data, textStatus, jqXHR) {
            console.log('always complete');
            console.log('data', data);
            console.log('textStatus', textStatus);
            console.log('jqXHR', jqXHR);

            $.unblockUI();
        });
}

function fn_comCmm_axios(config) {
    $.blockUI();

    axios.defaults.baseURL = vr_comCmm_contextPath;

    return axios(config).then(function(response) {
        // 성공 핸들링
        console.log(response);

        console.log(response.data);
        console.log(response.status);
        console.log(response.statusText);
        console.log(response.headers);
        console.log(response.config);

        return Promise.resolve(response);
    }).catch(function(error) {
        // 에러 핸들링
        console.log(error);

        return Promise.reject(error);
    }).finally(function() {
        // 항상 실행되는 영역
        console.log('항상 실행되는 영역');

        $.unblockUI();
    });
}

async function fn_comCmm_getCodes(codeId) {
    var config = {};
    config.url = '/rest/com/cmm/v1/cmmcodedetail';

    config.method = 'get';

    config.params = {};
    config.params.codeId = codeId;

    try {
        const response = await fn_comCmm_axios(config);
        console.log(response);
        return response.data;
    } catch (error) {
        console.error(error);
        return [];
    }
}
