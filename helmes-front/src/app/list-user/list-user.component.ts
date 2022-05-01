import {Component, OnInit} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {HomeForm} from "../models/HomeForm";
import {ListUserService} from "./list-user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.css']
})
export class ListUserComponent implements OnInit {

  dataSource = new MatTableDataSource<HomeForm>();
  displayedColumns: string[] = ['name', 'sectorId', 'sectorName'];
  clickedRows = new Set<HomeForm>();

  constructor(private listUserService: ListUserService,
              private route: Router) { }

  ngOnInit(): void {
    this.getUserList()
  }

  getUserList() {
    this.listUserService.getUserList()
      .subscribe(response => {
        this.dataSource = new MatTableDataSource(response);
      })
  }

  onClick(homeForm: HomeForm) {
    this.route.navigate(['/home'], {state: {data: homeForm}})
  }

}
