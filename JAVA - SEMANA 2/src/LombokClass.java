import lombok.*;

@Builder // permite los builds en el main
@Data // genera getters, setters, constructores y hash/equals
public class LombokClass {
    private String nombre;
    private Integer edad;
}
