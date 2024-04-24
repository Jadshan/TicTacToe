package game.TicTacToeAPI.controller;

import game.TicTacToeAPI.dto.StateDataRequest;
import game.TicTacToeAPI.entity.StateData;
import game.TicTacToeAPI.service.StateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class StateDataController {
    private final StateService service;
    @PostMapping("/saveState")
    public ResponseEntity<List<StateData>> saveState(@RequestBody StateDataRequest dataRequest)
    {
        StateData storedState = service.saveStateData(dataRequest);
        if(storedState == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(getAllState());
    }

    @GetMapping("/getAllState")
    public List<StateData> getAllState(){
        return service.getAllState();
    }


}
