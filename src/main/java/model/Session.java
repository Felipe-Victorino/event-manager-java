package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "session_id")
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Temporal(TemporalType.TIME)
	private Date startTime;
	@Temporal(TemporalType.TIME)
	private Date endTime;

    @OneToOne
	private Room room;

	private int predictedCapacity;

	private int totalScore;

	@OneToMany(mappedBy = "session")
	private List<Registry> registries;

	@OneToMany(mappedBy = "session")
	private List<Speaker> speaker;

    public Session(){}

    public long getId(){return this.id;}
    public void setDate(Date date){this.date = date;}
	public Date getEndTime() { return endTime;}
	public void setEndTime(Date endTime) {this.endTime = endTime;}
	public void setRoom(Room room){this.room = room;}
	public Date getStartTime() {return startTime;}
	public void setStartTime(Date startTime) {this.startTime = startTime;}

	public int getPredictedCapacity() {
		return predictedCapacity;
	}
	public void setPredictedCapacity(int predictedCapacity) {
		this.predictedCapacity = predictedCapacity;
	}

	public List<Registry> getParticipants() {return registries;}
	public void setParticipants(List<Registry> registries) {this.registries = registries;}
}