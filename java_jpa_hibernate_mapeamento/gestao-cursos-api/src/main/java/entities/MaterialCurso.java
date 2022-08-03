package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "MaterialCurso")
public class MaterialCurso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;

    @OneToOne(mappedBy = "MaterialCurso")
    private Curso curso ;

    public MaterialCurso() {
    }

    public MaterialCurso( String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
