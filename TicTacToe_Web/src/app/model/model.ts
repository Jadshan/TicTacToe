export interface GameState {
  stateData: stateData;
}

export interface stateData {
  id?: number;
  status: string;
  state: state[];
}

export interface state {
  gstaId?: number;
  ind: number;
  value: string;
}
