package com.example.simpan.pinjam.service;

import java.text.ParseException;

import com.example.simpan.pinjam.request.BaseResponse;
import com.example.simpan.pinjam.request.RequestDto;

public interface IAppService {
	
	public BaseResponse saveNewMember(RequestDto request);
	
	public BaseResponse<Object> getListMember();
	
	public BaseResponse addNewTransaction(RequestDto request) throws Exception;
	
	public BaseResponse<Object> getHistoryTransactionByMemberId (RequestDto request);
	
	public BaseResponse<Object> getHistoryTransactionByDate(RequestDto request);
}
