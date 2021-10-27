const URL = "http://localhost:8080"; //서버 접속 URL 
const LIST_COUNT = 10; //표시한 리스트 건수
const PAGENUMBER_COUNT = 10; //표시한 페이지 건수

/**
 *
 * @param {*} url 접속 URL
 * @param {*} param param
 * @param {*} successFunc 성공일때 호출할 함수 (data)
 * @param {*} failFunc 실패일때 호출할 함수 (request, status, error)
 */
function get(url, param, successFunc, failFunc) {
    this.call("GET", url, param, successFunc, failFunc);
}
/**
 *
 * @param {*} url 접속 URL
 * @param {*} param param
 * @param {*} successFunc 성공일때 호출할 함수 (data)
 * @param {*} failFunc 실패일때 호출할 함수 (request, status, error)
 */
function post(url, param, successFunc, failFunc) {
    this.call("POST", url, param, successFunc, failFunc);
}

/**
 *
 * @param {*} url 접속 URL
 * @param {*} param param
 * @param {*} successFunc 성공일때 호출할 함수 (data)
 * @param {*} failFunc 실패일때 호출할 함수 (request, status, error)
 */
function postJson(url, param, successFunc, failFunc) {
    this.callJson("POST", url, param, successFunc, failFunc);
}

function callJson(httpMethod, url, param, successFunc, failFunc) {
    $.ajax({
        type: httpMethod,
        url: url,
        data: JSON.stringify(param),
        dataType: "json",
        contentType: "application/json; charset=utf-8",
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

function call(httpMethod, url, param, successFunc, failFunc) {
    $.ajax({
        type: httpMethod,
        url: url,
        data: param,
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

function getPage(page, url, data, successFunc, failFunc) {
    this.callPage("GET", page, url, data, successFunc, failFunc)
}

function postPage(page, url, data, successFunc, failFunc) {
    this.callPage("POST", page, url, data, successFunc, failFunc)
}

function callPage(httpMethod, page, url, param, successFunc, failFunc) {
    if (!isEmpty(param)) {
        param.page = page;
        param.size = LIST_COUNT;
    }

    $.ajax({
        type: httpMethod,
        url: url,
        data: param,
        async: false,
        success: function(res) {

            if (res != null) {

                //TODO:success : false 처리

                if (res.success === true) {

                    var totalCount = res.data.totalElements;
                    if (isEmpty(totalCount)) {
                        totalCount = 0;
                    }
                    var currentPage = res.data.pageable.pageNumbers;

                    if (isEmpty(currentPage)) {
                        currentPage = 1;
                    } else {
                        currentPage = currentPage + 1;
                    }

                    if (successFunc != null) {
                        successFunc(res, getPageInfo(totalCount, currentPage));
                    }
                } else {
                    if (failFunc != null) failFunc(param, res.code, res.code);
                }
            }
        },
        error: function(req, status, error) {
            if (failFunc != null) failFunc(req, status, error);
        },
    });
}
/**
 * page 번호 목록 생성
 */
function getPageInfo(totalCount, currentPage) {
    var totalPage = totalCount / LIST_COUNT;

    if (totalCount % LIST_COUNT > 0) {
        totalPage++;
    }

    //currentPage = 현재 보고있는 페이지
    if (totalPage < currentPage) {
        currentPage = totalPage;
    }

    var startPage = ((currentPage - 1) / PAGENUMBER_COUNT) * PAGENUMBER_COUNT + 1;
    //현재 페이지가 pageCount와 같을 때를 유의하며 (page-1)을 하고
    // +1은 첫페이지가 0이나 10이 아니라 1이나 11로 하기 위함임
    var endPage = startPage + PAGENUMBER_COUNT - 1;
    // -1은 첫페이지가 1이나 11 등과 같을때 1~10, 11~20으로 지정하기 위함임

    if (endPage > totalPage) {
        endPage = totalPage;
    }

    var pageNumbers = new Array();

    for (var i = startPage; i <= endPage; i++) {
        pageNumbers.push(i);
    }

    //pre page
    var prePageNumber = 1;
    if (startPage > 1) {
        prePageNumber = startPage - 1;
    }
    //next page
    var nextPageNumber = totalPage;
    if (totalPage > endPage) {
        nextPageNumber = endPage + 1;
    }

    var pageInfo = new Object();
    pageInfo.pageNumbers = pageNumbers;
    pageInfo.prePageNumber = prePageNumber;
    pageInfo.nextPageNumber = nextPageNumber;

    return pageInfo;
}

/*
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
*/