package mvc.model;
import lombok.*;

@Data
@ToString
@AllArgsConstructor

public class Veiculo {
    private long idVeiculo;
    private String tipoVeiculo;
    private long capacidade;
    private String matricula;
    private long preco;
}
