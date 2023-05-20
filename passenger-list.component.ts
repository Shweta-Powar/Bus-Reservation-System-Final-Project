import { Component, OnInit } from '@angular/core';
import { Passenger } from '../passenger';
import { PassengerService } from '../passenger.service';
@Component({
  selector: 'app-passenger-list',
  templateUrl: './passenger-list.component.html',
  styleUrls: ['./passenger-list.component.css']
})
export class PassengerListComponent implements OnInit {

  passengers: any;

  constructor(private passengerService: PassengerService) { } 

  ngOnInit(): void {
    this.getPassengers();
  }
private getPassengers(){
  this.passengerService.getPassengersList().subscribe(data=> {
    this.passengers=data;
  });
}
}
