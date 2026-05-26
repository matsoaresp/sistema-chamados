package chamados.homeney.entity;
import chamados.homeney.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "usuario")
public class User {

    public User(String nome, String setor) {
        this.nome = nome;
        this.setor = setor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String setor;
    @Enumerated(EnumType.STRING)
    private UserRole role;
}
