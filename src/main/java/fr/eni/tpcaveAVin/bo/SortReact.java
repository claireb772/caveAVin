package fr.eni.tpcaveAVin.bo;

public class SortReact {

	private String direction;
	private String key;

	public SortReact() {
	}

	public SortReact(String direction, String key) {
		this.direction = direction;
		this.key = key;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
