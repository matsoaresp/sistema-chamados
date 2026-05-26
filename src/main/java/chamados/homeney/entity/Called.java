package chamados.homeney.entity;

import chamados.homeney.enums.PriorityRole;
import chamados.homeney.enums.StatusRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Called {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String titulo;
   private String descricao;
   @Enumerated(EnumType.STRING)
   private StatusRole status;
   private PriorityRole priority;

   public Called(String titulo, String descricao) {
      this.titulo = titulo;
      this.descricao = descricao;
   }
}
