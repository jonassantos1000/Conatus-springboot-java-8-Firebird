package com.conatus.conatussb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.conatus.conatussb.entities.Setting;

public interface ConfiguracaoRepository extends JpaRepository<Setting, Long>{
	
	
}
