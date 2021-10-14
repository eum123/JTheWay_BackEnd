package net.haaim.web.api.common.response;


import org.springframework.http.HttpStatus;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiResponse {
	@ApiModelProperty(value = "응답 성공여부 : true/false")
    private boolean success;

    @ApiModelProperty(value = "응답 코드 번호 :  0 = 정상,  0 != 비정상")
    private int code;

    @ApiModelProperty(value = "응답 메시지")
    private String msg;
    
    @ApiModelProperty(value = "응답 데이터")
    private Object data;
 
    public ApiResponse() {}
    
    public static ApiResponse getSuccessResponse(Object returnData) {
    	ApiResponse response = new ApiResponse();
    	response.success = true;
    	response.code = 0;
    	response.msg = "OK";
    	response.data = returnData;
    	
    	return response;
    }
 
    public static ApiResponse getErrorResponse(Exception e) {
    	ApiResponse response = new ApiResponse();
    	response.success = false;
    	response.code = 500;
    	response.msg = e.getMessage();
    	
    	return response;
    }
    
    public static ApiResponse getErrorResponse(HttpStatus status) {
    	ApiResponse response = new ApiResponse();
    	response.success = false;
    	response.code = status.value();
    	response.msg = status.getReasonPhrase();
    	
    	return response;
    }
}
