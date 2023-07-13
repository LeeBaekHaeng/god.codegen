function fn_comCmm_ajaxGet(url, settings) {
    if (settings === undefined) {
        settings = {};
    }

    var jqXHR = $.ajax({
        method: 'GET',
        url: vr_comCmm_contextPath + url,
        dataType: 'json',
        data: settings.data,
        success: settings.success,
        error: settings.error,
    });

    jqXHR.done(function(data, textStatus, jqXHR) {
        console.log('done');
        console.log('data', data);
        console.log('textStatus', textStatus);
        console.log('jqXHR', jqXHR);
    });

    jqXHR.fail(function(jqXHR, textStatus, errorThrown) {
        console.log('fail');
        console.log('jqXHR', jqXHR);
        console.log('textStatus', textStatus);
        console.log('errorThrown', errorThrown);
    });

    jqXHR.always(function(data, textStatus, jqXHR) {
        console.log('always');
        console.log('data', data);
        console.log('textStatus', textStatus);
        console.log('jqXHR', jqXHR);
    });

    return jqXHR;
}

function fn_comCmm_axios(config) {
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
    });;
}
