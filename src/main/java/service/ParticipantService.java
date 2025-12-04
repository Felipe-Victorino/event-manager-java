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
		this.dao.insert(participant);
		return participant;
	}

	public void updateParticipant(Participant part, String cpf, String newName){
		assert part != null;
		part.setNome(newName);
		part.setCpf(cpf);
		this.dao.update(part);
	}

	public void removeParticipant(String cpf){
		Participant part = searchParticipantByCpf(cpf);
		this.dao.delete(part);
	}

	public void printAllEntries() {
		List<Participant> participantList = this.dao.searchAll();
		for (Participant p : participantList){
			System.out.println(p.toString());
		}
	}

	public Participant setPastEntries(Participant part){
		SessionService sessionServer = new SessionService();
		List<Session> sessionsRegistered = sessionServer.getAllSessionsWPart(part);
		try {
			for (Session s : sessionsRegistered) {
				DateInterval interval = sessionServer.getSessionTimeInterval(s);
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