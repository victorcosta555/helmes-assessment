import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeComponent } from './home.component';
import {SectorGroup} from "../models/SectorsInterface";

describe('HomeComponent', () => {
  let component: HomeComponent;
  let fixture: ComponentFixture<HomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('#should getSector onInit', () => {
    component.ngOnInit();
    expect(component.sectors.length).toBeGreaterThan(0);
  })

  it('#onClick should reset selected object when is valid', () => {
    component.selected.name = "Victor";
    component.selected.sectorValue = 30;
    component.selected.agreeTerms = true;
    component.onClick();
    expect(component.selected.name.length).toEqual(0);
    expect(component.selected.sectorValue).toEqual(0);
    expect(component.selected.agreeTerms).toBeFalse();
  })
});
