import { Component,OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from '../user';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';
@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit{

  uid: number=0;
user: User=new User();

  constructor(private userService: UserService,
    private route:ActivatedRoute,private router: Router) { }

  ngOnInit():void{
    this.uid=this.route.snapshot.params['uid'];
    this.userService.getUserById(this.uid) .subscribe(data => {
    this.user=data;
    }, error => console.log(error));
  }
 public onSubmit(){
  this.userService.updateUserById(this.uid,this.user).subscribe( data => {
this.goToUserList();
  }, error => console.log(error));
  
}
goToUserList(){
  this.router.navigate(['/users']);
   }
  }


