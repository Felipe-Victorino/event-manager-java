package model;

import service.SessionService;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name = "feedback")
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int finalCapacity;

	private int predictedCapacity;

	private double score;

	@OneToOne
	private Session session;

	public Feedback(){

	}

	public long getId() {
		return id;
	}

	public int getFinalCapacity() {
		return finalCapacity;
	}

	public int getPredictedCapacity() {
		return predictedCapacity;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public double getScore() {
		return score;
	}

	public void setFinalCapacity(int finalCapacity) {
		this.finalCapacity = finalCapacity;
	}

	public void setPredictedCapacity(int predictedCapacity) {
		this.predictedCapacity = predictedCapacity;
	}

	public void setScore(double score) {
		this.score = score;
	}
}