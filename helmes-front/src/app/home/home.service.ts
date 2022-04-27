import {Injectable} from '@angular/core';
import {Observable, of} from "rxjs";
import {SectorGroup} from "../models/SectorsInterface";
import {SECTORS} from "../data/data";
import {HomeForm} from "../models/HomeForm";
import {HttpClient, HttpHeaders, HttpResponse} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  private url = '/api';

  constructor(private http: HttpClient) {
  }

  getSectors(): Observable<SectorGroup[]> {
    return of(SECTORS);
  }

  sendForm(homeForm: HomeForm): Observable<HttpResponse<HomeForm>> {
    const headers = new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*'
    });
    return this.http.post<HomeForm>(this.url, homeForm,  {observe: 'response', headers: headers});
  }
}
