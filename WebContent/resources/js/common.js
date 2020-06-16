function sleep(delay) {
  var start = new Date().getTime();
  while (new Date().getTime() < start + delay);
}

Date.prototype.format = function (f) {
  if (!this.valueOf()) return " ";

  var weekName = [
    "일요일",
    "월요일",
    "화요일",
    "수요일",
    "목요일",
    "금요일",
    "토요일",
  ];
  var d = this;

  return f.replace(/(yyyy|yy|MM|dd|E|hh|mm|ss|a\/p)/gi, function ($1) {
    switch ($1) {
      case "yyyy":
        return d.getFullYear();
      case "yy":
        return (d.getFullYear() % 1000).zf(2);
      case "MM":
        return (d.getMonth() + 1).zf(2);
      case "dd":
        return d.getDate().zf(2);
      case "E":
        return weekName[d.getDay()];
      case "HH":
        return d.getHours().zf(2);
      case "hh":
        return ((h = d.getHours() % 12) ? h : 12).zf(2);
      case "mm":
        return d.getMinutes().zf(2);
      case "ss":
        return d.getSeconds().zf(2);
      case "a/p":
        return d.getHours() < 12 ? "오전" : "오후";
      default:
        return $1;
    }
  });
};

String.prototype.string = function (len) {
  var s = "",
    i = 0;
  while (i++ < len) {
    s += this;
  }
  return s;
};
String.prototype.zf = function (len) {
  return "0".string(len - this.length) + this;
};
Number.prototype.zf = function (len) {
  return this.toString().zf(len);
};

/**
 * page 번호 목록 생성
 */
function getPageInfo(LIST_COUNT, PAGENUMBER_COUNT, totalCount, currentPage) {
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
