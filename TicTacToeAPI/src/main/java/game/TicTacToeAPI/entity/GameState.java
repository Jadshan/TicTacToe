package game.TicTacToeAPI.entity;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Transactional
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="gameState_Tbl")
public class GameState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Gsta_id")
    private Long gstaId;
    private String value;
    private int ind;
}
