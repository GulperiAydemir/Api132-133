package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)

public class PetStorePojo {

    private Integer id;
    private String status;

    public PetStorePojo() {
    }

    public PetStorePojo(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PetStorePojo{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}