package com.conatus.conatussb.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.conatus.conatussb.entities.Setting;
import com.conatus.conatussb.repositories.ConfiguracaoRepository;

@Service
public class ConfiguracaoService {
	
	@Autowired
	ConfiguracaoRepository repository;
	
	public Setting find() {
		Optional<Setting> obj= repository.findById((long) 1);
		return obj.get();
	}
	
	
	public Setting update(Setting obj) {
		Setting config = repository.getOne((long) 1);
		updateData(config,obj);
		return repository.save(config);	
	}
	
	public void updateData(Setting entity, Setting obj) {
		entity.setCnpj(obj.getCnpj());
		entity.setData(obj.getData());
		entity.setEmail(obj.getEmail());
		entity.setMensagemPadrao(obj.getMensagemPadrao());
		entity.setPortaSMTP(obj.getPortaSMTP());
		entity.setRazaoSocial(obj.getRazaoSocial());
		entity.setResponsavelLegal(obj.getResponsavelLegal());
		entity.setSenha(obj.getSenha());
		entity.setSmtp(obj.getSmtp());
		entity.setSSL(obj.getSSL());
		entity.setTLS(obj.getTLS());
	}
	
}
