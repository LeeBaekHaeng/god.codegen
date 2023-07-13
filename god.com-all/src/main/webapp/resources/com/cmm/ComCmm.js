function fn_comCmm_ajax(settings) {
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
        }).always(function(data, textStatus, jqXHR) {
            console.log('always complete');
            console.log('data', data);
            console.log('textStatus', textStatus);
            console.log('jqXHR', jqXHR);
        });
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
