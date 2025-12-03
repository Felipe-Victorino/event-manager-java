package service;

import dao.SpeakerDao;
import model.Speaker;

import java.util.List;


public class SpeakerService implements Service {

	private final SpeakerDao dao = new SpeakerDao();

	public Speaker createSpeaker(String name, String cpf){
		Speaker speak = new Speaker();
		speak.setNome(name);
		speak.setCpf(cpf);
		dao.insert(speak);
		return speak;

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

	public Speaker searchSpeaker(Speaker speaker){
		return dao.searchBy(speaker.getId());
	}
}