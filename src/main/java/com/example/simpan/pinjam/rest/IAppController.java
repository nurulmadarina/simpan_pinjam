package com.example.simpan.pinjam.rest;



import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simpan.pinjam.request.BaseResponse;
import com.example.simpan.pinjam.request.RequestDto;

@RestController
@RequestMapping(path = "/simpanpinjam")
public interface IAppController {
	
	@PostMapping(path = "/addNewMember")	
	public BaseResponse addNewMember(@RequestBody RequestDto request,  HttpServletRequest httpRequest);
	
	@GetMapping(path = "/getAllMember")	
	public BaseResponse getAllMember();
	
	@PostMapping(path = "/addNewTransaction")	
	public BaseResponse addNewTransaction(@RequestBody RequestDto request,  HttpServletRequest httpRequest) throws Exception;
	
	@PostMapping(path = "/getHistoryTransactionByName")	
	public BaseResponse getHistoryTransactionByName(@RequestBody RequestDto request,  HttpServletRequest httpRequest);
	
	@PostMapping(path = "/getHistoryTransactionByDate")	
	public BaseResponse getHistoryTransactionByDate(@RequestBody RequestDto request,  HttpServletRequest httpRequest);

}
