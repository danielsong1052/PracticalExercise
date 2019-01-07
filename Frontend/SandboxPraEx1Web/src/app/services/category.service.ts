import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { environment } from '../../environments/environment';
@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(
    private http: Http
  ) { }

  getAllCatetories(){
    let myHeaders = new Headers();
    myHeaders.append('Content-Type','application/json');
    return this.http.get(environment.baseUrl + '/category', {headers:myHeaders}).map(res => res.json());
  }
}
