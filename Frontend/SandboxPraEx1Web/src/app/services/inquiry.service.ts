import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'rxjs/add/operator/map';

import { Inquiry } from '../models/inquiry';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class InquiryService {
  inquiries: Inquiry[];
  inquiry: Inquiry;

  constructor(
    private http: Http,
    private httpc: HttpClient
  ) { }

  noAuthHeader = { headers: new HttpHeaders({ 'NoAuth' : 'True' })};

  getInquiryAll(){
    let myHeaders = new Headers();
    myHeaders.append('Content-Type','application/json');
    return this.http.get(environment.baseUrl + '/inquiry', {headers:myHeaders}).map(res => res.json());
  }

  getInquiry(id: number){
    let myHeaders = new Headers();
    myHeaders.append('Content-Type','application/json');
    return this.http.get(environment.baseUrl + '/inquiry/' +`${id}`, {headers:myHeaders}).map(res => res.json());
  }

  addInquiry(inquiry){
    console.log("iService inquiry : "+JSON.stringify(inquiry));
    return this.httpc.post(environment.baseUrl + '/addInquiry', inquiry, this.noAuthHeader);
  }
}
