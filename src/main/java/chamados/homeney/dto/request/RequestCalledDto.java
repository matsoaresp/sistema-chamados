package chamados.homeney.dto.request;
import jakarta.validation.constraints.NotBlank;
import chamados.homeney.enums.PriorityRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestCalledDto {
    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    private PriorityRole priority;
}
