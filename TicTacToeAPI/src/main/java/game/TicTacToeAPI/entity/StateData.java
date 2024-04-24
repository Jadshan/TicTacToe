package game.TicTacToeAPI.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "StateData_Tbl")
public class StateData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String status;
    @OneToMany(targetEntity = GameState.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "GS_fk",referencedColumnName = "id")
    private List<GameState> state;

}
