package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "registry")
public class Registry {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	@JoinColumn(name = "participant_id")
	private Participant participant;

	@ManyToOne
	@JoinColumn(name = "session_id")
	private Session session;

	@OneToOne
	@JoinColumn(name = "feedback_id")
	private Feedback feedback;


	public long getId() {return this.id;}
	public Participant getParticipant() {return this.participant;}
	public Session getSession() {return this.session;}
	public Feedback getFeedback(){return this.feedback;}

	public void setParticipant(Participant participant) {this.participant = participant;}
	public void setSession(Session session) {this.session = session;}
	public void setFeedback(Feedback feedback) {this.feedback = feedback;}
}