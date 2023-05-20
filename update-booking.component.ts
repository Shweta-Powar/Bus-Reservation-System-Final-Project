import { Component ,OnInit} from '@angular/core';
import { Booking } from '../booking'; 
import { BookingService } from '../booking.service';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
@Component({
  selector: 'app-update-booking',
  templateUrl: './update-booking.component.html',
  styleUrls: ['./update-booking.component.css']
})
export class UpdateBookingComponent  implements OnInit{

  id: number=0;
  booking: Booking=new Booking();

  constructor(private bookingService: BookingService,
    private route:ActivatedRoute,private router: Router) { }

  ngOnInit():void{
    this.id=this.route.snapshot.params['id'];
    this.bookingService.getBookingById(this.id) .subscribe(data => {
    this.booking=data;
    }, error => console.log(error));
  }
 public onSubmit(){
  this.bookingService.updateBookingById(this.id,this.booking).subscribe( data => {
this.goToBookingList();
  }, error => console.log(error));
  
}
goToBookingList(){
  this.router.navigate(['/bookings']);
   }
  }


