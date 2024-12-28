package zooCharacter;

public abstract class Visitor extends ZooCharacter {
	public Visitor(String name) {
		super(name);
	}

	private String ticketId;

	public abstract void roamAround();

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

}
