package net.haaim.web.error.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import net.haaim.web.common.response.ApiResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/exception")
public class ExceptionController {
 
    @GetMapping(value = "/accessdenied")
    public ApiResponse accessdeniedException() {
        return ApiResponse.getErrorResponse(HttpStatus.NOT_ACCEPTABLE);
    }
}
