import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GameState, stateData } from '../model/model';

@Injectable({
  providedIn: 'root',
})
export class GameService {
  url: string = 'http://localhost:8080/';

  constructor(private http: HttpClient) {}

  postState(state: GameState) {
    return this.http.post<stateData[]>(this.url + 'saveState', state);
  }

  getState() {
    return this.http.get<stateData[]>(this.url + 'getAllState');
  }
}
