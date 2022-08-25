package com.example.simpan.pinjam.service.impl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;



import com.example.simpan.pinjam.dao.entity.DataMember;
import com.example.simpan.pinjam.dao.entity.DataTransaction;
import com.example.simpan.pinjam.dao.repository.DataMemberRepository;
import com.example.simpan.pinjam.dao.repository.DataTransactionRepository;
import com.example.simpan.pinjam.exception.ReturnException;
import com.example.simpan.pinjam.request.BaseResponse;
import com.example.simpan.pinjam.request.RequestDto;
import com.example.simpan.pinjam.service.IAppService;
import com.sun.tools.sjavac.Log;

import jdk.jfr.internal.Logger;


@Service
@Transactional(rollbackOn = Exception.class)
public class AppService implements IAppService {

	@Autowired
	private DataMemberRepository dataMemberRepo;
	
	@Autowired
	private DataTransactionRepository dataTransactionRepo;
	
	private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	@Override
	public BaseResponse saveNewMember(RequestDto request) {
		
		DataMember newAnggota = new DataMember();
		
		try {
			newAnggota.setName(request.getName());
			newAnggota.setDateBirth(request.getDateBirth());
			newAnggota.setAddress(request.getAddress());
			newAnggota.setTeamId(request.getTeamId());
			newAnggota.setCreatedTimestamp(timestamp);
			System.out.println (timestamp);
			dataMemberRepo.save(newAnggota);
		}catch (Exception e){
			throw e;
		}
		return new BaseResponse<>("New Anggota Created");
	}

	@Override
	public BaseResponse<Object> getListMember() {
		List <DataMember> members = new ArrayList();
		members = dataMemberRepo.findAll();
		return new BaseResponse<>(members);
	}

	@Override
	public BaseResponse addNewTransaction(RequestDto request) throws Exception {
		Optional<DataMember> member = null;
		DataTransaction transaction = new DataTransaction();
		Date dateTransaction = new SimpleDateFormat("yyyy-MM-dd").parse(request.getDateTransaction()); 
		member = dataMemberRepo.findMember(request.getName());
		if (!member.isPresent()) {
			throw new ReturnException ("Member Belum Terdaftar");
		}
		transaction.setActivityTransaction(request.getActivityTransaction());
		transaction.setMemberId(member.get().getId());
		transaction.setDateTransaction(dateTransaction);
		transaction.setPrice(request.getPrice());
		transaction.setCreatedTimestamp(timestamp);
		
		dataTransactionRepo.save(transaction);
		return  new BaseResponse<>("Transaction Success");
	}

	
	@Override
	public BaseResponse<Object> getHistoryTransactionByMemberId(RequestDto request) {
		List<DataTransaction> transactions = new ArrayList();
		List<DataTransaction> totalTransactions = new ArrayList();
		Optional<DataMember> member = null;
		if (request.getName().isBlank() ) {	
			throw new ReturnException ("Member Name Can't Blank");
		}
		member = dataMemberRepo.findMember(request.getName());
		if (!member.isPresent()) {
			throw new ReturnException ("Member Belum Terdaftar");
		}
		transactions = dataTransactionRepo.findTrasactionByMemberId(member.get().getId(), Pageable.ofSize(request.getSize()));
		totalTransactions = dataTransactionRepo.findTotalTrasactionByMemberId(member.get().getId());
		int total = totalTransactions.size();
		System.out.println("cek value total :: " + transactions );
		System.out.println("cek value total :: " + total );
		Map<String, Object> listTransactions = new HashMap<>();
		listTransactions.put("list_transaction", transactions);
		listTransactions.put("total_transactions", total);
		
		
		return new BaseResponse<>(listTransactions);
	}

	@Override
	public BaseResponse<Object> getHistoryTransactionByDate(RequestDto request) {
		List<DataTransaction> transactions = new ArrayList();
		if (request.getDateStart() == null) {
			throw new ReturnException ("Start Date Tidak Boleh Kosong");
		}
		transactions = dataTransactionRepo.findTrasactionByDate(request.getDateStart(), request.getDateEnd(), Pageable.ofSize(request.getSize()));
		System.out.println("cek value total :: " + transactions );
		System.out.println("cek value total :: " + transactions.size());
		return new BaseResponse<>(transactions);
	}

}
