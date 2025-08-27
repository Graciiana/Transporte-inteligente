package mvc.model;
import lombok.*;

@Data
@ToString
@AllArgsConstructor

public class Passageiro {
    private long id;
    private String bilhete;
    private String nome;
    private String telefone;
    private float saldo;

}
