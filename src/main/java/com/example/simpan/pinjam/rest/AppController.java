package com.example.simpan.pinjam.rest;



import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.simpan.pinjam.request.BaseResponse;
import com.example.simpan.pinjam.request.RequestDto;
import com.example.simpan.pinjam.service.IAppService;

@Component
@Service
public class AppController implements IAppController{
	
	@Autowired
	IAppService appService;

	@Override
	public BaseResponse addNewMember(@RequestBody RequestDto request, HttpServletRequest httpRequest) {
		return appService.saveNewMember(request);
	}


	@Override
	public BaseResponse getAllMember() {
		return appService.getListMember();
	}


	@Override
	public BaseResponse addNewTransaction(RequestDto request, HttpServletRequest httpRequest) throws Exception {
		return appService.addNewTransaction(request);
	}


	@Override
	public BaseResponse getHistoryTransactionByName(RequestDto request, HttpServletRequest httpRequest) {
		return appService.getHistoryTransactionByMemberId(request);
	}


	@Override
	public BaseResponse getHistoryTransactionByDate(RequestDto request, HttpServletRequest httpRequest) {
		return appService.getHistoryTransactionByDate(request);
	}
	
	

}
