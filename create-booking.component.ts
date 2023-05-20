import { Component,OnInit } from '@angular/core';
import { Booking } from '../booking';
import { BookingService } from '../booking.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-booking',
  templateUrl: './create-booking.component.html',
  styleUrls: ['./create-booking.component.css']
})
export class CreateBookingComponent  implements OnInit {
  booking:Booking =new Booking();
  constructor(private bookingService:BookingService,
    private router:Router){ }

  ngOnInit():void{
 }
 saveBooking(){
  this.bookingService.createBooking(this.booking).subscribe( data=>{
    console.log(data);
    this.goToBookingList();
  },
  error =>console.log(error));
 }
 goToBookingList(){
this.router.navigate(['/bookings']);
 }
  onSubmit(){
    console.log(this.booking);
    this.saveBooking();
  }
  }


