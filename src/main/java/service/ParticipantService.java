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

public class ParticipantService {

	private Scanner sc = new Scanner(System.in);

	public Participant createParticipant(String nome, String cpf){
		Participant participant = new Participant();
		participant.setNome(nome);
		participant.setCpf(cpf);
		ParticipantDao dao = new ParticipantDao();
		dao.insert(participant);
		return participant;
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

	public void search(){
		String cpf = sc.nextLine();

		searchParticipantByCpf(cpf);

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