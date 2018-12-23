package jp.co.bizrefine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="event_tb")
public class Event {

	@Id
	@Column(name = "event_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "event_name")
    private String title;

	@Column(name = "event_start")
    private String start;

	@Column(name = "event_end")
    private String end;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getStart() {
        return start;
    }
    public void setStart(String start) {
        this.start = start;
    }
    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }
}