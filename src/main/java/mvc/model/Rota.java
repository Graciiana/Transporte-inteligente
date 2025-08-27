package mvc.model;
import lombok.*;

@Data
@ToString
@AllArgsConstructor

public class Rota {
    private long idRota;
    private String oriegem;
    private String destino;
}
