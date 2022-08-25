package com.example.simpan.pinjam.dao.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.simpan.pinjam.dao.entity.DataTransaction;

@Repository
public interface DataTransactionRepository extends JpaRepository <DataTransaction, String> {
	
	@Query(value = "select * from transaction as a "
			+ "where a.date_transaction between :dateTransaction and :dateTransaction "
			+ "order by a.date_transaction desc", nativeQuery = true)
	List<DataTransaction> findTrasactionByDate( @Param("dateTransaction")Date from, @Param("dateTransaction")Date to, Pageable pageable);

	@Query(value = "select * from transaction as a "
			+ "where a.member_id = :memberId "
			+ "order by a.created_timestamp desc", nativeQuery = true)
	List<DataTransaction> findTrasactionByMemberId( @Param("memberId")String memberId, Pageable pageable);
	
	@Query(value = "select * from transaction as a "
			+ "where a.member_id = :memberId "
			+ "order by a.created_timestamp desc", nativeQuery = true)
	List<DataTransaction> findTotalTrasactionByMemberId(@Param("memberId") String memberId);

}
