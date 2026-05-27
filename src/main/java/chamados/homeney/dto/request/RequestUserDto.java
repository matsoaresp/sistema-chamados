package chamados.homeney.dto.request;


import chamados.homeney.enums.PriorityRole;
import chamados.homeney.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestUserDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String setor;

    @NotBlank
    private UserRole role;

}
