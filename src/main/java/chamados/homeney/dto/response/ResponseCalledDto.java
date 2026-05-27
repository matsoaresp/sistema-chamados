package chamados.homeney.dto.response;

import chamados.homeney.enums.PriorityRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseCalledDto {


    private PriorityRole priority;

}
