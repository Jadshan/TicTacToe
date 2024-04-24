package game.TicTacToeAPI.dto;

import game.TicTacToeAPI.entity.StateData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StateDataRequest {
    private StateData stateData;
}
