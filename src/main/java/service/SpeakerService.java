package service;

import dao.SpeakerDao;
import model.Speaker;

import java.util.List;
import java.util.Objects;

public class SpeakerService {

	private SpeakerDao dao = new SpeakerDao();

	public Speaker searchSpeaker(Speaker speaker ){
		List<Speaker> speakers = dao.searchAll();
		for(Speaker s : speakers){
			if(Objects.equals(s.getCpf(), speaker.getCpf())){
				return s;
			}
		}
		return null;
	}
}