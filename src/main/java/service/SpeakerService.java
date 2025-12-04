package service;

import dao.SpeakerDao;
import model.Speaker;

import java.util.List;


public class SpeakerService implements Service<Speaker> {

	private final SpeakerDao dao = new SpeakerDao();

	public Speaker create(String name, String cpf){
		Speaker speak = new Speaker();
		speak.setNome(name);
		speak.setCpf(cpf);
		dao.insert(speak);
		return speak;

	}

	public void update(Speaker speaker, String cpf, String newName){
		assert speaker != null;
		speaker.setNome(newName);
		speaker.setCpf(cpf);
		this.dao.update(speaker);
	}

	public Speaker delete(Speaker speak){
		return this.dao.delete(speak);
	}

	public void printAllEntries() {
		List<Speaker> speakerList = dao.searchAll();
		for (Speaker s : speakerList){
			System.out.println(s.toString());
		}
	}

	public Speaker searchSpeaker(String cpf){
		List<Speaker> speakers = dao.searchAll();
		for(Speaker s : speakers){
			if(cpf.equals(s.getCpf())){
				return s;
			}
		}
		return null;
	}

	public Speaker search(long id){
		return dao.searchBy(id);
	}


}