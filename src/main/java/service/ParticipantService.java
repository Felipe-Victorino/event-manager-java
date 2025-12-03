package service;

import dao.ParticipantDao;
import exceptions.IntervalTreeOverlap;
import model.Participant;
import model.Session;
import util.interval.DateInterval;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ParticipantService implements Service{

	private final ParticipantDao dao = new ParticipantDao();

	public Participant createParticipant(String nome, String cpf){
		Participant participant = new Participant();
		participant.setNome(nome);
		participant.setCpf(cpf);
		dao.insert(participant);
		return participant;
	}

	public void updateParticipant(String cpf, String newName){
		Participant part = searchParticipantByCpf(cpf);
		assert part != null;
		part.setNome(newName);
		dao.update(part);
	}

	public void removeParticipant(String cpf){
		Participant part = searchParticipantByCpf(cpf);
		dao.delete(part);
	}

	@Override
	public void printAllEntries() {
		List<Participant> participantList = dao.searchAll();
		for (Participant p : participantList){
			System.out.println(p.toString());
		}
	}

	public Participant setPastEntries(Participant part){
		List<Session> sessionsRegistered = new SessionService().getAllSessionsWPart(part);
		try {
			for (Session s : sessionsRegistered) {
				DateInterval interval = new SessionService().getSessionTimeInterval(s);
				part.getIntervalTree().add(interval);
			}
		} catch (IntervalTreeOverlap e) {
			System.out.println(e.getMessage());

		}
		return part;
	}

	public Participant search(String cpf){

		return searchParticipantByCpf(cpf);

	}

	public Participant search(long id){
		return dao.searchBy(id);
	}


	private Participant searchParticipantByCpf(String participantCpf){
		ParticipantDao dao = new ParticipantDao();
		List<Participant> participants = dao.searchAll();

		for(Participant p : participants){
			if(Objects.equals(p.getCpf(), participantCpf)){
				System.out.println("Participant found:");
				System.out.println(p.toString());
				return p;
			}
		}
		System.out.println("Not found");
		return null;
	}
}