package mvc.model;
import lombok.*;

@Data
@ToString
@AllArgsConstructor

public class Viagem {
    private long idVIagem;
    private Passageiro passageiro;
    private Veiculo veiculo;
    private Rota rota;
}
