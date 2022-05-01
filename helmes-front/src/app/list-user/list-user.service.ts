import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {HomeForm} from "../models/HomeForm";

@Injectable({
  providedIn: 'root'
})
export class ListUserService {

  private url = "/api"

  constructor(private http: HttpClient) { }

  getUserList() : Observable<HomeForm[] | []> {
    return this.http.get<HomeForm[]>(this.url);
  }
}
