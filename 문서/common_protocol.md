# 공통
## 조회
  1. 요청
      - httpMethod : GET
      - data는 parameter 로 전달
  2. 응답
     - 데이터 : 
        ```json
        {
          "status": 200,
          "errorMessage": "",
          "result": {
            //각 항목별 데이터
          }
        }
        ```
## 처리 (저장 , 수정, 삭제)
  1. 요청
    - httpMethod : POST
    - 데이터 : 
        ```json
        {  
          "data": {
            //각 항목별 데이터
          }
        }
        ```
  2. 응답
     - 데이터 : 
     ```json
      {
        "status": 200,
        "errorMessage": "",
        "result": {
          //각 항목별 데이터
        }
      }
      ```
