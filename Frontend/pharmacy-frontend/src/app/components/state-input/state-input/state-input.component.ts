import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';
import {startWith, map} from 'rxjs/operators';
import { State } from 'src/app/model/state/state';
import { StateServiceService } from 'src/app/services/state-service/state-service.service';


@Component({
  selector: 'app-state-input',
  templateUrl: './state-input.component.html',
  styleUrls: ['./state-input.component.css']
})


export class StateInputComponent implements OnInit {

  stateCtrl = new FormControl();
  filteredStates: Observable<State[]>;
  state : String;
  states: State[];

  constructor(private stateService : StateServiceService) { 
    console.log("Usao u constructor")
    this.stateService.getStates().subscribe(
      success => {
        this.states = success;
        this.filteredStates = this.stateCtrl.valueChanges
      .pipe(
        startWith(''),
        map(state => state ? this._filterStates(state) : this.states.slice())
      );
      }
    )
  }

  ngOnInit(): void {
  
  }

  private _filterStates(value: string): State[] {
    const filterValue = value.toLowerCase();
    this.state = filterValue;
    return this.states.filter(state => state.name.toLowerCase().includes(filterValue));
  }

  public getState() {
    if (this.state === undefined) {
      return
    } else {
      console.log(this.state)
    }
    
  }

  public getStateData(state : State) {
    console.log(state.alpha2Code)
  }
}


