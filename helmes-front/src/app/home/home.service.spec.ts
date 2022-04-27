import { TestBed } from '@angular/core/testing';

import { HomeService } from './home.service';
import {SECTORS} from "../data/data";
import {HttpClient} from "@angular/common/http";
import {HomeForm} from "../models/HomeForm";
import {of} from "rxjs";

describe('HomeService', () => {
  let service: HomeService;
  let httpClientSpy: jasmine.SpyObj<HttpClient>;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    httpClientSpy = jasmine.createSpyObj('HttpClient', ['post']);
    service = TestBed.inject(HomeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('#getSectors should return an array of SectorsGroup', (done: DoneFn) => {
    expect(service.getSectors().subscribe(value => {
      expect(value).toBe(SECTORS);
      done();
    }))
  })

  //TODO
  it('should send the form and receive 201 when is valid', (done: DoneFn) => {
    const exptectedForm = { status: 201 };

    httpClientSpy.post.and.returnValue(of(exptectedForm));
  })
});
