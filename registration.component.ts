import { Component } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {
user:User=new User();

constructor(private userService: UserService,
  private router: Router) { } 

registration(){
  
}
login(){
  this.router.navigate(['/login']); 

}
}
