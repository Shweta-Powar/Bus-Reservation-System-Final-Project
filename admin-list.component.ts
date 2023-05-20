import { Component, OnInit } from '@angular/core';
import { Admin } from '../admin';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-admin-list',
  templateUrl: './admin-list.component.html',
  styleUrls: ['./admin-list.component.css']
})
export class AdminListComponent implements OnInit {

  admins: any;

  constructor(private adminService: AdminService) { } 

  ngOnInit(): void {
    this.getAdmins();
  }
private getAdmins(){
  this.adminService.getAdminsList().subscribe(data=> {
    this.admins=data;
  });
}
}
