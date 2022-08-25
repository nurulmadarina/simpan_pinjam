package com.example.simpan.pinjam.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.simpan.pinjam.dao.entity.DataMember;

public interface DataMemberRepository extends JpaRepository <DataMember, String>{
	
	@Query(value = "select * from anggota where name = :name", nativeQuery = true)
	Optional<DataMember> findMember(@Param("name") String name);

}
