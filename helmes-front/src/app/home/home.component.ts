import {Component, OnInit} from '@angular/core';
import {FormControl, Validators} from "@angular/forms";
import {SectorGroup} from "../models/SectorsInterface";
import {HomeService} from "./home.service";
import {HomeForm} from "../models/HomeForm";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  nameFormControl = new FormControl('', [Validators.required, Validators.min(5)]);
  sectors: SectorGroup[] = [];
  homeForm: HomeForm = new HomeForm();

  constructor(private homeService: HomeService,
              private _snackBar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.getSectors();
  }

  getSectors(): void {
    this.homeService.getSectors().subscribe(sectors => this.sectors = sectors);
  }

  onClick(): void {
    if (this.isValidForm()) {
      this.homeService.sendForm(this.homeForm)
        .subscribe((res: any) => {
          if (res.status === 201) {
            this.homeForm = new HomeForm();
            this.openSnackBar("User created");
          } else if (res.status === 404) {
            this.openSnackBar(`Sector not found ${this.homeForm.sector?.name}`);
          }
        });
    }
  }

  openSnackBar(message: string) {
    this._snackBar.open(message, 'Undo', {
      duration: 3000
    });
  }


  isValidForm(): boolean {
    return this.homeForm.name !== "" && this.homeForm.agreeTerms && this.homeForm.sector !== null;
  }
}
