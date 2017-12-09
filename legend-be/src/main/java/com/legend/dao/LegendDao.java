package com.legend.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.legend.dto.Member;

@Mapper
@Repository
public interface LegendDao {
	public List<Member> getMemberList();
}
