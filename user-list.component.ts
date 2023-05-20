import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: any;

  constructor(private userService: UserService,
    private router: Router) { } 

  ngOnInit(): void {
    this.getUsers();
  }
private getUsers(){
  this.userService.getUsersList().subscribe(data=> {console.log(data),
    this.users=data;
  });
}
userDetails(uid:number){
  this.router.navigate(['/user-details',uid]);
}
updateUser(uid:number){
this.router.navigate(['/update-user',uid]);
}
deleteUser(uid:number){
this.userService.deleteUser(uid).subscribe( data => {
  console.log(data);
  this.getUsers();
})
}
}
