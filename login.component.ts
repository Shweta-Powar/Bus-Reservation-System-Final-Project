import { Component ,OnInit} from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
user:User=new User();
constructor(private userService: UserService,
  private router: Router) { } 
login(){
  
}
welcome(){
  this.router.navigate(['/welcome']); 
  
}
}
