package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
	private Date startDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;

    @OneToOne
	private Room room;

	@OneToMany(mappedBy = "session")
	private List<Participant> participants;

    public Session(){}

    public long getId(){return this.id;}
    public Date getStartDate(){return this.startDate;}
    public Room getRoom(){return this.room;}

    public void setStartDate(Date date){this.startDate = date;}
    public void setRoom(Room room){this.room = room;}


}