package net.jtheway.web.common.response;


import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ApiResponseMessage {
	// HttpStatus
    private HttpStatus httpStatus = HttpStatus.OK;
    // Http Default Message
    private Object userResponse;
    // Error Message to USER
    private String errorMessage;
    // Error Code
    private String errorCode;
 
    public ApiResponseMessage() {}
 
    public ApiResponseMessage(HttpStatus status, Object userResponse, String errorCode, String errorMessage) {
        this.httpStatus = status;
        this.userResponse = userResponse;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    
    public ApiResponseMessage(Throwable t) {
    	this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    	this.userResponse = "";
    	this.errorMessage = t.getMessage();
    	this.errorCode = "";
    }
}
