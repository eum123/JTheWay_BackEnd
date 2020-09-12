/**
 *
 * @param {*} url 접속 URL
 * @param {*} data data
 * @param {*} successFunc 성공일때 호출할 함수 (data)
 * @param {*} failFunc 실패일때 호출할 함수 (request, status, error)
 */
function syncGet(url, data, successFunc, failFunc) {
    $.ajax({
        type: "GET",
        url: url,
        data: data,
        async: false,
        success: function(res) {
            if (res != null) {
                if (successFunc != null) {
                    successFunc(res);
                }
            }
        },
        error: function(req, status, error) {
            if (failFunc != null) failFunc(req, status, error);
        },
    });
}

/**
 *
 * @param {*} url 접속 URL
 * @param {*} data data
 * @param {*} successFunc 성공일때 호출할 함수 (data)
 * @param {*} failFunc 실패일때 호출할 함수 (request, status, error)
 */
function syncPost(url, data, successFunc, failFunc) {
    $.ajax({
        type: "POST",
        url: url,
        data: data,
        async: false,
        success: function(res) {
            if (res != null) {
                if (successFunc != null) {
                    successFunc(res);
                }
            }
        },
        error: function(req, status, error) {
            if (failFunc != null) failFunc(req, status, error);
        },
    });
}

function axios_example() {
    //axios 테스트
    axios
        .get(
            "https://raw.githubusercontent.com/joshua1988/doit-vuejs/master/data/demo.json"
        )
        .then(function(res) {
            //data.result.studentInfo = res.result;
            //test
            console.log(JSON.parse('{"name": "홍길동"}'));
            data.studentInfo = JSON.parse('{"name": "홍길동"}');
        })
        .catch(function(e) {
            console.error(e);
        });
}