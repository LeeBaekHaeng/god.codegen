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
