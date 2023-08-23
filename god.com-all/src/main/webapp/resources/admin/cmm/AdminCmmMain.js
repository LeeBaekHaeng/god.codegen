$(function() {

    fn_adminCmm_getCode();
    /*fn_adminCmm_getCode2();
    fn_adminCmm_getCode3();*/

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

            alert('요청처리가 성공적으로 수행되었습니다.');
        }).fail(function(jqXHR, textStatus, errorThrown) {
            console.log('jqXHR', jqXHR);
            console.log('textStatus', textStatus);
            console.log('errorThrown', errorThrown);

            $('#test').html(textStatus);

            //alert('에러가 발생했습니다!');
            alert('요청처리를 실패하였습니다.');
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

/**
 * Vue.js 코드 가져오기
 */
function fn_adminCmm_getCode3() {
    const { createApp } = Vue;

    createApp({

        data() {
            return {
                message: 'Hello Vue!',
                items: [],
                COM002: [],
                COM003: [],
                COM005: [],
            }
        },

        methods: {
            getCode() {
                var config = {};
                config.url = '/rest/com/cmm/v1/cmmcodedetail';

                config.method = 'get';

                config.params = {};
                config.params.codeId = 'COM001';

                var vm = this;

                fn_comCmm_axios(config)
                    .then(function(response) {
                        // 성공 핸들링
                        console.log(response);
                        vm.items = response.data;
                    })
                    .catch(function(error) {
                        // 에러 핸들링
                        console.log(error);
                        alert('에러가 발생했습니다!');
                    })
                    .finally(function() {
                        // 항상 실행되는 영역
                        console.log('항상 실행되는 영역');
                    });
            },

            async getCodeCOM002() {
                var config = {};
                config.url = '/rest/com/cmm/v1/cmmcodedetail';

                config.method = 'get';

                config.params = {};
                config.params.codeId = 'COM002';

                try {
                    const response = await fn_comCmm_axios(config);
                    console.log(response);
                    this.COM002 = response.data;
                } catch (error) {
                    console.error(error);
                }
            },

            async getCodeCOM003() {
                this.COM003 = await fn_comCmm_getCodes('COM003');
                this.COM005 = await fn_comCmm_getCodes('COM005');
            },

        },

        mounted() {
            this.getCode();
            this.getCodeCOM002();
            this.getCodeCOM003();
        },

    }).mount('#app');
}
