package fi.mps.monitor.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sensor {

    @Id
    private String serialNbr;
    private String name;

    protected Sensor() {}

    public Sensor(String serialNbr, String name) {
        this.serialNbr = serialNbr;
        this.name = name;
    }

    public String getSerialNbr() {
		return serialNbr;
	}

	public void setSerialNbr(String serialNbr) {
		this.serialNbr = serialNbr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
    public String toString() {
        return String.format(
                "Sencor[id=%d, name='%s', serialNbr='%s']",
                serialNbr, name, serialNbr);
    }
}
